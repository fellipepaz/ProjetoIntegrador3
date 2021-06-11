package br.senac.servlet;

import br.senac.adega.DAO.ClienteDAO;
import br.senac.adega.entity.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> listaClientes;
        listaClientes = ClienteDAO.listar();
        request.setAttribute("listaClientes", listaClientes);
        request.getRequestDispatcher("/clientes/listarClientes.jsp").forward(request, response);
    }
}