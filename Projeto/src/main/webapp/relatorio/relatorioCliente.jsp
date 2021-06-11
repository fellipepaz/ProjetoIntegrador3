<%-- 
    Document   : relatorioCliente
    Created on : 11/06/2021, 00:41:59
    Author     : thiag
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Relatório por Clientes</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h2 class="text-center">Relatório por Cliente</h2>
            </div>

            <div class="row">
                <div class="col">
                    <form action="CarregarDadosServlet" method="POST">
                        <div class="row">
                            <div class="col-10">
                                <div class="col">
                                    <table class="table table-hover">
                                        <th>ID do Cliente</th>
                                        <th>Nome</th>
                                        <th>CPF</th>
                                        <th>E-mail</th>
                                        <th>CEP</th>
                                        <th>numero</th>
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
                            <div class="col-2">
                                <div class="row mt-2">
                                    <input type="submit" value="Dados do cliente" class="btn shadow-lg rounded" style="width:820px; background-color:#B0C4DE">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <form action="RelatorioClienteServlet" method="POST">
                <div class="row mt-4">
                    <div class="col-12">
                        <h1 style="font-size: 28px; font-family: Helvetica">Digite o ID do cliente</h1>
                    </div> 
                </div>
                <div class="row ">
                    <div class="col">
                        <input type="text" class="form-control" name="idCliente" required="true" placeholder="ID do cliente"><br></br>
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
                        <button type="submit" class="btn shadow-lg rounded" style="width:220px; background-color:#B0C4DE">Listar relatório pelo cliente</button>
                    </div>
                </div>
            </form>
            <div><br><button type="submit" class="btn shadow-lg rounded" style="width:80px; background-color:#B0C4DE"><a href="<c:url value="../relatorio/relatorios.jsp"/>" style="text-decoration: none">Voltar</a></br></div>
        </div>
    </body>
</html>
