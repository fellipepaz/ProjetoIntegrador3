<%-- 
    Document   : vendas
    Created on : 16/05/2021, 14:30:16
    Author     : thiag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendas</title>
    </head>
    <body>
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
                <form action ="VenderProdutoServlet" method="POST">
                    ID do cliente: <input type="text" name="nome"><br />
                    ID do Produto: <input type="text" name="produto"><br />
                    Quantidade <input type="text" name="quantidade"><br />
                    Valor: <input type="text" name="valor"><br />
                    Data da venda: <input type="date" name="date"><br />
                    <br /><br />
                    <div class="form-group col-md-2 pr-3">
                        <button type="submit" class="btn btn-small btn-dark">Vender</button>
                    </div>
                </form>
            </div>
    </body>
</html>