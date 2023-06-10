package br.com.company.beautymaker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.company.beautymaker.model.Cliente;
import br.com.company.beautymaker.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/")
	public String cliente(@RequestParam("id") int id, Model model) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		model.addAttribute("cliente", cliente);
		return "cliente";
	}

	 @GetMapping("/{id}")
	 public String getCliente(@PathVariable int id, Model model) {
	 Optional<Cliente> optionalCliente = Optional.of(clienteService.findByIdCliente(id));
	 if (optionalCliente.isPresent()) {
	  Cliente cliente = optionalCliente.get();
	  model.addAttribute("cliente", cliente);
	 return "cliente";
	 } else {
	 model.addAttribute("error", "Cliente não encontrado");
	 return "error";
	 }
	 }
	 @GetMapping("/{id}/detalhar")
	    public String detalhesCliente(@PathVariable int id, Model model) {
	        Cliente cliente = clienteService.findByIdCliente(id);
	        model.addAttribute("cliente", cliente);
	        return "detalhesCliente";
	    }
	 @GetMapping("/listar")
	    public String listarCliente(Model model) {
	        List<Cliente> cliente = clienteService.findAllCliente();
	        model.addAttribute("cliente", cliente);
	        return "listarCliente";
	    }
	 @GetMapping("/")
	    public List<Cliente> getListCliente() {
	    	return clienteService.findAllCliente();
	    }
	@PostMapping("/")
    public Cliente saveCliente(@RequestBody Cliente cliente) {
    	return clienteService.saveCliente(cliente);
    	
    }

	@GetMapping("/{id}/editar")
	public String editCliente(@PathVariable int id, Model model) {
		Cliente cliente = clienteService.findByIdCliente(id);
        model.addAttribute("cliente", cliente);
        return "cliente";
    }
	@PostMapping("/{id}/editar")
    public Cliente saveEdicaoCliente(@RequestBody Cliente cliente,@PathVariable int id) {
        cliente.setId(id);
        return clienteService.saveCliente(cliente);
       
    }

	@PostMapping("/{id}/excluir")
	public String deleteCliente(@PathVariable int id) {
		clienteService.deleteByIdCliente(id);
        return "redirect:/cliente/";
		
	}
	@PostMapping("/autenticar")
    public String autenticarCliente(@RequestParam("email") String email, 
    		                        @RequestParam("senha") String senha,
    		                        Model model) {
        Cliente cliente = clienteService.autenticarUsuario(email, senha);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "cliente";
        } else {
            model.addAttribute("error", "Email ou senha inválidos");
            return "error";
        }
}
}
