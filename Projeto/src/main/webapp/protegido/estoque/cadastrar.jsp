<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <title>Cadastrar Estoque</title>
    </head>
    <body>
        <div class="container">
                <div class="row">
                    <h2 class="text-center">Estoque</h2>
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
            <!-- 
            <div class="row">
                <div class="col">
                    <form action="CarregarFilialServlet" method="POST">
                        <div class="row">
                            <div class="col-10">
                                <div class="row">
                                    <div class="col">
                                        <table class="table table-hover">
                                            <th>ID da Filial</th>
                                            <th>Nome da Filial</th>

                                            <c:forEach items="${filial}" var="filial">
                                                <tr>
                                                    <td>${filial.idFilial}</td>
                                                    <td>${filial.nome}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-2">
                                <div class="row mt-2">
                                    <input type="submit" value="Carregar Filiais" class="btn btn-primary shadow-lg rounded">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            -->
                <div class="container mt-3">
                    <div class="row col-md-10 mx-auto flex-row ">
                        <c:if test="${empty produto}">
                            <form action="CadastrarEstoque" method="POST">
                                    <input type="text" class="form-control" hidden="true" name="idProduto">
                                    <label>Nome do Produto</label>
                                    <input type="text" class="form-control" name="produto" >
                                    <label>Categoria</label>
                                    <div>
                                        <select name="categoria" class="form-control" required="true">
                                            <option value="">Selecione</option>
                                            <option value="Bebida Alcólica">Bebida Alcólica</option>
                                            <option value="Bebida Gaseificada">Bebida Gaseificada</option>
                                            <option value="Bebida Natural">Bebida Natural</option>
                                            <option value="Souvenir">Souvenir</option>
                                        </select>
                                    </div>
                                    <label>Filial</label>
                                    <div>
                                        <select name="idFilial" class="form-control" required="true">
                                            <option value="">Selecione</option>
                                            <option value="1">SP</option>
                                            <option value="2">MG</option>
                                            <option value="3">GO</option>
                                        </select>
                                    </div>
                                    <label>Valor</label>
                                    <input type="text" class="form-control" name="valor" >
                                    <label>Quantidade</label>
                                    <input type="text" class="form-control" name="quantidade" >
                                    <label>Data de Cadastro</label>
                                    <input type="date" class="form-control" name="dataCadastro" ><br>
                                    
                                <button type="submit" class="btn btn-small btn-dark">Cadastrar Produto</button>
                            </form>
                        </c:if>
                        <c:if test="${not empty produto}">
                            <form action="AlterarEstoqueServlet" method="POST">
                                    <input type="text" class="form-control" hidden="true" name="idProduto" value="${produto.idProduto}">
                                    <label>Nome do Produto</label>
                                    <input type="text" class="form-control" name="produto" value="${produto.produto}">
                                    <label>Categoria</label>
                                    <div>
                                        <select name="categoria" class="form-control" required="true">
                                            <option value="">Selecione</option>
                                            <option value="Bebida Alcólica">Bebida Alcólica</option>
                                            <option value="Bebida Gaseificada">Bebida Gaseificada</option>
                                            <option value="Bebida Natural">Bebida Natural</option>
                                            <option value="Souvenir">Souvenir</option>
                                        </select>
                                    </div>
                                    <label>Filial</label>
                                    <div>
                                        <select name="idFilial" class="form-control" reandoly="true">
                                            <option value="${produto.idFilial}">${produto.idFilial}</option>
                                        </select>
                                    </div>
                                    <label>Valor</label>
                                    <input type="text" class="form-control" name="valor" value="${produto.valor}">
                                    <label>Quantidade</label>
                                    <input type="text" class="form-control" name="quantidade" value="${produto.quantidade}">
                                    <label>Data de Cadastro</label>
                                    <input type="date" class="form-control" name="dataCadastro" value="${produto.dataCadastro}"><br>
                                    
                                <button type="submit" class="btn btn-small btn-dark">Alterar Produto</button>
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
