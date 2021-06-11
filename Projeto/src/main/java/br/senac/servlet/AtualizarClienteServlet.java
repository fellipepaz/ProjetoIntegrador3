
package br.senac.servlet;

import br.senac.adega.DAO.ClienteDAO;
import br.senac.adega.entity.Cliente;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarClienteServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente produto = ClienteDAO.getCliente(idCliente);
        
        request.setAttribute("cliente", produto);
        request.getRequestDispatcher("/clientes/cliente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idCliente"));
        String nome = request.getParameter("nome");
        int cpf = Integer.parseInt(request.getParameter("cpf"));
        String email = request.getParameter("email");
        int cep = Integer.parseInt(request.getParameter("cep"));
        int numero = Integer.parseInt(request.getParameter("numero"));
        String dataCadastro = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataCadastro);
        
        Cliente clientes = new Cliente(id, nome, cpf, email, cep, numero, data);
        
        boolean ok = ClienteDAO.atualizar(clientes);
        
        if (ok) {
            response.sendRedirect("sucesso.jsp");
        }else{
            response.sendRedirect("erro.jsp");
        }
    }
}