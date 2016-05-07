/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Pablo
 */
public class GUIActividades {

    private JPanel panel;
    JPanel[] paneles;

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
        panelActividades.setLayout(new GridLayout(0, 2));

        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE;
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
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 50, 50, 50);
        panelAgregar.add(label0, gbc);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 50, 10, 50);
        panelAgregar.add(label1, gbc);
        gbc.gridy = 2;
        panelAgregar.add(actividadesS, gbc);
        gbc.gridy = 3;
        panelAgregar.add(label2, gbc);
        gbc.gridy = 4;
        panelAgregar.add(fechaInicioS, gbc);
        gbc.gridy = 5;
        panelAgregar.add(label3, gbc);
        gbc.gridy = 6;
        panelAgregar.add(fechaFinS, gbc);
        gbc.gridy = 7;
        panelAgregar.add(label4, gbc);
        gbc.gridy = 8;
        gbc.insets = new Insets(0, 50, 10, 0);
        panelAgregar.add(distanciaTF, gbc);
        gbc.gridx = 2;
        gbc.insets = new Insets(0, 5, 10, 10);
        panelAgregar.add(label5, gbc);
        gbc.gridy = 9;
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 50, 20, 50);
        panelAgregar.add(agregarB, gbc);

        this.paneles = new JPanel[4];
        JLabel fechaActividad[] = new JLabel[4];
        JLabel tipoActividad[] = new JLabel[4];
        JLabel tiempoTotal[] = new JLabel[4];
        JLabel distancia[] = new JLabel[4];
        JLabel calorias[] = new JLabel[4];
        JLabel frecuencia[] = new JLabel[4];

        ArrayList<Actividad> actividades = Garmin.usuario.getActividades();
        GridBagConstraints gbc2;
        gbc2 = new GridBagConstraints();
        gbc2.fill = GridBagConstraints.NONE;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < 4; i++) {
            if (i < actividades.size()) {
                this.paneles[i] = new JPanel();
                this.paneles[i].setLayout(new GridBagLayout());
                this.paneles[i].setBorder(BorderFactory.createLineBorder(new Color(37, 64, 113), 10));
                this.paneles[i].addMouseListener(new PanelActividadListener());
                this.paneles[i].setName("panel" + i);

                fechaActividad[i] = new JLabel(df.format(actividades.get(i).getFecha()));

                tipoActividad[i] = new JLabel(actividades.get(i).getTipoActividad());
                tiempoTotal[i] = new JLabel("Tiempo total: " + actividades.get(i).tiempoToString());
                distancia[i] = new JLabel("Distancia total: " + String.valueOf(actividades.get(i).getDistanciaTotal()) + " Km");
                calorias[i] = new JLabel("Calorias quemandas: " + actividades.get(i).getCalorias());
                frecuencia[i] = new JLabel("Frec cardiaca prom: " + actividades.get(i).getFrecPromedio());

                gbc2.gridy = 0;
                gbc2.insets = new Insets(20, 30, 10, 30);
                paneles[i].add(fechaActividad[i], gbc2);
                gbc2.insets = new Insets(10, 30, 0, 30);
                gbc2.gridy = 1;
                paneles[i].add(tipoActividad[i], gbc2);
                gbc2.gridy = 2;
                paneles[i].add(tiempoTotal[i], gbc2);
                gbc2.gridy = 3;
                paneles[i].add(distancia[i], gbc2);
                gbc2.gridy = 4;
                paneles[i].add(calorias[i], gbc2);
                gbc2.gridy = 5;
                gbc2.insets = new Insets(10, 30, 20, 30);
                paneles[i].add(frecuencia[i], gbc2);
                panelActividades.add(paneles[i]);
            }
        }

    }

    class PanelActividadListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            Component panel = (Component) e.getSource();
            String name = panel.getName();
            ArrayList<Actividad> actividades = Garmin.usuario.getActividades();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            if (name.equals("panel0")) {
                JDialog dialog = new JDialog();
                dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                dialog.setSize(900, 650);
                dialog.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 0.2;
                gbc.weighty = 1;
                gbc.gridwidth = 1;
                JPanel panelInfo, panelGraf;
                panelInfo = new JPanel();
                panelInfo.setBackground(Color.red);
                dialog.add(panelInfo, gbc);

                panelGraf = new JPanel();
                panelGraf.setBackground(Color.green);
                panelGraf.setLayout(new GridBagLayout());
                gbc.gridx = 1;
                gbc.weightx = 1;
                dialog.add(panelGraf,gbc);
                dialog.setTitle("Actividad " + df.format(actividades.get(0).getFecha()));

             /*   List<Integer> datos = new ArrayList<Integer>();
                datos.add(5);
                datos.add(13);
                datos.add(7);
                datos.add(11);
                datos.add(10);
                datos.add(2);
                datos.add(4);
                datos.add(5);
                datos.add(5);
                datos.add(5);
                datos.add(13);
                datos.add(21);
                datos.add(11);
                datos.add(13);
                datos.add(2);
                datos.add(4);
                datos.add(16);
                datos.add(14);*/
                gbc.fill = GridBagConstraints.NONE;
                gbc.gridx = 0;
                gbc.gridy = 0;
                panelGraf.add(new DrawGraph(actividades.get(0).getFrecuencias()),gbc);
                gbc.gridy = 1;
                panelGraf.add(new DrawGraph(actividades.get(0).getVelocidades()),gbc);
                dialog.setVisible(true);
            }
            if (name.equals("panel1")) {

            }
            if (name.equals("panel2")) {

            }
            if (name.equals("panel3")) {

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    public JPanel refresh() {
        return this.panel;
    }
}
