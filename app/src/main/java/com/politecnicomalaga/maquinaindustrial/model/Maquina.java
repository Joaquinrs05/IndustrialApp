package com.politecnicomalaga.maquinaindustrial.model;


public class Maquina {
    // Atributos
    private Piloto piloto;
    private String codigo;
    private float temperatura;
    private boolean encendida = false;
    private float amperios;
    public enum Piloto {
        rojo,
        verde,
        amarillo,
        off
    }

    public Maquina(String codigo, float temperatura, float amperios) {
        this.codigo = codigo;
        this.temperatura = temperatura;
        this.amperios = amperios;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isEncendida() {
        return encendida;
    }

    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }

    public float getAmperios() {
        return amperios;
    }

    public void setAmperios(float amperios) {
        this.amperios = amperios;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public boolean arrancar() {
        if (temperatura <= 55 && amperios >= 3 && amperios <= 8) {
            encendida = true;
            piloto = Piloto.verde; // Asigna el estado verde al piloto
        } else if (temperatura >= 56 && temperatura <= 84 && amperios >= 3 && amperios <= 8) {
            piloto = Piloto.amarillo; // Asigna el estado amarillo al piloto
        } else if (temperatura >= 85 && (amperios < 3 || amperios > 8)) {
            encendida = false; // Apaga la máquina si la temperatura es alta y la corriente es insuficiente o excesiva
            piloto = Piloto.rojo; // Asigna el estado rojo al piloto
        }
        return encendida;
    }

    public Piloto comprobarPiloto(){

        if(encendida ){
            if(temperatura <= 55 ){
                return  piloto.verde;
            }else if(temperatura > 55 && temperatura <=85 ){
                return  piloto.amarillo;
            }else{
                return piloto.rojo;
            }
        }

        return null;

    }

    public  boolean Apagar(){
        encendida= false;
        piloto= Piloto.off;
        return  encendida;
    }
}
