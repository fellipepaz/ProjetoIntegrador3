<%-- 
    Document   : produtos
    Created on : 16/05/2021, 14:10:59
    Author     : thiag
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Cadastro produtos</title>
    </head>
    <body>
        <div class="container">
                <div class="row">
                    <h2 class="text-center">Produtos</h2>
                </div>
            <div class="container">
                <div class="row col-md-10 mx-auto flex-row">
                        <nav class="breadcrumb">
                            <ol class="breadcrumb">
                            <li class="breadcrumb-item active" aria-current="page"><a href="../index.jsp">Inicio</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="../venda/vendas.jsp">Vendas</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="../clientes/cliente.jsp">Cadastro Clientes</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="../relatorio/relatorios.jsp">Relatorios</a></li>
                            </ol>
                        </nav>
                </div>
            </div>
            
                <div class="container">
                    <div class="row col-md-10 mx-auto flex-row ">
                        <c:if test="${not empty produto}">
                            <form action="CadastrarProduto" method="POST">
                                <input type="text" name="idProduto" hidden="true" value="${produto.idProduto}">
                                <label class="form-label">ID do Cliente</label><br>
                                <input type="text" class="form-control" name="idCliente" value="${cliente}" readonly="true">
                                <label>Nome do Produto</label>
                                <input type="text" class="form-control" name="produto" value="${produto.produto}">
                                <label>Categoria</label>
                                <input type="text" class="form-control" name="categoria" value="${produto.categoria}">
                                <label>ID da Filial</label>
                                <input type="text" class="form-control" name="idFilial" value="${produto.idFilial}" readonly="true">
                                <label>Valor</label>
                                <input type="text" class="form-control" name="valor" value="${produto.valor}">
                                <label>Quantidade</label>
                                <input type="text" class="form-control" name="quantidade" value="${produto.quantidade}">
                                <label>Data de Cadastro</label>
                                <input type="date" class="form-control" name="dataCadastro" value="${produto.dataCadastro}"><br>
                                <button type="submit" class="btn btn-small btn-dark">Cadastrar Produto</button>
                            </form>
                        </c:if>
                    </div>
                </div>
            
                <div class="row mx-auto flex-row col-md-10 mt-5">
                    <button type="submit" class="btn btn-small btn-dark"><a href="<c:url value="/index.jsp"/>">Voltar</a></button>
                </div>
            </div>
        </body>
    </html>

