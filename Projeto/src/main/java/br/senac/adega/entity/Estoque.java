
package br.senac.adega.entity;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estoque {
 
    private int idProduto;
    private String produto;
    private String categoria;
    private int idFilial;
    private double valor;
    private int quantidade;
    private Date dataCadastro;
  
    public Estoque (int idProduto, String produto, String categoria, int idFilial, double valor, int quantidade, Date dataCadastro){
        this.idProduto = idProduto;
        this.produto = produto;
        this.idFilial = idFilial;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
    }
}
