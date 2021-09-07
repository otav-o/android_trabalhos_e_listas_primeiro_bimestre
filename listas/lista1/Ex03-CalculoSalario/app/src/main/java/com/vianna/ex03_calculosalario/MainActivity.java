package com.vianna.ex03_calculosalario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tiHorasTrabalhadas;
    TextInputLayout tiSalarioPorHora;
    TextInputLayout tiNumeroDependentes;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        btnCalcular.setOnClickListener(calcularSalario());
    }

    private View.OnClickListener calcularSalario() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }

    private void binding() {
        tiHorasTrabalhadas = findViewById(R.id.tiHorasTrabalhadas);
        tiNumeroDependentes = findViewById(R.id.tiNumeroDependentes);
        tiSalarioPorHora = findViewById(R.id.tiSalarioPorHora);
        btnCalcular = findViewById(R.id.button);
    }
}