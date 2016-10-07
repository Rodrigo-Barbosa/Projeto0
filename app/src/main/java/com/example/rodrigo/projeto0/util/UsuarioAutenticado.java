package com.example.rodrigo.projeto0.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rodrigo.projeto0.R;
import com.example.rodrigo.projeto0.cadastro.CadastrarProduto;
import com.example.rodrigo.projeto0.modelo.Usuario;

public class UsuarioAutenticado extends AppCompatActivity {
    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_autenticado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void cadastrarProduto(View view){
        Intent intent=new Intent(getApplicationContext(), CadastrarProduto.class);
        startActivity(intent);

    }

    public void exibirLista(View view){
        Intent intent=new Intent(getApplicationContext(), ListaProdutos.class);
        startActivity(intent);
    }

    public void verificarStatus(View view){
        Intent intent=new Intent(getApplicationContext(), VerificaStatus.class);
        startActivity(intent);
    }




}
