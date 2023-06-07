package br.com.company.beautymaker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.company.beautymaker.model.Funcionario;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String>{

}
