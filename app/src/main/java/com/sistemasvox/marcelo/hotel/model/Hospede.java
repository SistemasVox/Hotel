package com.sistemasvox.marcelo.hotel.model;

public class Hospede {
    private String nome, cpf, sexo, tel, data_in;

    public Hospede() {
    }

    public Hospede(String nome, String cpf, String sexo, String tel, String data_in) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.tel = tel;
        this.data_in = data_in;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getData_in() {
        return data_in;
    }

    public void setData_in(String data_in) {
        this.data_in = data_in;
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo='" + sexo + '\'' +
                ", tel='" + tel + '\'' +
                ", data_in='" + data_in + '\'' +
                '}';
    }
}
