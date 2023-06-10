package br.com.company.beautymaker.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "funcionario")
public class Funcionario extends Pessoa {
	@Id
    private int id;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String sexo, String endereco, Date dataNascimento, String cpf, String telefone) {
        super(nome, sexo, endereco, dataNascimento, cpf, telefone);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
