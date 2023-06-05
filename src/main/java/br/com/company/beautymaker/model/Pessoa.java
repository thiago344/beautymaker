package br.com.company.beautymaker.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Pessoa {
    private String nome;
    private String sexo;
    private String endereco;
    private String email;
    private Date dataNascimento;
    @Id
    private String cpf;
    private String telefone;

    public Pessoa() {
    }
    public void addAttribute(String string, Pessoa pessoa) {
		
		
	}

    public Pessoa(String nome, String sexo, String endereco, String email, Date dataNascimento, String cpf, String telefone) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date date) {
        this.dataNascimento = date;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

	
}