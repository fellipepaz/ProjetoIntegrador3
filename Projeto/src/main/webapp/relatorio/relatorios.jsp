<%-- 
    Document   : relatorios
    Created on : 16/05/2021, 14:27:22
    Author     : thiag
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Relatórios</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h2 class="text-center">Relatórios</h2>
            </div>
            <div class="container">
                <div class="row col-md-10 mx-auto flex-row">
                        <nav class="breadcrumb">
                            <ol class="breadcrumb">
                            <li class="breadcrumb-item active" aria-current="page"><a href="../index.jsp">Inicio</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="../venda/vendas.jsp">Vendas</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="../produtos/produtos.jsp">Cadastro Produtos</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="../clientes/cliente.jsp">Cadastro Clientes</a></li>
                            </ol>
                        </nav>
                </div>
            </div>

                <div class="container">    
                    <div class="row col-md-10 mx-auto flex-row ">
                        <div class="form-group col-md-2 pr-3">
                            <button type="submit" class="btn shadow-lg rounded" style="width:320px; background-color:#B0C4DE"><a href= ".../relatorio/relatorioCliente.jsp" style="text-decoration: none" color="black">Relatório por cliente</a></button><br></br>
                            <button type="submit" class="btn shadow-lg rounded" style="width:320px; background-color:#B0C4DE"><a href= ".../relatorio/relatorioFilial.jsp" style="text-decoration: none" color="black">Relatório por filial</a></button><br></br>
                            <button type="submit" class="btn shadow-lg rounded" style="width:320px; background-color:#B0C4DE"><a href= ".../relatorio/relatorioProduto.jsp" style="text-decoration: none" color="black">Relatório por produto</a></button>
                        </div>
                    </div>
                </div>
            </div>
    </body>
</html>
