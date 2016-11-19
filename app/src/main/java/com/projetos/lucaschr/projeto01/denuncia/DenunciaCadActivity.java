package com.projetos.lucaschr.projeto01.denuncia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.projetos.lucaschr.projeto01.R;

public class DenunciaCadActivity extends AppCompatActivity {

    DenunciaDAO dao;

    EditText edtCategoria, edtDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia_cad);

        EditText edtCategoria = (EditText) findViewById(R.id.denuncia_cad_edtCatedoria);
        EditText edtDescricao = (EditText) findViewById(R.id.denuncia_cad_edtDescricao);

        dao = new DenunciaDAO(this);

    }



    public void salvar(){
        Denuncia d = new Denuncia();
        d.setCategoria(edtCategoria.getText().toString());
        d.setDescricao(edtDescricao.getText().toString());
        dao.salvar(d);

        Log.i("Denuncia","Salvo corretamente");
        finish();
    }
}