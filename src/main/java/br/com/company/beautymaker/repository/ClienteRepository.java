package br.com.company.beautymaker.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.company.beautymaker.model.Cliente;


public interface ClienteRepository extends MongoRepository<Cliente, String> {
	Cliente findById(int id);

	void saveCliente(Cliente cliente);
    void deleteById(int id);
}
