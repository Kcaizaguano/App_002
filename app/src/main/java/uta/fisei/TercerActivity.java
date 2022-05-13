package uta.fisei;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TercerActivity extends AppCompatActivity {
    ListView listViewDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);

        listViewDatos = findViewById(R.id.listViewDatos);
        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,cargarDatosListView());
        //asociar los datos
        listViewDatos.setAdapter(adapter);


        //mostrar el item seleccionado
        listViewDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //REALIZAR EL CASTING  PARA OBTENER EL DATO
                String itemSelected = (String) listViewDatos.getAdapter().getItem(i);

                //Toast.makeText(TercerActivity.this, itemSelected, Toast.LENGTH_LONG).show();

                //PASAR DATOS HACIA ATRAS DE LA ACTIVIDAD
                Intent intent = new Intent();
                intent.setData(Uri.parse(itemSelected));
                setResult(Activity.RESULT_OK, intent); // dar mensaje al momento de cerrar la ventana y pasar le dato

                finish();

            }
        });
    }

        //metodo para llenar la lista

    public List<String> cargarDatosListView() {

        List<String> list = new ArrayList<String>();

        for (int i =1; i<=20 ; i++) {
            String item = "Numero" + " "+ i;
            list.add(item);
        }

        return  list;
    }




}
