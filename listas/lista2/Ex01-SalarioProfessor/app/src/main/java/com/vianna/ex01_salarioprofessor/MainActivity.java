package com.vianna.ex01_salarioprofessor;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vianna.ex01_salarioprofessor.models.Disciplina;
import com.vianna.ex01_salarioprofessor.models.Professor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnCadastroProfessor, btnLogin;

    private ArrayList<Professor> professores;
    private Professor professorLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();
        registraEventos();
        dadosProntos();
    }

    private void dadosProntos() {
        professores = new ArrayList<>();
        professores.add(new Professor("Daves", 30,
                true, true, true));
        professores.add(new Professor("Miriã",  30,
                false, false, false));
        professores.add(new Professor("Zezin", 30,
                false, true, true));

        professores.get(0).addDisciplina(new Disciplina("FPOO", 4, false));
        professores.get(0).addDisciplina(new Disciplina("Sistemas Operacionais", 4, true));
        professores.get(0).addDisciplina(new Disciplina("Padrões de Projeto", 2, false));
        professores.get(1).addDisciplina(new Disciplina("Redes de Computadores", 6, true));
    }

    private void registraEventos() {
        btnCadastroProfessor.setOnClickListener(callViewCadastroProfessor());
        btnLogin.setOnClickListener(callViewLoginProfessor());
    }

    private View.OnClickListener callViewLoginProfessor() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), LoginActivity.class);
                itn.putExtra("professores", professores);

                startActivity(itn);
            }
        };
    }

    private View.OnClickListener callViewCadastroProfessor() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), CadProfessorActivity.class);

                viewCadastroProfessor.launch(itn);
            }
        };
    }

    ActivityResultLauncher<Intent> viewCadastroProfessor = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 10) {
                        Professor p = (Professor) result.getData().getExtras()
                                .getSerializable("professorCriado");
                        professores.add(p);

                        Toast.makeText(getApplicationContext(), "Professor " + p.getNome() +
                                " cadastrado com sucesso!", Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    private void binding() {
        btnLogin = findViewById(R.id.btnLogin);
        btnCadastroProfessor = findViewById(R.id.btnCadastroProfessor);
    }
}