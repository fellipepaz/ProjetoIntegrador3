
package br.senac.servlet;
/**
 *
 * @author thiag
 */
import br.senac.adega.DAO.ProdutoDAO;
import br.senac.adega.DAO.VendasDAO;
import br.senac.adega.entity.Produto;
import br.senac.adega.entity.Vendas;
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
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        String produto = request.getParameter("produto");
        String categoria = request.getParameter("categoria");
        int idFilial = Integer.parseInt(request.getParameter("idFilial"));
        double valor = Double.parseDouble(request.getParameter("valor"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String dataCadastro = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataCadastro);
         
        double valorTotal = valor * quantidade;
        
        System.out.println("id do cliente no servlet: " + idCliente); 
       
        /*Produto produtos = new Produto(idProduto, produto, categoria, idFilial, valorTotal, quantidade, data);
        int IdProduto = ProdutoDAO.inserir(produtos);*/
        
        Vendas venda = new Vendas(0, idCliente, idProduto, quantidade, valor, valorTotal);
        venda.setDatavenda(data);
        boolean okVenda = VendasDAO.cadastrar(venda);
        
        if(okVenda){
          request.getRequestDispatcher("../sucesso.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("../erro.jsp").forward(request, response);
        }
    }
}
