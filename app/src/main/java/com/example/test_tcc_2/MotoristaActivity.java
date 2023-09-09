package com.example.test_tcc_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MotoristaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorista);

        // Referencie o botão de solicitação de conferência
        Button solicitacaoConferenciaButton = findViewById(R.id.solicitacaoConferenciaButton);

        //  ação para o botão
        solicitacaoConferenciaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemente a ação para o botão "Solicitação de Conferência"
                //packageContext Ebibe o nome da tela na parte superior
                Intent intent = new Intent(MotoristaActivity.this, Conferencia.class);
                startActivity(intent);
            }
        });
    }
}
