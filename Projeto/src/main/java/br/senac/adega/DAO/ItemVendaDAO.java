/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.adega.DAO;

import br.senac.adega.entity.Vendas;
import br.senac.sp.conexaobd.conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


 
public class ItemVendaDAO {
   
      public static int inserirVendas(Vendas item)throws Exception{
        String sql = "insert into vendas(idcliente,datavenda) VALUES (?, ?)";
        
        Connection conexao = Conexao.getConexao();  
        
          System.out.println("teste");
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            
            comando.setInt(1, item.idcliente);
            comando.setDate(2, (Date)( item.datavenda));
            
            comando.execute();
            
            
           ResultSet chavesGeradas = comando.getGeneratedKeys();
          
           if(chavesGeradas.next()){
             return  chavesGeradas.getInt(1);
               
           }

        }finally{
            conexao.close();
        }
        return -1;
    }
        
    }

    


    