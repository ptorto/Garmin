/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class GUIResumen {
    private JPanel panel;
    
    
    public GUIResumen(){
        JPanel panelPerfil,panelActividad,panelGrafica;
        this.panel = new JPanel();
        this.panel.setBackground(new Color(37, 64, 113));
        
        this.panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        
        
        JPanel panelIm = new JPanel();
        JLabel LabelImagen = new JLabel();
        LabelImagen.setIcon(new ImageIcon("test/Ave.gif"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelIm.add(LabelImagen,gbc);
        this.panel.add(panelIm,gbc);
        
        panelPerfil = new JPanel();
        panelPerfil.setBackground(new Color(37, 64, 113));
        panelPerfil.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty=2;
        gbc.insets=new Insets(50,5,0,0);
        this.panel.add(panelPerfil,gbc);
        
        
        JLabel labelP = new JLabel("Nombre");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy=0;
        gbc.insets= new Insets(0,10,0,5);
        panelPerfil.add(labelP,gbc);
        
        JLabel labelPn = new JLabel(Garmin.usuario.getNombre());
        gbc.gridx=1;
        panelPerfil.add(labelPn,gbc);
       
        
        JLabel labelP1 = new JLabel("Apodo");
         gbc.gridy=2;
         gbc.gridx=0;
         
        panelPerfil.add(labelP1,gbc);
       
        JLabel labelP1n = new JLabel(Garmin.usuario.getApodo());
        gbc.gridx=1;
        
        panelPerfil.add(labelP1n,gbc);
        
        JLabel labelP2 = new JLabel("Peso");
        gbc.gridy=3;
        gbc.gridx=0;
        
        panelPerfil.add(labelP2,gbc);
      
        JLabel labelP2n = new JLabel(Garmin.usuario.getPeso()+" "+"Kg");
        gbc.gridx=1;
       
        panelPerfil.add(labelP2n,gbc);
        
        JLabel labelP3 = new JLabel("Estatura");
        gbc.gridy=4;
        gbc.gridx=0;
      
        panelPerfil.add(labelP3,gbc);
        
        JLabel labelP3n = new JLabel(Garmin.usuario.getAltura()+" "+"m");
        gbc.gridx=1;
        
        panelPerfil.add(labelP3n,gbc);
        
        
        panelGrafica= new JPanel();
        panelGrafica.setBackground(Color.GREEN);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.weightx = 1;
        this.panel.add(panelGrafica,gbc);
        
        panelActividad = new JPanel();
        panelActividad.setLayout(new GridBagLayout());
        panelActividad.setBackground(new Color(37, 64, 113));
        gbc.gridx=1;
        gbc.gridy=1;
        this.panel.add(panelActividad,gbc);
        
        JLabel labelA = new JLabel("Kilometros corridos");
        gbc.gridy=1;
        gbc.insets= new Insets(10,70,0,10);
        panelActividad.add(labelA,gbc);
        
        Estadisticas est = new Estadisticas();
        JLabel labelAn = new JLabel(est.getDistanciaCorrida()+"Km");
        gbc.gridy=1;
        gbc.gridx=2;
        gbc.insets= new Insets(10,40,0,0);
        panelActividad.add(labelAn,gbc);
           
        JLabel labelA1 = new JLabel("Kilometros nadados");
        gbc.gridy=2;
        gbc.gridx=1;
        gbc.insets= new Insets(10,70,0,10);
        panelActividad.add(labelA1,gbc);
        
        JLabel labelA1n = new JLabel(est.getDistanciaNadada()+"Km");
        gbc.gridy=2;
        gbc.gridx=2;
        gbc.insets= new Insets(10,40,0,0);
        panelActividad.add(labelA1n,gbc);
        
        
        JLabel labelA2 = new JLabel("Kilometros en bici");
        gbc.gridy=3;
        gbc.gridx=1;
        gbc.insets= new Insets(10,70,0,10);
        panelActividad.add(labelA2,gbc);
        
        JLabel labelA2n = new JLabel(est.getDistanciaBici()+"Km");
        gbc.gridy=3;
        gbc.gridx=2;
        gbc.insets= new Insets(10,40,0,0);
        panelActividad.add(labelA2n,gbc);
        
        JLabel labelA5 = new JLabel("Kilometros caminados");
        gbc.gridy=4;
        gbc.gridx=1;
        gbc.insets= new Insets(10,70,0,10);
        panelActividad.add(labelA2,gbc);
        
        JLabel labelA5n = new JLabel(est.getDistanciaBici()+"Km");
        gbc.gridy=4;
        gbc.gridx=2;
        gbc.insets= new Insets(10,40,0,0);
        panelActividad.add(labelA2n,gbc);
        
        JLabel labelA3 = new JLabel("Calorias quemadas"); 
        gbc.gridy=5;
        gbc.gridx=1;
        gbc.insets= new Insets(10,70,0,10);
       panelActividad.add(labelA3,gbc);
       
        JLabel labelA3n = new JLabel(Garmin.usuario.getAltura()+" "+"m"); 
        gbc.gridy=5;
        gbc.gridx=2;
        gbc.insets= new Insets(10,40,0,0);
       panelActividad.add(labelA3n,gbc);
        
        JLabel labelA4 = new JLabel("Dias de ejercicio");
        gbc.gridy=6;
        gbc.gridx=1;
        gbc.insets= new Insets(10,70,0,10);
        panelActividad.add(labelA4,gbc);
         
        JLabel labelA4n = new JLabel(est.getDiasEjercicio()+"Km");
        gbc.gridy=6;
        gbc.gridx=2;
        gbc.insets= new Insets(10,40,0,0);
        panelActividad.add(labelA4n,gbc);
       
      
        
        
        
        
    }
    
    public JPanel refresh(){
        return this.panel;
    }
    
}