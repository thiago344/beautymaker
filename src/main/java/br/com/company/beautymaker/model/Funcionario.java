package br.com.company.beautymaker.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "funcionario")
public class Funcionario extends Pessoa {
	@Id
    private int id;
    private String email;
    private String senha;
    
    public Funcionario() {
    }

    public Funcionario(int id, String nome, String sexo, String endereco, Date dataNascimento, String cpf, String telefone, String email, String senha) {
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
