package com.example.listapc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private final static String NAME_DB = "virtualMercado.sqlite";
    private final static int VERSION_DB = 1;

    private final String sqlCreate = "CREATE TABLE Producto( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre	TEXT NOT NULL, " +
            "precio	NUMERIC NOT NULL, " +
            "descripcion	TEXT NOT NULL); ";



    public DbHelper(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //se elimina version anterior de tabla
        db.execSQL("DROP TABLE IF EXISTS Producto");
        //se crea nueva version de tabla
        db.execSQL(sqlCreate);
    }
}
