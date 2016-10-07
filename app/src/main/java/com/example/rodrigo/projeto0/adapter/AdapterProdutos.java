package com.example.rodrigo.projeto0.adapter;

import android.widget.BaseAdapter;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import com.example.rodrigo.projeto0.R;
import com.example.rodrigo.projeto0.modelo.Produto;

/**
 * Created by Rodrigo on 31/05/2016.
 */
public class AdapterProdutos extends BaseAdapter {
    private List<Produto> listaProdutos=new ArrayList<>();
    private Activity activity;

    public AdapterProdutos(List<Produto> lp, Activity ac){
        this.listaProdutos=lp;
        this.activity=ac;
    }

    @Override
    public int getCount() {
        return listaProdutos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaProdutos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaProdutos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(activity).inflate(R.layout.linha_adapter_produtos, parent, false);

        Produto produto=(Produto) getItem(position);

        TextView textView=(TextView) view.findViewById(R.id.textNome);

        textView.setText(produto.getDescricao()+" - "+produto.getNomeProduto());


        return view;
    }


}
