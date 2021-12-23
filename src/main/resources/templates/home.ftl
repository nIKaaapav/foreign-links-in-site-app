<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>People list</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>

<div class="container">

    <form style="margin-top: 30px; margin-bottom: 30px;" action="/" method="post">
        <div class="form-group">
            <label for="link">Link:</label>
            <input type="text" class="form-control" name="link" id="link" required>
        </div>
        <button style="margin-top: 10px;" type="submit" class="btn btn-primary">Submit</button>
    </form>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Link</th>
            <th scope="col"/>
        </tr>
        </thead>
        <tbody>
            <#list links as row>
                <tr>
                        <th scope="row">${row.id}</th>
                        <td>${row.link}</td>
                        <td><a href="/link?url=${row.link}">View links</a></td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>

</body>
</html>

