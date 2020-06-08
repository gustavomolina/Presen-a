package com.example.presenca;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConsultarDisciplina extends AppCompatActivity {
    private EditText texto_consultar;
    private Button botaoConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_disciplina);

        //Botão de voltar
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        texto_consultar = findViewById(R.id.textoConsultaDisciplina);
        botaoConsultar = findViewById(R.id.consultaDisciplina);

        botaoConsultar.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent_ver_faltas = new Intent(getApplicationContext(), VerFaltas.class);
                    intent_ver_faltas.putExtra("disciplina", texto_consultar.getText());
                    startActivity(intent_ver_faltas);
                }
            }
        );

    }
}
