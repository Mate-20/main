package com.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.spring.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring.entities.Book;
import com.spring.service.LoginService;
import com.spring.service.DeleteService;
import com.spring.service.EditService;

@Controller
public class HomeController {

@Autowired
private LoginService loginService;

    @RequestMapping("/")
	public String home() {
		return "login";
	}
	@RequestMapping(path="/logincheck" ,method=RequestMethod.POST)
	public String verifying(@RequestParam("abcd") String abcd, @RequestParam("pass") String pass, Model model) {
		boolean val = loginService.check(abcd, pass);
		if(val){
			model.addAttribute("user", abcd);
			return "display";
		}else{
			model.addAttribute("errorMsg","Login Username or Password is Incorrect");
			return "login";
		} 
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }
		return "login";
	}

	@RequestMapping("/addPage")
	public String addPage(){
		return "add";
	}

	@RequestMapping("/addData")
	public String addData(@RequestParam("code") int code,@RequestParam("bookName") String bookName,@RequestParam("authorName") String author,@RequestParam("date") String date){
		AddService add = new AddService();
		Book book = new Book(code, bookName, author, date);
		try {
			add.addBook(book);
			return "display";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "add";
	}

	@RequestMapping("/deleteData")
	public String delete(@RequestParam("bookCode") int code){
		DeleteService ds = new DeleteService();
		try {
			ds.deleteBook(code);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "display";

	}

	@RequestMapping("/editPage")
	public String editPage(@RequestParam("bookCode") int code,@RequestParam("bookDate") String date,@RequestParam("bookName") String name, Model model){
		model.addAttribute("bookCode", code);
		model.addAttribute("bookName", name);
		model.addAttribute("bookDate", date);
		return "edit";
	}

	@RequestMapping("/editData")
	public String editData(@RequestParam("bookcode") int code,@RequestParam("bookdate") String date,@RequestParam("bookname") String name, @RequestParam("author") String author){
		Book book = new Book(code, name, author, date);
		EditService edit = new EditService();
		try {
			edit.editBook(book);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "display";
	}



}
