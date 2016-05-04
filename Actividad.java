/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.io.*;

/**
 *
 * @author Pablo
 */
public class Actividad implements Serializable{
    private final String actividad;
    private final double duracion, distancia, calorias, frecCardiaca;
    
    
    public Actividad(String actividad, double duracion, double distancia, double calorias, double frecCardiaca){
        this.actividad = actividad;
        this.duracion = duracion;
        this.distancia = distancia;
        this.calorias = calorias;
        this.frecCardiaca = frecCardiaca;
    }
    
    public String getActividad(){
        return this.actividad;
    }
    public double getDistancia(){
        return this.distancia;
    }
}
