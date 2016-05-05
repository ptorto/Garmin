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
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;

/**
 *
 * @author Pablo
 */
public class GUIActividades {

    private JPanel panel;

    public GUIActividades() {
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
        panelAgregar.setLayout(new GridLayout(0, 1));

        JLabel label0, label1, label2, label3, label4, label5;
        label0 = new JLabel("Agregar actividad");
        label1 = new JLabel("Tipo de actividad:");
        label2 = new JLabel("Fecha de inicio:");
        label3 = new JLabel("Fecha de fin:");
        label4 = new JLabel("Distancia recorrida");
        label5 = new JLabel("Km");
        String[] tipoActividades = {"Correr", "Nadar", "Bicicleta", "Caminata"};
        SpinnerListModel actividadesModel = new SpinnerListModel(tipoActividades);
        JSpinner actividadesS = new JSpinner(actividadesModel);

        JSpinner fechaInicioS = new JSpinner(new SpinnerDateModel());

        panelAgregar.add(label0);
        panelAgregar.add(label1);
        panelAgregar.add(actividadesS);
        panelAgregar.add(label2);
        panelAgregar.add(label3);
        panelAgregar.add(label4);

        this.panel.add(panelAgregar, gbc);

        JPanel panelActividades = new JPanel();
        panelActividades.setLayout(new GridLayout(0, 2));

        gbc.gridx = 1;
        gbc.weightx = 1;

        this.panel.add(panelActividades, gbc);

        JPanel[] paneles = new JPanel[4];
        JLabel[] fechaActividad = new JLabel[4];
        JLabel[] tipoActividad = new JLabel[4];
        ArrayList<Actividad> actividades = Garmin.usuario.getActividades();
        for (int i = 0; i < 4; i++) {
            if (actividades.get(i) != null) {
                fechaActividad[i].setText(actividades.get(i).getFecha().toString());
                paneles[i].add(fechaActividad[i]);
                panelActividades.add(paneles[i]);
            }
        }

    }

    public JPanel refresh() {
        return this.panel;
    }
}
