package br.com.company.beautymaker.repository;

import br.com.company.beautymaker.model.Servicos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServicosRepository extends MongoRepository<Servicos, String> {

}
