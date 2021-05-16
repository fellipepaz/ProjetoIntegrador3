
import br.senac.adega.DAO.ClienteDAO;
import br.senac.adega.entity.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GeetingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        int cep = Integer.parseInt(request.getParameter("cep"));
        int num = Integer.parseInt(request.getParameter("num"));
        
        Cliente cliente = new Cliente(nome, cpf, email, cep, num);
        boolean ok = ClienteDAO.cadastrar(cliente);
        
        if(ok){
            response.sendRedirect("/sucesso.jsp");
        }else{
            response.sendRedirect("/erro.jsp");
        }
    }

}
