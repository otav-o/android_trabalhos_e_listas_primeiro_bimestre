package com.vianna.ex06_eleicaorepresentante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex06_eleicaorepresentante.models.Aluno;
import com.vianna.ex06_eleicaorepresentante.models.Eleicao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tiNome, tiMatricula, tiMatriculaVoto;
    Button btnCadastrar, btnVotar;

    private List<Aluno> listaAlunos = new ArrayList<>();

    Aluno votante = new Aluno(123, "Qualquer"); // ainda não sei fazer cadastros avançados, login, retornar alunos cadastrados e exibir na tela, etc.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        definirMetodosBotoes();
    }

    private void definirMetodosBotoes() {
        btnCadastrar.setOnClickListener(cadastrarAluno());
        btnVotar.setOnClickListener(votar());
    }

    private View.OnClickListener votar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eleicao e = new Eleicao(listaAlunos);

                int matriculaCandidato = Integer.parseInt(tiMatriculaVoto.getEditText().getText().toString());
                Aluno escolhido = null;
                try {
                    escolhido = e.retornarAlunoPorMatricula(matriculaCandidato);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                try {
                    votante.votar(escolhido);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                Toast.makeText(getApplicationContext(),
                        e.retornarResultados(), Toast.LENGTH_LONG).show();
            }
        };
    }

    private View.OnClickListener cadastrarAluno() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = tiNome.getEditText().getText().toString();
                int matricula = Integer.parseInt(tiMatricula.getEditText().getText().toString());
                listaAlunos.add(new Aluno(matricula, nome));

                Toast.makeText(getApplicationContext(),
                        String.format("Sucesso!"), Toast.LENGTH_LONG).show();
            }
        };
    }

    private void binding() {
        tiNome = findViewById(R.id.tiNome);
        tiMatricula = findViewById(R.id.tiMatriculaCadastro);
        tiMatriculaVoto = findViewById(R.id.tiMatriculaVoto);
        btnCadastrar = findViewById(R.id.btnCadastro);
        btnVotar = findViewById(R.id.btnVotar);
    }
}