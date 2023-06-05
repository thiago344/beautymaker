package br.com.company.beautymaker.controller;


import br.com.company.beautymaker.model.Serviços;
import br.com.company.beautymaker.repository.ServiçosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviços")
public class ServiçosController {


    @Autowired
    private ServiçosRepository serviçosRepository;

    @GetMapping("/")
    public List<Serviços> getProduto() {
        return serviçosRepository.findAll();
    }

    @PostMapping("/")
    public Serviços createServiços(@RequestBody Serviços serviços) {
        return serviçosRepository.save(serviços);
    }


}
