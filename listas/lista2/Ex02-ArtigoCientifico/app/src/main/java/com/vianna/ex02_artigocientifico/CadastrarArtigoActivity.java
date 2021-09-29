package com.vianna.ex02_artigocientifico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex02_artigocientifico.models.Artigo;
import com.vianna.ex02_artigocientifico.models.Pessoa.Pessoa;

import java.util.ArrayList;

public class CadastrarArtigoActivity extends AppCompatActivity {

    // TODO: exibir as pessoas cadastradas e permitir
    //  que sejam selecinadas como escritoras do artigo.

    TextInputLayout tiNome, tiDescricao;
    Button btnSalvar;
    Spinner spEscritores;
    ArrayList<Pessoa> escritores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_artigo);
        binding();

        escritores = (ArrayList<Pessoa>) getIntent().getExtras().getSerializable("escritores");
        preencheSpinner(escritores);

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

                a.addAutor((Pessoa) spEscritores.getSelectedItem());

                Intent i = new Intent();
                i.putExtra("artigo", a);
                setResult(10, i);

                finish();
            }
        };
    }

    private void preencheSpinner(ArrayList<Pessoa> pessoas) {
        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, pessoas);

        spEscritores.setAdapter(adapter);
    }

    private void binding() {
        tiNome = findViewById(R.id.tiTituloArtigoCadastro);
        tiDescricao = findViewById(R.id.tiDescricaoArtigo);

        btnSalvar = findViewById(R.id.btnSalvarArtigo);
        spEscritores = findViewById(R.id.spinner);
    }
}