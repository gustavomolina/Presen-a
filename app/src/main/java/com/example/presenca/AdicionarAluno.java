package com.example.presenca;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarAluno extends AppCompatActivity {
    public EditText nome_aluno;
    private Button adicionar_aluno;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_aluno);


        //Botão de voltar
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        //Variáveis
        nome_aluno = findViewById(R.id.textoConsultaDisciplina);
        adicionar_aluno = findViewById(R.id.consultaDisciplina);



        adicionar_aluno.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nome_disciplina;
                    Bundle extras = getIntent().getExtras();
                    nome_disciplina = extras.getString("disciplina");
                    try {

                        bd.execSQL("INSERT INTO " + nome_disciplina + " (nome_aluno, numero_faltas) VALUES (" + "'" + nome_aluno + "', '" + "'0'" + "')");

                        Toast.makeText(getApplicationContext(), "Aluno adicionado com sucesso!",
                            Toast.LENGTH_SHORT).show();
                        nome_aluno.setText(" ");
                    }
                    catch (Exception e){
                        Log.i("INFO-DB", e.getStackTrace().toString());

                    }


                }
            }
        );
        nome_aluno.setText(" ");

    }
}
