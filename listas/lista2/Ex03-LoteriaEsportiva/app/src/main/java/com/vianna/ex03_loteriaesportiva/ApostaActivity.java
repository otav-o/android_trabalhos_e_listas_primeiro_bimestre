package com.vianna.ex03_loteriaesportiva;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

//import com.vianna.ex03_loteriaesportiva.adapter.jogo.JogoAdapter;
import com.vianna.ex03_loteriaesportiva.models.Loteria.Jogo;

import java.util.ArrayList;

public class ApostaActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<Jogo> jogos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aposta);

        binding();
    }

    ActivityResultLauncher<Intent> viewDetailJogo = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == 10) {
                        int pos = result.getData().getExtras().getInt("position");
                        String nome = result.getData().getExtras().getString("nome");
//                        ((JogoAdapter)rv.getAdapter()).updateHolder(nome, pos);

                    }

                }
            }
    );

    private void binding() {
        rv = findViewById(R.id.rvApostas);
    }
}