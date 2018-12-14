package com.sistemasvox.marcelo.hotel.model;

public class NotaFiscal {
    private String cod;
    private Double valor;
    private Hospede hospede;

    public NotaFiscal() {
    }

    public NotaFiscal(String cod, Double valor, Hospede hospede) {
        this.cod = cod;
        this.valor = valor;
        this.hospede = hospede;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
    @Override
    public String toString() {
        return "NotaFiscal{" +
                "cod='" + cod + '\'' +
                ", valor=" + valor +
                ", hospede=" + hospede +
                '}';
    }
}
