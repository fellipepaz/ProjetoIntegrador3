/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.adega.DAO;

import br.senac.adega.entity.Vendas_Produtos;
import br.senac.sp.conexaobd.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;




/**
 *
 * @author Lenovo
 */
public class ItemVendas_ProdutosDAO {
       public static void inserirVendasProdutos(Vendas_Produtos item,int idVenda)throws Exception{
        String sql = "insert into vendas_produtos(idvenda,idProduto,quantidade,total) VALUES (?, ?, ?, ?)";
        
        Connection conexao = Conexao.getConexao();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, idVenda);
            comando.setInt(2, item.idProduto);
            comando.setInt(3, item.quantidade);
            comando.setDouble(4, item.total);
            
            comando.execute();
            
        }finally{
            conexao.close();
        }

    }
}
