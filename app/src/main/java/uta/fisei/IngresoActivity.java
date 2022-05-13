package uta.fisei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IngresoActivity extends AppCompatActivity {

    EditText editTextUsuario, editTextClave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextClave = findViewById(R.id.editTextClave);

    }

    public  void  ingresar (View view){
        String usuario = editTextUsuario.getText().toString();
        String clave = editTextClave.getText().toString();

        if (usuario.equals("admin") && clave.equals("admin")){
            //mostrar un activity
            Intent intent = new Intent(this,MainActivity.class);

            //pasar parametros

            intent.putExtra("variable_usuario",usuario);
            intent.putExtra("variable_clave",clave);


            startActivity(intent);
        } else {
            Toast.makeText(this, "  ERROR:  Usuario o clave incorrecto", Toast.LENGTH_SHORT).show();
        }

    }

    public void finalizarApp(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //ASOCIAR EL MENU AL ACTIVITY
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //inflar menu con al informacion del menu diseñado
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

        //return true

    }
}