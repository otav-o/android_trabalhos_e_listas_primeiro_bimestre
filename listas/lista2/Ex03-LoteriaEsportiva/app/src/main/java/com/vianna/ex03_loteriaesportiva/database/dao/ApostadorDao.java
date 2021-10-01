package com.vianna.ex03_loteriaesportiva.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.vianna.ex03_loteriaesportiva.database.DataBase;
import com.vianna.ex03_loteriaesportiva.models.Apostador;

import java.util.ArrayList;

public class ApostadorDao extends GenericsDao<Apostador, Integer> {
    public ApostadorDao(Context ctx) {
        super(ctx);
    }

    @Override
    public void inserir(Apostador obj) {
        try {
            open();
            String sql = "insert into " + DataBase.APOSTADOR_TABLE_NAME +
                    "(" + DataBase.FIELD_APOSTADOR_NOME + ") " +
                    " values('" + obj.getNome() + "')";
            con.execSQL(sql);
        } finally {
            close();
        }
    }

    @Override
    public void alterar(Apostador obj) {
        try {
            open();
            ContentValues cv = new ContentValues();
            cv.put(DataBase.FIELD_APOSTADOR_NOME, obj.getNome());

            con.update(DataBase.APOSTADOR_TABLE_NAME, cv,
                    DataBase.FIELD_APOSTADOR_ID + " = " + obj.getId(),null );

        } finally {
            close();
        }
    }

    @Override
    public void apagar(Integer key) {
        try {
            open();
            con.delete(DataBase.APOSTADOR_TABLE_NAME,
                    DataBase.FIELD_APOSTADOR_ID + " = " + key,null);
        } finally {
            close();
        }
    }

    @Override
    public Apostador findById(Integer key) {
        try {
            open();

            String sql = "select * from apostador where id = "+key;
            Cursor c = con.rawQuery(sql,null);

            Apostador a = null;
            if (c.moveToFirst()){
                a = new Apostador(c.getInt(0), c.getString(1));
            }

            return a;

        } finally {
            close();
        }
    }

    @Override
    public ArrayList<Apostador> findAll() {
        try {
            open();

            String sql = "select * from apostador";
            Cursor c = con.rawQuery(sql,null);

            ArrayList<Apostador> lista = new ArrayList<>();

            c.moveToFirst();
            while (!c.isAfterLast()){
                Apostador a = new Apostador(c.getInt(0), c.getString(1));

                lista.add(a);
                c.moveToNext();
            }
            return lista;

        } finally {
            close();
        }
    }

    @Override
    public long count() {
        try {
            open();

            String sql = "select count(*) from apostador";
            Cursor c = con.rawQuery(sql,null);

            c.moveToFirst();

            return c.getLong(0);
        } finally {
            close();
        }

    }
}

