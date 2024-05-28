package com.politecnicomalaga.maquinaindustrial.model;

public class PreguntaRespuestas {

    static int cont = 0;
    private int id;
    private int valida;

    public PreguntaRespuestas(int valida) {
        cont++;
        this.id = cont;
        this.valida = valida;
    }

    public boolean acertar(int respuesta){

        return valida == respuesta;
    }

}