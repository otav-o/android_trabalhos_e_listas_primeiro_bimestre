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

public class AvaliarArtigoActivity extends AppCompatActivity {

    TextInputLayout tiNota;
    Spinner spinner;
    Button btnVotar;

    private ArrayList<Artigo> artigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliar_artigo);

        artigos = (ArrayList<Artigo>) getIntent().getExtras().getSerializable("artigos");

        binding();
        preencheSpinner();
    }

    private void preencheSpinner() {

        ArrayAdapter<Artigo> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, artigos);

        spinner.setAdapter(adapter);
    }

    private void binding() {
        tiNota = findViewById(R.id.tiNotaArtigo);
        spinner = findViewById(R.id.spinner2);
        btnVotar = findViewById(R.id.btnVotar);

        btnVotar.setOnClickListener(atribuirNota());
    }

    private View.OnClickListener atribuirNota() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Artigo a = (Artigo) spinner.getSelectedItem();
                a.setNota(Integer.parseInt(tiNota.getEditText().getText().toString()));

                Intent i = new Intent();
                i.putExtra("artigo", a);
                setResult(10, i);

                finish();
            }
        };
    }
}