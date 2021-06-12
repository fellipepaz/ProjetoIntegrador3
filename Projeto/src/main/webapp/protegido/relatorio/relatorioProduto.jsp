<%-- 
    Document   : relatorioProduto
    Created on : 11/06/2021, 00:42:53
    Author     : thiag
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Relatório por Produtos</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h2 class="text-center">Relatório por Produtos</h2>
            </div>

            <div class="row">
                <div class="col">
                    <form action="CarregarDadosServlet" method="POST">
                        <div class="row">
                            <div class="col-10">
                                <div class="col">
                                    <table class="table table-hover">
                                        <th>ID do Produto</th>
                                        <th>Nome do Produto</th>
                                        <th>Categoria</th>
                                        <th>Nome da Filial</th>
                                        <th>Valor</th>
                                        <th>Quantidade</th>
                                        <th>Data de Cadastro</th>

                                        <c:forEach items="${produtos}" var="produto">
                                            <tr>
                                                <td>${produto.idProduto}</td>
                                                <td>${produto.nomeProduto}</td>
                                                <td>${produto.categoria}</td>
                                                <td>${produto.nomeFilial}</td>
                                                <td>${produto.valor}</td>
                                                <td>${produto.quantidadeProduto}</td>
                                                <td>${produto.dataCadastro}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="row mt-2">
                                    <input type="submit" value="Dados do produto" class="btn shadow-lg rounded" style="width:150px; background-color:#B0C4DE">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <form action="RelatorioProdutoServlet" method="POST">
                <div class="row">
                    <div class="col">
                        <h1 style="font-size: 28px; font-family: Helvetica">Digite o tipo do produto</h1>
                    </div> 
                </div>
                <div class="row ">
                    <div class="col">
                        <input type="text" class="form-control" name="categoria" required="true" placeholder="Tipo do produto"><br></br>
                    </div>

                    <div class="row">
                        <div class="col">
                            <h1 style="font-size: 28px; font-family: Helvetica">Selecione uma Data Inicial</h1>
                        </div>
                        <div class="col">
                            <h1 style="font-size: 28px; font-family: Helvetica">Selecione uma Data Final</h1>
                        </div>

                        <div class="row">
                            <div class="col">
                                <input type="date" class="form-control" name="dataInicio" required="true"><br></br>
                            </div>
                            <div class="col">
                                <input type="date" class="form-control" name="dataFim" required="true">
                            </div>
                        </div>      
                    </div>

                    <div class="col">
                        <button type="submit" class="btn shadow-lg rounded" style="width:320px; background-color:#B0C4DE">Listar relatório pelo produto</button>
                    </div>
                </div>
            </form>
            <div><br><button type="submit" class="btn shadow-lg rounded" style="width:80px; background-color:#B0C4DE"><a href="<c:url value="../relatorio/relatorios.jsp"/>" style="text-decoration: none">Voltar</a></br></div>
        </div>
    </body>
</html>
