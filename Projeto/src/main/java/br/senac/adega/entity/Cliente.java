/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.adega.entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Cliente {
    public int id;
    public String nome;  
    public String cpf;
    public String email;    
    public int cep;
    public int numero;
    
    public Cliente(String nome, String cpf, String email, int cep, int numero) {
        this.nome = nome;
        this.cpf = cpf;;
        this.email = email;
        this.cep = cep;
        this.numero = numero;
        
    }
}


