package com.example.presenca;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterFalta extends RecyclerView.Adapter<AdapterFalta.MyViewHolder> {
    private List<Aluno> listaAlunos;
    public AdapterFalta(List<Aluno> listaFilmes) {
        this.listaAlunos = new ArrayList<Aluno>();
        this.listaAlunos = listaFilmes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Este método cria a View para serem exibidos os elementos

        // Converte o layout XML para uma View
        View listaItens = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_adapter_falta, viewGroup,false);

        return new MyViewHolder(listaItens);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        // Este método atualiza a visualização e mostra os elementos
        // i representa cada posição no RecyclerView
        // Como setamos a quantidade de elementos para lista.size()
        // i vai de 0 a lista.size

        myViewHolder.nome.setText(listaAlunos.get(i).getNome());
        myViewHolder.faltas.setText(listaAlunos.get(i).getFaltas());
    }

    @Override
    public int getItemCount() {
        // Retorna a quantidade de itens que serão exibidos
        return listaAlunos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //cria elementos gráficos que estarão no modelo
        TextView nome;
        TextView faltas;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //linka os elementos do layout aos atributos da classe
            nome = itemView.findViewById(R.id.tvNome);
            faltas = itemView.findViewById(R.id.tvFaltas);
        }
    }
}
