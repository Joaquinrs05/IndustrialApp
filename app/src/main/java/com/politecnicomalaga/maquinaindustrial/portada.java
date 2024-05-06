package com.politecnicomalaga.maquinaindustrial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class portada extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portada);

        Button botonIniciar = findViewById(R.id.Quiz);
        botonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando se hace clic en el botón de la portada, iniciar la actividad principal
                Intent intent = new Intent(portada.this, MainActivity.class);
                startActivity(intent);
                finish(); // Cerrar la actividad de la portada para que no se pueda volver atrás
            }
        });
    }
}
