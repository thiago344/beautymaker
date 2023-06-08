package br.com.company.beautymaker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.company.beautymaker.model.Agenda;

public interface AgendaRepository extends MongoRepository<Agenda, String> {
	Agenda findById(int id);
	void saveCliente(Agenda agenda);
    void deleteById(int id);
}
