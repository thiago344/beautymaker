package br.com.company.beautymaker.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Cliente extends Pessoa {
    @Id
    private int id;
    private String email;
    private String senha;

    public Cliente() {
    }

    public Cliente(int id, String email, String senha, String nome, String sexo, String endereco, Date dataNascimento, String cpf, String telefone) {
        super(nome, sexo, endereco, dataNascimento, cpf, telefone);
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

