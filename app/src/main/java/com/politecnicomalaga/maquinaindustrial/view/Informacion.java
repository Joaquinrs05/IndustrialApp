package com.politecnicomalaga.maquinaindustrial.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.politecnicomalaga.maquinaindustrial.R;

public class Informacion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion); // Asegúrate de tener informacion.xml en res/layout

        // Mover el findViewById y el setOnClickListener dentro del onCreate
        Button nosotros = findViewById(R.id.volver);
        nosotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el botón, iniciar la actividad de la portada
                Intent intent = new Intent(Informacion.this, Portada.class);
                startActivity(intent);
            }
        });
    }
}
