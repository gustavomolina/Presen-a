package com.example.presenca;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VerFaltas extends AppCompatActivity {
    private RecyclerView recyclerFaltas;
    private List<Aluno> listaAlunos = new ArrayList<Aluno>();
    private SQLiteDatabase bd;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_faltas);

        //Botão de voltar
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerFaltas = findViewById(R.id.recyclerDados);
        //Carregar alunos
        carregarAlunos();

        // Configurar adapter
        AdapterFalta adapter = new AdapterFalta(listaAlunos);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerFaltas.setLayoutManager(layoutManager);
        // fixa o tamanho para otimizar
        recyclerFaltas.setHasFixedSize(true);
        // adiciona linha separadora dos elementos
        recyclerFaltas.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        recyclerFaltas.setAdapter(adapter);

        // Adicionando eventos de clique a partir de classe já estabelecida
        recyclerFaltas.addOnItemTouchListener(
            new RecyclerItemClickListener(
                getApplicationContext(), recyclerFaltas, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Toast.makeText(getApplicationContext(), "Clique em " + listaAlunos.get(position).getNome(),Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onLongItemClick(View view, int position) {
                    Toast.makeText(getApplicationContext(), "Clique longo em " + listaAlunos.get(position).getFaltas(),Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            }
            )
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void carregarAlunos(){
        String nome_disciplina, nome_aluno, numero_faltas;
        Bundle extras = getIntent().getExtras();
        nome_disciplina = extras.getString("disciplina");
        try{
            Cursor cursor = bd.rawQuery("SELECT * FROM " + nome_disciplina, null);
            //while(!cursor.isLast()){
            cursor.moveToFirst();
                nome_aluno = cursor.getString(cursor.getColumnIndex("nome_aluno"));
                numero_faltas = cursor.getString(cursor.getColumnIndex("numero_faltas"));

                listaAlunos.add(new Aluno(nome_aluno, numero_faltas));
                //cursor.moveToNext();
            //}

        }
        catch (Exception e){
            Log.i("INFO-DB", e.getStackTrace().toString());
            Toast.makeText(getApplicationContext(), "Erro no carregamento!", Toast.LENGTH_SHORT).show();
        }

        listaAlunos.add(new Aluno("Joao", "2"));
        listaAlunos.add(new Aluno("Carlos", "3"));
    }
}
