<%-- 
    Document   : cliente
    Created on : 16/05/2021, 00:02:29
    Author     : thiag
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Cadastro cliente</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h2 class="text-center">Clientes</h2>
            </div>
            <div class="container">
                <div class="row col-md-10 mx-auto flex-row">
                    <nav class="breadcrumb">
                        <ol class="breadcrumb">
                        <li class="breadcrumb-item active" aria-current="page"><a href="../index.jsp">Inicio</a></li>
                        <li class="breadcrumb-item active" aria-current="page"><a href="../venda/vendas.jsp">Vendas</a></li>
                        <li class="breadcrumb-item active" aria-current="page"><a href="../produtos/produtos.jsp">Cadastro Produtos</a></li>
                        <li class="breadcrumb-item active" aria-current="page"><a href="../relatorio/relatorios.jsp">Relatorios</a></li>
                        </ol>
                    </nav>
                
                </div>
            
            </div>
            
            <div class="container">
                <div class="row col-md-10 mx-auto flex-row ">
                    <c:if test="${empty cliente}">
                        <form action="CadastrarClienteServlet" method="POST">
                            <label>Nome</label>
                            <input type="text" name="nome" class="form-control">
                            <label>CPF</label>
                            <input type="text" name="cpf" class="form-control">
                            <label>E-mail</label>
                            <input type="text" name="email" class="form-control">
                            <label>CEP</label>
                            <input type="text" name="cep" class="form-control">
                            <label>Número</label>
                            <input type="text" name="numero" class="form-control">
                            <label>Data de Cadastro</label>
                            <input type="date" class="form-control" name="dataCadastro"><br>
                            <button type="submit" class="btn btn-small btn-dark">Cadastrar Cliente</button>
                        </form>
                    </c:if>
                    <c:if test="${not empty cliente}">
                          <form action="AtualizarClienteServlet" method="POST">
                            <input type="text" name="idCliente" hidden="true" value="${cliente.idCliente}">
                            <label>Nome</label>
                            <input type="text" name="nome" class="form-control" value="${cliente.nome}">
                            <label>CPF</label>
                            <input type="text" name="cpf" class="form-control" value="${cliente.cpf}">
                            <label>E-mail</label>
                            <input type="text" name="email" class="form-control" value="${cliente.email}">
                            <label>CEP</label>
                            <input type="text" name="cep" class="form-control" value="${cliente.cep}">
                            <label>Número</label>
                            <input type="text" name="numero" class="form-control" value="${cliente.numero}">
                            <label>Data de Cadastro</label>
                            <input type="date" class="form-control" name="dataCadastro" class="form-control" value="${cliente.dataCadastro}"><br>
                            
                            <button type="submit" class="btn btn-small btn-dark">Atualizar Cliente</button>
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
 