package uta.fisei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import uta.fisei.baseDatos.ClientesDataBase;

public class ClientesActivity extends AppCompatActivity {

    EditText editTextNombre, editTextApellido, editTextsaldo, editTextCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextsaldo = findViewById(R.id.editTextSaldo);


    }

    public  void  onCLicInsertar(View view){

        //crea la base de datos o devolver el puntero si la base ya se encutra creada
        ClientesDataBase clientesDataBase = new ClientesDataBase(this
        ,"CLIENTES_DB",null,1);

        //abrir la base de datos en modo lectura(SELECT )
       // SQLiteDatabase sql = clientesDataBase.getReadableDatabase();

        //abrir la base de datos en modo escritura (select, DMl,DDL)
        SQLiteDatabase sql = clientesDataBase.getWritableDatabase();

        //obtener los datos ingresados en los controles
        String codigo = editTextCodigo.getText().toString();
        String nombre =  editTextNombre.getText().toString();
        String  apellido = editTextApellido.getText().toString();
        String saldo = editTextsaldo.getText().toString();

       // para insetar manual
        //sql.execSQL("INSERT INTO CLIENTES(Codigo, Nombre, Apellido,Saldo) VALUES ('Juan','Valle',200.5)");

        //para tener el problema de seguridad
       // sql.execSQL("INSERT INTO CLIENTES(Codigo, Nombre, Apellido,Saldo) VALUES ('"+codigo+"','"+nombre+"',"+200.5+")");

        //insertar valores de manera correcta
        ContentValues valores = new ContentValues();
        valores.put("Nombre", nombre);
        valores.put("Apellido", apellido);
        valores.put("Saldo", saldo);

        //enviar a la base de datos
        sql.insert("Clientes",null,valores);

        sql.close();
        limpiar();
        Toast.makeText(this, "Se inserto el cliente", Toast.LENGTH_SHORT).show();

    }

    public  void  limpiar(){
        editTextCodigo.setText("");
        editTextNombre.setText("");
        editTextApellido.setText("");
        editTextsaldo.setText("");
    }

    public  void  onCLicBorrar(View view){

        ClientesDataBase clientesDataBase = new ClientesDataBase(this
                ,"CLIENTES_DB",null,1);

        //abrir la base de datos en modo escritura (select, DMl,DDL)
        SQLiteDatabase sql = clientesDataBase.getWritableDatabase();


    }

    public  void  onCLicModificar(View view){

        ClientesDataBase clientesDataBase = new ClientesDataBase(this
                ,"CLIENTES_DB",null,1);

        //abrir la base de datos en modo escritura (select, DMl,DDL)
        SQLiteDatabase sql = clientesDataBase.getWritableDatabase();



    }

    public  void  onCLicBUscar(View view){

        ClientesDataBase clientesDataBase = new ClientesDataBase(this
                ,"CLIENTES_DB",null,1);

        //abrir la base de datos en modo lectura(SELECT )
        SQLiteDatabase sql = clientesDataBase.getReadableDatabase();

        //obtener el codigo del cliente
        String codigo = editTextCodigo.getText().toString();

       // String SELECT  = "SELECT * FROM  Clientes WHERE Codigo='"+codigo+"'";
        String SELECT  = "SELECT * FROM  Clientes WHERE Codigo=" + codigo;
        //select Codigo (0), Nombre (1), Apellido (2), Saldo (3)

        //String SELECT  = "SELECT Nombre, Apellido, Saldo FROM  Clientes WHERE Codigo=" + codigo;



        Cursor cursor = sql.rawQuery(SELECT,null);

        if (cursor.moveToFirst()){

            editTextNombre.setText(cursor.getString(1));
            editTextApellido.setText(cursor.getString(2));
            editTextsaldo.setText(cursor.getString(3));


        }else {
            Toast.makeText(this, "No se encontro el cliente", Toast.LENGTH_SHORT).show();
            limpiar();

        }

        sql.close();
        //while (cursor.moveToFirst())



    }

    public  void  onCLicMostrar(View view){

        ClientesDataBase clientesDataBase = new ClientesDataBase(this
                ,"CLIENTES_DB",null,1);

        //abrir la base de datos en modo lectura(SELECT )
        SQLiteDatabase sql = clientesDataBase.getReadableDatabase();



    }

}