package com.example.rodrigo.projeto0.cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.rodrigo.projeto0.util.ListaProdutos;
import com.example.rodrigo.projeto0.R;
import com.example.rodrigo.projeto0.modelo.Produto;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CadastrarProduto extends AppCompatActivity {
    private Produto produto = new Produto();
    private EditText edt_nome = null;
    private EditText edt_descricao = null;
    private EditText edt_codigo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_novo_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.edt_nome = (EditText) findViewById(R.id.edtNomeProduto);
        this.edt_descricao = (EditText) findViewById(R.id.edtDescricao);
        this.edt_codigo = (EditText) findViewById(R.id.edtCodigoRastreio);

        if(getIntent().hasExtra("idProduto")){
            Bundle bundle = getIntent().getExtras();
            Long id = bundle.getLong("idProduto");
            produto = (Produto) Produto.findById(Produto.class, id);
            setProduto(produto);
        }


    }

    public void setProduto(Produto produto){
        this.produto = produto;
        edt_nome.setText(produto.getNomeProduto());
        edt_descricao.setText(produto.getDescricao());
        edt_codigo.setText(produto.getCodigoRastreio());
    }

    public void salvarCadastro(View view) {
        if (produto.getId() == null) {
            produto.setNomeProduto(edt_nome.getText().toString());
            produto.setCodigoRastreio(edt_codigo.getText().toString());
            produto.setDescricao(edt_descricao.getText().toString());

            produto.save();

            passarDadosWebService(produto.getNomeProduto(), produto.getCodigoRastreio(), produto.getDescricao());

            //Fechando a activity
            finish();
        } else {
            produto.setNomeProduto(edt_nome.getText().toString());
            produto.setCodigoRastreio(edt_codigo.getText().toString());
            produto.setDescricao(edt_descricao.getText().toString());
            produto.save();

            Intent intent = new Intent(getApplicationContext(), ListaProdutos.class);
            startActivity(intent);
            //Toast.makeText(CadastrarProduto.this, "Produto: " + produto.getId(), Toast.LENGTH_SHORT.show);

            //Fechando a activity
            finish();
        }
    }

        //Este método envia os dados de cadastro para o webService contendo todos atributos que deverão
        //ser cadastrados
    private void passarDadosWebService(String nomeProduto, String descricao, String codigoRastreio){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String myurl = "http://172.17.244.245:8080/ServicoWeb/resource/WebService/add";
        String POST_PARAMS = "nomeProduto="+nomeProduto+"&codigoRastreio="+codigoRastreio+"&descricao="+descricao;
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

    public void cancelarCadastro(View view){
        //
        finish();
    }

}
