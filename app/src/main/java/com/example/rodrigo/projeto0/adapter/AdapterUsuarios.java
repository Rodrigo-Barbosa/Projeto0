package com.example.rodrigo.projeto0.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rodrigo.projeto0.R;
import com.example.rodrigo.projeto0.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo on 31/05/2016.
 */
public class AdapterUsuarios extends BaseAdapter{
    private List<Usuario> listaUsuarios=new ArrayList<>();
    private Activity activity;

    public AdapterUsuarios(Activity ac, List<Usuario> lu){
        this.listaUsuarios=lu;
        this.activity=ac;
    }


    @Override
    public int getCount() {
        return listaUsuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return listaUsuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaUsuarios.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(activity).inflate(R.layout.linha_adapter_usuarios, parent, false);

        Usuario usuario=(Usuario) getItem(position);

        TextView textView=(TextView) view.findViewById(R.id.textNome);

        textView.setText(usuario.getNome()+" - "+usuario.getEmail());


        return view;
    }
}
