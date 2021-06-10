
package br.senac.servlet;
/**
 *
 * @author thiag
 */
import br.senac.adega.DAO.ProdutoDAO;
import br.senac.adega.entity.Produto;
import java.io.IOException;
import java.sql.Date;
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
        String produto = request.getParameter("produto");
        String categoria = request.getParameter("categoria");
        int idFilial = Integer.parseInt(request.getParameter("idFilial"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String dataCadastro = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataCadastro);
        
        Produto produtos = new Produto(0, produto, categoria, idFilial, valor, quantidade, data);
        boolean ok = ProdutoDAO.inserir(produtos);
        
        if(ok){
            response.sendRedirect("../sucesso.jsp");
        }else{
            response.sendRedirect("../erro.jsp");
        }
        
    }

}
