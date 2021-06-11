
package br.senac.adega.DAO;

import br.senac.adega.entity.Vendas;
import br.senac.sp.conexaobd.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendasDAO {
    
    public static boolean cadastrar(Vendas venda){
        boolean ok = true;
        
        String query = "insert into vendas_produtos(idCliente, idProduto, quantidade_venda, valor, total, dataVenda) values (?, ?, ?, ?, ?, ?)";
        Connection con;
        System.out.println("id do cliente: "+venda.getIdcliente());
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, venda.getIdcliente());
            ps.setInt(2, venda.getIdProduto());
            ps.setInt(3, venda.getQuantidade());
            ps.setDouble(4, venda.getValor());
            ps.setDouble(5, venda.getValortTotal());
            ps.setDate(6, venda.getDatavenda());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }       
        return ok;
    }
}
