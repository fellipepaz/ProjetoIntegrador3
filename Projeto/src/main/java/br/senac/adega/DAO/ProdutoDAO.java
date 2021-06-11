/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.adega.DAO;

import br.senac.adega.entity.Produto;
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


public class ProdutoDAO {

    public static int inserir(Produto produtos){
        int id = 0;
        String sql = "INSERT INTO Estoque (produto, categoria, idFilial, valor, quantidade, dataCadastro) VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
            Connection conexao = Conexao.getConexao();
            PreparedStatement comando = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            comando.setString(1, produtos.getProduto());
            comando.setString(2, produtos.getCategoria());
            comando.setInt(3, produtos.getIdFilial());
            comando.setDouble(4, produtos.getValor());
            comando.setInt(5, produtos.getQuantidade());
            comando.setDate(6, produtos.getDataCadastro()); 
            comando.execute();
            ResultSet rs = comando.getGeneratedKeys();
            rs.next();
            id = Integer.parseInt(rs.getString(1));
        }catch (SQLException e){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    return id;

    }
    
    public static boolean excluir(int id) throws SQLException{
        boolean ok = true;
        String sql = "DELETE FROM Estoque WHERE id = ?";
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
    
    public static List<Produto> listar() throws Exception{
        String sql = "SELECT * FROM Estoque";
        Connection conexao = Conexao.getConexao();
        List<Produto> lista = new ArrayList();
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet dados = comando.executeQuery();
            while(dados.next()){
               int id = dados.getInt("id");
               String produto = dados.getString("produto");
               String categoria = dados.getString("categoria");
               int idFilial = dados.getInt("idFilial");
               double valor = dados.getDouble("valor");
               int quantidade = dados.getInt("quantidade");
               Date dataCadastro = dados.getDate("dataCadastro");
               
               Produto produtos = new Produto(id, produto, categoria, idFilial, valor, quantidade, dataCadastro);
               lista.add(produtos); 
            }
            
        }catch (SQLException e){

        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static List<Produto> pesquisar(String product) throws Exception{
        String sql = "SELECT * FROM Estoque WHERE produto LIKE ?";
        
        Connection conexao = Conexao.getConexao();
        List<Produto> lista = new ArrayList();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, "%" + product + "%");
            
            ResultSet dados = comando.executeQuery();
            
            while(dados.next()){
               
               int id = dados.getInt("id");
               String produto = dados.getString("produto");
               String categoria = dados.getString("categoria");
               int idFilial = dados.getInt("idFilial");
               double valor = dados.getDouble("valor");
               int quantidade = dados.getInt("quantidade");
               Date dataCadastro = dados.getDate("dataCadastro");
               
               Produto produtos = new Produto(id, produto, categoria, idFilial, valor, quantidade, dataCadastro );
               lista.add(produtos); 
            }
            
        }catch (SQLException e){

        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static boolean editar(Produto produtos) throws SQLException{
        boolean ok = true;
        String sql = "UPDATE Estoque SET produto = ?, categoria=?, nomeFilial = ?, valor = ?, quantidade = ?, dataCadastro=? WHERE id = ?"; 
        
        Connection conexao = Conexao.getConexao();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, produtos.getProduto());
            comando.setString(2, produtos.getCategoria());
            comando.setInt(3, produtos.getIdFilial());
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
