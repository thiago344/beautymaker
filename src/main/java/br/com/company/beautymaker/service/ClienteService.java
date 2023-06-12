package br.com.company.beautymaker.service;

import br.com.company.beautymaker.model.Cliente;
import br.com.company.beautymaker.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findByIdCliente(int id) {
        Optional<Cliente> optionalCliente = Optional.of(clienteRepository.findById(Integer.toString(id))).get();
        return optionalCliente.orElse(null);
    }

    public List<Cliente> findAllCliente() {
        return clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteByIdCliente(int id) {
        clienteRepository.deleteById(Integer.toString(id));
    }

        public Cliente autenticarUsuario(String email, String senha) {
            if (email == null || senha == null) {
                throw new IllegalArgumentException("Email e senha são obrigatórios");
            }

            Cliente cliente = clienteRepository.findByEmail(email);

        if (cliente == null) {
                throw new RuntimeException("Usuário inexistente");
            }

        if (!cliente.getEmail().equals(email) && !cliente.getSenha().equals(senha)) {
                throw new RuntimeException("Usuário ou Senha incorreto");
            }

            return cliente; 
        }
        
        public Cliente validarCadastro(Cliente cliente) {

            if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
                throw new IllegalArgumentException("Nome é obrigatório");
            }

            if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
                throw new IllegalArgumentException("Email é obrigatório");
            }

            if (cliente.getSenha() == null || cliente.getSenha().isEmpty()) {
                throw new IllegalArgumentException("Senha é obrigatória");
            }

            if (cliente.getSexo() == null || cliente.getSexo().isEmpty()) {
                throw new IllegalArgumentException("Sexo é obrigatório");
            }

            if (cliente.getEndereco() == null || cliente.getEndereco().isEmpty()) {
                throw new IllegalArgumentException("Endereço é obrigatório");
            }

            if (cliente.getDataNascimento() == null) {
                throw new IllegalArgumentException("Data de Nascimento é obrigatória");
            }

            if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
                throw new IllegalArgumentException("CPF é obrigatório");
            }

            if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
                throw new IllegalArgumentException("Telefone é obrigatório");
            }

            if (clienteRepository.findByEmail(cliente.getEmail()) != null) {
                throw new IllegalArgumentException("Email já está em uso");
            }
            return clienteRepository.save(cliente);
    }

}
