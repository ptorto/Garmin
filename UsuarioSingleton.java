/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

/**
 *
 * @author Pablo
 */
public class UsuarioSingleton {

    public static Usuario usuario = null;

    public UsuarioSingleton(Usuario usuario) {
        if (UsuarioSingleton.usuario == null){
            UsuarioSingleton.usuario = usuario;
        }
    }
    
    public static void setUsuario(Usuario usuario){
        UsuarioSingleton.usuario = usuario;
    }
    
    public static Usuario getUsuario(){
        return UsuarioSingleton.usuario;
    }
}