package com.vianna.ex05_pescador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex05_pescador.models.Peixe;
import com.vianna.ex05_pescador.models.RegulamentoPesca;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvLimitePeso, tvMulta, tvSomaMultas;
    Button btnCadastrar;
    TextInputLayout tiPeso;

    List<Peixe> pescados= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        atualizarInformacoes();
        btnCadastrar.setOnClickListener(cadastrarPeixe());
    }

    private View.OnClickListener cadastrarPeixe() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso = Double.parseDouble(tiPeso.getEditText().getText().toString());
                pescados.add(new Peixe(peso));

                Peixe[] peixesArray = new Peixe[pescados.size()];
                pescados.toArray(peixesArray);
                tvSomaMultas.setText(String.format("R$%.2f", RegulamentoPesca.calcularMulta(peixesArray)));
            }
        };
    }

    private void atualizarInformacoes() {
        tvLimitePeso.setText(String.format("%.2fkg", RegulamentoPesca.getPesoMaximoPorPescado()));
        tvMulta.setText(String.format("R$%.2f", RegulamentoPesca.getMultaPorQuiloExcedente()));
    }

    private void binding() {
        tvLimitePeso = findViewById(R.id.tvLimitePeso);
        tvMulta = findViewById(R.id.tvValorMulta);
        tvSomaMultas = findViewById(R.id.tvSomaMultas);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        tiPeso = findViewById(R.id.tiPeso);
    }
}