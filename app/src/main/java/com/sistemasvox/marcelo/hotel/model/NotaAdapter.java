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
    List<NotaFiscal> lista;
    final String TAG = "Teste";

    public NotaAdapter(Context ctx, List<NotaFiscal> lista) {
        this.ctx = ctx;
        this.lista = lista;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Passo 1 Criar o Objeto NotaFiscal
        NotaFiscal notaFiscal = lista.get(position);

        //Passo 2 Criar Linha (Lista de Layouts)
        View linha = LayoutInflater.from(ctx).inflate(R.layout.layout_notas_fiscais,null);

        //Passo 3 Preecher
        TextView nome = linha.findViewById(R.id.txtNomeRes);
        TextView cpf = linha.findViewById(R.id.txtCPFR);
        TextView valor = linha.findViewById(R.id.txtValorNotaR);

        nome.setText(notaFiscal.getNome());
        cpf.setText(notaFiscal.getCpf());
        valor.setText(String.valueOf(notaFiscal.getValor()));

        return linha;
    }
}
