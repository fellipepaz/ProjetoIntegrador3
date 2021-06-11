
package br.senac.servlet;

import br.senac.adega.DAO.RelatorioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RelatorioPorFilial", urlPatterns = {"/RelatorioPorFilial"})
public class RelatorioPorFilial extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idFilial = Integer.parseInt(request.getParameter("idFilial"));
        String dateForm1 = request.getParameter("dataInicio");
        String dateForm2 = request.getParameter("dataFim");
        Date dataInicio = Date.valueOf(dateForm1);
        Date dataFim = Date.valueOf(dateForm2);

        double valor = RelatorioDAO.getFilial(idFilial, dataInicio, dataFim);
        int quantidade = RelatorioDAO.getFilialQuantidade(idFilial, dataInicio, dataFim);

        request.setAttribute("valor", valor);
        request.setAttribute("quantidade", quantidade);

        request.getRequestDispatcher("/listarVendasCliente.jsp").forward(request, response);
    }
}
