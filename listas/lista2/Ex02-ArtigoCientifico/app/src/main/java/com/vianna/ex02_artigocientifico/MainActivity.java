package com.vianna.ex02_artigocientifico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnCadastrarArtigo, btnCadastrarEscritor, btnAvaliarArtigo;
    TextView lblArtigosMaisAvaliados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();
        registraEventos();
    }

    private void registraEventos() {
        btnAvaliarArtigo.setOnClickListener(callViewAvaliarArtigo());
        btnCadastrarEscritor.setOnClickListener(callViewCadastrarEscritor());
        btnCadastrarArtigo.setOnClickListener(callViewCadastrarArtigo());
    }

    private View.OnClickListener callViewCadastrarArtigo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), CadastrarArtigoActivity.class);
                startActivity(itn);
            }
        };
    }

    private View.OnClickListener callViewCadastrarEscritor() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), CadastrarEscritorActivity.class);

//                viewCadastroEscritor.launch(itn);
                startActivity(itn);
            }
        };
    }

    private View.OnClickListener callViewAvaliarArtigo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: implementar
            }
        };
    }

    private void binding() {
        btnCadastrarArtigo = findViewById(R.id.btnSubmeterArtigoView);
        btnCadastrarEscritor = findViewById(R.id.btnCadastrarEscritorView);
        btnAvaliarArtigo = findViewById(R.id.btnAvaliarArtigoView);

        lblArtigosMaisAvaliados = findViewById(R.id.tvArtigosCampeoes);
    }
}