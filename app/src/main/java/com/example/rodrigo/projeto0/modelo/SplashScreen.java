package com.example.rodrigo.projeto0.modelo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.rodrigo.projeto0.MainActivity;
import com.example.rodrigo.projeto0.R;

/**
 * Created by Rodrigo on 16/08/2016.
 */
public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setando para que seja carregado a splashscreen
        setContentView(R.layout.splashscreen);

        //Criando uma thread para chamar
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    //Tentar fazer a Thread dormir por 3000 segundos
                    //Nesse momento ele irá aguardar 3s
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {
                    //Automaticamente ela irá passar da activity atual para a próxima
                    //que no caso seria a MainActivity
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    //Intent intent = new Intent(SplashScreen.this, Banner.class);
                    //Aqui iremos carregar a intent
                    startActivity(intent);
                }
            }

        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
