package com.projetos.lucaschr.projeto01.denuncia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.projetos.lucaschr.projeto01.R;

public class DenunciaActivity extends Activity {

    DenunciaDAO dao;
    EditText edtID;
    TextView tvDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia);

        dao = new DenunciaDAO(this);
        Intent intent = getIntent();
        String ID = intent.getStringExtra(Denuncia.ID);

        DenunciaDAO denunciaDAO = new DenunciaDAO(this);
        Denuncia denuncia = denunciaDAO.buscar(ID);

        denuncia.getDescricao();

        tvDescricao = (TextView) findViewById(R.id.activity_denuncia_tvDescricao);

        if (!intent.getStringExtra(Denuncia.ID).equals("")) {
            String id = intent.getStringExtra(Denuncia.ID);
            edtID.setText(id);
            buscar();
        }
    }


    public void buscar() {
        Denuncia denuncia = dao.buscar(edtID.getText().toString());
        tvDescricao.setText(denuncia.getDescricao());
    }
}
