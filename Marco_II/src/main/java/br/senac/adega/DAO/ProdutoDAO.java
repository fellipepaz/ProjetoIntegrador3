/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.adega.DAO;

import br.senac.adega.entity.Produto;
import br.senac.sp.conexaobd.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Beto
 */
public class ProdutoDAO {

    public static void inserir(Produto item)throws Exception{
        String sql = "INSERT INTO produto (produto, filial, valor, quantidade) VALUES (?, ?, ?, ?)";
        
        Connection conexao = Conexao.getConexao();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, item.produto);
            comando.setString(2, item.filial);
            comando.setDouble(3, item.valor);
            comando.setInt(4, item.quantidade);          
            comando.execute();
            
        }finally{
            conexao.close();
        }
    }
    
    public static void excluir(int id) throws Exception{
        String sql = "DELETE FROM produto WHERE id = ?";
        
        Connection conexao = Conexao.getConexao();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, id);
   
            comando.execute();
        }finally{
            conexao.close();
        }
    }
    
    public static List<Produto> listar() throws Exception{
        String sql = "SELECT * FROM produto";
        
        Connection conexao = Conexao.getConexao();
        List<Produto> lista = new ArrayList();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            ResultSet dados = comando.executeQuery();
            
            while(dados.next()){
                Produto item = new Produto();
                
               item.id = dados.getInt("id");
                item.produto = dados.getString("produto");
                item.filial = dados.getString("filial");
                item.valor = dados.getDouble("valor");
                item.quantidade = dados.getInt("quantidade");
                lista.add(item); 
            }
            
        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static List<Produto> pesquisar(String produto) throws Exception{
        String sql = "SELECT * FROM produto WHERE produto LIKE ?";
        
        Connection conexao = Conexao.getConexao();
        List<Produto> lista = new ArrayList();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, "%" + produto + "%");
            
            ResultSet dados = comando.executeQuery();
            
            while(dados.next()){
                Produto item = new Produto();
                
                item.id = dados.getInt("id");
                item.produto = dados.getString("produto");
                item.filial = dados.getString("filial");
                item.valor = dados.getDouble("valor");
                item.quantidade = dados.getInt("quantidade");
               
                
                lista.add(item);
                
            }
            
        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static void editar(Produto item) throws Exception{
        String sql = "UPDATE produto SET produto = ?, filial = ?, valor = ?, quantidade = ? WHERE id = ?"; 
        
        Connection conexao = Conexao.getConexao();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
             comando.setString(1, item.produto);
            comando.setString(2, item.filial);
            comando.setDouble(3, item.valor);
            comando.setInt(4, item.quantidade);   
            comando.setInt(5, item.id);
            
            comando.execute();
            
        }finally{
            conexao.close();
        }
    }
}
