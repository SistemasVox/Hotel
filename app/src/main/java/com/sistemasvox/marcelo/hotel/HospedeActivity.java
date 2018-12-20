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
import com.sistemasvox.marcelo.hotel.services.RetrofitService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        /*
        hospedes = new ArrayList<Hospede>();
        hospedes.add(new Hospede("Marcelo Vieira", "122.999.666-40", "M", "(34) 99150-9513", "2018-12-13"));
        hospedes.add(new Hospede("Marcelo Ômega", "111.222.333-40", "M", "(34) 99150-9513", "2018-12-13"));*/

        hospedes = (List<Hospede>) RetrofitService.getServico().getHospedes();

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
        if ((nome.getText().length() < 3) || (cpf.getText().length() != 14) || (sexo.getText().length() != 1) || (tefelone.getText().length() != 15) || (data.getText().length() != 10)) {
            mensagem("Dados inválidos, siga o exemplo em claro.");
        } else {
            mensagem("Cadastrando...");
            salvarHospede(new Hospede(nome.getText().toString(), cpf.getText().toString(), sexo.getText().toString(), tefelone.getText().toString(), data.getText().toString()));
        }
    }

    private void salvarHospede(Hospede hospede) {
        RetrofitService.getServico().deletaHospede(hospede.getCpf()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                mensagem("Hospede atualizado com sucesso.");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
        RetrofitService.getServico().salvarHospedeRetro(hospede).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                mensagem("Hospede salvo no banco de dados. ");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mensagem("Erro ao salvar Hospede no banco de dados. ");
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        preecher_salvar_Hospede(view, hospedes.get(position));
    }

    private void preecher_salvar_Hospede(View view, Hospede hospede) {
        cadastrarHospedes(view);
        TextView nome = findViewById(R.id.txtNomeRes);
        TextView cpf = findViewById(R.id.txtCPFR);
        TextView sexo = findViewById(R.id.txtSexoR);
        TextView tel = findViewById(R.id.txtTelR);
        TextView data_in = findViewById(R.id.txtDataINR);
        nome.setText(hospede.getNome());
        cpf.setText(hospede.getCpf());
        sexo.setText(hospede.getSexo());
        tel.setText(hospede.getTel());
        data_in.setText(hospede.getData_in());

    }

    private void mensagem(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
