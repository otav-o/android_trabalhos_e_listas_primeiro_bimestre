package com.vianna.ex06_eleicaorepresentante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tiNome, tiMatricula, tiMatriculaVoto;
    Button btnCadastrar, btnVotar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        definirMetodosBotoes();
    }

    private void definirMetodosBotoes() {
        btnCadastrar.setOnClickListener(cadastrarAluno());
        btnVotar.setOnClickListener(votar());
    }

    private View.OnClickListener votar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    private View.OnClickListener cadastrarAluno() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    private void binding() {
        tiNome = findViewById(R.id.tiNome);
        tiMatricula = findViewById(R.id.tiMatriculaCadastro);
        tiMatriculaVoto = findViewById(R.id.tiMatriculaVoto);
        btnCadastrar = findViewById(R.id.btnCadastro);
        btnVotar = findViewById(R.id.btnVotar);
    }
}