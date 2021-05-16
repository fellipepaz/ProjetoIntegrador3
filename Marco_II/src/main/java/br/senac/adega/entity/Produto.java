/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.adega.entity;

/**
 *
 * @author Beto
 */
public class Produto {
    public int id;
    public String produto;  
    public String filial;
    public double valor;
    public int quantidade;  
  
 
    
       public String getProduto(){
        return produto;
    }
       
        public String getFilial(){
        return filial;
    }
        public int getQuantidade(){
        return quantidade;
    }
      
         public double getValor(){
        return valor;
    }
         
        public int getId(){
        return id;
    }
}
//
