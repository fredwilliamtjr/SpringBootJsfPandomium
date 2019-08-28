package br.com.smartfull.primefaces;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
public class Index implements Serializable {

    @Inject
    private Pessoa pessoa;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String exibir() {
        return "Olá " + pessoa.getNome() + " " + pessoa.getSobreNome() + "!";
    }

}
