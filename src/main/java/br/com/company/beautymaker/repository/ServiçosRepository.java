package br.com.company.beautymaker.repository;

import br.com.company.beautymaker.model.Serviços;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiçosRepository extends MongoRepository<Serviços, String> {

}
