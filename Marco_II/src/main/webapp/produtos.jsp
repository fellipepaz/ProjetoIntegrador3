<%-- 
    Document   : produtos
    Created on : 16/05/2021, 14:10:59
    Author     : thiag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro produtos</title>
    </head>
    <body>
        <div class="app">
            <div id="content" style="flex-direction: column; background-color: white;">
                <div class="row">
                    <h2 class="text-center">Produtos</h2>
                </div>
                <div class="row">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active" aria-current="page"><a href="index.jsp">Inicio</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="vendas.jsp">Vendas</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Cadastro Produtos</li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="cliente.jsp">Cadastro Cliente</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="relatorios.jsp">Relatorios</a></li>

                        </ol>
                    </nav>
                </div>

                <div class="container">    
                    <div class="row col-md-10 mx-auto flex-row ">
                        <div class="form-group col-md-2 pr-3">
                            <label>Nome do Produto</label>
                            <input type="text" class="form-control" id="idProduto">
                            <div><label>Valor</label>
                                <input type="text" class="form-control" id="idValor">
                                <label>Quantidade</label>
                                <input type="text" class="form-control" id="idQuant"></div>

                        </div>
                        <div class="form-group col-md-2 pr-3">
                            <button type="submit" class="btn btn-small btn-dark">Cadastrar</button>
                            <button type="submit" class="btn btn-small btn-dark">Pesquisar</button>
                        </div>
                    </div>
                </div>
                </body>
                </html>
