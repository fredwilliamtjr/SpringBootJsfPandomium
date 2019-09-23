package br.com.smartfull.springbootjsfpandomium.bean;

import br.com.smartfull.springbootjsfpandomium.dto.PessoaDto;
import br.com.smartfull.springbootjsfpandomium.model.Pessoa;
import br.com.smartfull.springbootjsfpandomium.service.PessoaService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
public class Index implements Serializable {

    @Inject
    private PessoaDto pessoaDto;

    @Inject
    private PessoaService pessoaService;

    @PostConstruct
    private void inicio() {
        listar();
    }

    private List<Pessoa> pessoaList = new ArrayList<>();

    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    public PessoaDto getPessoaDto() {
        return pessoaDto;
    }

    public void setPessoaDto(PessoaDto pessoaDto) {
        this.pessoaDto = pessoaDto;
    }


    public void salvar() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDto.getNome());
        pessoa.setSobreNome(pessoaDto.getSobreNome());
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        listar();
    }

    public void listar() {
        pessoaList = pessoaService.todas();

    }

}
