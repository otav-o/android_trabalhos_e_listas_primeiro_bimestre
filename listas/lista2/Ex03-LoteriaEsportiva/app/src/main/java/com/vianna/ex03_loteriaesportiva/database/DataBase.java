package com.vianna.ex03_loteriaesportiva.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {


    public static final String JOGO_TABLE_NAME = "jogo";
    public static final String APOSTADOR_TABLE_NAME = "apostador";

    public static final String JOGO_DB = "jogo.db";
    public static final int VERSION_DB = 2;

    public DataBase(@Nullable Context context) {
        super(context, JOGO_DB, null, VERSION_DB);
    }

    public static final String FIELD_APOSTADOR_ID = "id";
    public static final String FIELD_APOSTADOR_NOME = "nome";
    public static final String APOSTADOR_CREATE= " create table " + APOSTADOR_TABLE_NAME + "(" +
            " " + FIELD_APOSTADOR_ID + " integer primary key autoincrement, " +
            " " + FIELD_APOSTADOR_NOME + " text not null )";
    public static final String JOGO_CREATE= " create table " + JOGO_TABLE_NAME + "(" +
            " " + FIELD_APOSTADOR_ID + " integer primary key autoincrement, " +
            " " + FIELD_APOSTADOR_NOME + " text not null, " +
            " " + FIELD_APOSTADOR_ID + "Apostador integer not null " +
            ")";


    @Override
    public void onCreate(SQLiteDatabase con) {
        con.execSQL(APOSTADOR_CREATE);
        con.execSQL(JOGO_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase con, int vBanco, int vApp) {

        Log.i("BANCO", "Versão Banco :: "+vBanco);
        Log.i("BANCO", "Versão App :: "+vApp);

        con.execSQL("DROP TABLE " + JOGO_TABLE_NAME);
        con.execSQL("DROP TABLE " + APOSTADOR_TABLE_NAME);

        onCreate(con);
    }
}
