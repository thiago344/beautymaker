package br.com.company.beautymaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.company.beautymaker.model.Funcionario;
import br.com.company.beautymaker.repository.FuncionarioRepository;
import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario findById(int id) {

        return funcionarioRepository.findById(Integer.toString(id)).get();


    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deleteById(int id) {
        funcionarioRepository.deleteById(Integer.toString(id));
    }
    public Funcionario autenticarUsuario(String email, String senha) {
        if (email == null || senha == null) {
            throw new IllegalArgumentException("Email e senha são obrigatórios");
        }

        Funcionario funcionario = funcionarioRepository.findByEmail(email);

    if (funcionario == null) {
            throw new RuntimeException("Usuário ou Senha incorreto");
        }

    if (!funcionario.getSenha().equals(senha)) {
            throw new RuntimeException("Usuário ou Senha incorreto");
        }

        return funcionario; 
    }
    
    public Funcionario validarCadastro(Funcionario funcionario) {

        if (funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        if (funcionario.getEmail() == null || funcionario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }

        if (funcionario.getSenha() == null || funcionario.getSenha().isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória");
        }

        if (funcionario.getSexo() == null || funcionario.getSexo().isEmpty()) {
            throw new IllegalArgumentException("Sexo é obrigatório");
        }

        if (funcionario.getEndereco() == null || funcionario.getEndereco().isEmpty()) {
            throw new IllegalArgumentException("Endereço é obrigatório");
        }

        if (funcionario.getDataNascimento() == null) {
            throw new IllegalArgumentException("Data de Nascimento é obrigatória");
        }

        if (funcionario.getCpf() == null || funcionario.getCpf().isEmpty()) {
            throw new IllegalArgumentException("CPF é obrigatório");
        }

        if (funcionario.getTelefone() == null || funcionario.getTelefone().isEmpty()) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }

        if (funcionarioRepository.findByEmail(funcionario.getEmail()) != null) {
            throw new IllegalArgumentException("Email já está em uso");
        }
        return funcionarioRepository.save(funcionario);
}
}
