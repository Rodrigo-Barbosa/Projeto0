package com.example.rodrigo.projeto0.modelo;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Rodrigo on 03/05/2016.
 */
public class Usuario extends SugarRecord {

    private String nome;
    private String email;
    private String celular;
    private String senha;

    public Usuario(){

    }



    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() { return senha; }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
