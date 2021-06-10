package br.senac.servlet;

import br.senac.adega.DAO.EstoqueDAO;
import br.senac.adega.entity.Estoque;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AlterarEstoqueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
        Estoque produto = EstoqueDAO.getEstoque(idProduto);
        
        request.setAttribute("produto", produto);
        request.getRequestDispatcher("/estoque/cadastrar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idProduto"));
        String produto = request.getParameter("produto");
        String categoria = request.getParameter("categoria");
        String filial = request.getParameter("filial");
        double valor = Double.parseDouble(request.getParameter("valor"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String dataCadastro = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataCadastro);
        
        Estoque produtos = new Estoque(id, produto, categoria, filial, valor, quantidade, data);
        
        boolean ok = EstoqueDAO.editar(produtos);
        if (ok) {
            response.sendRedirect("sucesso.jsp");
        }else{
            response.sendRedirect("erro.jsp");
        }
    }
}
