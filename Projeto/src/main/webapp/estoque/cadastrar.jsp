<%-- 
    Document   : cadastrar
    Created on : 10/06/2021, 16:51:11
    Author     : wmdbox
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Estoque</title>
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
                            <form action="CadastrarEstoque" method="POST">
                                    <!--<label>IdProduto</label>
                                    <input type="text" class="form-control" id="id">-->
                                    <label>Nome do Produto</label>
                                    <input type="text" class="form-control" name="produto">
                                    <label>Categoria</label>
                                    <input type="text" class="form-control" name="categoria">
                                    <label>ID da Filial</label>
                                    <input type="text" class="form-control" name="idFilial">
                                    <label>Valor</label>
                                    <input type="text" class="form-control" name="valor">
                                    <label>Quantidade</label>
                                    <input type="text" class="form-control" name="quantidade">
                                    <label>Data de Cadastro</label>
                                    <input type="date" class="form-control" name="dataCadastro"><br>
                                <button type="submit" class="btn btn-small btn-dark">Cadastrar Produto</button>
                            </form>
                    </div>
                </div>
            
                <div class="row mx-auto flex-row col-md-10 mt-5">
                    <button type="submit" class="btn btn-small btn-dark"><a href="<c:url value="/index.jsp"/>">Voltar</a></button>
                </div>
            </div>
    </body>
</html>
