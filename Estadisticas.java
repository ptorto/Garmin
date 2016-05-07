/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.util.ArrayList;

/**
 *
 * @author fernandacayon
 */
public class Estadisticas {
    
    public double getDistanciaCorrida(){
      
        double distancia = 0;
         double tipoActividad;
         ArrayList<Actividad> actividades;
         actividades=Garmin.usuario.getActividades();
         ArrayList<Medicion> mediciones;
         
         for (Actividad i : actividades){
             mediciones=i.getMediciones();
            
             if(i.getTipoActividad().equals("Correr")){
                 distancia+=i.getDistanciaTotal();
             }
         }
      
        return distancia;
    }
    
    public double getDistanciaNadada(){
      
        double distancia = 0;
         double tipoActividad;
         ArrayList<Actividad> actividades;
         actividades=Garmin.usuario.getActividades();
         ArrayList<Medicion> mediciones;
         
         for (Actividad i : actividades){
             mediciones=i.getMediciones();
            
             if(i.getTipoActividad().equals("Nadar")){
                 distancia+=i.getDistanciaTotal();
             }
         }
      
        return distancia;
    }
    
    public double getDistanciaBici(){
      
        double distancia = 0;
         double tipoActividad;
         ArrayList<Actividad> actividades;
         actividades=Garmin.usuario.getActividades();
         ArrayList<Medicion> mediciones;
         
         for (Actividad i : actividades){
             mediciones=i.getMediciones();
            
             if(i.getTipoActividad().equals("Bici")){
                 distancia+=i.getDistanciaTotal();
             }
         }
      
        return distancia;
    }
    
    public double getDiasEjercicio(){
      
         ArrayList<Actividad> actividades;
         actividades=Garmin.usuario.getActividades();
         
         
        return actividades.size();
    }
}