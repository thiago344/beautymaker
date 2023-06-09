package br.com.company.beautymaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.company.beautymaker.model.Agenda;
import br.com.company.beautymaker.repository.AgendaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    public Optional<Agenda> findById(int id) {
        return Optional.of(agendaRepository.findById(Integer.toString(id))).get();
    }

    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public void deleteById(int id) {
        agendaRepository.deleteById(Integer.toString(id));
    }
    public boolean verificarDataHoraAgendada(LocalDateTime dataHora) {
        List<Agenda> listAgenda = agendaRepository.findAll();
        
        for (Agenda agenda : listAgenda) {
            LocalDateTime agendamento = agenda.getDataHora();
            
            if (agendamento != null && agendamento.equals(dataHora)) {
                return true; 
            }
        }
        
        return false;
    }

}
