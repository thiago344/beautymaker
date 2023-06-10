package br.com.company.beautymaker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.company.beautymaker.model.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String>{

}
