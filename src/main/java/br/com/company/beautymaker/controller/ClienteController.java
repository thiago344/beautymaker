package br.com.company.beautymaker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.company.beautymaker.model.Cliente;
import br.com.company.beautymaker.model.Funcionario;
import br.com.company.beautymaker.model.Pessoa;
import br.com.company.beautymaker.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/")
	public String cliente(@RequestParam("id") int id, Model model) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		model.addAttribute("cliente", cliente);
		return "cliente";
	}

//	    @GetMapping("/{id}")
	// public String getCliente(@PathVariable int id, Model model) {
	// Optional<Cliente> optionalCliente = clienteRepository.findById(id);
	// if (optionalCliente.isPresent()) {
	// // Cliente cliente = optionalCliente.get();
	// // model.addAttribute("cliente", cliente);
	// return "cliente";
	// } else {
	// model.addAttribute("error", "Cliente não encontrado");
	// return "error";
	// }
	// }
	
	@PostMapping("/")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
    	return clienteRepository.save(cliente);
    	
    }

	@GetMapping("/{id}/editar")
	public String editCliente(@PathVariable int id, Model model) {
		Cliente cliente = clienteRepository.findById(id);
        model.addAttribute("cliente", cliente);
        return "cliente";
    }
	@PostMapping("/{id}/editar")
    public String saveEdicaoCliente(@PathVariable int id, @ModelAttribute Cliente cliente) {
        cliente.setId(id);
        clienteRepository.save(cliente);
        return "redirect:/cliente/";
    }

	@PostMapping("/{id}/excluir")
	public String deleteCliente(@PathVariable int id) {
		ClienteRepository.deleteById(id);;
        return "redirect:/cliente/";
		
	}
}
