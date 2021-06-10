package br.senac.servlet;

import br.senac.adega.DAO.ProdutoDAO;
import br.senac.adega.entity.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarProdutos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produto> listaProdutos;
        try {
            listaProdutos = ProdutoDAO.listar();
            request.setAttribute("listaProdutos", listaProdutos);
            request.getRequestDispatcher("/produtos/listarProdutos.jsp").forward(request, response);
        } catch (Exception ex) {
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }
}