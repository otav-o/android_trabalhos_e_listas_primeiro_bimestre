package com.vianna.ex01_salarioprofessor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex01_salarioprofessor.models.Disciplina;
import com.vianna.ex01_salarioprofessor.models.Professor;

public class CadDisciplinaActivity extends AppCompatActivity {

    TextInputLayout tiNomeDisciplina, tiCreditosDisciplina;
    CheckBox cbEhEad;

    Professor professorLogado = (Professor) getIntent().getExtras().getSerializable("professorLogado");;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_disciplina);

        binding();
        registraEventos();
    }

    private void registraEventos() {
        cbEhEad.setOnClickListener(salvarDisciplina());
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
    }
}