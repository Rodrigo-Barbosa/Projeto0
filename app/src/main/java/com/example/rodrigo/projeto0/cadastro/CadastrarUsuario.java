package com.example.rodrigo.projeto0.cadastro;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rodrigo.projeto0.R;
import com.example.rodrigo.projeto0.modelo.Usuario;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CadastrarUsuario extends AppCompatActivity {
    private Usuario usuario = new Usuario();
    private static final String TAG="USUARIO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void salvarUsuario(View view){
        //Recuperando o campo
        EditText campoNome=(EditText) findViewById(R.id.editNomeUsuario);
        EditText campoEmail=(EditText) findViewById(R.id.editEmail);
        EditText campoCelular=(EditText) findViewById(R.id.editCelular);
        EditText campoSenha=(EditText) findViewById(R.id.editSenha);

        //Pegando o valor do campo
        String nome=campoNome.getText().toString();
        String email=campoEmail.getText().toString();
        String celular=campoCelular.getText().toString();
        String senha=campoSenha.getText().toString();

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setCelular(celular);
        usuario.setSenha(senha);

        usuario.save();
        //Chamando o método que envia as informações para o WebService
        passarDadosWebService(usuario.getNome(), usuario.getEmail(), usuario.getCelular(), usuario.getSenha());

        Toast.makeText(CadastrarUsuario.this, "O usuario: " + usuario.getNome()+" foi cadastrado", Toast.LENGTH_SHORT).show();
        finish();
    }


    //Este método envia os dados de cadastro para o webService contendo todos atributos que deverão
    //ser cadastrados
    private void passarDadosWebService(String nome, String email, String celular, String senha){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String myurl = "http://172.21.101.55:8080/ServicoWeb/resource/WebService/add";
        String POST_PARAMS = "nome="+nome+"&email="+email+"&celular="+celular+"&senha="+senha;
        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);

            OutputStream os = conn.getOutputStream();
            os.write(POST_PARAMS.getBytes());
            os.flush();
            os.close();

            conn.connect();
            int response = conn.getResponseCode();
            Log.i("MainActivity", "The response is: " + response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void excluir(View view){
        usuario.delete();
        finish();
    }


    public void cancelarCadastro(View view){
        finish();

    }

    //    public void cadastrar(View view) {
//        //Recuperando o campo inteiro
//        EditText campoNome = (EditText) findViewById(R.id.editNomeUsuario);
//        EditText campoEmail = (EditText) findViewById(R.id.editEmail);
//        EditText campoCelular = (EditText) findViewById(R.id.editCelular);
//        EditText campoSenha = (EditText) findViewById(R.id.editSenha);
//
//        usuario.setNome(campoNome.getText().toString());
//        usuario.setEmail(campoEmail.getText().toString());
//        usuario.setCelular(campoCelular.getText().toString());
//        usuario.setSenha(campoSenha.getText().toString());
//
//        usuario.setNome("Teste Nome");
//        usuario.setEmail("Teste Email");
//        usuario.setCelular("Teste Celular");
//        usuario.setSenha("Teste Senha");
//        //if (usuario.getId()==null) {
//        //Log.i(TAG, "Dentro do IF");
//        usuario.save();
//        //Chamando o método que envia ar informações para o WebService
//        passarDadosWebService(usuario.getNome(), usuario.getEmail(), usuario.getCelular(), usuario.getSenha());
//
//        Toast.makeText(CadastrarUsuario.this, "Usuario: " + usuario.getId(), Toast.LENGTH_SHORT).show();
//        finish();
//    }







}
