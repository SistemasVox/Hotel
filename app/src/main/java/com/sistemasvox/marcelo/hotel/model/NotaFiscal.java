package com.sistemasvox.marcelo.hotel.model;

public class NotaFiscal {
    private String nome, cpf, valor;

    public NotaFiscal() {
    }

    public NotaFiscal(String nome, String cpf, String valor) {
        this.nome = nome;
        this.cpf = cpf;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
