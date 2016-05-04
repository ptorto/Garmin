/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Pablo
 */
public class Garmin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, ParseException {
        // TODO code application logic here
        Usuario usuario1 = new Usuario("Pablo", "Masculino", "Torto", "fufo", "pablotortoriello@gmail.com",
                1.87, 67.5, "20/08/1991");
        Actividad actividad = new Actividad("correr", 3600, 1000, 253, 123);
        Actividad actividad2 = new Actividad("nadar", 7200, 2500, 541, 176);
        usuario1.agregarActividad(actividad);
        usuario1.agregarActividad(actividad2);

        usuario1.guardar();
        
        
        GUIPrincipal gui = new GUIPrincipal();
        
        
        /*
        ArrayList<String> arreglo = new ArrayList<String>();

        Usuario usuario1 = new Usuario("Pablo", "Masculino", "Torto", "fufo", "pablotortoriello@gmail.com",
                1.87, 67.5, "20/08/1991");
        Actividad actividad = new Actividad("correr", 3600, 1000, 253, 123);
        Actividad actividad2 = new Actividad("nadar", 7200, 2500, 541, 176);
        usuario1.agregarActividad(actividad);
        usuario1.agregarActividad(actividad2);

        usuario1.guardar();

        Usuario usuarioRecuperado = new Usuario();
        usuarioRecuperado = usuarioRecuperado.load("Pablo");

        System.out.printf("Usuario: %s, Sexo: %s\n", usuarioRecuperado.getNombre(), usuarioRecuperado.getSexo());

        ArrayList<Actividad> actividades = usuarioRecuperado.getActividades();
        Actividad act;
        for (int i = 0; i < actividades.size(); i++) {
            act = actividades.get(i);
            System.out.println(act.getActividad());
        }
        
         /*
        try {
            FileInputStream fis = new FileInputStream("test/user_"+usuario+".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            this = (Usuario) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("No se puede cargar el usuario");
        } catch (IOException ex) {
            System.out.println("No se puede cargar el usuario");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        Actividad actividad = new Actividad("Natacion", 25, 10, 132, 120);
        Actividad actividad2 = new Actividad("Correr", 25, 15, 132, 120);
        Usuario user = new Usuario("Pablo", "Masculino", "Torto", "fufo", "pablo@gmail.com", 1.88, 67);

        user.agregarActividad(actividad);
        user.agregarActividad(actividad2);

        user.guardar();

        FileInputStream fin = new FileInputStream(new File("test/usuario1.txt"));
        ObjectInputStream input = new ObjectInputStream(fin);
        Usuario usuario = (Usuario) input.readObject();
        input.close();

        System.out.println("Usuario: " + usuario.getNombre());
        
        ArrayList<Actividad> actividades = usuario.getActividades();
        
        Object[] arreglo =actividades.toArray();
        Actividad act;
        for (Object i : arreglo){
            act = (Actividad) i;
            System.out.println(act.getDistancia());
        }
                 */
    }
}
