package br.com.smartfull.springbootjsfpandomium.service;

import br.com.smartfull.springbootjsfpandomium.model.Pessoa;
import br.com.smartfull.springbootjsfpandomium.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PessoaService implements Serializable {

    @Inject
    private PessoaRepository pessoaRepository;

    private static final long serialVersionUID = 1L;

    public List<Pessoa> todas() {
        Iterable<Pessoa> pessoaIterable = pessoaRepository.findAll();
        List<Pessoa> collect = StreamSupport.stream(pessoaIterable.spliterator(), false).collect(Collectors.toList());
        return collect;
    }

    public Pessoa salvar(Pessoa pessoa) {
        Pessoa pessoaSave = pessoaRepository.save(pessoa);
        return pessoaSave;
    }


}
