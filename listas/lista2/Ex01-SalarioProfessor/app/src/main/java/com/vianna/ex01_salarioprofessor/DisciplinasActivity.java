package com.vianna.ex01_salarioprofessor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.vianna.ex01_salarioprofessor.models.Disciplina;
import com.vianna.ex01_salarioprofessor.models.Professor;

import java.util.ArrayList;

public class DisciplinasActivity extends AppCompatActivity {

    TextView lblDisciplinasListagem, lblProfessorLogado;
    ArrayList<Disciplina> disciplinas;
    Professor professorLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas);

        binding();
        professorLogado = (Professor) getIntent().getExtras().getSerializable("professorLogado");
        disciplinas = (ArrayList<Disciplina>) professorLogado.getDisciplinas();

        mostrarDadosEmTela();
    }

    private void mostrarDadosEmTela() {
        lblProfessorLogado.setText("Disciplinas do professor: " + professorLogado.getNome());
        String base = "";
        for (Disciplina d: disciplinas) {
            base += String.format("%s, Créditos: %d, %s EAD \n", d.getNome(), d.getCreditos(),
                    d.getEhEad() ? "É" : "Não é");
        }
        lblDisciplinasListagem.setText(base);
    }

    private void binding() {
        lblDisciplinasListagem = findViewById(R.id.tvDisciplinasListagem);
        lblProfessorLogado = findViewById(R.id.tvNomeProfessorLogadoDisciplinas);
    }
}