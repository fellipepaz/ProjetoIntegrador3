
package br.senac.adega.DAO;

import br.senac.adega.entity.Filial;
import br.senac.sp.conexaobd.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilialDAO {
    
    public static List<Filial> getFiliais(){
        List<Filial> lista = new ArrayList();
        String query = "select * from filial";
        Connection con;
        try{
            con = Conexao.getConexao();
            PreparedStatement comando = con.prepareStatement(query);
            ResultSet dados = comando.executeQuery();
            while(dados.next()){
               int idFilial = dados.getInt("idFilial");
               String nome = dados.getString("nome");
               Filial produtos = new Filial(idFilial, nome);
               lista.add(produtos); 
            }
        }catch (SQLException e){

        }
       
        return lista;
    }
}
