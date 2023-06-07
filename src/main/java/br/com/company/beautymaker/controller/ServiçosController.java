package br.com.company.beautymaker.controller;


import br.com.company.beautymaker.model.Serviços;
import br.com.company.beautymaker.repository.ServiçosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/serviços")
public class ServiçosController {

    @Autowired
    private ServiçosRepository serviçosRepository;

    @GetMapping("/serviços")
    public String serviços(@RequestParam("id") int id,
                           @RequestParam("nome") String nome,
                           Model model) {
        Serviços serviços = new Serviços();

        serviços.setId(id);
        serviços.setNome(nome);

        model.addAttribute("serviços", serviços);
        return "serviços";
    }

    @GetMapping("/")
    public List<Serviços> getListServiços() {
        return serviçosRepository.findAll();
    }

    @PostMapping("/")
    public Serviços saveServiços(@ModelAttribute Serviços serviços) {
        return serviçosRepository.save(serviços);
    }
}
