/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.adega.DAO;

import br.senac.adega.entity.Cliente;
import br.senac.sp.conexaobd.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
  
   public static boolean cadastrar(Cliente cliente){
        boolean ok = true;
        String query = "insert into cliente (nome, cpf, email, cep, numero, dataCadastro ) values (?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setInt(4, cliente.getCep());
            ps.setInt(5, cliente.getNumero());
            ps.setDate(6, cliente.getDataCadastro());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
     public static boolean atualizar(Cliente cliente){
        
        boolean ok = true;
        String query = "update cliente set nome=?, email=?,cep=?,numero=?,dataCadastro=? where cpf=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setInt(3, cliente.getCep());
            ps.setInt(4, cliente.getNumero());
            ps.setString(5, cliente.getCpf());
            ps.setDate(6, cliente.getDataCadastro());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }
    
    public static List<Cliente> getClientes(){
        
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                int cep = rs.getInt("cep");
                int numero = rs.getInt("numero");
                Date dataCadastro = rs.getDate("dataCadastro");
               
                Cliente cliente = new Cliente(nome,cpf,email,cep,numero,dataCadastro);
                clientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;
    }
    
    public static boolean deletar(String cpf){
        
        boolean ok = true;
        String query = "delete from cliente where cpf=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }
    
    public static Cliente getCliente(String cpf){
        
        Cliente cliente = null;
        String query = "select * from cliente where cpf=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                int cep = rs.getInt("cep");
                int numero = rs.getInt("numero");
                Date dataCadastro = rs.getDate("dataCadastro");
                cliente = new Cliente(nome, cpf, email, cep, numero, dataCadastro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }
}
