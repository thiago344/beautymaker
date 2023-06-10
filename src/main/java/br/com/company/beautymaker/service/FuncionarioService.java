package br.com.company.beautymaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.company.beautymaker.model.Funcionario;
import br.com.company.beautymaker.repository.FuncionarioRepository;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario findById(int id) {
        Optional<Funcionario> optionalFuncionario = Optional.of(funcionarioRepository.findById(id));
        return optionalFuncionario.orElse(null);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deleteById(int id) {
        funcionarioRepository.deleteById(id);
    }
}
