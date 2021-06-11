
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Lista de Clientes</title>
        
        <script>
            function mostrarTelaConfirmacao(nome, id){
                $("#nomeCliente").html(nome);
                $("#idCliente").val(id);
                
                var modalConfirmacao = $("#modalConfirmacao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao(){
                $("#modalConfirmacao").hide();
            }
            
            function deletarProduto(){
                var id = $("#idCliente").val();
                fecharTelaConfirmacao();
                $.ajax( "ExcluirClienteServlet?idCliente=" + id).done(function() {
                    location.reload();
                })
                .fail(function() {
                    console.log( "error" );
                    $("#alerta").css("display", "block");
                    setTimeout(function(){
                        $("#alerta").css("display", "none");
                    }, 2000);
                });
            }
        </script>
    </head>
    <body class="container">
        <div class="alert alert-danger" role="alert" id="alerta" style="display: none">
            Erro ao excluir o cliente!
        </div>
        
        <table class="table table-hover">
            <th>ID</th>
            <th>Nome do Cliente</th>
            <th>CPF</th>
            <th>Email</th>
            <th>CEP</th>
            <th>Número</th>
            <th>Data de Cadastro</th>
            
            <c:forEach items="${listaClientes}" var="cliente">
                <tr>
                    <td>${cliente.idCliente}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.cpf}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.numero}</td>
                    <td>${cliente.cep}</td>
                    <td>${cliente.dataCadastro}</td>
                    
                    <td><a href="AtualizarClienteServlet?idCliente=${cliente.idCliente}" class="btn btn-primary shadow-lg rounded">Alterar</a></td>
                    <td><button type="button" class="btn btn-primary shadow-lg rounded" onclick="mostrarTelaConfirmacao('${cliente.nome}', '${cliente.idCliente}')">Excluir</button></td>
                </tr>
            </c:forEach>
        </table>

         <!-- Modal -->
        <div class="modal" id="modalConfirmacao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                  <p>Produto: <label id="nomeCliente"></label> <br>Confirmar exclusão do produto?</p>
                  <input type="hidden" id="idCliente" />
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                <button type="button" class="btn btn-primary" onclick="deletarProduto()">Confirmar</button>
              </div>
            </div>
          </div>
        </div>
    </body>
</html>
