package br.com.company.beautymaker.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.company.beautymaker.model.Agenda;
import br.com.company.beautymaker.model.Cliente;
import br.com.company.beautymaker.model.Funcionario;
import br.com.company.beautymaker.model.Servicos;
import br.com.company.beautymaker.service.AgendaService;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping("/")
    public String agenda(@RequestParam("id") int id,
                         @RequestParam("funcionario") Funcionario funcionario,
                         @RequestParam("cliente") Cliente cliente,
                         @RequestParam("servicos") Servicos servicos,
                         @RequestParam("dataHora") LocalDateTime dataHora,
                         Model model) {
        Agenda agenda = new Agenda();
        agenda.setId(id);
        agenda.setFuncionario(funcionario);
        agenda.setCliente(cliente);
        agenda.setServicos(servicos);
        agenda.setDataHora(dataHora);
        model.addAttribute("agenda", agenda);
        return "agenda";
    }

    @GetMapping("/{id}")
    public String getAgenda(@PathVariable int id, Model model) {
        Optional<Agenda> optionalAgenda = agendaService.findById(id);
        if (optionalAgenda.isPresent()) {
            Agenda agenda = optionalAgenda.get();
            model.addAttribute("agenda", agenda);
            return "agenda";
        } else {
            model.addAttribute("error", "Agenda não encontrada");
            return "error";
        }
    }

    @PostMapping("/")
    public String saveAgenda(@RequestBody Agenda agenda) {
        agendaService.save(agenda);
        return "redirect:/agenda/";
    }

    @GetMapping("/{id}/editar")
    public String editAgenda(@PathVariable int id, Model model) {
        Optional<Agenda> optionalAgenda = agendaService.findById(id);
        if (optionalAgenda.isPresent()) {
            Agenda agenda = optionalAgenda.get();
            model.addAttribute("agenda", agenda);
            return "agenda";
        } else {
            model.addAttribute("error", "Agenda não encontrada");
            return "error";
        }
    }

    @PostMapping("/{id}/editar")
    public String saveEdicaoAgenda(@PathVariable int id, @ModelAttribute Agenda agenda) {
        agenda.setId(id);
        agendaService.save(agenda);
        return "redirect:/agenda/";
    }

    @PostMapping("/{id}/excluir")
    public String deleteAgenda(@PathVariable int id) {
        agendaService.deleteById(id);
        return "redirect:/agenda/";
    }
    @PostMapping("/verificar-agendamento")
    @ResponseBody
    public boolean verificarAgendamento(@RequestBody String dataHora) {
    	System.out.println(dataHora);
    	return true;
       // return agendaService.verificarDataHoraAgendada(dataHora);
    }
}
