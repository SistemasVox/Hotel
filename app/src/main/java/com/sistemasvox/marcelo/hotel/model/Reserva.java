package com.sistemasvox.marcelo.hotel.model;

public class Reserva {
    private String cpf, tempoHosp;
    private Hospede hospede;

    public Reserva() {
    }

    public Reserva(String cpf, Hospede hospede) {
        this.cpf = cpf;
        this.hospede = hospede;
    }

    public Reserva(String cpf, String tempoHosp, Hospede hospede) {
        this.cpf = cpf;
        this.tempoHosp = tempoHosp;
        this.hospede = hospede;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTempoHosp() {
        return tempoHosp;
    }

    public void setTempoHosp(String tempoHosp) {
        this.tempoHosp = tempoHosp;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
}
