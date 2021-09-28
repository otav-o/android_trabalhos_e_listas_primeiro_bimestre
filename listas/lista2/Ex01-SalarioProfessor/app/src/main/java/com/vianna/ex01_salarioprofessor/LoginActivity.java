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

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex01_salarioprofessor.models.Disciplina;
import com.vianna.ex01_salarioprofessor.models.Professor;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout tiNomeProfessor;
    Button btnLogar;
    ArrayList<Professor> professores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        binding();
        registraEventos();
        professores = (ArrayList<Professor>) getIntent().getExtras().getSerializable("professores");

        Toast.makeText(getApplicationContext(), professores.get(0).getNome(),
                Toast.LENGTH_LONG).show();

    }

    private void registraEventos() {
        btnLogar.setOnClickListener(logar());
    }

    private View.OnClickListener logar() { // na prática, logar significa abrir a tela de cadastro de disciplinas
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent itn = new Intent(getApplicationContext(), CadDisciplinaActivity.class);
                    Professor professorLogado = encontrarProfessor(tiNomeProfessor.getEditText().getText().toString());
                    itn.putExtra("professorLogado", professorLogado);
//                    viewCadastroDisciplina.launch(itn);

                    startActivity(itn);
                }
            };
        }

    private Professor encontrarProfessor(String nome) {
        for (Professor p: professores) {
            if(nome.equals(p.getNome()))
                return p;
        }
        return null;
    }

//    ActivityResultLauncher<Intent> viewCadastroDisciplina = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result.getResultCode() == 10) {
//                        Disciplina d = (Disciplina) result.getData().getExtras().getSerializable("disciplina");
//                        // TODO: consertar isso daqui. Recuperar o professor logado.
//                        professorLogado.addDisciplina(d);
//
//                        Toast.makeText(getApplicationContext(), "Disciplina " + d.getNome() +
//                                        " adicionada com sucesso ao professor " + professorLogado.getNome(),
//                                Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//    );

    private void binding() {
        tiNomeProfessor = findViewById(R.id.tiNomeProfessor);
        btnLogar = findViewById(R.id.btnLogar);
    }
}