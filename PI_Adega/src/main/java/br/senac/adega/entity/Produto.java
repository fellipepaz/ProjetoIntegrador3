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
    public String cor;
    public String marca;
    public int estoque;
    public double preco;
    
       public String getProduto(){
        return produto;
    }
        public String getCor(){
        return cor;
    }
        public String getMarca(){
        return marca;
    }
        public int getEstoque(){
        return estoque;
    }
        public double getPreco(){
        return preco;
    }
        public int getId(){
        return id;
    }
}
//
