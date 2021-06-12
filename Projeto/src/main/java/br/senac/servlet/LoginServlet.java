package br.senac.servlet;

import br.senac.adega.DAO.UsuarioDAO;
import br.senac.adega.entity.Usuario;
import br.senac.utils.CryptoUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senhaAberta = request.getParameter("senha");
        
        Usuario usuario = UsuarioDAO.getUsuarioLogin(login);
        Usuario usuarioSenha = UsuarioDAO.getUsuarioLoginSenha(login, senhaAberta);
        
        if(usuarioSenha != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect(request.getContextPath() + "/protegido/index.jsp");
        }
        
//        if (usuario == null) {
//            response.sendRedirect(request.getContextPath() + "/index.jsp?loginInvalido=true");
//        } else {
//            boolean senhaOK = CryptoUtils.verificarSenha(senhaAberta, usuario.getSenha());
//            if (senhaOK) {
//                HttpSession sessao = request.getSession();
//                sessao.setAttribute("usuario", usuario);
//                if (sessao.getAttribute("usuario") == usuario.isAdmin()) {
//                    
//                }
//            } else{
//                response.sendRedirect(request.getContextPath() + "/index.jsp?loginInvalido=true");
//            }
//        }
    }
}
