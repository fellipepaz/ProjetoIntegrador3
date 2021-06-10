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
        String sql = "INSERT INTO produto (produto, categoria, filial, valor, quantidade, dataCadastro) VALUES (?, ?, ?, ?, ?, ?)";
        
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
    
    public static boolean excluir(int id) throws SQLException{
        boolean ok = true;
        String sql = "DELETE FROM produto WHERE id = ?";
        Connection conexao = Conexao.getConexao();
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);
            comando.execute();
        }catch (SQLException e){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            ok = false;
        }
    return ok;
    }
    
    public static List<Estoque> listar() throws Exception{
        String sql = "SELECT * FROM produto";
        Connection conexao = Conexao.getConexao();
        List<Estoque> lista = new ArrayList();
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet dados = comando.executeQuery();
            while(dados.next()){
               int id = dados.getInt("id");
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

        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static List<Estoque> pesquisar(String product) throws Exception{
        String sql = "SELECT * FROM produto WHERE produto LIKE ?";
        
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
    
    public static boolean editar(Estoque produtos) throws SQLException{
        boolean ok = true;
        String sql = "UPDATE produto SET produto = ?, categoria=?, filial = ?, valor = ?, quantidade = ?, dataCadastro=? WHERE id = ?"; 
        
        Connection conexao = Conexao.getConexao();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, produtos.getProduto());
            comando.setString(2, produtos.getCategoria());
            comando.setString(3, produtos.getFilial());
            comando.setDouble(4, produtos.getValor());
            comando.setInt(5, produtos.getQuantidade());
            comando.setDate(6, produtos.getDataCadastro()); 
            comando.setInt(7, produtos.getId()); 
            comando.execute();
            
        }catch (SQLException e){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
            ok = false;
        }
    return ok;
    }
}
