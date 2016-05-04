/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class Usuario implements Serializable {

    private String nombre, sexo, apodo, contrasena, email;
    private double altura, peso;
    private int edad;
    private Date fechaAlta;
    private Date fechaNacimiento;
    private ArrayList<Actividad> actividades = null;
    private ArrayList<Meta> metas = null;

    public Usuario(){
        this.fechaAlta = new Date();
    }
    
    public Usuario(String nombre, String sexo, String apodo, String contrasena, String email,
            double altura, double peso, String fechaNacimiento) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.apodo = apodo;
        this.contrasena = contrasena;
        this.email = email;
        this.altura = altura;
        this.peso = peso;
        this.fechaAlta = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        try {
            this.fechaNacimiento = sdf.parse(fechaNacimiento);
        } catch (ParseException ex) {
            System.out.println("Error al guardar fecha de nacimiento");
        }
        if (this.fechaAlta.getMonth() > this.fechaNacimiento.getMonth()) {
            this.edad = this.fechaAlta.getYear() - this.fechaNacimiento.getYear();
        } else {
            this.edad = this.fechaAlta.getYear() - this.fechaNacimiento.getYear() - 1;
        }
        this.actividades = new ArrayList<Actividad>();
        this.metas = new ArrayList<Meta>();
    }
    
   
    /**
     * Guarda toda la informacion del usuario
     *
     * @throws FileNotFoundException No se pudo crear el archivo
     */
    public void guardar() throws FileNotFoundException {
        FileOutputStream fout = new FileOutputStream("test/user_"+this.nombre+".dat");
        try (ObjectOutputStream output = new ObjectOutputStream(fout)) {
            output.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error fout");
        }
    }

    /**
     * Carga la información de un usuario dado
     * @param usuario nombre del usuario que se quiere cargar
     * @return regresa el usuario cargado
     * @throws FileNotFoundException no se encontro el archivo para cargar
     */
    public static Usuario load(String usuario) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream("test/user_"+usuario+".dat");
        try (ObjectInputStream input = new ObjectInputStream(fis)) {
            return (Usuario) input.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al cargar usuario");
        }
        return null;
    }
    
     /**
     * Agrega una nueva actividad al usuario
     *
     * @param actividad Actividad que se va a agregar
     */
    public void agregarActividad(Actividad actividad) {
        this.actividades.add(actividad);

    }

    /**
     * Agrega una nueva meta al usuario
     *
     * @param meta
     */
    public void agregarMeta(Meta meta) {
        this.metas.add(meta);
    }

    /**
     * Regresa la lista de actividades registradas para el usuario
     *
     * @return ArrayList con todas las actividades del usuario
     */
    public ArrayList<Actividad> getActividades() {
        return this.actividades;
    }

    /**
     * Regresa la lista de metas registradas para el usuario
     *
     * @return ArrayList con todas las metas del usuario
     */
    public ArrayList<Meta> getMetas() {
        return this.metas;
    }

    /**
     * Hacer un cambio de nombre para el usuario
     *
     * @param nombre Nuevo nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Hacer un cambio de sexo para el usuario
     *
     * @param sexo Nuevo sexo del usuario
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Hacer un cambio de contraseña para el usuario
     *
     * @param contrasena Nueva contraseña del usuario
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Hacer un cambio del email del usuario
     *
     * @param email Nuevo email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Hacer un cambio del apodo del usuario
     *
     * @param apodo Nuevo apodo del usuario
     */
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    /**
     * Hacer un cambio en la altura del usuario
     *
     * @param altura Nueva altura del usuario en mts
     */
    public void setAltura(Double altura) {
        this.altura = altura;
    }

    /**
     * Hacer un cambio del peso del usuario
     *
     * @param peso Nuevo peso del usuario en Kg
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * Hacer un cambio de la fecha de nacimiento del usuario
     *
     * @param fecha Nueva fecha de nacimiento
     */
    public void setFechaNacimiento(Date fecha) {
        this.fechaNacimiento = fecha;
    }

    /**
     * Obtener el nombre del usuario
     *
     * @return nombre del usuario
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtener el sexo del usuario
     *
     * @return sexo del usuario
     */
    public String getSexo() {
        return this.sexo;
    }

    /**
     * Obtener el aposo del usuario
     *
     * @return apodo del usuario
     */
    public String getApodo() {
        return this.apodo;
    }

    /**
     * Obtener la contraseña del usuario
     *
     * @return contraseña del usuario
     */
    public String getContrasena() {
        return this.contrasena;
    }

    /**
     * Obtener el email del usuario
     *
     * @return email del usuario
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Obtener la altura del usuario
     *
     * @return altura del usuario
     */
    public double getAltura() {
        return this.altura;
    }

    /**
     * Obtener el peso del usuario
     *
     * @return peso del usuario
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Obtener la fecha de alta del usuario
     *
     * @return fecha de alta del usuario
     */
    public Date getFechaAlta() {
        return this.fechaAlta;
    }

    /**
     * OBtener la fecha de nacimiento del usuario
     *
     * @return fecha de nacimiento del usuario
     */
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

}
