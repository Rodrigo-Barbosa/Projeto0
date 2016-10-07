package com.example.rodrigo.projeto0.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.rodrigo.projeto0.R;
import com.example.rodrigo.projeto0.adapter.AdapterProdutos;
import com.example.rodrigo.projeto0.cadastro.CadastrarProduto;
import com.example.rodrigo.projeto0.modelo.Produto;

import java.util.List;

public class VerificaStatus extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private List<Produto> listaProduto;
    private ListView listaViewProduto;
    Produto produto;
    private AdapterProdutos produtoAdapter;

    private ImageButton bt_alterar;
    private ImageButton bt_excluir;

    private Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica_status);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.bt_alterar=(ImageButton) findViewById(R.id.btAlterar);
        this.bt_excluir=(ImageButton) findViewById(R.id.btExcluir);

        //Ao carregar a activity ele inicia-se inativo
        bt_alterar.setEnabled(false);
        bt_excluir.setEnabled(false);

        preencherLista();
        //Recuperando o layoutListView e atribuido a variavel listaView
        listaViewProduto = (ListView) findViewById(R.id.listView_Produtos);
        //Permitindo que a lista seja clicavel
        listaViewProduto.setOnItemClickListener(this);


    }

    public void preencherLista(){
        produtoAdapter = new AdapterProdutos(Produto.listAll(Produto.class), this);
        listaViewProduto = (ListView) findViewById(R.id.listView_Produtos);
        listaViewProduto.setAdapter(produtoAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Ao clicar na lista ele vai pegar o id do objeto que recebeu click e atribui a variavel idItem
        Long idItem = produtoAdapter.getItemId(position);
        bundle = new Bundle();

        //Chamando o metodo putLong para armazenar um par de Ids( sendo o primeiro uma String e o segundo o idItem
        bundle.putLong("idProduto", idItem);

        //habilitando os botões
        bt_alterar.setEnabled(true);
        bt_excluir.setEnabled(true);

    }

    public void alterar(View view){
        Intent intent = new Intent(this, CadastrarProduto.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void excluir(View view){
        Long id = bundle.getLong("idProduto");
        produto = (Produto) Produto.findById(Produto.class, id);
        produto.delete();
        //chama o método novamente para atualizar as alterações
        preencherLista();

    }
}