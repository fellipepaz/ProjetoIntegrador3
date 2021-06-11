<%-- 
    Document   : relatorioFilial
    Created on : 11/06/2021, 00:42:31
    Author     : thiag
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Relatório por Filial</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h2 class="text-center">Relatório por Filial</h2>
            </div>

            <div class="row">
                <div class="col">
                    <form action="CarregarDadosServlet" method="POST">
                        <div class="row">
                            <div class="col-10">
                                <div class="col">
                                    <table class="table table-hover">
                                        <th>Nome da Filial</th>
                                        <th>Data de Cadastro</th>

                                        <c:forEach items="${produtos.idFilial}" var="filial">
                                            <tr>
                                                <td>${filial.nomeFilial}</td>
                                                <td>${filial.dataCadastro}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>

                            <div class="col-2">
                                <div class="row mt-2">
                                    <input type="submit" value="Dados da filial" class="btn shadow-lg rounded" style="width:150px; background-color:#B0C4DE">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <form action="RelatorioFilialServlet" method="POST">
                <div class="row mt-4">
                    <div class="col-12">
                        <h1 style="font-size: 28px; font-family: Helvetica">Digite o estado da filial</h1>
                    </div> 
                </div>
                <div class="row ">
                    <div class="col">
                        <input type="text" class="form-control" name="nomeFilial" required="true" placeholder="Nome da filial"><br></br>
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
                        <button type="submit" class="btn shadow-lg rounded" style="width:220px; background-color:#B0C4DE">Listar relatório pela filial</button>
                    </div>
                </div>
            </form>
            <div><br><button type="submit" class="btn shadow-lg rounded" style="width:80px; background-color:#B0C4DE"><a href="<c:url value="../relatorio/relatorios.jsp"/>" style="text-decoration: none">Voltar</a></br></div>
        </div>
    </body>
</html>
