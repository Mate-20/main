<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
    <%
    String errorMsg = (String)request.getAttribute("errorMsg");
    if (errorMsg != null) {
%>
		<div class="error-msg" style="background-color: rgb(253, 168, 168); max-width: 250px; padding: 10px; border-radius: 6px; margin-bottom: 10px;">
            <%=errorMsg%>
        </div>
        
<%
	request.removeAttribute("errorMssg");
    }
%>
    <div class="text-center mt-5">
        <h1>
            Enter Login Details
        </h1>
    </div>
    <div class="mt-5 text-center">
        <div class="card container" style="width: 40%; background-color: rgb(230, 255, 238);">
            <div class="card-body">
                <form action="logincheck" method="post">
                    <div class="mb-3">
                        <label class="form-label">Name</label>
                        <input type="text" class="form-control" name="abcd" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input type="password" class="form-control" name="pass" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
    </div>

</body>

</html>