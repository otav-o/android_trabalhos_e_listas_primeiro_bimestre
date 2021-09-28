package com.vianna.ex01_salarioprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex01_salarioprofessor.models.Disciplina;
import com.vianna.ex01_salarioprofessor.models.Professor;

public class CadDisciplinaActivity extends AppCompatActivity {

    TextInputLayout tiNomeDisciplina, tiCreditosDisciplina;
    CheckBox cbEhEad;
    Button btnSalvarDisciplina, btnMostrarDisciplinas;
    TextView lblNomeProfessor;

    Professor professorLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_disciplina);

        professorLogado = (Professor) getIntent().getExtras().getSerializable("professorLogado");
        binding();
        lblNomeProfessor.setText(String.format("Professor logado: %s", professorLogado.getNome()));
        registraEventos();
    }

    private void registraEventos() {
        btnSalvarDisciplina.setOnClickListener(salvarDisciplina());
        btnMostrarDisciplinas.setOnClickListener(mostrarDisciplinasProfessorLogado());
    }

    private View.OnClickListener mostrarDisciplinasProfessorLogado() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itn = new Intent(getApplicationContext(), DisciplinasActivity.class);
                itn.putExtra("professorLogado", professorLogado);
                startActivity(itn);
            }
        };
    }

    private View.OnClickListener salvarDisciplina() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disciplina d = new Disciplina(tiNomeDisciplina.getEditText().getText().toString(),
                        Integer.parseInt(tiCreditosDisciplina.getEditText().getText().toString()),
                        cbEhEad.isChecked());

                professorLogado.addDisciplina(d);
            }
        };
    }

    private void binding() {
        tiCreditosDisciplina = findViewById(R.id.tiCreditosDisciplina);
        tiNomeDisciplina = findViewById(R.id.tiNomeDisciplina);
        cbEhEad = findViewById(R.id.cbEhEad);
        btnSalvarDisciplina = findViewById(R.id.btnSalvarDisciplina);
        lblNomeProfessor = findViewById(R.id.tvNomeProfessorLogado);
        btnMostrarDisciplinas = findViewById(R.id.btnMostrarDisciplinasProfessor);
    }
}