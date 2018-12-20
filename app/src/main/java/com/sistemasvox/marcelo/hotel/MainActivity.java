package com.sistemasvox.marcelo.hotel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity extends Activity implements View.OnKeyListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnHospede(View v) {
        Intent i = new Intent(this, HospedeActivity.class);
        startActivity(i);
    }
    public void btnNotas(View v) {
        Intent i = new Intent(this, NotaFiscalActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP;
    }
}
