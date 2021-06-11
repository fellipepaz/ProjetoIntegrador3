package br.senac.servlet;

import br.senac.adega.DAO.FilialDAO;
import br.senac.adega.entity.Filial;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarregarFilialServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Filial> listaFiliais = FilialDAO.getFiliais();
        request.setAttribute("filial", listaFiliais);
        request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
    }
}
