<%-- 
    Document   : cliente
    Created on : 16/05/2021, 00:02:29
    Author     : wmdbox
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <ol class="breadcrumb">
        <li class="breadcrumb-item active" aria-current="page"><a href="index.html">Inicio</a></li>
        <li class="breadcrumb-item active" aria-current="page"><a href="vendas.html">Vendas</a></li>
        <li class="breadcrumb-item active" aria-current="page"><a href="produtos.html">Cadastro Produtos</a></li>
        <li class="breadcrumb-item active" aria-current="page">Cadastro Cliente</li>
        <li class="breadcrumb-item active" aria-current="page"><a href="relatorios.html">Relatorios</a></li>
    </ol>
    <form action="CadastrarClienteServlet" method="POST">
        Nome: <input type="text" name="nome" ><br />
        CPF: <input type="text" name="cpf" ><br />
        E-mal: <input type="text" name="email" ><br />
        CEP: <input type="text" name="cep" ><br />
        Número: <input type="text" name="num" ><br />
        <br /><br />
        <div class="form-group col-md-2 pr-3">
            <button type="submit" class="btn btn-small btn-dark">Cadastrar Cliente</button>
        </div>
    </form>
    </body>
</html>
