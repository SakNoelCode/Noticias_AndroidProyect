package com.example.noticias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Mostrar Icono en el ActionBar
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        spinner = findViewById(R.id.spinner);

        String opc [] = {"","Diarios de Mexico","Diarios del Mundo"};

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this,R.layout.spinner_diarios,opc);

        spinner.setAdapter(adapter);


    }


    public void VerDiarios(View view){
        //Obtenemos el valor del item
        String seleccion = spinner.getSelectedItem().toString();
        if(seleccion.equals("Diarios de Mexico")){

            Intent i = new Intent(this,activity_DiariosMexico.class);
            startActivity(i);

        }else if(seleccion.equals("Diarios del Mundo")){
            Intent i = new Intent(this,activity_DiariosMundo.class);
            startActivity(i);

        }else{
            Toast.makeText(this,"Debes seleccionar una opción",Toast.LENGTH_SHORT).show();
        }
    }
}