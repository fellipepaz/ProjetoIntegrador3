<%-- 
    Document   : vendas
    Created on : 16/05/2021, 14:30:16
    Author     : thiag
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Vendas</title>
    </head>
    <body class="container">
        <div class="app">
            <div id="content" style="flex-direction: column; background-color: white;">
                <div class="row">
                    <h2 class="text-center">Vendas</h2>
                </div>
                <div class="row">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item active" aria-current="page"><a href="../index.jsp">Inicio</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="../produtos/produtos.jsp">Cadastro Produtos</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="../clientes/cliente.jsp">Cadastro Cliente</a></li>
                            <li class="breadcrumb-item active" aria-current="page"><a href="../relatorio/relatorios.jsp">Relatorios</a></li>
                        </ol>
                    </nav>
                </div>
                
                <div class="row">
                    <div class="col">
                        <form action="CarregarDadosServlet" method="POST">
                        <div class="row">
                            <div class="col-10">
                                <div class="row">
                                    <div class="col">
                                        <table class="table table-hover">
                                            <th>ID do Cliente</th>
                                            <th>Nome</th>
                                            <th>Email</th>
                                            <th>CPF</th>
                                            <th>CEP</th>
                                            <th>Telefone</th>
                                            <th>Sexo</th>
                                            <th>Data de Cadastro</th>

                                            <c:forEach items="${cliente}" var="cliente">
                                                <tr>
                                                    <td>${cliente.idCliente}</td>
                                                    <td>${cliente.nome}</td>
                                                    <td>${cliente.cpf}</td>
                                                    <td>${cliente.email}</td>
                                                    <td>${cliente.cep}</td>
                                                    <td>${cliente.numero}</td>
                                                    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataCadastro}"/></td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <table class="table table-hover">
                                            <th>ID do Produto</th>
                                            <th>Nome do Produto</th>
                                            <th>Categoria</th>
                                            <th>ID da Filial</th>
                                            <th>Quantidade</th>
                                            <th>Valor</th>
                                            <th>Data de Cadastro</th>

                                            <c:forEach items="${listaProdutos}" var="produto">
                                                <tr>
                                                    <td>${produto.idProduto}</td>
                                                    <td>${produto.produto}</td>
                                                    <td>${produto.categoria}</td>
                                                    <td>${produto.idFilial}</td>
                                                     <td>${produto.quantidade}</td>
                                                    <td>${produto.valor}</td>
                                                    <td>${produto.dataCadastro}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-2">
                                <div class="row mt-2">
                                    <input type="submit" value="Carregar Dados" class="btn btn-primary shadow-lg rounded">
                                </div>
                            </div>
                        </div>
                    </form>
                    </div>
                </div>
                
                <div class="row mt-5">
                    <div class="col">
                    <form action ="VenderProdutoServlet" method="POST">
                        ID do cliente: <input type="text" name="idCliente"><br />
                        ID do Produto: <input type="text" name="idProduto"><br />
                        <br /><br />
                        <div class="form-group col-md-2 pr-3">
                            <button type="submit" class="btn btn-small btn-dark">Realizar Venda</button>
                        </div>
                    </form>
                    </div>
                </div>
                
                <div class="row mx-auto flex-row col-md-10 mt-5">
                    <button type="submit" class="btn btn-small btn-dark"><a href="<c:url value="/index.jsp"/>">Voltar</a></button>
                </div>
            </div>
    </body>
</html>
