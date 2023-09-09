package com.example.test_tcc_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class cadastro_alimento extends AppCompatActivity {

    private EditText edtProduto, edtUnidade;
    private Button btnSalvar, btnCancelar;
    private TextView txtProduto, txtUnid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_alimento);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        txtProduto = (TextView) findViewById(R.id.txtProduto);
        txtUnid = (TextView) findViewById(R.id.txtUnidade);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { cadastro_alimento.this.finish();

            }
        });
    }
}