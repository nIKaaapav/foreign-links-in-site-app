<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body style="background-color: #f5f5f5;">

<div class="col-4 offset-4">
    <a href="/" style="color: red" class="badge badge-secondary">To home</a>

    <div style="display: flex; margin-bottom: 30px; margin-top: 30px; justify-content: space-between;">
        <p>Total</p> <p>${total}</p>
    </div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Link</th>
            <th scope="col">Level</th>
            <th scope="col">Counts foreign links</th>
        </tr>
        </thead>
        <tbody>
        <#list links as row>
        <tr>
            <th scope="row">${row?counter}</th>
            <td>${row.link}</td>
            <td>${row.level}</td>
            <td>${row.countsForeignLinks}</td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>

</body>
</html>
