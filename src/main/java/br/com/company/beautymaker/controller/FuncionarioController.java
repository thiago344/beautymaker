package br.com.company.beautymaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.company.beautymaker.model.Funcionario;
import br.com.company.beautymaker.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;


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
    @GetMapping("/{id}")
	 public String getFuncionario(@PathVariable int id, Model model) {
	 Optional<Funcionario> optionalFuncionario = Optional.of(funcionarioRepository.findById(id));
	 if (optionalFuncionario.isPresent()) {
	  Funcionario funcionario = optionalFuncionario.get();
	  model.addAttribute("funcionario", funcionario);
	 return "funcionario";
	 } else {
	 model.addAttribute("error", "Funcionario não encontrado");
	 return "error";
	 }
	 }

    @GetMapping("/listar")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        model.addAttribute("funcionarios", funcionarios);
        return "listaFuncionarios";
    }

    @GetMapping("/{id}/detalhar")
    public String detalheFuncionario(@PathVariable int id, Model model) {
        Optional<Funcionario> optionalFuncionario = Optional.of(funcionarioRepository.findById(id));
        if (optionalFuncionario.isPresent()) {
            Funcionario funcionario = optionalFuncionario.get();
            model.addAttribute("funcionario", funcionario);
            return "detalheFuncionario";
        } else {
            model.addAttribute("error", "Funcionario não encontrado");
            return "error";
        }
    }


    @PostMapping("/")
    public Funcionario saveFuncionario(@RequestBody Funcionario funcionario) {
    	 return funcionarioRepository.save(funcionario);
       
    }

    @GetMapping("/{id}/editar")
    public Funcionario editFuncionario(@RequestBody Funcionario funcionario,@PathVariable int id) {
    	return funcionario = funcionarioRepository.findById(id);
        
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