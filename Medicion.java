package garmin;

import java.io.Serializable;
import java.util.ArrayList;

public class Medicion implements Serializable {

    private double distancia;
    private double tiempo;
    private double frecCardiaca;

    //private Medicion next;
    public Medicion(double distancia, double tiempo, double frecCardiaca) {
        this.distancia = distancia;
        this.tiempo = tiempo;
        this.frecCardiaca = frecCardiaca;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getTiempo() {
        return tiempo;
    }

    public double getFrecCardiaca() {
        return frecCardiaca;
    }

    @Override
    public String toString() {
        return ("Datos" + this.getDistancia() + "\n" + this.getTiempo() + "\n" + this.getFrecCardiaca());
    }
}
