package br.com.company.beautymaker.controller;


import br.com.company.beautymaker.model.Servicos;
import br.com.company.beautymaker.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/servicos")
public class ServicosController {

    @Autowired
    private ServicosRepository servicosRepository;

    @GetMapping("/servicos")
    public String servicos(@RequestParam("id") int id,
                           @RequestParam("nome") String nome,
                           Model model) {
        Servicos servicos = new Servicos();

        servicos.setId(id);
        servicos.setNome(nome);

        model.addAttribute("servicos", servicos);
        return "servicos";
    }

    @GetMapping("/")
    public List<Servicos> getListServicos() {
        return servicosRepository.findAll();
    }

    @PostMapping("/")
    public Servicos saveServicos(@ModelAttribute Servicos servicos) {
        return servicosRepository.save(servicos);
    }
}
