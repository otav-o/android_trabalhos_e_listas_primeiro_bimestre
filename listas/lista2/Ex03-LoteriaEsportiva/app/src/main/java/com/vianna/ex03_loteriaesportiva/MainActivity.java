package com.vianna.ex03_loteriaesportiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vianna.ex03_loteriaesportiva.database.dao.ApostadorDao;
import com.vianna.ex03_loteriaesportiva.models.Apostador;

public class MainActivity extends AppCompatActivity {

    Button btnFazerLogin;
    ApostadorDao apostadorDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();
        registrarEventos();
        apostadorDao = new ApostadorDao(getApplicationContext());
        preparedDatabase();

        Toast.makeText(getApplicationContext(),
                "Quantidade de usuários cadastrados = " + apostadorDao.count(),
                Toast.LENGTH_LONG).show();

    }

    private void preparedDatabase() {
        if (apostadorDao.count() == 0) {
            apostadorDao.inserir(new Apostador(0, "Daves"));
            apostadorDao.inserir(new Apostador(0, "Miriã"));
            apostadorDao.inserir(new Apostador(0, "Camila"));
            apostadorDao.inserir(new Apostador(0, "Leonardo"));
        }
    }

    private void registrarEventos() {
        btnFazerLogin.setOnClickListener(callLoginView());
    }

    private View.OnClickListener callLoginView() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: chamar a outra tela
                Intent itn = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(itn);
            }
        };
    }

    private void binding() {
        btnFazerLogin = findViewById(R.id.btnFazerLoginCallView);
    }
}