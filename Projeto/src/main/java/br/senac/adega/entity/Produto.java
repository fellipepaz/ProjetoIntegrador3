
package br.senac.adega.entity;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    
    private int id;
    private String produto; 
    private String categoria;
    private int idFilial;
    private double valor;
    private int quantidade;
    private Date dataCadastro;
  
    public Produto (int id, String produto, String categoria, int idFilial, double valor, int quantidade, Date dataCadastro){
        this.id = id;
        this.produto = produto;
        this.idFilial = idFilial;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
    }
}