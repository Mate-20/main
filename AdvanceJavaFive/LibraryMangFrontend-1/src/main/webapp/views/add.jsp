
    <!DOCTYPE html>
    <html lang="en">
    
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ADD BOOK</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
            <script src="/webjars/jquery/3.6.0/jquery.min.js"></script>

            
    </head>
    
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-auto">
                    <h1>Add Book Details</h1>
                </div>
            </div>
        </div>
    
        <div class="container">
            <form id="addBookForm" method="post" action="/addData">
                <div class="mb-3">
                    <label class="form-label">Book Code</label>
                    <input type="text" class="form-control" name="code" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Book Name</label>
                    <input type="text" class="form-control" name="bookName" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Author</label>
                    <input type="text" class="form-control" name="authorName" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Added On</label>
                    <input type="text" class="form-control" readonly id="date" name="date">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="button" class="btn btn-danger" id="cancelBtn">Cancel</button>
            </form>
        </div>
    </body>
    <script>
        var today = new Date().toISOString().substr(0, 10);
        document.getElementById("date").value = today;
        
        const cancelBtn = document.getElementById('cancelBtn');    
        cancelBtn.addEventListener('click', () => {
            // Go back to the previous page
            window.history.back();
        });
    </script>
    </html>