package com.vianna.ex03_calculosalario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex03_calculosalario.models.Empregado;
import com.vianna.ex03_calculosalario.models.Emprego;

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
                double salarioHora = Double.parseDouble(
                        tiSalarioPorHora.getEditText().getText().toString());
                int numeroDependentes = Integer.parseInt(
                        tiNumeroDependentes.getEditText().getText().toString());
                double horasTrabalhadas = Double.parseDouble(
                        tiHorasTrabalhadas.getEditText().getText().toString());

                Emprego e = new Emprego(salarioHora, horasTrabalhadas);
                Empregado empregado = new Empregado(e, numeroDependentes);

                Toast.makeText(getApplicationContext(),
                        String.format("Seu salário líquido, com as deduções do governo, é de: "
                                + empregado.getSalarioLiquido()), Toast.LENGTH_LONG).show();
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