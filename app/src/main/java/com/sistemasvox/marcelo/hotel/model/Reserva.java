package com.sistemasvox.marcelo.hotel.model;

public class Reserva {
    private String cod, tempoHosp;
    private Hospede hospede;

    public Reserva() {
    }

    public Reserva(String cod, String tempoHosp, Hospede hospede) {
        this.cod = cod;
        this.tempoHosp = tempoHosp;
        this.hospede = hospede;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
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
