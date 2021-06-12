/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.adega.entity;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vendas {
    
    private int idVenda;
    private int idCliente;
    private int idProduto;
    private int quantidade;
    private double valor;
    private double valortTotal;
    private Date datavenda;
  
    public Vendas(int idVenda, int idCliente, int idProduto, int quantidade, double valor, double valortTotal) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.idCliente = idCliente;
        this.quantidade = quantidade;
        this.valor = valor;
        this.valortTotal = valortTotal;
    }
}
