package com.example.test_tcc_2;

import static android.R.drawable.ic_dialog_alert;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test_tcc_2.R;

public class SolicitacaoColetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao_coleta);

        Button confirmarColetaButton = findViewById(R.id.confirmarColetaButton);

        confirmarColetaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Exibir uma mensagem de confirmação
               // Toast.makeText(SolicitacaoColetaActivity.this, "Coleta confirmada", Toast.LENGTH_SHORT).show();

                // Inflar o layout personalizado
              //  LayoutInflater inflater = getLayoutInflater();
             //   View layout = inflater.inflate(R.layout.custom_toast_layout, findViewById(R.id.custom_toast_layout));

            //    ImageView icon = layout.findViewById(R.id.icon); // Certifique-se de que o ImageView seja encontrado corretamente.

             //   icon.setImageResource(R.drawable.ic_dialog_info);

           //     Toast toast = new Toast(getApplicationContext());
           //     toast.setDuration(Toast.LENGTH_LONG);
            //    toast.setView(layout);
           //     toast.show();

// Exibir o Toast


                Toast.makeText(SolicitacaoColetaActivity.this, "Coleta confirmada", Toast.LENGTH_SHORT).show();


                // Redirecionar para a HomeActivity
                Intent intent = new Intent(SolicitacaoColetaActivity.this, UsuarioDoadorActivity.class);
                startActivity(intent);
            }
        });
    }
}
