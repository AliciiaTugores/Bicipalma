package edu.pingpong.estacion;


import edu.pingpong.bicicleta.Movil;
import edu.pingpong.tarjetaUsuario.Autenticacion;

import java.util.Arrays;
import java.util.Optional;

public class Estacion {

    private final int id;
    private final String direccion;
    private final Anclajes anclajes;

    public Estacion (int id, String direccion, int numAnclajes) {
        this.id = id;
        this.direccion = direccion;
        this.anclajes = new Anclajes(numAnclajes);
    }

    private int getId(){
        return id;
    }

    private String getDireccion(){
        return direccion;
    }

    @Override
    public String toString() {
        return "Estacion{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", anclajes=" + anclajes +
                '}';
    }

    private Anclaje[] anclajes(){
        return this.anclajes.anclajes();
    }

    private int numAnclajes(){
        return this.anclajes.numAnclajes();
    }

    public void consultarEstacion(){
        System.out.println(this);
    }

    public int anclajesLibres(){
       // return (int) Arrays.stream(anclajes()).filter(a -> !a.isOcupado()).count();
        int libres = 0;
        for (Anclaje i : anclajes()) {
            libres = i.isOcupado()? libres: ++ libres;
            }
        return libres;
        }

    public void anclarBicicleta(Movil bici){
        Optional<Anclaje> anclajeLibre = Arrays.stream(anclajes()).filter(a -> !a.isOcupado()).findAny();

        if (anclajeLibre.isPresent()) {
            anclajeLibre.get().anclarBici(bici);
        }
        else{
            System.out.println("No existen anclajes disponibles para bici " + bici);
        }
    }

    public boolean leerTarjetaUsuario(Autenticacion tarjetaUsuario){
        return tarjetaUsuario.isActivada();
    }

    public void retirarBicicleta(Autenticacion tarjetaUsuario) {
        if(leerTarjetaUsuario(tarjetaUsuario)) {
            Optional<Anclaje> anclajeOcupado = Arrays.stream(anclajes()).filter(Anclaje::isOcupado).findAny();
            if (anclajeOcupado.isPresent()) {
                mostrarBicicleta(anclajeOcupado.get().getBici());
                anclajeOcupado.get().liberarBici();
            }
            else {
                System.out.println("No hay bicis");
            }
        } else {
            System.out.println("Tarjeta de usuario inactiva :(");
        }
        }
    private void mostrarBicicleta(Movil bicicleta /*, int numeroAnclaje*/) {
        System.out.println("bicicleta retirada: " + bicicleta.getId()
                /*+ " del anclaje: " + numeroAnclaje*/);
    }

    private void mostrarAnclaje(Movil bicicleta, int numeroAnclaje) {
        System.out.println("bicicleta " + bicicleta.getId()
                + " anclada en el anclaje " + numeroAnclaje);
    }

    public void consultarAnclajes() {
        Arrays.stream(anclajes()).map(a -> Optional.ofNullable(a.getBici()))
                .forEach(bici -> System.out.print("Anclaje " +
                        (bici.isPresent()? bici.get(): "libre")
                        + '\n'));
    }
}
