package com.projetos.lucaschr.projeto01.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lucas on 04/11/16.
 */
public class BancoDados {

    private static final String NOME_BANCO = "cidadelimpa";
    private static final int VERSAO_BANCO = 1;

    //Script
    private static final String[] SCRIPT_DATABASE_DELETE = new String[] {"DROP TABLE IF EXISTS denuncia;"};

    //Tabela com id sequencial usa-se _id
    private static final String[] SCRIPT_DATABASE_CREATE = new String[]{
            "create table denuncia(_id integer primary key, den_id text, den_categoria text, den_descricao text, den_latitude text, den_longitude text, den_img text);"
    };

    private static SQLiteDatabase db;

    public static SQLiteDatabase getDB(Context ctx) {
        if (db == null) {
            SQLiteHelper dbHelper = new SQLiteHelper(ctx, NOME_BANCO, VERSAO_BANCO, SCRIPT_DATABASE_CREATE, SCRIPT_DATABASE_DELETE);
            db = dbHelper.getWritableDatabase();
        }
        return db;

    }
}
