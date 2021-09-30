package com.vianna.ex03_loteriaesportiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin, btnCallCriarApostador;
    TextInputLayout tiLogin, tiSenha;

    String login, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding();
        registraEventos();
    }

    private void registraEventos() {
        btnCallCriarApostador.setOnClickListener(callCriarUsuario());
        btnLogin.setOnClickListener(login());
    }

    private View.OnClickListener login() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: validar usuário com banco de dados
                login = tiLogin.getEditText().getText().toString();
                senha = tiSenha.getEditText().getText().toString();
            }
        };
    }

    private View.OnClickListener callCriarUsuario() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: chamar tela de cadastro
//                Intent itn = new Intent(getApplicationContext(), xxxx.class);
//                itn.putExtra("usuarioLogado", yyyy);
//                startActivity(itn);
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