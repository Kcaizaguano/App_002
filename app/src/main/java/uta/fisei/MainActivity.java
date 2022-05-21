package uta.fisei;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText editTextPrimerValor, editTextSegundoValor, editTextResultado;
     Button btn_potencia, btn_salir;
     TextView textViewDatos;


     //OBTENER LOS DATOS  ENVIADOS AL CERRAR LA ACTIVIDAD (DESDE ATRAS-ADELANTE )
    ActivityResultLauncher<Intent>  activityResult =
             registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                 @Override
                 public void onActivityResult(ActivityResult result) {

                     //procesasr los datos
                     if (result.getResultCode() == Activity.RESULT_OK)
                     {
                         //obtener los datos regresados
                         Intent data = result.getData();
                         //Toast.makeText(MainActivity.this, "Datos regresados" + data.getDataString(), Toast.LENGTH_LONG).show();

                        textViewDatos.setText(data.getDataString());

                     }
                 }
             });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextPrimerValor = findViewById(R.id.editTextPrimerValor);
        editTextSegundoValor = findViewById(R.id.editTextSegundoValor);
        editTextResultado = findViewById(R.id.editTextResultado);
        btn_potencia = findViewById(R.id.buttonPotencia);
        btn_salir = findViewById(R.id.buttonSalir);
        textViewDatos = findViewById(R.id.textViewDatos);

        //Manejador para el evento click del boton
        btn_potencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String b =  editTextPrimerValor.getText().toString();
                String e = editTextSegundoValor.getText().toString();

                int base = Integer.parseInt(b);
                int exponente = Integer.parseInt(e);
                Matematicas matematicas = new Matematicas();
                editTextResultado.setText(String.valueOf(matematicas.Potencia(base,exponente)));

            }
        });

        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //obtener los parametros
        Bundle bundle = getIntent().getExtras();

        /*
        editTextResultado.setText(bundle.getString("variable_usuario"));
        editTextSegundoValor.setText(bundle.getString("variable_clave"));
        */

        //acceso a  a la barrra del telefono
        this.getSupportActionBar().setTitle("Usted esta conectado como "+
                                            bundle.getString("variable_usuario"));


    }

    public void onClicPotencia (View view) {

        String b =  editTextPrimerValor.getText().toString();
        String e = editTextSegundoValor.getText().toString();

        int base = Integer.parseInt(b);
        int exponente = Integer.parseInt(e);

        /*
        long resultado = 1;
        for (int i=1; i <= exponente; i++){
            resultado *= base;
        }
        */
        Matematicas matematicas = new Matematicas();
        editTextResultado.setText(String.valueOf(matematicas.Potencia(base,exponente)));
        //editTextResultado.setText(String.valueOf(Matematicas.sumar(base,exponente))); clase estatica por que se  puede llamar sin Instaciar
    }


    public void onCLickMonstrarActivitie(View view){

        //Mostrar activitie

        Intent intent = new Intent(this, TercerActivity.class);

        //this.startActivity(intent);
        //utilizar actividades que  van aregresar datos
        activityResult.launch(intent);
    }


    public void onCLickLlamar(View view) {
        // Intent intent = new Intent(android.content.Intent.);-- PROCESO PARA LLAMAR A UNA NUEVA ACCION
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+563489879"));
        startActivity(intent);
        //Uri uri = new Uri("")
    }


    public void onCLickNavegador(View view){

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
        startActivity(intent);


    }

    public void finalizarApp(View view){

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }



}