<%@ page import="com.spring.entities.Author" %>
<%@ page import="com.spring.service.AuthorService" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>

<body>
    <%
    AuthorService service = new AuthorService();
    List<Author> authors = service.fetchAuthors();
    int bookcode = (Integer)request.getAttribute("bookCode");
    String bookdate = String.valueOf(request.getAttribute("bookDate"));
    String bookname = String.valueOf(request.getAttribute("bookName"));
  %>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-auto">
                <h1>Edit Book Details</h1>
            </div>
        </div>
    </div>

    <div class="container">
        <form action="/editData">
            <div class="mb-3">
                <label class="form-label">Book Code</label>
                <input type="text" class="form-control" readonly value="<%=bookcode%>" name="bookcode">
            </div>
            <div class="mb-3">
                <label class="form-label">Book Name</label>
                <input type="text" class="form-control" value="<%=bookname%>" name="bookname">
            </div>
            <div class="mb-3">
                <label class="form-label">Author</label>
                <select class="form-select" name="author">    
                    <% for (Author author : authors) { %>
                        <option value="<%= author.getName() %>"><%= author.getName() %></option>
                    <% } %>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Added On</label>
                <input type="text" class="form-control" readonly id="date" value="<%=bookdate%>" name="bookdate">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="button" class="btn btn-danger" id="cancelBtn">Cancel</button>
        </form>
    </div>
</body>
<script>

    const cancelBtn = document.getElementById('cancelBtn');    
    cancelBtn.addEventListener('click', () => {
        // Go back to the previous page
        window.history.back();
    });
</script>
</html>