package com.sistemasvox.marcelo.hotel.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sistemasvox.marcelo.hotel.R;

import java.util.List;

public class NotaAdapter extends BaseAdapter {
    Context ctx;
    List<NotaFiscal> notaFiscals;

    public NotaAdapter(Context ctx, List<NotaFiscal> notaFiscals) {
        this.ctx = ctx;
        this.notaFiscals = notaFiscals;
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
        //Passo 1 Criar o Objeto NotaFiscal
        NotaFiscal notaFiscal = notaFiscals.get(position);

        //Passo 2 Criar Linha (Lista de Layouts)
        View linha = LayoutInflater.from(ctx).inflate(R.layout.layout_notas_fiscais,null);

        //Passo 3 Preecher
        TextView nome = (TextView) linha.findViewById(R.id.txtNomeRes);
        TextView cpf = (TextView) linha.findViewById(R.id.txtCPFR);
        TextView valor = (TextView) linha.findViewById(R.id.txtValorNotaR);
        TextView id = (TextView) linha.findViewById(R.id.txtNotaID);

        nome.setText(notaFiscal.getHospede().getNome());
        cpf.setText(notaFiscal.getHospede().getCpf());
        valor.setText(String.valueOf(notaFiscal.getValor()));
        id.setText(notaFiscal.getCod());

        return linha;
    }
}
