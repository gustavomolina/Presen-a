package com.example.presenca;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class TelaInicio extends AppCompatActivity {
    private ImageView adicionarClasse, adicionarRegistro, verFaltas, editarAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicio);

        //Ligação entre as imagens e as variaveis

        adicionarClasse = findViewById(R.id.icone_adicionar_classe);
        //adicionarRegistro = findViewById(R.id.icone_adicionar_faltas);
        verFaltas = findViewById(R.id.icone_ver_faltas);
        //editarAluno = findViewById(R.id.icone_editar_aluno);

        adicionarClasse.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent_adicionar_classe = new Intent(getApplicationContext(), AdicionarClasse.class);
                    startActivity(intent_adicionar_classe);
                }
            }
        );

        /*adicionarRegistro.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent_adicionar_registro = new Intent(getApplicationContext(), AdicionarRegistro.class);
                    startActivity(intent_adicionar_registro);
                }
            }
        );*/
        verFaltas.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent_ver_faltas = new Intent(getApplicationContext(), ConsultarDisciplina.class);
                    startActivity(intent_ver_faltas);
                }
            }
        );

        /*editarAluno.setOnClickListener(
            new OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent_editar_aluno = new Intent(getApplicationContext(), EditarAluno.class);
                    startActivity(intent_editar_aluno);
                }
            }
        );*/

        /*ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);*/


    }
}
