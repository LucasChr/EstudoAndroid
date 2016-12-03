package com.projetos.lucaschr.projeto01.denuncia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.projetos.lucaschr.projeto01.R;

public class DenunciaCadActivity extends AppCompatActivity {

    private EditText edtCategoria, edtDescricao;
    private DenunciaDAO denunciaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denuncia_cad);

        edtCategoria = (EditText) findViewById(R.id.denuncia_cad_edtCatedoria);
        edtDescricao = (EditText) findViewById(R.id.denuncia_cad_edtDescricao);

        //instancia do DenunciaDAO
        denunciaDAO = new DenunciaDAO(this);

    }

    //todo evento criado para botao em tela espera uma view
    public void salvarDenuncia(View v){
        Denuncia d = new Denuncia();
        d.setCategoria(edtCategoria.getText().toString());
        d.setDescricao(edtDescricao.getText().toString());
        d.setFoto(null);
        d.setLatitude(null);
        d.setLongitude(null);

        denunciaDAO.salvar(d);

        Log.i("Denuncia","Salvo corretamente");
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}