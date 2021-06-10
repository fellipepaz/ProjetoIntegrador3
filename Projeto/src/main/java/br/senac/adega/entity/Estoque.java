
package br.senac.adega.entity;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estoque {
 
    private int id;
    private String produto; 
    private String categoria;
    private String filial;
    private double valor;
    private int quantidade;
    private Date dataCadastro;
  
    public Estoque (int id, String produto, String categoria, String filial, double valor, int quantidade, Date dataCadastro){
        this.id = id;
        this.produto = produto;
        this.filial = filial;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
        this.dataCadastro = dataCadastro;
    }
}
