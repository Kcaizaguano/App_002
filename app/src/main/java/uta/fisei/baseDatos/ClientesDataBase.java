package uta.fisei.baseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClientesDataBase extends SQLiteOpenHelper {


    private String CREATE_TABLE_CLIENTES = "CREATE TABLE Clientes (" +
            "Codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Nombre TEXT, " +
            "Apellido TEXT," +
            "Saldo REAL)";


    public ClientesDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Crear la estructura de la base de datos
        sqLiteDatabase.execSQL(CREATE_TABLE_CLIENTES);

        //Agregar datos en las tablas
        //insert into .....

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //Cambios requeridos en la base de datos
        //if (sqLiteDatabase)
        sqLiteDatabase.execSQL(CREATE_TABLE_CLIENTES);


    }
}
