package com.projetos.lucaschr.projeto01.denuncia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.projetos.lucaschr.projeto01.sqlite.BancoDados;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 16/11/16.
 */

public class DenunciaDAO {

    SQLiteDatabase db;

    public DenunciaDAO(Context context){ db = BancoDados.getDB(context);}


    public void salvar(Denuncia denuncia) {
        ContentValues values = new ContentValues();
        values.put(Denuncia.CATEGORIA, denuncia.getCategoria());
        values.put(Denuncia.DESCRICAO, denuncia.getDescricao());
        values.put(Denuncia.FOTO, denuncia.getFoto());
        values.put(Denuncia.LATITUDE, denuncia.getLatitude());
        values.put(Denuncia.LONGITUDE, denuncia.getLongitude());
        db.insert(Denuncia.TABELA, null, values);
    }

    public void alterar(Denuncia denuncia) {
        ContentValues values = new ContentValues();
        values.put(Denuncia.CATEGORIA, denuncia.getCategoria());
        values.put(Denuncia.DESCRICAO, denuncia.getDescricao());
        values.put(Denuncia.FOTO, denuncia.getFoto());
        values.put(Denuncia.LATITUDE, denuncia.getLatitude());
        values.put(Denuncia.LONGITUDE, denuncia.getLongitude());

        String id = String.valueOf(denuncia.getId());
        String[] whereArgs = new String[]{id};

        db.update(Denuncia.TABELA, values, Denuncia.ID +" = ?", whereArgs);
    }

    public Denuncia buscar(String id) {


        String[] colunas = Denuncia.COLUNAS;
        String[] whereArgs = new String[]{id};

        Cursor c = db.query(Denuncia.TABELA, colunas,Denuncia.ID + " = ?", whereArgs, null, null, null);

        c.moveToFirst();

        Denuncia denuncia = new Denuncia();
        denuncia.setId(c.getLong(c.getColumnIndex(Denuncia.ID)));
        denuncia.setCategoria(c.getString(c.getColumnIndex(Denuncia.CATEGORIA)));
        denuncia.setDescricao(c.getString(c.getColumnIndex(Denuncia.DESCRICAO)));
        denuncia.setFoto(c.getString(c.getColumnIndex(Denuncia.FOTO)));
        denuncia.setLatitude(c.getString(c.getColumnIndex(Denuncia.LATITUDE)));
        denuncia.setLongitude(c.getString(c.getColumnIndex(Denuncia.LONGITUDE)));


        return denuncia;
    }

    public List<Denuncia> listar() {

        String[] colunas = Denuncia.COLUNAS;
        Cursor c = db.query(Denuncia.TABELA, colunas, null, null, null, null, null);

        List<Denuncia> denuncias = new ArrayList<Denuncia>();
        if (c.moveToFirst()) {
            do {
                Denuncia denuncia = new Denuncia();
                denuncia.setId(c.getLong(c.getColumnIndex(Denuncia.ID)));
                denuncia.setCategoria(c.getString(c.getColumnIndex(Denuncia.CATEGORIA)));
                denuncia.setDescricao(c.getString(c.getColumnIndex(Denuncia.DESCRICAO)));
                denuncia.setFoto(c.getString(c.getColumnIndex(Denuncia.FOTO)));
                denuncia.setLatitude(c.getString(c.getColumnIndex(Denuncia.LATITUDE)));
                denuncia.setLongitude(c.getString(c.getColumnIndex(Denuncia.LONGITUDE)));

                denuncias.add(denuncia);

                Log.i("lista", denuncia.getDescricao());
            } while (c.moveToNext());
        }
        return denuncias;
    }


    public void excluir(String id) {
        String[] whereArgs = new String[]{id};
        db.delete(Denuncia.TABELA,Denuncia.ID + " = ?", whereArgs);
    }

}
