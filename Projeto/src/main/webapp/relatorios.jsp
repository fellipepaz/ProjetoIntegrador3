<%-- 
    Document   : relatorios
    Created on : 16/05/2021, 14:27:22
    Author     : thiag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorios</title>
    </head>
    <body>
        <div class="app">
            <div id="content" style="flex-direction: column; background-color: white;">
                <div class="row">
                    <h2 class="text-center">Relatórios</h2>
                </div>
                <div class="row">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active" aria-current="page"><a href="index.jsp">Inicio</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="vendas.jsp">Vendas</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="produtos.jsp">Cadastro Produtos</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="cliente.jsp">Cadastro Cliente</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Relatorios</li>

                        </ol>
                    </nav>
                </div>

                <div class="container">    
                    <div class="row col-md-10 mx-auto flex-row ">
                        <div class="form-group col-md-2 pr-3">
                            <label>Nome do Cliente</label>
                            <input type="text" class="form-control" id="idCliente">
                            <div><label>Produto</label>
                                <input type="text" class="form-control" id="idProduto">
                                <label>Filial</label>
                                <input type="text" class="form-control" id="idFilial"></div>

                        </div>
                        <button type = "submit" class="btn btn-small btn-dark">Pesquisar</button>
                    </div>
                </div>
            </div>
    </body>
</html>