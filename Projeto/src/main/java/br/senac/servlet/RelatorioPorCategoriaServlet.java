
package br.senac.servlet;

import br.senac.adega.DAO.RelatorioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RelatorioPorCategoriaServlet extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoria = request.getParameter("categoria");
        String dateForm1 = request.getParameter("dataInicio");
        String dateForm2 = request.getParameter("dataFim");
        Date dataInicio = Date.valueOf(dateForm1);
        Date dataFim = Date.valueOf(dateForm2);

        double valor = RelatorioDAO.getCategoria(categoria, dataInicio, dataFim);
        int quantidade = RelatorioDAO.getCategoriaQuantidade(categoria, dataInicio, dataFim);

        request.setAttribute("valor", valor);
        request.setAttribute("quantidade", quantidade);

        request.getRequestDispatcher("/listarVendas.jsp").forward(request, response);
    }
}
