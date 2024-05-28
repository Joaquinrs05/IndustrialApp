package com.politecnicomalaga.maquinaindustrial;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.politecnicomalaga.maquinaindustrial.data.StringConst;
import com.politecnicomalaga.maquinaindustrial.model.PreguntaRespuestas;

public class MainActivity extends AppCompatActivity {
    private PreguntaRespuestas pregunta1, pregunta2, pregunta3, pregunta4;
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

                    Intent intent = new Intent(portada.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.quiz);
        
        TextView pregunta = (TextView) findViewById(R.id.pregunta);
        Button miBotonA = (Button) findViewById(R.id.botonA);
        Button miBotonB = (Button) findViewById(R.id.botonB);
        Button miBotonC = (Button) findViewById(R.id.botonC);
        Button miBotonD = (Button) findViewById(R.id.botonD);
        Button miBotonNext = (Button) findViewById(R.id.next);

        miBotonNext.callOnClick();

        thisAct = this;

        pregunta1 = new PreguntaRespuestas(1);
        pregunta2 = new PreguntaRespuestas(1);
        pregunta3 = new PreguntaRespuestas(1);
        pregunta4 = new PreguntaRespuestas(1);

        miBotonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pregunta1.acertar(1);
            }
        });

        miBotonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pregunta1.acertar(2);
            }
        });

        miBotonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pregunta1.acertar(3);
            }
        });

        miBotonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pregunta1.acertar(4);
            }
        });

        miBotonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pregunta.setText(StringConst.pregunta1);
            }
        });

    }
}