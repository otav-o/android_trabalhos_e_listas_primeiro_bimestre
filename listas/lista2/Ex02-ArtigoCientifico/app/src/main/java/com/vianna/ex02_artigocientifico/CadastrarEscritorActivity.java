package com.vianna.ex02_artigocientifico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex02_artigocientifico.models.Pessoa.Aluno;
import com.vianna.ex02_artigocientifico.models.Pessoa.Orientador;
import com.vianna.ex02_artigocientifico.models.Pessoa.Pessoa;
import com.vianna.ex02_artigocientifico.models.Pessoa.Professor;

public class CadastrarEscritorActivity extends AppCompatActivity {

    Button btnSalvar;
    TextInputLayout tiNomeEscritor;
    RadioButton rbAluno, rbProfessor, rbOrientador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_escritor);

        binding();
        registraEventos();
    }

    private void registraEventos() {
        btnSalvar.setOnClickListener(salvarEscritor());
    }

    private View.OnClickListener salvarEscritor() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = tiNomeEscritor.getEditText().getText().toString();
                Pessoa p;
                if (rbOrientador.isChecked())
                    p = new Orientador(nome);
                else if (rbProfessor.isChecked())
                    p = new Professor(nome);
                else
                    p = new Aluno(nome);

                // TODO fazer um ActivityResultLauncher na tela anterior e passar isso para lá
                Toast.makeText(getApplicationContext(), "Pessoa " + p.getNome() +
                        " cadastrada com sucesso!", Toast.LENGTH_LONG).show();
            }
        };
    }

    private void binding() {
        btnSalvar = findViewById(R.id.btnSalvarEscritor);

        tiNomeEscritor = findViewById(R.id.tiNomeEscritorCadastro);

        rbAluno = findViewById(R.id.rbAluno);
        rbProfessor = findViewById(R.id.rbProfessor);
        rbOrientador = findViewById(R.id.rbOrientador);
    }
}