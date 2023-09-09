package com.example.test_tcc_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class UsuarioDoadorActivity extends AppCompatActivity {

    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuariodoador);



        Button solicitacao = findViewById(R.id.solicitacaocoleta);
        Button eventosButton = findViewById(R.id.eventosButton);
        Button noticiasButton = findViewById(R.id.noticiasButton);

        solicitacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  ação para o botão "solictação de coleta"
                Intent intent = new Intent(UsuarioDoadorActivity.this, SolicitacaoColetaActivity.class);
                startActivity(intent);
            }
        });

        eventosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ação para o botão "Eventos"
            }
        });

        noticiasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // aqui vai  Implementar a ação para o botão "Notícias"
            }
        });

        // Configurar o gráfico de pizza aqui
        setupPieChart();
    }

    private void setupPieChart() {
        pieChart = findViewById(R.id.pieChartt);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(70f, "Doado"));
        entries.add(new PieEntry(30f, "Restante"));

        PieDataSet dataSet = new PieDataSet(entries, "Alimentos Doados");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);
    }
}
