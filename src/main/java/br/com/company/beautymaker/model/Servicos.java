package br.com.company.beautymaker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servicos")
public class Servicos {

    @Id
    private int id;
    private String nome;

    public Servicos(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Servicos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
