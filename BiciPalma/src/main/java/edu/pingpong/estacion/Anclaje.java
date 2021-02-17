package edu.pingpong.estacion;

import edu.pingpong.bicicleta.Movil;

public class Anclaje {

    private boolean ocupado;
    private Movil bici;

    Anclaje () {
    }

    boolean isOcupado() {
        return this.ocupado;
    }

    Movil getBici() {
        return this.bici;
    }

    void anclarBici(Movil bici) {
        this.bici = bici;
        this.ocupado = true;
    }

    void liberarBici(){
        this.bici = null;
        this.ocupado = false;
    }

    @Override
    public String toString() {
        return  "ocupado: " + Boolean.toString(isOcupado());
    }
}

