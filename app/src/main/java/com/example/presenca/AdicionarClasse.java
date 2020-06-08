package com.example.presenca;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarClasse extends AppCompatActivity {

    private Button botaoCadastrar;
    private EditText textoDisciplina;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_classe);

        //Botão de voltar
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        //Determinação das variaveis
        textoDisciplina = findViewById(R.id.textoConsultaDisciplina);
        botaoCadastrar = findViewById(R.id.consultaDisciplina);






        //Ação de cadastrar disciplina
        botaoCadastrar.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nome_disciplina;

                    nome_disciplina = textoDisciplina.getText().toString();

                    try {
                        // criando o objeto para manipular o BD
                        bd = openOrCreateDatabase("appDB", MODE_PRIVATE, null);

                        // criando a tabela da disciplina
                        bd.execSQL("CREATE TABLE IF NOT EXISTS " + nome_disciplina + " (nome_aluno VARCHAR PRIMARY KEY, numero_faltas VARCHAR)");
                        Toast.makeText(getApplicationContext(), "Disciplina cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        Log.i("INFO-DB", e.getStackTrace().toString());
                    }

                    final Intent intent_adicionar_aluno = new Intent(getApplicationContext(), AdicionarAluno.class);
                    intent_adicionar_aluno.putExtra("disciplina", nome_disciplina);
                    startActivity(intent_adicionar_aluno);
                }
            }
        );


    }
}
