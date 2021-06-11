/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.adega.entity;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
public class Cliente {
    public int idCliente;
    public String nome;  
    public int cpf;
    public String email;    
    public int cep;
    public int numero;
    public Date dataCadastro;
    
    public Cliente(int idCliente, String nome, int cpf, String email, int cep, int numero, Date dataCadastro) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;;
        this.email = email;
        this.cep = cep;
        this.numero = numero;
        this.dataCadastro=dataCadastro;
        
    }
}