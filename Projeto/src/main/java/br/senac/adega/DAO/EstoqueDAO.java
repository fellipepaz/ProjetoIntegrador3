package br.senac.adega.DAO;

import br.senac.adega.entity.Estoque;
import java.sql.SQLException;
import br.senac.sp.conexaobd.conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstoqueDAO {
    
    public static boolean inserir(Estoque produtos){
        boolean ok = true;
        String sql = "INSERT INTO estoque (produto, categoria, filial, valor, quantidade, dataCadastro) VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conexao = Conexao.getConexao();
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, produtos.getProduto());
            comando.setString(2, produtos.getCategoria());
            comando.setString(3, produtos.getFilial());
            comando.setDouble(4, produtos.getValor());
            comando.setInt(5, produtos.getQuantidade());
            comando.setDate(6, produtos.getDataCadastro()); 
            comando.execute();
            
        }catch (SQLException e){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            ok = false;
        }
    return ok;

    }
    
    public static boolean excluir(int id){
        boolean ok = true;
        String sql = "DELETE FROM estoque WHERE idProduto = ?";
        Connection conexao;
        try{
            conexao = Conexao.getConexao();
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            comando.execute();
        }catch (SQLException e){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            ok = false;
        }
    return ok;
    }
    
    public static List<Estoque> listar(){
        String sql = "select * from estoque";
        Connection conexao;
        List<Estoque> lista = new ArrayList();
        try{
            conexao = Conexao.getConexao();
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet dados = comando.executeQuery();
            while(dados.next()){
               int id = dados.getInt("idProduto");
               String produto = dados.getString("produto");
               String categoria = dados.getString("categoria");
               String filial = dados.getString("filial");
               double valor = dados.getDouble("valor");
               int quantidade = dados.getInt("quantidade");
               Date dataCadastro = dados.getDate("dataCadastro");
               Estoque produtos = new Estoque(id, produto, categoria, filial, valor, quantidade, dataCadastro);
               lista.add(produtos); 
            }
        }catch (SQLException e){

        }
        
        return lista;
    }
    
    public static List<Estoque> pesquisar(String product) throws Exception{
        String sql = "SELECT * FROM estoque WHERE produto LIKE ?";
        
        Connection conexao = Conexao.getConexao();
        List<Estoque> lista = new ArrayList();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, "%" + product + "%");
            
            ResultSet dados = comando.executeQuery();
            
            while(dados.next()){
               
               int id = dados.getInt("id");
               String produto = dados.getString("produto");
               String categoria = dados.getString("categoria");
               String filial = dados.getString("filial");
               double valor = dados.getDouble("valor");
               int quantidade = dados.getInt("quantidade");
               Date dataCadastro = dados.getDate("dataCadastro");
               
               Estoque produtos = new Estoque(id, produto, categoria, filial, valor, quantidade, dataCadastro );
               lista.add(produtos); 
            }
            
        }catch (SQLException e){

        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static boolean editar(Estoque produtos){
        boolean ok = true;
        String sql = "UPDATE estoque SET produto = ?, categoria=?, filial = ?, valor = ?, quantidade = ?, dataCadastro=? WHERE idProduto = ?"; 
        
        Connection conexao;
        try{
            conexao = Conexao.getConexao();
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, produtos.getProduto());
            comando.setString(2, produtos.getCategoria());
            comando.setString(3, produtos.getFilial());
            comando.setDouble(4, produtos.getValor());
            comando.setInt(5, produtos.getQuantidade());
            comando.setDate(6, produtos.getDataCadastro()); 
            comando.setInt(7, produtos.getIdProduto()); 
            comando.execute();
            
        }catch (SQLException e){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            ok = false;
        }
    return ok;
    }
    
    public static Estoque getEstoque(int idProduto){
        Estoque produto = null;
        String query = "select * from estoque where idProduto=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idProduto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String filial = rs.getString("filial");
                String produtos = rs.getString("produto");
                int quantidade = rs.getInt("quantidade");
                String categoria = rs.getString("categoria");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                produto = new Estoque(idProduto, produtos, categoria, filial, valor, quantidade, dataCadastro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produto;
    }
    
}
