
package br.senac.servlet;

import br.senac.adega.DAO.EstoqueDAO;
import br.senac.adega.entity.Estoque;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thiag
 */
public class VenderProdutoServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        Estoque produto = EstoqueDAO.getEstoque(idProduto);
        request.setAttribute("produto", produto);
        request.setAttribute("cliente", idCliente);
        request.getRequestDispatcher("/produtos/produtos.jsp").forward(request, response);
    }
}
