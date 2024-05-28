package com.politecnicomalaga.maquinaindustrial.model;

public class PreguntaRespuestas {

    static int cont = 0;
    private int id;
    private int valida;
    private boolean acertada;

    public PreguntaRespuestas(int valida) {
        cont++;
        this.id = cont;
        this.valida = valida;
        this.acertada = false;
    }

    public void acertar(int respuesta){

        if(valida == respuesta) {
            setAcertada(true);
        }

    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        PreguntaRespuestas.cont = cont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValida() {
        return valida;
    }

    public void setValida(int valida) {
        this.valida = valida;
    }

    public boolean isAcertada() {
        return acertada;
    }

    public void setAcertada(boolean acertada) {
        this.acertada = acertada;
    }
}