<%@ page import="com.spring.entities.Book" %>
<%@ page import="com.spring.service.BookService" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Books</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<% BookService bookService=new BookService(); 
List<Book> books = bookService.fetchBooks();
  String user = String.valueOf(request.getAttribute("user"));
%>
          <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Navbar</a>
              <h4 style="color: white;">HI <%=user%></h4>
            </div>
          </nav>
          <div class="container text-center">
            <h1>BOOKS LISTING</h1>
            <form action="/addPage">
              <input type="submit" value="ADD" class="addbtn">
            </form>
            <form action="/logout" class="mt-2">
              <input type="submit" value="LOGOUT" style="margin: 10px;" class="logoutbtn">
            </form>
          </div>
          <%if(books.size() == 0){%>
            <div class="text-center">
              <h2>ADD SOME BOOKS</h2>
            </div>
            
        <%} else{%>
          <table class="table table-bordered container" id="bookTable">
            <thead>
              <tr>
                <th scope="col">Book Code</th>
                <th scope="col">Book Name</th>
                <th scope="col">Author</th>
                <th scope="col">Date Added</th>
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>
              <% for (Book book : books) { %>
                <tr>
                  <td>
                    <%= book.getBookCode() %>
                  </td>
                  <td>
                    <%= book.getBookName() %>
                  </td>
                  <td>
                    <%= book.getAuthor() %>
                  </td>
                  <td>
                    <%= book.getDate() %>
                  </td>
                  <td>
                    <div class="inline">
                      <form action="/editPage" style="padding: 5px;">
                        <input type="hidden" name="bookCode" value="<%= book.getBookCode()%>">
                        <input type="hidden" name="bookDate" value="<%= book.getDate()%>">
                        <input type="hidden" name="bookName" value="<%= book.getBookName()%>">
                        <input type="submit" value="Edit" class="editbtn">
                      </form>
                      <form action="/deleteData" style="padding: 5px;">
                        <input type="hidden" name="bookCode" value="<%= book.getBookCode()%>">
                        <input type="submit" value="Delete" class="delbtn">
                      </form>
                    </div>
                  </td>
                </tr>
                <% } %>
            </tbody>
          </table>
          <%}%>
      </body>
<style>
.inline {
    display: flex;
}
.editbtn {
    background-color: rgb(173, 240, 240);
    border-radius: 5px;
 }

.delbtn {
   background-color: rgb(223, 103, 129);
   border-radius: 5px;
}
.table-bordered {
  border: 2px solid #555;
}
.addbtn{
  background-color: rgb(173, 240, 240);
}
.logoutbtn{
  background-color: rgb(223, 103, 129);
}
</style>

</html>