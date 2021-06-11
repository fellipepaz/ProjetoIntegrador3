<%-- 
    Document   : index
    Created on : 16/05/2021, 00:22:11
    Author     : thiag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Inicio</title>
    </head>
    <body>
        <div class="app">
        <div id="content" style="flex-direction: column; background-color: white;">
            <div class="row">
                <h2 class="text-center">ADEGA'S TI</h2>
            </div>
            <div class="row">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item active" aria-current="page">Inicio</li>
                        <li class="breadcrumb-item active" aria-current="page"><a href="venda/vendas.jsp">Vendas</a></li>
                        <li class="breadcrumb-item active" aria-current="page"><a href="estoque/cadastrar.jsp">Cadastrar Estoque</a></li>
                        <li class="breadcrumb-item active" aria-current="page"><a href="ListarEstoque">Listar Estoque</a></li>
                        <li class="breadcrumb-item active" aria-current="page"><a href="clientes/cliente.jsp">Cadastro Cliente</a></li>
                        <li class="breadcrumb-item active" aria-current="page"><a href="ListarCliente">Listar Clientes</a></li>
                        <li class="breadcrumb-item active" aria-current="page"><a href="relatorio/relatorios.jsp">Relatorios</a></li>
                    </ol>
                </nav>
            </div>

        </div>
    </body>
</html>