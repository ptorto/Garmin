/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *
 * @author Pablo
 */
public class Garmin {

    /**
     * @param args the command line arguments
     */
    public static Usuario usuario;
    public static boolean sesionIniciada = false;

    public static void main(String[] args) {
        // TODO code application logic here
        Usuario usuario1 = new Usuario("Pablo", "Masculino", "Torto", "fufo", "pablotortoriello@gmail.com",
                1.87, 67.5, "20/08/1991");
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha =new Date();
        Actividad actividad = new Actividad("Correr", fecha);
        
        Actividad actividad2 = new Actividad("Nadar", new Date());
        Actividad actividad3 = new Actividad("Bici", new Date());
        Actividad actividad4 = new Actividad("Nadar", new Date());
        Actividad actividad5 = new Actividad("Caminata", new Date());
        
        actividad.agregarMedicion(new Medicion(0,0,124));
        actividad.agregarMedicion(new Medicion(1,360,128));
        actividad.agregarMedicion(new Medicion(2.2,800,130));
        actividad.agregarMedicion(new Medicion(4.4,1400,127));
        actividad.agregarMedicion(new Medicion(5.55,1600,124));
        actividad.agregarMedicion(new Medicion(6.7,2120,125));
        actividad.agregarMedicion(new Medicion(7.84,2500,125));
        actividad.agregarMedicion(new Medicion(8.99,2900,124));
        actividad.agregarMedicion(new Medicion(9.1,3214,128));
        actividad.agregarMedicion(new Medicion(10.3,3700,130));
        actividad.agregarMedicion(new Medicion(11.45,4012,127));
        actividad.agregarMedicion(new Medicion(12.67,4690,124));
        actividad.agregarMedicion(new Medicion(13.82,5015,125));
        actividad.agregarMedicion(new Medicion(14.95,5298,125));
        
        actividad2.agregarMedicion(new Medicion(0,0,124));
        actividad2.agregarMedicion(new Medicion(0.1,100,128));
        actividad2.agregarMedicion(new Medicion(0.2,220,130));
        actividad2.agregarMedicion(new Medicion(0.4,380,127));
        actividad2.agregarMedicion(new Medicion(0.55,490,124));
        actividad2.agregarMedicion(new Medicion(0.7,681,125));
        actividad2.agregarMedicion(new Medicion(0.84,812,125));
        
        actividad3.agregarMedicion(new Medicion(0,0,124));
        actividad3.agregarMedicion(new Medicion(0.1,100,128));
        actividad3.agregarMedicion(new Medicion(0.2,220,130));
        actividad3.agregarMedicion(new Medicion(0.4,380,127));
        actividad3.agregarMedicion(new Medicion(0.55,490,124));
        actividad3.agregarMedicion(new Medicion(0.7,681,125));
        actividad3.agregarMedicion(new Medicion(0.84,1900,125));
        
        actividad4.agregarMedicion(new Medicion(0,0,124));
        actividad4.agregarMedicion(new Medicion(0.1,100,128));
        actividad4.agregarMedicion(new Medicion(0.2,220,130));
        actividad4.agregarMedicion(new Medicion(0.4,380,127));
        actividad4.agregarMedicion(new Medicion(0.55,490,124));
        actividad4.agregarMedicion(new Medicion(0.7,681,125));
        actividad4.agregarMedicion(new Medicion(0.84,8632,125));
        
        actividad5.agregarMedicion(new Medicion(0,0,124));
        actividad5.agregarMedicion(new Medicion(0.1,100,128));
        actividad5.agregarMedicion(new Medicion(0.2,220,130));
        actividad5.agregarMedicion(new Medicion(0.4,380,127));
        actividad5.agregarMedicion(new Medicion(0.55,490,124));
        actividad5.agregarMedicion(new Medicion(0.7,681,125));
        actividad5.agregarMedicion(new Medicion(0.84,1231,125));
        System.out.println(actividad.tiempoToString());
        
        usuario1.agregarActividad(actividad);
        usuario1.agregarActividad(actividad2);
        usuario1.agregarActividad(actividad3);
        usuario1.agregarActividad(actividad4);
        usuario1.agregarActividad(actividad5);

        
        try {
            usuario1.guardar();
        } catch (Exception e) {
            System.out.println("No se pudo guardar");
        }

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
