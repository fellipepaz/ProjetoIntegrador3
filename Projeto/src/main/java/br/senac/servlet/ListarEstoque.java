package br.senac.servlet;

import br.senac.adega.DAO.EstoqueDAO;
import br.senac.adega.entity.Estoque;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ListarEstoque extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Estoque> listaProdutos;
        listaProdutos = EstoqueDAO.listar();
        request.setAttribute("listaProdutos", listaProdutos);
        request.getRequestDispatcher("/estoque/listarEstoque.jsp").forward(request, response);
    }
}