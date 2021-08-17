package com.example.noticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;

public class activity_DiariosMundo extends AppCompatActivity {

    private ListView listView_DiarioMundo;

    private String noticierosMundo [] = {"New York Times","USA Today","BBC","The Times","ABC","RT"};

    private String ulrnoticieros[]={"https://www.nytimes.com/es/","https://www.usatoday.com/",
            "https://www.bbc.com/mundo","https://www.thetimes.co.uk/","https://www.abc.es/",
            "https://actualidad.rt.com/"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__diarios_mundo);

        //Mostrar Icono en el ActionBar
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        listView_DiarioMundo = findViewById(R.id.listview_DiariosMundo);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.listview_diariosmundo,noticierosMundo);

        listView_DiarioMundo.setAdapter(adapter);

        listView_DiarioMundo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = ulrnoticieros[i];
                navegar(url);
            }
        });
    }

    public void Volver(View view){
        finish();
    }

    private void navegar(String url) {
        Intent i = new Intent(this,activity_NavegadorDiarios.class);
        i.putExtra("url",url);
        startActivity(i);
    }

    //Inicializar el Menu OverFlow
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_overflow,menu);
        return true;
    }

    //Selección de Una opcion de Menú
    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();
        if(id == R.id.opc_acercade){
            Intent i = new Intent(this,activity_AcercaDe.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}