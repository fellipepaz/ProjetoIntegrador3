
package br.senac.adega.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private int id;
    private String produto;  
    private String filial;
    private double valor;
    private int quantidade;  
  

    
    public Produto (int id, String produto, String filial, double valor, int quantidade){

    this.id = id;
    this.produto = produto;
    this.filial = filial;
    this.valor = valor;
    this.quantidade = quantidade;

    }
}


