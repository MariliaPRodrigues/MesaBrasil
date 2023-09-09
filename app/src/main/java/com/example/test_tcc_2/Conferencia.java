package com.example.test_tcc_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Conferencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferencia);

        // Referências aos elementos da interface
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        Button confirmarColetaButton = findViewById(R.id.confirmarColetaButton);

        //  adicionar uma linha à tabela
        addTableRow("Produto 1", "5", tableLayout);

        // adicionar outra linha à tabela
        addTableRow("Produto 2", "10", tableLayout);

        // Definir ação do botão "Confirmar Coleta"
        confirmarColetaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aqui você pode adicionar o código para confirmar a coleta
                Toast.makeText(Conferencia.this, "Coleta Confirmada", Toast.LENGTH_SHORT).show();


                // Redirecionar para a HomeActivity
                Intent intent = new Intent(Conferencia.this, MotoristaActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método para adicionar uma linha à tabela
    private void addTableRow(String produto, String qtd, TableLayout tableLayout) {
        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
        ));

        TextView produtoTextView = new TextView(this);
        produtoTextView.setText(produto);
        produtoTextView.setLayoutParams(new TableRow.LayoutParams(
                0,
                TableRow.LayoutParams.WRAP_CONTENT,
                1.0f
        ));

        TextView qtdTextView = new TextView(this);
        qtdTextView.setText(qtd);
        qtdTextView.setLayoutParams(new TableRow.LayoutParams(
                0,
                TableRow.LayoutParams.WRAP_CONTENT,
                1.0f
        ));

        Spinner coletadoSpinner = new Spinner(this);
        coletadoSpinner.setLayoutParams(new TableRow.LayoutParams(
                0,
                TableRow.LayoutParams.WRAP_CONTENT,
                1.0f
        ));

        tableRow.addView(produtoTextView);
        tableRow.addView(qtdTextView);
        tableRow.addView(coletadoSpinner);

        tableLayout.addView(tableRow);
    }
}
