package com.vianna.ex03_loteriaesportiva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex03_loteriaesportiva.database.dao.ApostadorDao;
import com.vianna.ex03_loteriaesportiva.models.Apostador;

public class CadastraApostadorActivity extends AppCompatActivity {

    TextInputLayout tiNome, tiSenha, tiConfirmacaoSenha;
    Button btnSalvar;
    ApostadorDao apostadorDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_apostador);

        binding();
        registraEventos();
        apostadorDao = new ApostadorDao(getApplicationContext());
    }

    private void registraEventos() {
        btnSalvar.setOnClickListener(criarConta());
    }

    private View.OnClickListener criarConta() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Apostador a = new Apostador(0,
                        tiNome.getEditText().getText().toString());
                apostadorDao.inserir(a);
            }
        };
    }

    private void binding() {
        tiNome = findViewById(R.id.tiNomeApostadorCadastro);
        tiSenha = findViewById(R.id.tiSenhaApostadorCadastro);
        tiConfirmacaoSenha = findViewById(R.id.tiConfirmaSenhaApostadorCadastro);

        btnSalvar = findViewById(R.id.btnCriarContaApostador);
    }
}