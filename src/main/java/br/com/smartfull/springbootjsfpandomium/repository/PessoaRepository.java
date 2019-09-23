package br.com.smartfull.springbootjsfpandomium.repository;

import br.com.smartfull.springbootjsfpandomium.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
