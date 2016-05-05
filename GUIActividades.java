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
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;

/**
 *
 * @author Pablo
 */
public class GUIActividades {

    private JPanel panel;

    public GUIActividades() {
        this.panel = new JPanel();
        this.panel.setBackground(new Color(37, 64, 113));
        this.panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;

        JPanel panelAgregar = new JPanel();
        panelAgregar.setLayout(new GridBagLayout());
        
        this.panel.add(panelAgregar, gbc);
        
        JPanel panelActividades = new JPanel();
        panelActividades.setLayout(new GridBagLayout());
        
        gbc.gridx = 1;
        gbc.weightx = 1;

        this.panel.add(panelActividades, gbc);

        JLabel label0, label1, label2, label3, label4, label5;
        label0 = new JLabel("AGREGAR ACTIVIDAD");
        label1 = new JLabel("Tipo de actividad:");
        label2 = new JLabel("Fecha de inicio:");
        label3 = new JLabel("Fecha de fin:");
        label4 = new JLabel("Distancia recorrida");
        label5 = new JLabel("Km");
        JTextField distanciaTF = new JTextField("10");
        String[] tipoActividades = {"Correr", "Nadar", "Bicicleta", "Caminata"};
        SpinnerListModel actividadesModel = new SpinnerListModel(tipoActividades);
        JSpinner actividadesS = new JSpinner(actividadesModel);

        JSpinner fechaInicioS = new JSpinner(new SpinnerDateModel());
        JSpinner fechaFinS = new JSpinner(new SpinnerDateModel());
        
        JButton agregarB = new JButton("Agregar");

        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.insets = new Insets(20, 50, 50, 50);
        panelAgregar.add(label0,gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 50, 10, 50);
        panelAgregar.add(label1,gbc);
        gbc.gridy = 2;
        panelAgregar.add(actividadesS,gbc);
        gbc.gridy = 3;
        panelAgregar.add(label2,gbc);
        gbc.gridy = 4;
        panelAgregar.add(fechaInicioS,gbc);
        gbc.gridy = 5;
        panelAgregar.add(label3,gbc);
        gbc.gridy = 6;
        panelAgregar.add(fechaFinS,gbc);
        gbc.gridy = 7;
        panelAgregar.add(label4,gbc);
        gbc.gridy = 8;
        gbc.insets = new Insets(0, 50, 10, 0);
        panelAgregar.add(distanciaTF, gbc);
        gbc.gridx = 2;
        gbc.insets = new Insets(0, 5, 10, 10);
        panelAgregar.add(label5,gbc);
        gbc.gridy = 9;
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 50, 20, 50);
        panelAgregar.add(agregarB, gbc);
        

        

        

        JPanel[] paneles = new JPanel[4];
        JLabel fechaActividad[] = new JLabel[4];
        JLabel tipoActividad[] = new JLabel[4];
        ArrayList<Actividad> actividades = Garmin.usuario.getActividades();
        for (int i = 0; i < 4 ; i++) {
            if(i < actividades.size()) {
                fechaActividad[i]= new JLabel(actividades.get(i).getFecha().toString());
                paneles[i] = new JPanel();
                paneles[i].setLayout(new GridLayout(0,1));
                tipoActividad[i] = new JLabel(actividades.get(i).getTipoActividad());
                paneles[i].add(fechaActividad[i]);
                paneles[i].add(tipoActividad[i]);
                panelActividades.add(paneles[i]);
                
            }
        }

    }

    public JPanel refresh() {
        return this.panel;
    }
}
