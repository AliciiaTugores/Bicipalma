package edu.pong;

public class Estacion {
    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    public Estacion (int id, String direccion, Anclajes anclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = anclajes;
    }

    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "id" + getId() + "\n" +
                "direccion" + getDireccion();
    }

}

