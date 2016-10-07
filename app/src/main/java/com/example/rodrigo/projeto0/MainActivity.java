package com.example.rodrigo.projeto0;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rodrigo.projeto0.cadastro.CadastrarUsuario;
import com.example.rodrigo.projeto0.util.RecuperaSenha;
import com.example.rodrigo.projeto0.util.UsuarioAutenticado;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void novoUsuario(View view){
        Intent intent=new Intent(getApplicationContext(), CadastrarUsuario.class);
        startActivity(intent);
    }

    //Este método fará o tratamento de recuperação de senha
    public void recuperaSenha(View view){
        Intent intent=new Intent(getApplicationContext(), RecuperaSenha.class);
        startActivity(intent);
    }

    //Efetua busca no BD para verificar a existência do usuário
    public void entrar(View view){
        //if(){
        //
        //}

        Intent intent=new Intent(getApplicationContext(), UsuarioAutenticado.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
