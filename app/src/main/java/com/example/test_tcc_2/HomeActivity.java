package com.example.test_tcc_2;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button coletaButton = findViewById(R.id.coletaButton);
        Button cadastroAlimentosButton = findViewById(R.id.cadastroAlimentosButton);
        Button cadastroRotasButton = findViewById(R.id.cadastroRotasButton);
        Button coletasFinalizadasButton = findViewById(R.id.coletasFinalizadasButton);

        int numeroInstituicoesAtendidas = 154; // Número inicial (pode ser carregado dinamicamente)
        TextView numeroInstituicoesTextView = findViewById(R.id.numeroInstituicoesTextView);
        numeroInstituicoesTextView.setText(String.valueOf(numeroInstituicoesAtendidas));


        // Configurar os listeners dos botões aqui OK1

        Button configButtonTela = findViewById(R.id.configButton);
        configButtonTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, ConfiguracaoActivity.class);
                startActivity(intent);
            }
        });

        cadastroRotasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this, CadastroRotasActivity.class);
                startActivity(intent);
            }
        });

    }
}