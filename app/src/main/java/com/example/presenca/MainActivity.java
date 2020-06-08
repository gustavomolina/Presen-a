package com.example.presenca;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText textoUsuario, textoSenha;
    private Button botaoGravar, botaoBuscar;
    private SQLiteDatabase bd;

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaração dos botoes e textos
        textoUsuario = findViewById(R.id.etUsuario);
        textoSenha = findViewById(R.id.etSenha);
        botaoGravar = findViewById(R.id.btGravar);
        botaoBuscar = findViewById(R.id.btBuscar);

        //Parte do banco, de consulta e cadastro
        try {
            // criando o objeto para manipular o BD
            bd = openOrCreateDatabase("appDB", MODE_PRIVATE, null);

            // criando a tabela
            bd.execSQL("CREATE TABLE IF NOT EXISTS " +
                "usuarios (usuario VARCHAR PRIMARY KEY, senha VARCHAR)");


        }
        catch (Exception e){

        }

        // evento de clique para o Gravar
        botaoGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, pass;
                user = textoUsuario.getText().toString();
                //name = textoNome.getText().toString();
                pass = textoSenha.getText().toString();

                try {

                    bd.execSQL("INSERT INTO usuarios (usuario, senha) VALUES (" + "'" + user +
                        "', '" + pass + "')");



                    textoUsuario.setText(" ");
                    //textoNome.setText("");
                    textoSenha.setText(" ");
                    Toast.makeText(getApplicationContext(), "Cadastro realizado com sucesso!",
                        Toast.LENGTH_SHORT).show();
                    textoUsuario.setText(" ");
                    textoSenha.setText("");
                }
                catch (Exception e){
                    Log.i("INFO-DB", e.getStackTrace().toString());

                }
            }
        });

        // evento do botão buscar
        botaoBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, user_digitado, pass;

                user_digitado = textoUsuario.getText().toString();

                try{
                    Cursor cursor = bd.rawQuery("SELECT * FROM usuarios WHERE usuario = '" + user_digitado + "'", null);

                    cursor.moveToFirst();
                    user = cursor.getString(cursor.getColumnIndex("usuario"));
                   // name = cursor.getString(cursor.getColumnIndex("nome"));
                    pass = cursor.getString(cursor.getColumnIndex("senha"));

                    textoUsuario.setText(user);
                    //textoNome.setText(name);
                    textoSenha.setText(pass);

                    //if(user.equals(user_digitado)){

                        final Intent intent = new Intent(getApplicationContext(), TelaInicio.class);
                        //Toast.makeText(getApplicationContext(), "Feito login!", Toast.LENGTH_SHORT).show();

                        startActivity(intent);
                    //}
                                    }
                catch (Exception e){
                    Log.i("INFO-DB", e.getStackTrace().toString());
                }
            }
        });
        textoUsuario.setText(" ");
        textoSenha.setText("");

    }
}
