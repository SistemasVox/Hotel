package com.sistemasvox.marcelo.hotel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemasvox.marcelo.hotel.model.NotaAdapter;
import com.sistemasvox.marcelo.hotel.model.NotaFiscal;
import com.sistemasvox.marcelo.hotel.services.RetrofitService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotaFiscalActivity extends Activity {

    List<NotaFiscal> notaFiscals;
    ListView listView;
    final String TAG = "Zzzzz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_fiscal);
    }

    public void listarNotas(View v) {
        listView = new ListView(this);
        /*
        notaFiscals = new ArrayList<NotaFiscal>();
        notaFiscals.add(new NotaFiscal("Marcelo Vieira", "122.999.666-40", "100.00"));
        notaFiscals.add(new NotaFiscal("Marcelo Ômega", "111.222.333-40", "200.00"));
        */
        getNostas(this);


    }

    private void getNostas(final Context context) {
        Call<List<NotaFiscal>> call = RetrofitService.getServico().getNotas();
        call.enqueue(new Callback<List<NotaFiscal>>() {
            @Override
            public void onResponse(Call<List<NotaFiscal>> call, Response<List<NotaFiscal>> response) {
                if (response.isSuccessful()) {
                    notaFiscals = response.body();
                    listView.setAdapter(new NotaAdapter(context, notaFiscals));
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            preecher_salvar_Notas(view, notaFiscals.get(position));
                        }
                    });
                    setContentView(listView);
                }
            }

            @Override
            public void onFailure(Call<List<NotaFiscal>> call, Throwable t) {
                mensagem("Erro, talvez seu servidor esteja onffline.");
            }
        });
    }

    public void cadastrarNotas(View v) {
        setContentView(R.layout.savedit_notas_fiscais);
        TextView textView = findViewById(R.id.btnDel);
        textView.setVisibility(View.INVISIBLE);

    }

    private void preecher_salvar_Notas(View v, NotaFiscal notaFiscal) {

        setContentView(R.layout.savedit_notas_fiscais);

        TextView nome = findViewById(R.id.txtNomeResE);
        TextView cpf = findViewById(R.id.txtCPFRR);
        TextView valor = findViewById(R.id.txtValorNotaRR);

        Log.i(TAG, notaFiscal.getNome());
        Log.i(TAG, notaFiscal.getCpf());
        Log.i(TAG, notaFiscal.getValor());

        nome.setText(notaFiscal.getNome());
        cpf.setText(notaFiscal.getCpf());
        valor.setText(String.valueOf(notaFiscal.getValor()));

    }

    public void salvarNota(NotaFiscal notaFiscal) {
        RetrofitService.getServico().salvarNota(notaFiscal).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                mensagem("Nota salva no banco de dados. ");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mensagem("Erro ao salvar nota no banco de dados. ");
            }
        });
    }

    public void lerNota(View v) {
        TextView nome = findViewById(R.id.txtNomeResE);
        TextView cpf = findViewById(R.id.txtCPFRR);
        TextView valor = findViewById(R.id.txtValorNotaRR);
        if ((nome.getText().length() < 3) || (cpf.getText().length() != 14) || Double.parseDouble(valor.getText().toString()) < 100) {
            mensagem("Dados inválidos");
        } else {
            mensagem("Cadastrando...");
            //Atualizando se existir
            deletaNota(v);
            salvarNota(new NotaFiscal(nome.getText().toString(), cpf.getText().toString(), valor.getText().toString()));
        }

    }

    public void deletaNota(View v) {
        TextView textView = findViewById(R.id.txtCPFRR);
        RetrofitService.getServico().deletaNota(textView.getText().toString()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                mensagem("Nota deletada com sucesso.");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                mensagem("Hospede não encontrado, ou servidor Offline.");
            }
        });
        setContentView(R.layout.activity_nota_fiscal);
    }
    private void mensagem(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
