package com.example.test_tcc_2;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class ConfiguracaoActivity extends AppCompatActivity {

    private Button fontepequenaButton;
    private Button fontemediaButton;
    private Button fontegrandeButton;
    Switch switcher;
    boolean nightMODE;
    private float ourFontsize = 14f;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        getSupportActionBar().hide();
        switcher = findViewById(R.id.Switcher);
        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightMODE = sharedPreferences.getBoolean("night", false);
        if (nightMODE){
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nightMODE) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", false);
                } else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", true);
                }
                editor.apply();

            }
        });

        fontepequenaButton = findViewById(R.id.fontepequenaButton);
        fontemediaButton = findViewById(R.id.fontemediaButton);
        fontegrandeButton = findViewById(R.id.fontegrandeButton);

        Button FontePequena, Fontemedia,FonteGrande;

        TextView text,text2,text3,text4,tema,fonte;

        Fontemedia = findViewById(R.id.fontemediaButton);
        FontePequena = findViewById(R.id.fontepequenaButton);
        FonteGrande = findViewById(R.id.fontegrandeButton);
        //configuração menu
        text = findViewById(R.id.configuracoesTEXT);
        text2 = findViewById(R.id.fontepequenaButton);
        text3 = findViewById(R.id.fontemediaButton);
        text4 = findViewById(R.id.fontegrandeButton);
        tema = findViewById(R.id.temaTextView);
        fonte = findViewById(R.id.fonteTextView);

        FontePequena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define tamanho fonte
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                text2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                text3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                text4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                tema.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                fonte.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

            }
        });
        Fontemedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // decreasing the size by 4 unit
                // assigning new textsize to our text
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
                text2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                text3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                text4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                tema.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                fonte.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);

            }
        });
        FonteGrande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // decreasing the size by 4 unit
                // assigning new textsize to our text
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,35);
                text3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                text4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                tema.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                fonte.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);

            }
        });
    }

}
