package com.vianna.ex01_compradecarro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.vianna.ex01_compradecarro.models.Carro;
import com.vianna.ex01_compradecarro.models.Motor;
import com.vianna.ex01_compradecarro.models.acessorios.Alarme;
import com.vianna.ex01_compradecarro.models.acessorios.ArCondicionado;
import com.vianna.ex01_compradecarro.models.acessorios.CambioAutomatico;
import com.vianna.ex01_compradecarro.models.acessorios.EPintura;
import com.vianna.ex01_compradecarro.models.acessorios.IAcessorio;
import com.vianna.ex01_compradecarro.models.acessorios.KitMultimidia;
import com.vianna.ex01_compradecarro.models.acessorios.TetoSolar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tiModelo;
    private CheckBox cbAlarme, cbArCondicionado, cbCambioAutomatico, cbKitMultimidia, cbTetoSolar;
    private RadioButton rbCorMetalica, rbCorComemorativa, rbCorEspecial;
    private Button btnCalcularPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding();

        btnCalcularPreco.setOnClickListener(calcular());
    }

    private View.OnClickListener calcular() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Carro c = new Carro(tiModelo.toString(), new Motor(1.0));
                List<IAcessorio> acessorios = obterAcessorios();
                c.adicionarAcessorio(acessorios);

                double precoFinal = c.getPrecoFinal();

                Toast.makeText(getApplicationContext(),
                        String.format("O carro custa: %.2f", precoFinal), Toast.LENGTH_LONG).show();
            }
        };
    }

    private List<IAcessorio> obterAcessorios() {
        List<IAcessorio> lista = new ArrayList<>();
        if (cbAlarme.isChecked())
            lista.add(new Alarme());

        if (cbArCondicionado.isChecked())
            lista.add(new ArCondicionado());

        if (cbCambioAutomatico.isChecked())
            lista.add(new CambioAutomatico());

        if (cbKitMultimidia.isChecked())
            lista.add(new KitMultimidia());

        if (cbTetoSolar.isChecked())
            lista.add(new TetoSolar());

        if (rbCorComemorativa.isChecked())
            lista.add(EPintura.COMEMORATIVA);
        else if (rbCorEspecial.isChecked())
            lista.add(EPintura.ESPECIAL);
        else if (rbCorMetalica.isChecked())
            lista.add(EPintura.METALICA);

        return lista;
    }

    private void binding() {
        tiModelo = findViewById(R.id.tiModelo);
        cbAlarme = findViewById(R.id.cbAlarme);
        cbArCondicionado = findViewById(R.id.cbArCondicionado);
        cbCambioAutomatico = findViewById(R.id.cbCambioAutomatico);
        cbKitMultimidia = findViewById(R.id.cbKitMultimidia);
        cbTetoSolar = findViewById(R.id.cbTetoSolar);
        rbCorMetalica = findViewById(R.id.rbCorMetalica);
        rbCorComemorativa = findViewById(R.id.rbCorComemorativa);
        rbCorEspecial = findViewById(R.id.rbCorEspecial);
        btnCalcularPreco = findViewById(R.id.btnCalcular);
    }
}