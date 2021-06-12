package br.senac.adega.DAO;

import br.senac.sp.conexaobd.conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiag
 */
public class RelatorioDAO {

    public static double getFilial( int filial, Date dataInicial, Date dataFinal) {
        double valor = 0;
        String query = "select sum(Estoque.valor) from Estoque inner JOIN Filial ON Filial.idFilial = Estoque.idProduto where Estoque.dataCadastro between ? and ? and Estoque.idFilial like ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, dataInicial);
            ps.setDate(2, dataFinal);
            ps.setInt(3, filial);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString(1) == null) {
                valor = 0;
            } else {
                valor = Double.parseDouble(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return valor;
    }

    public static int getFilialQuantidade(int filial, Date dataInicial, Date dataFinal) {
        int valor = 0;
        String query = "select sum(Esstoque.quantidade) from Estoque inner JOIN Filial ON Filial.idFilial = Estoque.idProduto where Estoque.dataCadastro between ? and ? and Filial.nome like ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, dataInicial);
            ps.setDate(2, dataFinal);
            ps.setInt(3, filial);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString(1) == null) {
                valor = 0;
            } else {
                valor = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return valor;
    }

    public static int getCliente(int idCliente, Date dataInicial, Date dataFinal) {
        int quantidade = 0;
        String query = "select count(Cliente.nome) from Cliente INNER JOIN vendas_produtos ON vendas_produtos.idCliente = Cliente.idCliente where Cliente.idCliente like ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            rs.next();
            quantidade = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return quantidade;
    }

    public static double getCategoria(String categoria, Date dataInicial, Date dataFinal) {
        double valor = 0;
        String query = "select sum(Estoque.valor) from Estoque where Estoque.dataCadastro between ? and ? and Estoque.categoria like ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, dataInicial);
            ps.setDate(2, dataFinal);
            ps.setString(3, categoria);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString(1) == null) {
                valor = 0;
            } else {
                valor = Double.parseDouble(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return valor;
    }

    public static int getCategoriaQuantidade(String categoria, Date dataInicial, Date dataFinal) {
        int quantidade = 0;
        String query = "select sum(Estoque.quantidade) from Estoque where Estoque.dataCadastro between ? and ? and Estoque.categoria like ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, dataInicial);
            ps.setDate(2, dataFinal);
            ps.setString(3, categoria);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString(1) == null) {
                quantidade = 0;
            } else {
                quantidade = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return quantidade;
    }

    public static double getClienteValor(int idCliente, Date dataInicio, Date dataFim) {
        int quantidade = 0;
        String query = "select count(Cliente.nome) from Cliente INNER JOIN Venda ON Venda.idCliente = Cliente.idCliente where Cliente.idCliente like ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            rs.next();
            quantidade = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return quantidade;
    }

}
