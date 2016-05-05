/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

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

    public Actividad(String tipoActividad,Date fecha,Date horaInicio,Date horaFin)
    {
	this.tipoActividad = tipoActividad;
	this.fecha = fecha;
	this.horaInicio = horaInicio;
	this.horaFin = horaFin;
        //this.mediciones = new ArrayList<Medicion>();
    }
    
    public String getTipoActividad()
    {
	return tipoActividad;
    }
    public Date getFecha()
    {
	return fecha;
    }
    public Date getHoraInicio()
    {
	return horaInicio;
    }
    // public Medicion getMediciones()
    //{
    //	return mediciones;
    //}
    public void agregarMedicion(Medicion medicion)
    {
	mediciones.add(medicion);
    }
    public void imprime()
    {
	System.out.println("Actividad: "+tipoActividad+"\n"+fecha+horaInicio+"\n"+horaFin);
	for(Medicion medicion: mediciones)
	    System.out.println(medicion);
    }
}

