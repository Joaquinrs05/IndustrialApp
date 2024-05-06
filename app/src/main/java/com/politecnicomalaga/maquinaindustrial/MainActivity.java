package com.politecnicomalaga.maquinaindustrial;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.politecnicomalaga.maquinaindustrial.model.Maquina;
//import com.politecnicomalaga.maquinaindustrial.model.Piloto;

public class MainActivity extends AppCompatActivity {
    private Maquina maquina;
    private Activity thisAct;


    public class portada extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.portada);

            Button botonQuiz = findViewById(R.id.Quiz);
            botonQuiz.setOnClickListener(new View.OnClickListener() {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Todo se hace a partir de set content view;

        setContentView(R.layout.quiz);

        thisAct = this;

        maquina = new Maquina("22", 3, 4);

        //los botones
        Button miBotonArrancar = (Button) findViewById(R.id.Arrancar);
        Button mibotonApagar = (Button) findViewById(R.id.Apagar);
        Button mibotonComprobar = (Button) findViewById(R.id.Comprobar);
        EditText numeroTemperatura = (EditText) findViewById(R.id.NumeroTemperatura);
        EditText numeroAmperios = (EditText) findViewById(R.id.NumeroAmperios);
        TextView Led = (TextView) findViewById(R.id.led);
        TextView colorLed = (TextView) findViewById(R.id.Colorled);
        TextView estadoMaquina = (TextView) findViewById(R.id.EstadoMaquina);
        TextView estado = (TextView) findViewById(R.id.Estado);


        //Botones en los que interacctuar
        //hecho, funciona relativamente bien
        miBotonArrancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Maquina.Piloto encendida = maquina.comprobarPiloto();
                // Obtener el texto ingresado por el usuario en los campos de temperatura y amperios
                String tempText = numeroTemperatura.getText().toString();
                String ampText = numeroAmperios.getText().toString();

                // Verificar si los campos están vacíos
                if (tempText.isEmpty() || ampText.isEmpty()) {
                    // Mostrar un mensaje indicando que se necesitan números
                    Toast.makeText(MainActivity.this, "Por favor, ingresa números en ambos campos.", Toast.LENGTH_SHORT).show();
                    return; // Salir del método onClick ya que no se pueden realizar cálculos sin números
                }else{
                    maquina.arrancar();
                    estadoMaquina.setText("Encendido");
                    estadoMaquina.setTextColor(Color.GREEN);
                    colorLed.setBackgroundColor(Color.GREEN);
                }
            }
        });


        mibotonComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Obtener el texto ingresado por el usuario en los campos de temperatura y amperios
                String tempText = numeroTemperatura.getText().toString();
                String ampText = numeroAmperios.getText().toString();

                // Verificar si los campos están vacíos
                if (tempText.isEmpty() || ampText.isEmpty()) {
                    // Mostrar un mensaje indicando que se necesitan números
                    Toast.makeText(MainActivity.this, "Por favor, ingresa números en ambos campos.", Toast.LENGTH_SHORT).show();
                    return; // Salir del método onClick ya que no se pueden realizar cálculos sin números
                }

                // Obtener los valores de temperatura y amperios ingresados por el usuario
                float temperatura = Float.parseFloat(numeroTemperatura.getText().toString());
                float amperios = Float.parseFloat(numeroAmperios.getText().toString());

                // Llamar al método Comprobar() de la máquina
                Maquina.Piloto encendida = maquina.comprobarPiloto();
                if (maquina.isEncendida()) {

                    if (temperatura <= 55 && amperios >= 3 && amperios <= 8) {
                        maquina.setEncendida(true);
                        maquina.setPiloto(Maquina.Piloto.verde); // Asigna el estado verde al piloto
                        colorLed.setBackgroundColor(Color.GREEN);
                    } else if (temperatura >= 56 && temperatura <= 84 && amperios >= 3 && amperios <= 8) {
                        maquina.setPiloto(Maquina.Piloto.amarillo); // Asigna el estado amarillo al piloto
                        colorLed.setBackgroundColor(Color.YELLOW);
                    } else if (temperatura >= 85 && (amperios < 3 || amperios > 8)) {
                        maquina.setEncendida(false); // Apaga la máquina si la temperatura es alta y la corriente es insuficiente o excesiva
                        maquina.setPiloto(Maquina.Piloto.off); // Asigna el estado rojo al piloto
                        colorLed.setBackgroundColor(Color.BLACK);
                        estadoMaquina.setTextColor(Color.RED);
                        estadoMaquina.setText("Apagado");
                    }
                } else {
                    maquina.setEncendida(false);
                    maquina.setPiloto(Maquina.Piloto.off);
                    colorLed.setBackgroundColor(Color.BLACK);
                }
            }
        });

        //Hecho, funciona relaticamente bien
        mibotonApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maquina.Apagar();
                estadoMaquina.setText("Apagado");
                estadoMaquina.setTextColor(Color.RED);
                colorLed.setBackgroundColor(Color.RED);
            }
        });

    }
}