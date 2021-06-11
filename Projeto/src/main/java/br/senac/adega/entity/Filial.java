
package br.senac.adega.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filial {
    
    private int idFilial;
    private String nome;

    public Filial(int idFilial, String nome) {
        this.idFilial = idFilial;
        this.nome = nome;
    }
}
