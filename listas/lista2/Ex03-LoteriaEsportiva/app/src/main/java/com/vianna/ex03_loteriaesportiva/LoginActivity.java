package com.vianna.ex03_loteriaesportiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex03_loteriaesportiva.database.dao.ApostadorDao;
import com.vianna.ex03_loteriaesportiva.models.Apostador;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin, btnCallCriarApostador;
    TextInputLayout tiLogin, tiSenha;

    String login, senha;

    ApostadorDao apostadorDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding();
        registraEventos();
        apostadorDao = new ApostadorDao(getApplicationContext());
    }

    private void registraEventos() {
        btnCallCriarApostador.setOnClickListener(callCriarUsuario());
        btnLogin.setOnClickListener(login());
    }

    private View.OnClickListener login() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = tiLogin.getEditText().getText().toString();
                senha = tiSenha.getEditText().getText().toString();

                Apostador usuarioLogado = apostadorDao.findById(0);

                if (usuarioLogado.getNome() == login) {
                    Intent itn = new Intent(getApplicationContext(), ApostaActivity.class);
                    itn.putExtra("usuarioLogado", usuarioLogado);
                    startActivity(itn);
                }
            }
        };
    }

    private View.OnClickListener callCriarUsuario() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), CadastraApostadorActivity.class);
                startActivity(itn);
            }
        };
    }

    private void binding() {
        btnLogin = findViewById(R.id.btnLoginApostador);
        btnCallCriarApostador = findViewById(R.id.btnCadastrarUsuarioCallView);

        tiLogin = findViewById(R.id.tiNomeLogin);
        tiSenha = findViewById(R.id.tiSenhaLogin);
    }
}