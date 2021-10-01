package com.vianna.ex03_loteriaesportiva.database.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.vianna.ex03_loteriaesportiva.database.DataBase;

import java.util.ArrayList;

public abstract class GenericsDao<O, K> {

    private DataBase db;
    private Context ctx;
    protected SQLiteDatabase con;

    public GenericsDao(Context ctx) {
        this.ctx = ctx;
        db = new DataBase(ctx);
    }

    public void open(){
        con = db.getWritableDatabase();
    }

    public void close(){
        db.close();
    }


    public abstract void inserir(O obj);
    public abstract void alterar(O obj);
    public abstract void apagar(K key);
    public abstract O findById(K key);
    public abstract ArrayList<O> findAll();
    public abstract long count();
}

