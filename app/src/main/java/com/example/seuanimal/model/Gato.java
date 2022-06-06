package com.example.seuanimal.model;

public class Gato {
    private int foto;
    private String nome;
    private String descricao;
    private String situacao;

    public Gato(){
    }

    public Gato(int foto, String nome, String descricao, String situacao) {
        this.foto = foto;
        this.nome = nome;
        this.descricao = descricao;
        this.situacao = situacao;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
