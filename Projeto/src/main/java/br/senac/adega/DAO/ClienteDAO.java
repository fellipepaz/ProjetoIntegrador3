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
  
   public static List<Cliente> listar(){
        String sql = "select * from cliente";
        Connection conexao;
        List<Cliente> lista = new ArrayList();
        try{
            conexao = Conexao.getConexao();
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet dados = comando.executeQuery();
            while(dados.next()){
               int id = dados.getInt("idCliente");
               String nome = dados.getString("nome");
               int cpf = dados.getInt("cpf");
               String email = dados.getString("email");
               int cep = dados.getInt("cep");
               int numero = dados.getInt("numero");
               Date dataCadastro = dados.getDate("dataCadastro");
               Cliente cliente = new Cliente(id, nome, cpf, email, numero, cep, dataCadastro);
               lista.add(cliente); 
            }
        }catch (SQLException e){

        }
        
        return lista;
    }
    
   public static boolean cadastrar(Cliente cliente){
        boolean ok = true;
        String query = "insert into cliente (nome, cpf, email, cep, numero, dataCadastro ) values (?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getCpf());
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
        String query = "update cliente set nome=?, cpf=?, email=?, cep=?, numero=?, dataCadastro=? where idCliente=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setInt(4, cliente.getCep());
            ps.setInt(5, cliente.getNumero());
            ps.setDate(6, cliente.getDataCadastro());
            ps.setInt(7, cliente.getIdCliente());
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
                int id = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                int cpf = rs.getInt("cpf");
                String email = rs.getString("email");
                int cep = rs.getInt("cep");
                int numero = rs.getInt("numero");
                Date dataCadastro = rs.getDate("dataCadastro");
               
                Cliente cliente = new Cliente(id, nome,cpf,email,cep,numero,dataCadastro);
                clientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;
    }
    
    public static boolean deletar(int id){
        boolean ok = true;
        String query = "delete from cliente where idCliente=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }
    
    public static Cliente getCliente(int id){
        Cliente cliente = null;
        String query = "select * from cliente where idCliente=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int cpf = rs.getInt("cpf");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                int cep = rs.getInt("cep");
                int numero = rs.getInt("numero");
                Date dataCadastro = rs.getDate("dataCadastro");
                cliente = new Cliente(id, nome, cpf, email, cep, numero, dataCadastro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }
}
