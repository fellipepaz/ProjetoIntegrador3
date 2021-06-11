
package br.senac.servlet;

import br.senac.adega.DAO.RelatorioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RelatorioPorClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String dateForm1 = request.getParameter("dataInicio");
        String dateForm2 = request.getParameter("dataFim");
        Date dataInicio = Date.valueOf(dateForm1);
        Date dataFim = Date.valueOf(dateForm2);

        int quantidade = RelatorioDAO.getCliente(idCliente, dataInicio, dataFim);
        double valor = RelatorioDAO.getClienteValor(idCliente, dataInicio, dataFim);


        request.setAttribute("quantidade", quantidade);

        request.getRequestDispatcher("/listarVendasCliente.jsp").forward(request, response);
    }
}
