package com.sistemasvox.marcelo.hotel.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sistemasvox.marcelo.hotel.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReservaAdapter extends BaseAdapter {
    Context ctx;
    List<Reserva> lista;


    public ReservaAdapter(Context ctx, List<Reserva> lista) {
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Passo 1 Criar o Objeto Hospede
        Reserva reserva = lista.get(position);

        //Passo 2 Criar Linha (Lista de Layouts)
        View linha = LayoutInflater.from(ctx).inflate(R.layout.layout_reserva,null);

        //Passo 3 Preecher
        TextView nome = (TextView) linha.findViewById(R.id.txtNomeRes);
        TextView cpf = (TextView) linha.findViewById(R.id.txtCPFR);
        TextView tempo = (TextView) linha.findViewById(R.id.txtTempHospR);

        nome.setText(reserva.getHospede().getNome());
        cpf.setText(reserva.getHospede().getCpf());
        tempo.setText(tempoHostegagem(reserva.getHospede().getData_in()));

        return null;
    }

    private String tempoHostegagem(String data_in) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = null;
        try {
            firstDate = sdf.parse(sdf.format(new Date().getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date secondDate = null;
        try {
            secondDate = sdf.parse(data_in);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return String.valueOf(diff);
    }
}
