package br.com.company.beautymaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.company.beautymaker.model.Funcionario;
import br.com.company.beautymaker.repository.FuncionarioRepository;

import java.util.List;


@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @GetMapping("/")
    public String funcionario(@RequestParam("id") int id, Model model) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        model.addAttribute("funcionario", funcionario);
        return "funcionario";
    }

    @GetMapping("/listar")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        model.addAttribute("funcionarios", funcionarios);
        return "listaFuncionarios";
    }

    @GetMapping("/{id}")
    public String detalhesFuncionario(@PathVariable int id, Model model) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        model.addAttribute("funcionario", funcionario);
        return "detalhesFuncionario";
    }

    @PostMapping("/")
    public String saveFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return "redirect:/funcionario/";
    }

    @GetMapping("/{id}/editar")
    public String editFuncionario(@PathVariable int id, Model model) {
        Funcionario funcionario = funcionarioRepository.findById(id);
        model.addAttribute("funcionario", funcionario);
        return "editarFuncionario";
    }

    @PostMapping("/{id}/editar")
    public String saveEdicaoFuncionario(@PathVariable int id, @ModelAttribute Funcionario funcionario) {
        funcionario.setId(id);
        funcionarioRepository.save(funcionario);
        return "redirect:/funcionario/";
    }

    @PostMapping("/{id}/excluir")
    public String deleteFuncionario(@PathVariable int id) {
        funcionarioRepository.deleteById(id);
        return "redirect:/funcionario/";
    }
}