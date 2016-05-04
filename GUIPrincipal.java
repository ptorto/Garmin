/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JPanel;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Pablo
 */
public class GUIPrincipal {

    private JFrame frame;
    private JPanel panelPrincipal, panelInfo;
    private Usuario usuario;

    public GUIPrincipal() {
        this.frame = new JFrame("Garmin");
        this.frame.setSize(500, 500);
        this.frame.getContentPane().setBackground(new Color(37, 64, 113));
        this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.frame.setLayout(new BorderLayout());

        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(new Color(37, 64, 113));
        panelPrincipal.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        //gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        gbc.ipady = 100;

        Dimension size = new Dimension(220, 50);
        JButton botonInicioSesion = new JButton("Iniciar Sesion");
        botonInicioSesion.setMinimumSize(size);
        botonInicioSesion.setPreferredSize(size);
        botonInicioSesion.addActionListener(new IniciarSesionListener());
        JButton botonActividades = new JButton("Actividades");
        botonActividades.setMinimumSize(size);
        botonActividades.setPreferredSize(size);
        botonActividades.addActionListener(new ActividadesListener());
        JButton botonLogros = new JButton("Logros");
        botonLogros.setMinimumSize(size);
        botonLogros.setPreferredSize(size);
        JButton botonResumen = new JButton("Resumen");
        botonResumen.setMinimumSize(size);
        botonResumen.setPreferredSize(size);
        botonResumen.addActionListener(new ResumenListener());

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(37, 64, 113));
        panelMenu.setLayout(new GridLayout(0, 1));
        panelMenu.add(botonInicioSesion);
        panelMenu.add(botonResumen);
        panelMenu.add(botonActividades);
        panelMenu.add(botonLogros);
        
        size = new Dimension(500,600);
        this.panelPrincipal.setMinimumSize(size);
        this.panelPrincipal.setPreferredSize(size);

        this.panelPrincipal.add(panelMenu, gbc);

        panelInfo = new JPanel();
        panelInfo.setBackground(Color.RED);
        gbc.gridx = 1;
        gbc.weightx = 1;

        this.panelPrincipal.add(panelInfo, gbc);
        this.frame.add(panelPrincipal);
        this.frame.setVisible(true);

        botonInicioSesion.doClick();
    }
    
    

    class IniciarSesionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GridBagLayout layout = (GridBagLayout) panelPrincipal.getLayout();
            GridBagConstraints gbc = layout.getConstraints(panelPrincipal.getComponent(1));
            panelPrincipal.remove(panelPrincipal.getComponent(1));
            GUIInicioSesion is = new GUIInicioSesion();
            panelPrincipal.add(is.refresh(), gbc);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        }
    }

    class ResumenListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GridBagLayout layout = (GridBagLayout) panelPrincipal.getLayout();
            GridBagConstraints gbc = layout.getConstraints(panelPrincipal.getComponent(1));
            panelPrincipal.remove(panelPrincipal.getComponent(1));
            GUIResumen res = new GUIResumen();
            panelPrincipal.add(res.refresh(), gbc);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        }

    }
    
    class ActividadesListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            GridBagLayout layout = (GridBagLayout) panelPrincipal.getLayout();
            GridBagConstraints gbc = layout.getConstraints(panelPrincipal.getComponent(1));
            panelPrincipal.remove(panelPrincipal.getComponent(1));
            System.out.println("por aca");
            GUIActividades res = new GUIActividades();
            panelPrincipal.add(res.refresh(), gbc);
            panelPrincipal.revalidate();
            panelPrincipal.repaint();
        }
    }
}
