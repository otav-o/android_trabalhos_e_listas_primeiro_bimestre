package com.vianna.ex01_salarioprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex01_salarioprofessor.models.Professor;

public class CadProfessorActivity extends AppCompatActivity {

    TextInputLayout tiNome, tiSalarioHora;
    CheckBox cbEspecializacao, cbMestrado, cbDoutorado;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_professor);

        binding();
        registrarEventos();
    }

    private void registrarEventos() {
        btnSalvar.setOnClickListener(salvarProfessor());
    }

    private View.OnClickListener salvarProfessor() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = tiNome.getEditText().getText().toString();
                double salarioHora = Double.parseDouble(tiSalarioHora.getEditText().getText().toString());

                Professor p = new Professor(nome, salarioHora,
                        cbDoutorado.isChecked(), cbEspecializacao.isChecked(), cbMestrado.isChecked());

                Intent i = new Intent();
                i.putExtra("professorCriado", p);
                setResult(10, i);

                finish();
            }
        };
    }

    private void binding() {
        tiNome = findViewById(R.id.tiNomeProfessorCadastro);
        tiSalarioHora = findViewById(R.id.tiSalarioPorHoraCadastro);

        cbEspecializacao = findViewById(R.id.cbEspecializacao);
        cbMestrado = findViewById(R.id.cbMestrado);
        cbDoutorado = findViewById(R.id.cbDoutorado);

        btnSalvar = findViewById(R.id.btnSalvarProfessorCadastro);
    }
}