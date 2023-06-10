package br.com.company.beautymaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.company.beautymaker.model.Servicos;
import br.com.company.beautymaker.repository.ServicosRepository;
import java.util.List;

@Service
public class ServicosService {

    @Autowired
    private ServicosRepository servicosRepository;

    public List<Servicos> findAll() {
        return servicosRepository.findAll();
    }

    public Servicos save(Servicos servicos) {
        return servicosRepository.save(servicos);
    }
}
