package com.politecnicomalaga.maquinaindustrial.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.politecnicomalaga.maquinaindustrial.MainActivity;
import com.politecnicomalaga.maquinaindustrial.R;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado); // Asegúrate de tener el archivo resultado.xml en res/layout

        // Obteniendo el resultado del quiz desde MainActivity
        int res = MainActivity.getRes();

        // Mostrando el resultado en el TextView
        TextView resultadoTextView = findViewById(R.id.res);
        resultadoTextView.setText(String.valueOf(res));
    }
}
