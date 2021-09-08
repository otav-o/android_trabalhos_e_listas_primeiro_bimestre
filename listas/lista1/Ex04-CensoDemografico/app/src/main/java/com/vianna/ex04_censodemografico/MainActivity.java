package com.vianna.ex04_censodemografico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex04_censodemografico.models.Censo;
import com.vianna.ex04_censodemografico.models.Genero;
import com.vianna.ex04_censodemografico.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RadioButton rbMasculino, rbFeminino;
    Button btnCadastrar, btnCalcular;
    TextInputLayout tiCorCabelos, tiIdade, tiCorOlhos, tiAltura;

    List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        registraEventos();
    }

    private void registraEventos() {
        btnCadastrar.setOnClickListener(cadastrarPessoa());
        btnCalcular.setOnClickListener(calcularResultado());
    }

    private View.OnClickListener cadastrarPessoa() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Genero g = rbFeminino.isChecked() ? Genero.feminino : Genero.masculino;
                String corCabelos = tiCorCabelos.getEditText().getText().toString();
                String corOlhos = tiCorOlhos.getEditText().getText().toString();
                int idade = Integer.parseInt(tiIdade.getEditText().getText().toString());
                double altura = Double.parseDouble(tiAltura.getEditText().getText().toString());

                listaPessoas.add(new Pessoa(g, corOlhos, corCabelos, idade, altura));

                Toast.makeText(getApplicationContext(),
                        String.format("Salvo"), Toast.LENGTH_LONG).show();
            }
        };
    }

    private View.OnClickListener calcularResultado() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa[] populacao = new Pessoa[listaPessoas.size()];
                listaPessoas.toArray(populacao);
                Censo c1 = new Censo(populacao);

                Toast.makeText(getApplicationContext(),
                        String.format("Dados desta população: "
                                + c1.retornarPesquisa()), Toast.LENGTH_LONG).show();
            }
        };
    }

    private void binding() {
        rbFeminino = findViewById(R.id.rbFeminino);
        rbMasculino = findViewById(R.id.rbMasculino);

        tiAltura = findViewById(R.id.tiAltura);
        tiCorCabelos = findViewById(R.id.tiCorCabelos);
        tiIdade = findViewById(R.id.tiIdade);
        tiCorOlhos = findViewById(R.id.tiCorOlhos);

        btnCadastrar = findViewById(R.id.btnCadastrarPessoa);
        btnCalcular = findViewById(R.id.btnCalcular);
    }
}