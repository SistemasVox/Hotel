package com.sistemasvox.marcelo.hotel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemasvox.marcelo.hotel.model.Hospede;
import com.sistemasvox.marcelo.hotel.model.HospedeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HospedeActivity extends Activity implements AdapterView.OnItemClickListener {

    List<Hospede> hospedes;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospede);
    }

    public void listarHospedes(View v) {
        listView = new ListView(this);
        setContentView(listView);
        hospedes = new ArrayList<Hospede>();

        hospedes.add(new Hospede("Marcelo Vieira", "122.999.666-40", "M", "(34) 99150-9513", "2018-12-13", "01"));
        hospedes.add(new Hospede("Marcelo Ômega", "111.222.333-40", "M", "(34) 99150-9513", "2018-12-13", "02"));

        listView.setAdapter(new HospedeAdapter(this, hospedes));
        listView.setOnItemClickListener(this);

    }

    public void cadastrarHospedes(View v) {
        setContentView(R.layout.savedit_hosp);
    }

    public void salvarHospedes(View v) {
        TextView nome = findViewById(R.id.txtNomeRes);
        TextView cpf = findViewById(R.id.txtCPFR);
        TextView sexo = findViewById(R.id.txtSexoR);
        TextView tefelone = findViewById(R.id.txtTelR);
        TextView data = findViewById(R.id.txtDataINR);
        TextView nota = findViewById(R.id.txtNotaIDR);
        if ((nome.getText().length() < 3) || (cpf.getText().length() != 14) || (sexo.getText().length() != 1) || (tefelone.getText().length() != 15) || (data.getText().length() != 10) || (nota.getText().length() != 2)) {
            mensagem("Dados inválidos, siga o exemplo em claro.");
        } else {
            mensagem("Dados OK");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Hospede hospede = (Hospede) parent.getItemAtPosition(position);
        Toast.makeText(this, hospede.getNome(), Toast.LENGTH_SHORT).show();
    }

    private void mensagem(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
