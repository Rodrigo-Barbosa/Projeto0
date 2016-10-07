package com.example.rodrigo.projeto0.modelo;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Rodrigo on 29/05/2016.
 */

//@XTreamAlias
public class Produto extends SugarRecord {
    private String nomeProduto;
    private String codigoRastreio;
    private String descricao;


/*
    private static void lerEventoXML() {
        try {
            XStream xStream = new XStream(new Dom4JDriver());
            xStream.alias("eventos", ArrayList.class);
            xStream.processAnnotations(LerRetornoEventoXML.class);

            BufferedReader input = new BufferedReader(new FileReader("eventos.xml"));
            ArrayList<LerRetornoEventoXML> listaEventosRetorno = (ArrayList) xStream.fromXML(input);
            input.close();

            for (LerRetornoEventoXML retornoEventos : retornoEvento) {
                System.out.println("Endereço: " + endereco.getRua() + " - " + endereco.getCidade());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
*/

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
