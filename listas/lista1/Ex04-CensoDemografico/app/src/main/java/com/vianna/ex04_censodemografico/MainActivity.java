package com.vianna.ex04_censodemografico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.vianna.ex04_censodemografico.models.Censo;

public class MainActivity extends AppCompatActivity {

    RadioButton rbMasculino, rbFeminino;
    Button btnCadastrar, btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();
    }

    private void registraEventos() {
        btnCadastrar.setOnClickListener(cadastrarPessoa());
        btnCalcular.setOnClickListener(calcularResultado());
    }

    private View.OnClickListener cadastrarPessoa() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    private View.OnClickListener calcularResultado() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Censo c1 = new Censo(pessoas);

            }
        };
    }

    private void binding() {
        rbFeminino = findViewById(R.id.rbFeminino);
        rbMasculino = findViewById(R.id.rbMasculino);

        btnCadastrar = findViewById(R.id.btnCadastrarPessoa);
        btnCalcular = findViewById(R.id.btnCalcular);
    }
}