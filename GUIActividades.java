/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
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
    private JTextField distanciaTF;
    private JSpinner actividadesS, fechaInicioS, fechaFinS;

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
        distanciaTF = new JTextField("10");
        String[] tipoActividades = {"Correr", "Nadar", "Bicicleta", "Caminata"};
        SpinnerListModel actividadesModel = new SpinnerListModel(tipoActividades);
        actividadesS = new JSpinner(actividadesModel);

        fechaInicioS = new JSpinner(new SpinnerDateModel());
        fechaFinS = new JSpinner(new SpinnerDateModel());

        JButton agregarB = new JButton("Agregar");
        agregarB.addActionListener(new AgregarActionListener());

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

        JPanel[] paneles = new JPanel[4];
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

        /*
        ordenar actividades por fecha para sacar las ultimas 4
         */
        
        Actividad act;
        ArrayList<Actividad> actMostradas = new ArrayList<Actividad>();
        
        HashMap<Actividad, Date> hmap = new HashMap<Actividad, Date>();
        for(int i = 0; i < actividades.size();i++){
            hmap.put(actividades.get(i), actividades.get(i).getFecha());
        }
        
        Set set = hmap.entrySet();
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            Map.Entry elem = (Map.Entry)iter.next();
            elem.getValue();
        }
        
        
        /*
        for (int j = 0, elim = 10; j < 4; j++) {
            for (int i = 1; i < actTemp.size(); i++) {
                if (actTemp.get(i).getFecha().getTime() < act.getFecha().getTime()) {
                    act = actTemp.get(i);
                    elim = i;
                }
            }
            if (elim != 10) {
                actTemp.remove(elim);
            }
            actMostradas.add(act);
        }
*//*
        for (int i = 0; i < 4; i++) {
            paneles[i] = new JPanel();
            paneles[i].setLayout(new GridBagLayout());
            paneles[i].setBorder(BorderFactory.createLineBorder(new Color(37, 64, 113), 10));
            paneles[i].addMouseListener(new PanelActividadListener());
            paneles[i].setName("panel" + i);

            fechaActividad[i] = new JLabel(df.format(actMostradas.get(i).getFecha()));

            tipoActividad[i] = new JLabel(actMostradas.get(i).getTipoActividad());
            tiempoTotal[i] = new JLabel("Tiempo total: " + actMostradas.get(i).tiempoToString());
            distancia[i] = new JLabel("Distancia total: " + String.valueOf(actMostradas.get(i).getDistanciaTotal()) + " Km");
            calorias[i] = new JLabel("Calorias quemandas: " + actMostradas.get(i).getCalorias());
            frecuencia[i] = new JLabel("Frec cardiaca prom: " + actMostradas.get(i).getFrecPromedio());

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
*/
    }

    class PanelActividadListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            Component panel = (Component) e.getSource();
            String name = panel.getName();
            ArrayList<Actividad> actividades = Garmin.usuario.getActividades();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Actividad actividad;
            int numActividad;
            if (name.equals("panel0")) {
                numActividad = 0;
            } else if (name.equals("panel1")) {
                numActividad = 1;
            } else if (name.equals("panel2")) {
                numActividad = 2;
            } else {
                numActividad = 3;
            }

            actividad = actividades.get(numActividad);

            JDialog dialog = new JDialog();
            dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            dialog.setSize(900, 650);
            dialog.setTitle("Actividad " + df.format(actividad.getFecha()));

            JPanel panelDialog = new JPanel();
            panelDialog.setLayout(new GridBagLayout());
            panelDialog.setBackground(new Color(37, 64, 113));

            dialog.add(panelDialog);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 0.4;
            gbc.weighty = 1;
            gbc.gridwidth = 1;

            JPanel panelInfo, panelGraf;
            panelInfo = new JPanel();
            panelInfo.setLayout(new GridBagLayout());
            panelDialog.add(panelInfo, gbc);

            panelGraf = new JPanel();
            panelGraf.setLayout(new GridBagLayout());
            panelGraf.setBackground(new Color(37, 64, 113));
            gbc.gridx = 1;
            gbc.weightx = 1;
            panelDialog.add(panelGraf, gbc);

            JLabel label0, label1, label2, label3, label4, label5, label6;
            label0 = new JLabel(actividad.getTipoActividad());
            label1 = new JLabel("Fecha de actividad: " + df.format(actividad.getFecha()));
            label2 = new JLabel("Tiempo de actividad: " + actividad.tiempoToString());
            label3 = new JLabel("Velocidad promedio: " + new DecimalFormat("#.##").format(actividad.getVelPromedio()) + " Km/hr");
            label4 = new JLabel("Frec cardiaca promedio: " + actividad.getFrecPromedio() + " lpm");
            label5 = new JLabel("Frec cardiaca max: " + actividad.getFrecMax() + " lpm");
            label6 = new JLabel("Calorias quemadas: " + actividad.getCalorias() + " Kcal");

            gbc.gridy = 0;
            gbc.insets = new Insets(20, 30, 10, 30);
            panelInfo.add(label0, gbc);
            gbc.insets = new Insets(10, 30, 0, 30);
            gbc.gridy = 1;
            panelInfo.add(label1, gbc);
            gbc.gridy = 2;
            panelInfo.add(label2, gbc);
            gbc.gridy = 3;
            panelInfo.add(label3, gbc);
            gbc.gridy = 4;
            panelInfo.add(label4, gbc);
            gbc.gridy = 5;
            panelInfo.add(label5, gbc);
            gbc.gridy = 6;
            gbc.insets = new Insets(10, 30, 20, 30);
            panelInfo.add(label6, gbc);

            gbc.fill = GridBagConstraints.NONE;
            gbc.insets = new Insets(5, 5, 0, 5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            panelGraf.add(new JLabel("Velocidad vs Tiempo"), gbc);
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 5, 0, 5);
            JPanel graficaVelTiempo = new DrawGraph(actividad.getVelocidadesGrafica());
            graficaVelTiempo.setBorder(BorderFactory.createLineBorder(new Color(37, 64, 113), 10));

            panelGraf.add(graficaVelTiempo, gbc);

            gbc.gridy = 2;
            gbc.insets = new Insets(5, 5, 0, 5);
            panelGraf.add(new JLabel("Frecuencia cardiaca vs Tiempo"), gbc);
            gbc.gridy = 3;
            gbc.insets = new Insets(0, 5, 0, 5);
            JPanel graficaFrecTiempo = new DrawGraph(actividad.getFrecuencias());
            graficaFrecTiempo.setBorder(BorderFactory.createLineBorder(new Color(37, 64, 113), 10));
            panelGraf.add(graficaFrecTiempo, gbc);

            gbc.gridy = 4;
            gbc.insets = new Insets(5, 5, 0, 5);
            panelGraf.add(new JLabel("Frecuencia cardiaca vs Tiempo"), gbc);
            gbc.gridy = 5;
            gbc.insets = new Insets(0, 5, 0, 5);
            JPanel graficaFrecTiempo2 = new DrawGraph(actividad.getVelocidadesGrafica());
            graficaFrecTiempo2.setBorder(BorderFactory.createLineBorder(new Color(37, 64, 113), 10));
            panelGraf.add(graficaFrecTiempo2, gbc);

            dialog.setVisible(true);
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

    class AgregarActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String tipoActividad = (String) actividadesS.getValue();
            Date fechaInicio = (Date) fechaInicioS.getValue();
            Date fechaFin = (Date) fechaFinS.getValue();
            double distancia = Double.parseDouble(distanciaTF.getText());
            System.out.println(distancia);
        }
    }

    public JPanel refresh() {
        return this.panel;
    }
}
