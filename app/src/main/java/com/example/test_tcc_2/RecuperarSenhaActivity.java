package com.example.test_tcc_2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecuperarSenhaActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button recuperarSenhaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

        emailEditText = findViewById(R.id.emailEditText);
        recuperarSenhaButton = findViewById(R.id.recuperarSenhaButton);

        recuperarSenhaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aqui  implementar a lógica de recuperação de senha
                // Por exemplo, enviar um e-mail de redefinição de senha para o endereço fornecido

                Toast.makeText(RecuperarSenhaActivity.this, "E-mail enviado, verifique sua caixa de mensagem! ", Toast.LENGTH_SHORT).show();


                // Redirecionar
                Intent intent = new Intent(RecuperarSenhaActivity.this, RecuperarSenhaActivity.class);
                startActivity(intent);
            }
        });
    }
}
