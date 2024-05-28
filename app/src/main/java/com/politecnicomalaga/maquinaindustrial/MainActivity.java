package com.politecnicomalaga.maquinaindustrial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.politecnicomalaga.maquinaindustrial.data.StringConst;
import com.politecnicomalaga.maquinaindustrial.model.PreguntaRespuestas;
import com.politecnicomalaga.maquinaindustrial.view.Resultado;

public class MainActivity extends AppCompatActivity {
    private PreguntaRespuestas pregunta1, pregunta2, pregunta3, pregunta4;
    private static int cont;
    private static int res;


    public static class portada extends AppCompatActivity {
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
        ImageView miImagen = (ImageView) findViewById(R.id.imagen);
        cont = 1;

        pregunta.setText(StringConst.pregunta1);
        miBotonA.setText(StringConst.respuesta1A);
        miBotonB.setText(StringConst.respuesta1B);
        miBotonC.setText(StringConst.respuesta1C);
        miBotonD.setText(StringConst.respuesta1D);
        miImagen.setImageResource(R.drawable.guindos);
        pregunta1 = new PreguntaRespuestas(2);
        pregunta2 = new PreguntaRespuestas(3);
        pregunta3 = new PreguntaRespuestas(3);
        pregunta4 = new PreguntaRespuestas(1);

        miBotonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean acertada;
                if (cont==1) {
                    acertada = pregunta1.acertar(1);
                } else if (cont==2) {
                    acertada = pregunta2.acertar(1);
                } else if (cont==3) {
                    acertada = pregunta3.acertar(1);
                } else {
                    acertada = pregunta4.acertar(1);
                }
                if(acertada) {
                    miBotonA.setBackgroundColor(Color.GREEN);
                    res++;
                } else {
                    miBotonA.setBackgroundColor(Color.RED);
                }
            }
        });

        miBotonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean acertada;
                if (cont==1) {
                    acertada = pregunta1.acertar(2);
                } else if (cont==2) {
                    acertada = pregunta2.acertar(2);
                } else if (cont==3) {
                    acertada = pregunta3.acertar(2);
                } else {
                    acertada = pregunta4.acertar(2);
                }
                if(acertada) {
                    miBotonB.setBackgroundColor(Color.GREEN);
                    res++;
                } else {
                    miBotonB.setBackgroundColor(Color.RED);
                }
            }
        });

        miBotonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean acertada;
                if (cont==1) {
                    acertada = pregunta1.acertar(3);
                } else if (cont==2) {
                    acertada = pregunta2.acertar(3);
                } else if (cont==3) {
                    acertada = pregunta3.acertar(3);
                } else {
                    acertada = pregunta4.acertar(3);
                }
                if(acertada) {
                    miBotonC.setBackgroundColor(Color.GREEN);
                    res++;
                } else {
                    miBotonC.setBackgroundColor(Color.RED);
                }
            }
        });

        miBotonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean acertada;
                if (cont==1) {
                    acertada = pregunta1.acertar(4);
                } else if (cont==2) {
                    acertada = pregunta2.acertar(4);
                } else if (cont==3) {
                    acertada = pregunta3.acertar(4);
                } else {
                    acertada = pregunta4.acertar(4);
                }
                if(acertada) {
                    miBotonD.setBackgroundColor(Color.GREEN);
                    res++;
                } else {
                    miBotonD.setBackgroundColor(Color.RED);
                }
            }
        });
        miBotonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                if (cont == 5) {
                    Intent intent = new Intent(MainActivity.this, Resultado.class);
                    startActivity(intent);
                    finish();
                } else {
                    if (cont == 2) {
                        pregunta.setText(StringConst.pregunta2);
                        miBotonA.setText(StringConst.respuesta2A);
                        miBotonB.setText(StringConst.respuesta2B);
                        miBotonC.setText(StringConst.respuesta2C);
                        miBotonD.setText(StringConst.respuesta2D);
                        miImagen.setImageResource(R.drawable.fiatlux);

                    } else if (cont == 3) {
                        pregunta.setText(StringConst.pregunta3);
                        miBotonA.setText(StringConst.respuesta3A);
                        miBotonB.setText(StringConst.respuesta3B);
                        miBotonC.setText(StringConst.respuesta3C);
                        miBotonD.setText(StringConst.respuesta3D);
                        miImagen.setImageResource(R.drawable.tabacalera);
                    } else if (cont == 4) {
                        pregunta.setText(StringConst.pregunta4);
                        miBotonA.setText(StringConst.respuesta4A);
                        miBotonB.setText(StringConst.respuesta4B);
                        miBotonC.setText(StringConst.respuesta4C);
                        miBotonD.setText(StringConst.respuesta4D);
                        miImagen.setImageResource(R.drawable.pisos);
                    }
                    miBotonA.setBackgroundColor(Color.BLACK);
                    miBotonB.setBackgroundColor(Color.BLACK);
                    miBotonC.setBackgroundColor(Color.BLACK);
                    miBotonD.setBackgroundColor(Color.BLACK);
                }
            }
        });

    }

    public static int getRes() {
        return res;
    }
}