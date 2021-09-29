package com.vianna.ex03_loteriaesportiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnFazerLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();
        registrarEventos();
    }

    private void registrarEventos() {
        btnFazerLogin.setOnClickListener(callLoginView());
    }

    private View.OnClickListener callLoginView() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: chamar a outra tela
                //Intent itn = new Intent(getApplicationContext(), ???.class);
                //startActivity(itn);
            }
        };
    }

    private void binding() {
        btnFazerLogin = findViewById(R.id.btnFazerLoginCallView);
    }
}