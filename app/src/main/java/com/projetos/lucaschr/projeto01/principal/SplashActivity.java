package com.projetos.lucaschr.projeto01.principal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.projetos.lucaschr.projeto01.R;
import com.projetos.lucaschr.projeto01.sqlite.BancoDados;

public class SplashActivity extends AppCompatActivity {

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Sempre importar o R do meu projeto
        setContentView(R.layout.activity_splash);

        db = BancoDados.getDB(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(SplashActivity.this, PrincipalActivity.class);
                startActivity(it);
            }
        },3000);

    }
}
