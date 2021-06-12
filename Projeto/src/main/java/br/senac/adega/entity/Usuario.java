
package br.senac.adega.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    
    private final String PERFIL_GERENTE = "GERENTE";
    
    private String nome;
    private String login;
    private String senha;
    private String perfil;
    private String filial;
    
    public boolean isAdmin() {
        return perfil.equalsIgnoreCase("isAdmin");
    }
}
