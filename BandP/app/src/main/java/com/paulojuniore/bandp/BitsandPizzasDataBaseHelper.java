package com.paulojuniore.bandp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class BitsandPizzasDataBaseHelper extends SQLiteOpenHelper {

    // Nome do banco de dados
    private static final String DB_NAME = "bitsandpizzas";

    // Versão do banco de dados
    private static final int DB_VERSION = 2;

    public BitsandPizzasDataBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDataBase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDataBase(db, oldVersion, newVersion);
    }

    private void updateMyDataBase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE PIZZAS ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT);");

            insertPizza(db, "Diavolo", "Delicious");
            insertPizza(db, "Funghi", "Especial");
            insertPizza(db, "Magheritta", "Very good");
        }
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE PIZZAS ADD COLUMN FAVORITE NUMERIC");
        }
    }

    private void insertPizza(SQLiteDatabase db, String name, String description) {
        ContentValues pizzaValues = new ContentValues();
        pizzaValues.put("NAME", name);
        pizzaValues.put("DESCRIPTION", description);
        db.insert("PIZZAS", null, pizzaValues);
    }

}
