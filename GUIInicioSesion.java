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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Pablo
 */
public class GUIInicioSesion {

    private JPanel panel, panelSesionIniciada;
    private JTextField usuarioTF, passwordTF;

    public GUIInicioSesion() {

        this.panel = new JPanel();
        this.panel.setBackground(new Color(37, 64, 113));
        this.panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        if (!Garmin.sesionIniciada) {
            JPanel panelInicioSesion = new JPanel();
            panelInicioSesion.setLayout(new GridBagLayout());
            this.panel.add(panelInicioSesion, gbc);

            JLabel usuarioL, passwordL;
            usuarioL = new JLabel("Usuario:");
            passwordL = new JLabel("Contraseña:");
            this.usuarioTF = new JTextField();
            this.passwordTF = new JTextField();
            JButton iniciaSesionB = new JButton("Iniciar Sesion");
            iniciaSesionB.addActionListener(new IniciaSesionListener());
            JButton crearCuentaB = new JButton("Crear Cuenta");

            gbc.gridy = 0;
            gbc.insets = new Insets(50, 100, 0, 100);
            panelInicioSesion.add(usuarioL, gbc);
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 100, 10, 100);
            panelInicioSesion.add(usuarioTF, gbc);
            gbc.gridy = 2;
            gbc.insets = new Insets(0, 100, 0, 100);
            panelInicioSesion.add(passwordL, gbc);
            gbc.gridy = 3;
            gbc.insets = new Insets(0, 100, 10, 100);
            panelInicioSesion.add(passwordTF, gbc);
            gbc.gridy = 4;
            panelInicioSesion.add(iniciaSesionB, gbc);
            gbc.gridy = 5;
            gbc.insets = new Insets(0, 100, 50, 100);
            panelInicioSesion.add(crearCuentaB, gbc);
        } else {
            panelSesionIniciada = new JPanel();
            panelSesionIniciada.setLayout(new GridBagLayout());
            JLabel bienvenidaL = new JLabel();
            JButton cerrarSesionB = new JButton("Salir");
            cerrarSesionB.addActionListener(new cerrarSesionListener());
            this.panel.add(panelSesionIniciada);
            if (Garmin.usuario.getSexo().equals("Masculino")) {
                bienvenidaL.setText("¡Bienvenido " + Garmin.usuario.getApodo() + "!");
            } else {
                bienvenidaL.setText("¡Bienvenida " + Garmin.usuario.getApodo() + "!");
            }
            gbc.insets = new Insets(100, 100, 15, 100);
            panelSesionIniciada.add(bienvenidaL, gbc);
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 100, 100, 100);
            panelSesionIniciada.add(cerrarSesionB, gbc);
        }
    }

    public JPanel refresh() {
        return this.panel;
    }

    class cerrarSesionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Garmin.sesionIniciada = false;
        }

    }

    class IniciaSesionListener implements ActionListener {

        String usuario, password;

        @Override
        public void actionPerformed(ActionEvent e) {
            String usuarioLeido, passwordLeido;
            boolean noEncontrado = false;
            this.usuario = usuarioTF.getText();
            this.password = passwordTF.getText();
            String lectura;

            try {
                FileReader fr = new FileReader("test/usuarios.txt");
                BufferedReader br = new BufferedReader(fr);
                while (!Garmin.sesionIniciada && !noEncontrado) {
                    lectura = br.readLine();
                    if (lectura == null) {
                        System.out.println("No se encontro al usuario");
                        noEncontrado = true;
                    } else {
                        StringTokenizer st = new StringTokenizer(lectura, "/");
                        usuarioLeido = st.nextToken();
                        passwordLeido = st.nextToken();
                        if (this.usuario.equals(usuarioLeido) && this.password.equals(passwordLeido)) {
                            Garmin.sesionIniciada = true;
                            Garmin.usuario = Usuario.load(this.usuario);
                            panel.remove(panel.getComponent(0));
                            panelSesionIniciada = new JPanel();
                            panelSesionIniciada.setLayout(new GridBagLayout());
                            JLabel bienvenidaL = new JLabel();
                            JButton cerrarSesionB = new JButton("Salir");
                            cerrarSesionB.addActionListener(new cerrarSesionListener());
                            GridBagConstraints gbc = new GridBagConstraints();
                            gbc.fill = GridBagConstraints.HORIZONTAL;
                            gbc.gridx = 0;
                            gbc.gridy = 0;
                            gbc.insets = new Insets(100, 100, 15, 100);
                            if (Garmin.usuario.getSexo().equals("Masculino")) {
                                bienvenidaL.setText("¡Bienvenido " + Garmin.usuario.getApodo() + "!");
                            } else {
                                bienvenidaL.setText("¡Bienvenida " + Garmin.usuario.getApodo() + "!");
                            }
                            panelSesionIniciada.add(bienvenidaL, gbc);
                            gbc.gridy = 1;
                            gbc.insets = new Insets(0, 100, 100, 100);
                            panelSesionIniciada.add(cerrarSesionB, gbc);
                            panel.add(panelSesionIniciada);
                            panel.revalidate();
                            panel.repaint();
                        }
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("No se pudo abrir el archivo");
            } catch (IOException ex) {
                System.out.println("No se pudo leer del archivo");
            }
        }
    }
}
