package com.vianna.ex05_pescador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex05_pescador.models.RegulamentoPesca;

public class MainActivity extends AppCompatActivity {

    TextView tvLimitePeso, tvMulta;
    Button btnCadastrar;
    TextInputLayout tiPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        atualizarInformacoes();
        // btnCadastrar.setOnClickListener(cadastrarPeixe());
    }

    private void atualizarInformacoes() {
        tvLimitePeso.setText(String.format("%.2f", RegulamentoPesca.getPesoMaximoPorPescado()));
        tvMulta.setText(String.format("%.2f", RegulamentoPesca.getMultaPorQuiloExcedente()));
    }

    private void binding() {
        tvLimitePeso = findViewById(R.id.tvLimitePeso);
        tvMulta = findViewById(R.id.tvValorMulta);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        tiPeso = findViewById(R.id.tiPeso);
    }
}