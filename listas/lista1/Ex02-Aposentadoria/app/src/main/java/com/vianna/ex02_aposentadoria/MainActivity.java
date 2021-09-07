package com.vianna.ex02_aposentadoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex02_aposentadoria.models.Empregado;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tiAnoNascimento;
    private TextInputLayout tiAnosTrabalhados;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        btnCalcular.setOnClickListener(calcular());
    }

    private View.OnClickListener calcular() {
        return  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int anoNascimento = Integer.parseInt(tiAnoNascimento.getEditText().getText().toString());
                int anosTrabalhados = Integer.parseInt(tiAnosTrabalhados.getEditText().getText().toString());
                Empregado emp = new Empregado(anoNascimento, anosTrabalhados);

                if (emp.podeAposentar())
                    Toast.makeText(getApplicationContext(),
                            String.format("Você pode aposentar!"), Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),
                            String.format("Você não pode aposentar!"), Toast.LENGTH_LONG).show();
            }
        };
    }

    private void binding() {
        tiAnoNascimento = findViewById(R.id.tiAnoNascimento);
        tiAnosTrabalhados = findViewById(R.id.tiAnosTrabalhados);
        btnCalcular = findViewById(R.id.btnCalcular);
    }
}