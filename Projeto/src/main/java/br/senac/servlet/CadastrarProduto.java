
package br.senac.servlet;
/**
 *
 * @author thiag
 */
import br.senac.adega.DAO.ProdutoDAO;
import br.senac.adega.entity.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastrarProduto extends HttpServlet { 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt (request.getParameter("id"));
        String produto = request.getParameter("produto");
        String filial = request.getParameter("filial");
        double valor = Double.parseDouble(request.getParameter("valor"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        
        Produto produtos = new Produto(id, produto, filial, valor, quantidade);
        boolean ok = false;
        try {
            ok = ProdutoDAO.inserir(produtos);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(ok){
            response.sendRedirect("sucesso.jsp");
        }else{
            response.sendRedirect("erro.jsp");
        }
        
    }

}
