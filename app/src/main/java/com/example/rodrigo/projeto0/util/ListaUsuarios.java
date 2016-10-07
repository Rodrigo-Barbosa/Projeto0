package com.example.rodrigo.projeto0.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rodrigo.projeto0.R;
import com.example.rodrigo.projeto0.cadastro.CadastrarUsuario;
import com.example.rodrigo.projeto0.adapter.AdapterUsuarios;
import com.example.rodrigo.projeto0.modelo.Usuario;

import java.util.List;

public class ListaUsuarios extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listaUsuarios;
    private AdapterUsuarios adapterUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaUsuarios=(ListView)findViewById(R.id.listUsuarios);
        preencherListaUsuarios();

        listaUsuarios.setOnItemClickListener(this);
        // listaUsuarios.setOnItemLongClickListener(adapterUsuarios);

    }

    @Override
    protected void onResume() {
        super.onResume();
        preencherListaUsuarios();
    }

    public void chamarNovoUsuario(View view) {
        Intent itt = new Intent(this, CadastrarUsuario.class);
        startActivity(itt);
    }



    public List<Usuario> getListaUsuarios() {
        List<Usuario> listUs=Usuario.listAll(Usuario.class);
        //List<Usuario> lisUs = Usuario.findWithQuery(Usuario.class, "Select * from Usuario where nome = ?", "a");
        return listUs;
    }

    private void preencherListaUsuarios(){
        adapterUsuarios=new AdapterUsuarios(this, getListaUsuarios());
        listaUsuarios.setAdapter(adapterUsuarios);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Usuario usuario=(Usuario) adapterUsuarios.getItem(position);
        Long idItem=adapterUsuarios.getItemId(position);
        Bundle bd=new Bundle();
        bd.putLong("idUsuario",idItem);
        //Usuario p=Usuario.findById(Usuario.class, idItem);
        //Log.i("LISTA", "Id Usuario: "+p.getId());
        Intent itt=new Intent(this, CadastrarUsuario.class);
        itt.putExtras(bd);
        startActivity(itt);
    }
}
