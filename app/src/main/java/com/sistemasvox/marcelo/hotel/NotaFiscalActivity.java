package com.sistemasvox.marcelo.hotel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.sistemasvox.marcelo.hotel.model.Hospede;
import com.sistemasvox.marcelo.hotel.model.NotaAdapter;
import com.sistemasvox.marcelo.hotel.model.NotaFiscal;
import com.sistemasvox.marcelo.hotel.model.Reserva;
import com.sistemasvox.marcelo.hotel.model.ReservaAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscalActivity extends Activity implements AdapterView.OnItemClickListener{

    List<NotaFiscal> notaFiscals;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_fiscal);
    }
    public void listarNotas(View v) {
        listView = new ListView(this);
        notaFiscals = new ArrayList<NotaFiscal>();

        notaFiscals.add(new NotaFiscal("01",0.00, new Hospede("Marcelo Vieira", "122.999.666-40", "M", "(34) 99150-9513", "2018-12-13", "01")));
        notaFiscals.add(new NotaFiscal("02",0.00, new Hospede("Marcelo Ômega", "111.222.333-40", "M", "(34) 99150-9513", "2018-12-13", "02")));

        listView.setAdapter(new NotaAdapter(this, notaFiscals));
        setContentView(listView);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NotaFiscal notaFiscal = (NotaFiscal) parent.getItemAtPosition(position);
        Toast.makeText(this, notaFiscal.getHospede().getNome(), Toast.LENGTH_SHORT).show();
    }

    private void mensagem(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
