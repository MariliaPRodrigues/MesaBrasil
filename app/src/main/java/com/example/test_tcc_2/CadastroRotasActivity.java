package com.example.test_tcc_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class CadastroRotasActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    public ListView listViewBairro, listViewNovaRota, listViewRotas;
    ImageButton buttonAddRota, buttonRemoveRota,buttonLixeira;
    Button buttonSalvar, buttonCancelar;
    ImageView notificacaoIcone;
    String itemBairro, itemNovaRota, itemRotas;
    ArrayAdapter adapterNovaRota, adapterRota;
    ArrayList<String> listNovaRota = new ArrayList<String>();
    ArrayList<String> listBairros = new ArrayList<String>();
    ArrayList<String> listRotas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_rotas);

        getSupportActionBar().hide();

        buttonAddRota = findViewById(R.id.buttonAddRota);
        buttonRemoveRota = findViewById(R.id.buttonRemoveRota);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonCancelar = findViewById(R.id.buttonCancelar);
        listViewBairro = (ListView)findViewById(R.id.listViewBairro);
        listViewNovaRota = (ListView)findViewById(R.id.listViewNovaRota);
        listViewRotas = (ListView)findViewById(R.id.listViewRotas);
        notificacaoIcone = findViewById(R.id.notificacao);
        buttonLixeira = findViewById(R.id.btn_lixeira);

        listBairros.add("Sagrada Familia");
        listBairros.add("São José");
        listBairros.add("Santa Catarina");
        listBairros.add("Centro");
        listBairros.add("Vila Nova");
        listBairros.add("Camaquã");
        listBairros.add("Assunção");
        listBairros.add("Jardim Europa");
        listBairros.add("Bela Vista");

        ArrayAdapter adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,
                        listBairros
                );

        listViewBairro.setAdapter(adapter);

        listViewBairro.setOnItemClickListener(listClick);
        listViewNovaRota.setOnItemClickListener(listClickNovaRota);
        listViewRotas.setOnItemClickListener(listClickRotas);

        buttonAddRota.setOnClickListener(v -> {

            listNovaRota.add(itemBairro);
            adapterNovaRota = new ArrayAdapter<String>(CadastroRotasActivity.this,
                    android.R.layout.simple_list_item_1, listNovaRota);

            listViewBairro.clearChoices();
            listViewBairro.requestLayout();
            listViewBairro.setAdapter(adapter);
            listViewNovaRota.setAdapter(adapterNovaRota);
        });

        buttonRemoveRota.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                listNovaRota.remove(itemNovaRota);
                adapterNovaRota = new ArrayAdapter<String>(CadastroRotasActivity.this,
                        android.R.layout.simple_list_item_1, listNovaRota);

                listViewNovaRota.setAdapter(adapterNovaRota);
            }
        });

        notificacaoIcone.setOnClickListener(v -> {
            Toast.makeText(this, "Próxima versão", Toast.LENGTH_SHORT).show();

        });

        buttonSalvar.setOnClickListener(v -> {
            Toast.makeText(this, "Rota inserida no banco de dados", Toast.LENGTH_SHORT).show();
            listRotas.add(String.format("Rota 0%d", listRotas.size() + 1));

            adapterRota = new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1,
                            listRotas
                    );
            listViewRotas.setAdapter(adapterRota);
            adapterNovaRota.clear();
        });

        buttonCancelar.setOnClickListener(v -> {
            adapterNovaRota.clear();
        });

        buttonLixeira.setOnClickListener(v -> {
            Toast.makeText(this, "Rota excluída com sucesso.", Toast.LENGTH_SHORT).show();

            listRotas.remove(itemRotas);
            adapterNovaRota = new ArrayAdapter<String>(CadastroRotasActivity.this,
                    android.R.layout.simple_list_item_1, listRotas);

            listViewRotas.setAdapter(adapterRota);

        });
    }

    public void showMenuNavBar(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.nav_bar_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.solicitacaoColetaMenuToolbar:
                /*intent = new Intent(this, SolicitacaoColetaActivity.class);
                startActivity(intent);*/
                return true;
            case R.id.cadastroAlimentoMenuToolbar:
                /*intent = new Intent(this, CadastroAlimentosActivity.class);
                startActivity(intent);*/
                return true;
            case R.id.cadastroRotasMenuToolbar:
                intent = new Intent(this, CadastroRotasActivity.class);
                startActivity(intent);
                return true;
            case R.id.coletasFinalizadasMenuToolbar:
                /*intent = new Intent(this, ColetasFinalizadasActivity.class);
                startActivity(intent);*/
                return true;
            case R.id.configMenuToolbar:
                intent = new Intent(this, ConfiguracaoActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    private AdapterView.OnItemClickListener listClick = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            itemBairro = (String) listViewBairro.getItemAtPosition(i);
        }
    };

    private AdapterView.OnItemClickListener listClickNovaRota = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            itemNovaRota = (String) listViewNovaRota.getItemAtPosition(i);
        }
    };

    private AdapterView.OnItemClickListener listClickRotas = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            itemRotas = (String) listViewRotas.getItemAtPosition(i);
        }
    };
}