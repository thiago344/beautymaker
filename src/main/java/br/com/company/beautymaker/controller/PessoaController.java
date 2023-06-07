package br.com.company.beautymaker.controller;

import br.com.company.beautymaker.model.Pessoa;
import br.com.company.beautymaker.repository.PessoaRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PessoaController {
	
	@Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/pessoa")
    public String pessoa(@RequestParam("nome") String nome,
                         @RequestParam("sexo") String sexo,
                         @RequestParam("endereco") String endereco,
                         @RequestParam("email") String email,
                         @RequestParam("dataNascimento") String dataNascimento,
                         @RequestParam("cpf") String cpf,
                         @RequestParam("telefone") String telefone,
                         Model model) {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setSexo(sexo);
        pessoa.setEndereco(endereco);
        pessoa.setEmail(email);
        pessoa.setDataNascimento(converterData(dataNascimento));
        pessoa.setCpf(cpf);
        pessoa.setTelefone(telefone);

        model.addAttribute("pessoa", pessoa);

        return "pessoa";
    }
    
    @GetMapping("/")
    public List<Pessoa> getListPessoas() {
    	return pessoaRepository.findAll();
    }
    
    @PostMapping("/")
    public Pessoa savePessoa(@RequestBody Pessoa pessoa) {
    	return pessoaRepository.save(pessoa);
    	
    }
    
    // Método para converter para string
    private Date converterData(String dataNascimento) {
    	String pattern = "yyyy-MM-dd";
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    	LocalDate localDate = LocalDate.parse(dataNascimento, formatter);
    	Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    	
    	return date;
    }
    
}



