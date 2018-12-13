package com.sistemasvox.marcelo.hotel.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sistemasvox.marcelo.hotel.R;

import java.util.List;

public class HospedeAdapter  extends BaseAdapter {

    Context ctx;
    List<Hospede> lista;

    public HospedeAdapter(Context ctx, List<Hospede> lista) {
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
        Hospede hospede = lista.get(position);

        //Passo 2 Criar Linha (Lista de Layouts)
        View linha = LayoutInflater.from(ctx).inflate(R.layout.hospede,null);

        //Passo 3 Preecher

        TextView nome = (TextView) linha.findViewById(R.id.txtNomeRes);
        TextView cpf = (TextView) linha.findViewById(R.id.txtCPFR);
        TextView sexo = (TextView) linha.findViewById(R.id.txtSexoR);
        TextView tel = (TextView) linha.findViewById(R.id.txtTelR);
        TextView data_in = (TextView) linha.findViewById(R.id.txtDataINR);
        TextView numNota = (TextView) linha.findViewById(R.id.txtNotaIDR);


        nome.setText(hospede.getNome());
        cpf.setText(hospede.getCpf());
        sexo.setText(hospede.getSexo());
        tel.setText(hospede.getTel());
        data_in.setText(hospede.getData_in());
        numNota.setText(hospede.getNumNota());

        return linha;
    }
}
