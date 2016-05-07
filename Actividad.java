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

/**
 *
 * @author Pablo
 */
public class Actividad implements Serializable {

    private String tipoActividad;
    private Date fecha;
    private Date horaInicio;
    private Date horaFin;
    ArrayList<Medicion> mediciones;
    
    

    public Actividad(String tipoActividad, Date fecha, Date horaInicio, Date horaFin) {
        this.tipoActividad = tipoActividad;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.mediciones = new ArrayList<Medicion>();
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public ArrayList<Medicion> getMediciones() {
        return this.mediciones;
    }

    public void agregarMedicion(Medicion medicion) {
        mediciones.add(medicion);
    }
    
     public double getTiempoTotal() {


        return this.mediciones.get(this.mediciones.size()-1).getTiempo();
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
    
    public String tiempoToString(){
        int horas; 
        double minutos;
        horas = (int) Math.floor(this.getTiempoTotal()*0.000277778);
        minutos = this.getTiempoTotal()*0.000277778 % 1;
        
        if(horas == 0){
            return (int)(minutos*60) + "m";
        }
        else
            return horas+"h  "+(int)(minutos * 60) +"m";
    }
    
    public double getVelPromedio() {
        double velAcumulada = 0;
        for (Medicion medicion : this.mediciones) {
            velAcumulada += medicion.getDistancia() / medicion.getTiempo();
        }
        return velAcumulada / this.mediciones.size();
    }

    public int getFrecPromedio() {
        double frecAcumulada = 0;
        for (Medicion medicion : this.mediciones) {
            frecAcumulada += medicion.getFrecCardiaca();
        }
        return (int)frecAcumulada / this.mediciones.size();
    }
    
    public List<Integer> getFrecuencias() {
        List<Integer> datos = new ArrayList<Integer>();
        for (Medicion medicion : this.mediciones){
            datos.add((int)medicion.getFrecCardiaca());
        }
        return datos;
    }
    
    public List<Integer> getVelocidades() {
        List<Integer> datos = new ArrayList<Integer>();
        for (Medicion medicion : this.mediciones){
            datos.add((int)(( medicion.getDistancia()*1000 / medicion.getTiempo() )*3.6));
            System.out.println("vel: " + (int)( medicion.getDistancia()*1000 / medicion.getTiempo() )*3.6);
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
        return this.mediciones.get(this.mediciones.size()-1).getDistancia();
    }
    
    public int getCalorias(){
        return 100;
    }

    public void imprime() {
        System.out.println("Actividad: " + tipoActividad + "\n" + fecha + horaInicio + "\n" + horaFin);
        for (Medicion medicion : this.mediciones) {
            System.out.println(medicion);
        }
    }
}
