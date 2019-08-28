package br.com.smartfull.primefaces;

import javax.inject.Named;
import java.io.Serializable;

@Named
public class Pessoa implements Serializable {

    private String nome = "Fred";
    private String sobreNome = "Junior";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

}
