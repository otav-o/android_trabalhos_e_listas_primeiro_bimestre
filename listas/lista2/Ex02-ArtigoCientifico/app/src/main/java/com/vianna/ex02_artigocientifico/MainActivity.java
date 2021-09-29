package com.vianna.ex02_artigocientifico;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vianna.ex02_artigocientifico.models.Artigo;
import com.vianna.ex02_artigocientifico.models.Pessoa.Aluno;
import com.vianna.ex02_artigocientifico.models.Pessoa.Orientador;
import com.vianna.ex02_artigocientifico.models.Pessoa.Pessoa;
import com.vianna.ex02_artigocientifico.models.Pessoa.Professor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCadastrarArtigo, btnCadastrarEscritor, btnAvaliarArtigo;
    TextView lblArtigosMaisAvaliados;
    
    private ArrayList<Artigo> artigos;
    private ArrayList<Pessoa> escritores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();
        registraEventos();
        dadosProntos();
    }

    private void dadosProntos() {
        escritores = new ArrayList<>();
        artigos = new ArrayList<>();

        Artigo a1 = new Artigo("Os altos salários dos professores de TI", "Um estudo sobre meu professor de Java");
        Artigo a2 = new Artigo("Impactos da pandemia na saúde mental universitária", "Uma abordagem interdisciplinar");
        Artigo a3 = new Artigo("Como dormir melhor", "Durma 8h");
        Artigo a4 = new Artigo("Como funcionam as vacinas", "As diferentes tecnologias das vacinas.");

        Pessoa p1 = new Orientador("Daves");
        Pessoa p2 = new Aluno("Jonas");
        Pessoa p3 = new Professor("Marcelo");

        a1.addAutor(p1, p2);
        a2.addAutor(p3);
        a2.addAutor(p2, p3);

        escritores.add(p1); escritores.add(p2); escritores.add(p3);
        artigos.add(a1); artigos.add(a2); artigos.add(a3); artigos.add(a4);
    }

    private void registraEventos() {
        btnAvaliarArtigo.setOnClickListener(callViewAvaliarArtigo());
        btnCadastrarEscritor.setOnClickListener(callViewCadastrarEscritor());
        btnCadastrarArtigo.setOnClickListener(callViewCadastrarArtigo());
    }

    private View.OnClickListener callViewCadastrarArtigo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), CadastrarArtigoActivity.class);
                itn.putExtra("escritores", escritores);
                viewCadastroArtigo.launch(itn);
            }
        };
    }

    ActivityResultLauncher<Intent> viewCadastroArtigo = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 10) {

                        Artigo a = (Artigo) result.getData().getExtras().getSerializable("artigo");

                        artigos.add(a);

                        Toast.makeText(getApplicationContext(),
                                "Artigo " + a.getTitulo() + " cadastrado com sucesso!",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

    private View.OnClickListener callViewCadastrarEscritor() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), CadastrarEscritorActivity.class);

                viewCadastroEscritor.launch(itn);
            }
        };
    }

    ActivityResultLauncher<Intent> viewCadastroEscritor = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 10) {

                        Pessoa p = (Pessoa) result.getData().getExtras().getSerializable("escritor");

                        escritores.add(p);

                        Toast.makeText(getApplicationContext(),
                                "Escritor "+p.getNome()+" cadastrado com sucesso!",
                                Toast.LENGTH_LONG).show();

                    }
                }
            });

    private View.OnClickListener callViewAvaliarArtigo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itn = new Intent(getApplicationContext(), AvaliarArtigoActivity.class);
                itn.putExtra("artigos", artigos);
                viewAvaliarArtigo.launch(itn);
            }
        };
    }

    ActivityResultLauncher<Intent> viewAvaliarArtigo = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 10) {
                        Artigo a = (Artigo) result.getData().getExtras().getSerializable("artigo");

                        Toast.makeText(getApplicationContext(),
                                "Nota " + a.getNota() + " atribuída ao artigo " + a.getTitulo(),
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

    private void binding() {
        btnCadastrarArtigo = findViewById(R.id.btnSubmeterArtigoView);
        btnCadastrarEscritor = findViewById(R.id.btnCadastrarEscritorView);
        btnAvaliarArtigo = findViewById(R.id.btnAvaliarArtigoView);

        lblArtigosMaisAvaliados = findViewById(R.id.tvArtigosCampeoes);
    }
}