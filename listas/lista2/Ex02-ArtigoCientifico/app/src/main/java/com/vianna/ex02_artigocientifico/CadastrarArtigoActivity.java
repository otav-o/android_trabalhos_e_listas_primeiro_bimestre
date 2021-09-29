package com.vianna.ex02_artigocientifico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex02_artigocientifico.models.Artigo;

public class CadastrarArtigoActivity extends AppCompatActivity {

    // TODO: exibir as pessoas cadastradas e permitir
    //  que sejam selecinadas como escritoras do artigo.

    TextInputLayout tiNome, tiDescricao;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_artigo);
        binding();

        registraEventos();
    }

    private void registraEventos() {
        btnSalvar.setOnClickListener(salvarArtigo());
    }

    private View.OnClickListener salvarArtigo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Artigo a = new Artigo(tiNome.getEditText().getText().toString(),
                        tiDescricao.getEditText().getText().toString());

                // TODO: permitir seleção de autor
//                a.addAutor();

                Intent i = new Intent();
                i.putExtra("artigo", a);
                setResult(10, i);

                finish();
            }
        };
    }

    private void binding() {
        tiNome = findViewById(R.id.tiTituloArtigoCadastro);
        tiDescricao = findViewById(R.id.tiDescricaoArtigo);

        btnSalvar = findViewById(R.id.btnSalvarArtigo);
    }
}