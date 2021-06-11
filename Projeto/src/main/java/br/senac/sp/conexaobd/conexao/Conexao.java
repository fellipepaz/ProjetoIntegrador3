
package br.senac.sp.conexaobd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConexao() throws SQLException{
        String url = "jdbc:mysql://127.0.0.1:3306/pi_adega?useSSL=false";
        String user = "root";
        String pass = "";
        
        return DriverManager.getConnection(url,user,pass);
    }
}
