/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

/**
 *
 * @author Pablo
 */
public class GUIActividades {
    
    private JPanel panel;
    
    public GUIActividades(){
        this.panel = new JPanel();
        this.panel.setBackground(Color.RED);
        this.panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        
        JPanel panelAgregar = new JPanel();
        panelAgregar.setLayout(new GridLayout(0,1));
        
        JLabel label0, label1, label2, label3, label4, label5;
        label0 = new JLabel("Agregar actividad");
        label1 = new JLabel("Tipo de actividad:");
        label2 = new JLabel("Fecha de inicio:");
        label3 = new JLabel("Fecha de fin:");
        label4 = new JLabel("Distancia recorrida");
        label5 = new JLabel("Km");
        String[] actividades = {"Correr","Nadar","Bicicleta","Caminata"};
        SpinnerListModel actividadesModel = new SpinnerListModel(actividades);
        JSpinner actividadesS = new JSpinner(actividadesModel);
        
        panelAgregar.add(label0);
        panelAgregar.add(label1);
        panelAgregar.add(actividadesS);
        panelAgregar.add(label2);
        panelAgregar.add(label3);
        panelAgregar.add(label4);
        
        this.panel.add(panelAgregar, gbc);
        
        JPanel panelActividades = new JPanel();
        panelActividades.setLayout(new GridLayout(0,2));
        
        gbc.gridx = 1;
        gbc.weightx = 1;
        
        //this.panel.add(panelActividades, gbc);
        
    }
    
    public JPanel refresh(){
        return this.panel;
    }
}
