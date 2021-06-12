<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Tela de Login</title>
    </head>
    <body class="container">
        <h1 class="text-center">Login</h1>
        <form action="LoginServlet" mehotd="POST">
            <div class="form-group">
              <label for="exampleInputEmail1">Digite o seu login</label>
              <input type="text" class="form-control" name="login" aria-describedby="emailHelp" placeholder="Seu login"><br>
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Senha</label>
              <input type="password" class="form-control" name="senha" placeholder="Senha"><br>
            </div>
            
            <button type="submit" class="btn btn-primary" style = "background-color: #B0C4DE">Enviar</button>
        </form>
    </body>
</html>
