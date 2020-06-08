package com.example.presenca;

public class Aluno{
    private String nome_aluno;
    private String numero_faltas;

    public Aluno (String nome_aluno, String numero_faltas){
        this.nome_aluno = nome_aluno;
        this.numero_faltas = numero_faltas;
    }

    public String getNome(){
        return this.nome_aluno;
    }

    public String getFaltas(){
        return String.valueOf(this.numero_faltas);

    }

    public void setNome_aluno(String nome_aluno){
        this.nome_aluno = nome_aluno;
    }

    public void setNumero_faltas(String numero_faltas){
        this.numero_faltas = numero_faltas;
    }
}
