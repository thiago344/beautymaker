package br.com.company.beautymaker.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Cliente extends Pessoa {
	@Id
    private int id;

    public Cliente() {
    }

    public Cliente(int id, String nome, String sexo, String endereco, String email, Date dataNascimento, String cpf, String telefone) {
        super(nome, sexo, endereco, email, dataNascimento, cpf, telefone);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
