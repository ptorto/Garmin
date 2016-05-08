/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Pablo
 */
public class Actividad implements Serializable {

    private String tipoActividad;
    private Date fecha;
    ArrayList<Medicion> mediciones;

    public Actividad(String tipoActividad, Date fecha) {
        this.tipoActividad = tipoActividad;
        this.fecha = fecha;
        this.mediciones = new ArrayList<Medicion>();
    }

    public static Actividad actRandon(String tipoActividad, Date fechaInicio, Date fechaFin, double dist) {
        Actividad actividad;
        Medicion medicion;
        actividad = new Actividad(tipoActividad, fechaInicio);

        double tiempo = (fechaFin.getTime() - fechaInicio.getTime()) * 0.001;
        double distancia = 0;
        final double DISTANCIA = 333;
        int frecCardiaca = 0;
        double velocidad, tempDistancia = 0;

        Random rand = new Random();

        switch (tipoActividad) {
            case "Correr":

                break;
            case "Nadar":
                break;
            case "Bicicleta":
                int i;
                for (i = 0; i < tiempo; i += 60) {
                    if (i == 0) {
                        frecCardiaca = 60 + rand.nextInt(6);
                        medicion = new Medicion(0, 0, frecCardiaca);
                        actividad.agregarMedicion(medicion);
                    } else {
                        if (tempDistancia < 375) {
                            tempDistancia = DISTANCIA + rand.nextInt(40);
                        } else if (tempDistancia < 425) {
                            tempDistancia = 400 + rand.nextInt(40);
                        } else if (tempDistancia < 470) {
                            tempDistancia = 450 + rand.nextInt(80);
                        }

                        distancia += tempDistancia;
                        velocidad = tempDistancia / i;
                        
                        System.out.println("distancia"+distancia+"vel"+velocidad);

                        if (distancia < 800) {
                            frecCardiaca = 63 + rand.nextInt(5);
                        } else if (distancia < 1500) {
                            frecCardiaca = 67 + rand.nextInt(10);
                        } else if (distancia < 2100) {
                            frecCardiaca = 75 + rand.nextInt(15);
                        } else if (distancia < 2700) {
                            frecCardiaca = 84 + rand.nextInt(10);
                        } else if (distancia < 3100) {
                            frecCardiaca = 92 + rand.nextInt(10);
                        } else if (distancia < 3600) {
                            frecCardiaca = 100 + rand.nextInt(15);
                        } else {
                            frecCardiaca = 120 + rand.nextInt(13);
                            if (velocidad > 25) {
                                frecCardiaca = 130 + rand.nextInt(12);
                            }
                        }
                        if (distancia < dist * 1000) {
                            medicion = new Medicion(distancia / 1000, i, frecCardiaca);
                            actividad.agregarMedicion(medicion);
                        }
                        
                        System.out.println("freccard: "+frecCardiaca );

                    }

                }
                medicion = new Medicion(dist, i, frecCardiaca);
                actividad.agregarMedicion(medicion);
                Garmin.usuario.agregarActividad(actividad);
                break;
            case "Caminata":
                break;
        }
        return actividad;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public ArrayList<Medicion> getMediciones() {
        return this.mediciones;
    }

    public void agregarMedicion(Medicion medicion) {
        mediciones.add(medicion);
    }

    public double getTiempoTotal() {

        return this.mediciones.get(this.mediciones.size() - 1).getTiempo();
    }

    public double getVelMax() {
        double velMax = 0;
        for (Medicion medicion : this.mediciones) {
            if ((medicion.getDistancia() / medicion.getTiempo()) > velMax) {
                velMax = medicion.getDistancia() / medicion.getTiempo();
            }
        }
        return velMax;
    }

    public String tiempoToString() {
        int horas;
        double minutos;
        horas = (int) Math.floor(this.getTiempoTotal() * 0.000277778);
        minutos = this.getTiempoTotal() * 0.000277778 % 1;

        if (horas == 0) {
            return (int) (minutos * 60) + "m";
        } else {
            return horas + "h  " + (int) (minutos * 60) + "m";
        }
    }

    public double getVelPromedio() {
        double velAcumulada = 0, tiempo, distancia;
        double tempTiempo = 0, tempDistancia = 0;

        for (Medicion medicion : this.mediciones) {
            tiempo = (medicion.getTiempo() - tempTiempo) / 3600;
            distancia = (medicion.getDistancia() - tempDistancia);
            if (distancia != 0) {
                velAcumulada += distancia / tiempo;
            }
            tempTiempo = medicion.getTiempo();
            tempDistancia = medicion.getDistancia();
        }
        return velAcumulada / this.mediciones.size();
    }

    public int getFrecPromedio() {
        double frecAcumulada = 0;
        for (Medicion medicion : this.mediciones) {
            frecAcumulada += medicion.getFrecCardiaca();
        }
        return (int) frecAcumulada / this.mediciones.size();
    }

    public List<Integer> getFrecuencias() {
        List<Integer> datos = new ArrayList<Integer>();
        for (Medicion medicion : this.mediciones) {
            datos.add((int) medicion.getFrecCardiaca());
        }
        return datos;
    }

    public List<Integer> getVelocidadesGrafica() {
        List<Integer> datos = new ArrayList<Integer>();
        double tempTiempo = 0, tempDistancia = 0;
        double velocidad;
        for (Medicion medicion : this.mediciones) {
            if (medicion.getDistancia() == 0) {
                datos.add(0);
            } else {
                double tiempo = (medicion.getTiempo() - tempTiempo) / 3600;
                double distancia = (medicion.getDistancia() - tempDistancia);
                velocidad = distancia / tiempo;
                datos.add((int) velocidad);
                tempTiempo = medicion.getTiempo();
                tempDistancia = medicion.getDistancia();
            }
        }
        return datos;
    }

    public double getFrecMax() {
        double frec = 0;
        for (Medicion medicion : this.mediciones) {
            if (medicion.getFrecCardiaca() > frec) {
                frec = medicion.getFrecCardiaca();
            }
        }
        return frec;
    }

    public double getDistanciaTotal() {
        return this.mediciones.get(this.mediciones.size() - 1).getDistancia();
    }

    public int getCalorias() {
        return 100;
    }
}
