package br.senac.servlet;

import br.senac.adega.DAO.ClienteDAO;
import br.senac.adega.DAO.EstoqueDAO;
import br.senac.adega.entity.Cliente;
import br.senac.adega.entity.Estoque;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarregarDadosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Estoque> listaProdutos = EstoqueDAO.listar();
        List<Cliente> listaClientes = ClienteDAO.getClientes();
        
        request.setAttribute("listaProdutos", listaProdutos);
        request.setAttribute("cliente", listaClientes);
        
        request.getRequestDispatcher("vendas.jsp").forward(request, response);
    }
}