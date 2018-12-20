package com.sistemasvox.marcelo.hotel.services;

import com.sistemasvox.marcelo.hotel.model.Hospede;
import com.sistemasvox.marcelo.hotel.model.NotaFiscal;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InterfaceDeServicos {

    @GET("/hospedes/{cpf}")
    Call<Hospede> getHospede(@Path("cpf") String cpf);

    @GET("/hospedes")
    Call<List<Hospede>> getHospedes();

    @DELETE("/hospedes/{cpf}")
    Call<ResponseBody> deletaHospede(@Path("cpf") int id);

    @POST("/hospede")
    Call<ResponseBody> salvarHospedeRetro(@Body Hospede hospede);

    @GET("/notas/{id}")
    Call<NotaFiscal> getNota(@Path("id") String id);

    @GET("/notas")
    Call<List<NotaFiscal>> getNotas();

    @DELETE("/notas/{cpf}")
    Call<ResponseBody> deletaNota(@Path("cpf") String id);

    @POST("/nota")
    Call<ResponseBody> salvarNota(@Body NotaFiscal notaFiscal);
}
