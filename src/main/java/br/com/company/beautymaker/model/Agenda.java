package br.com.company.beautymaker.model;
import java.time.LocalDateTime;

public class Agenda {
    private int id;
    private Funcionario funcionario;
    private Cliente cliente;
    private Servicos servicos;
    private LocalDateTime dataHora;

    public Agenda() {
    }

    public Agenda(int id, Funcionario funcionario, Cliente cliente, Servicos servicos, LocalDateTime dataHora) {
        this.id = id;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.servicos = servicos;
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
       this.cliente = cliente;
    }
    public void setServicos(Servicos servicos) {
    	this.servicos = servicos;
    }
    public Servicos getServicos() {
        return servicos;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}

