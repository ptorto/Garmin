/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.awt.Color;
import java.awt.Dimension;
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
    private JTextField usuarioTF, passwordTF, nombreTF, apodoTF, emailTF, contrasenaTF, alturaTF, pesoTF;
    private JRadioButton masculinoRB, femeninoRB;
    private JSpinner fechaNacimientoS;

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
            this.usuarioTF = new JTextField("Pablo");
            this.passwordTF = new JTextField("torto");
            JButton iniciaSesionB = new JButton("Iniciar Sesion");
            iniciaSesionB.addActionListener(new IniciaSesionListener());
            JButton crearCuentaB = new JButton("Crear Cuenta");
            crearCuentaB.addActionListener(new CrearCuentaListener());

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

    class CrearCuentaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.remove(panel.getComponent(0));

            JPanel panelAlta = new JPanel();
            panelAlta.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(panelAlta);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 0;

            JLabel label0, label1, label2, label3, label4, label5, label6, label7, label8;

            label0 = new JLabel("Crear nuevo usuario");
            gbc.insets = new Insets(40, 70, 20, 70);
            panelAlta.add(label0, gbc);

            label1 = new JLabel("Nombre: ");
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 70, 2, 70);
            panelAlta.add(label1, gbc);

            nombreTF = new JTextField();
            gbc.insets = new Insets(0, 70, 10, 70);
            gbc.gridy = 2;
            panelAlta.add(nombreTF, gbc);

            label2 = new JLabel("Apodo:");
            gbc.gridy = 3;
            gbc.insets = new Insets(0, 70, 2, 70);
            panelAlta.add(label2, gbc);

            apodoTF = new JTextField();
            gbc.gridy = 4;
            gbc.insets = new Insets(0, 70, 10, 70);
            panelAlta.add(apodoTF, gbc);

            label5 = new JLabel("Sexo:");
            gbc.gridy = 5;
            gbc.insets = new Insets(0, 70, 2, 70);
            panelAlta.add(label5, gbc);

            masculinoRB = new JRadioButton("M");
            femeninoRB = new JRadioButton("F");
            ButtonGroup group = new ButtonGroup();
            group.add(masculinoRB);
            group.add(femeninoRB);
            gbc.gridy = 6;
            panelAlta.add(masculinoRB, gbc);
            gbc.gridy = 7;
            panelAlta.add(femeninoRB, gbc);

            label8 = new JLabel("Fecha nacimiento:");
            gbc.gridy = 8;
            gbc.insets = new Insets(0, 70, 2, 70);
            panelAlta.add(label8, gbc);

            fechaNacimientoS = new JSpinner(new SpinnerDateModel());
            gbc.gridy = 9;
            gbc.insets = new Insets(0, 70, 10, 70);
            panelAlta.add(fechaNacimientoS, gbc);

            label6 = new JLabel("Altura(m):");
            gbc.gridy = 10;
            gbc.insets = new Insets(0, 70, 2, 70);
            panelAlta.add(label6, gbc);

            alturaTF = new JTextField();
            gbc.gridy = 11;
            gbc.insets = new Insets(0, 70, 10, 70);
            panelAlta.add(alturaTF, gbc);

            label7 = new JLabel("Peso(Kg):");
            gbc.gridy = 12;
            gbc.insets = new Insets(0, 70, 2, 70);
            panelAlta.add(label7, gbc);

            pesoTF = new JTextField();
            gbc.gridy = 13;
            gbc.insets = new Insets(0, 70, 10, 70);
            panelAlta.add(pesoTF, gbc);

            label3 = new JLabel("Email:");
            gbc.gridy = 14;
            gbc.insets = new Insets(0, 70, 2, 70);
            panelAlta.add(label3, gbc);

            emailTF = new JTextField();
            gbc.gridy = 15;
            gbc.insets = new Insets(0, 70, 10, 70);
            panelAlta.add(emailTF, gbc);

            label4 = new JLabel("Contraseña:");
            gbc.gridy = 16;
            gbc.insets = new Insets(0, 70, 2, 70);
            panelAlta.add(label4, gbc);

            contrasenaTF = new JTextField();
            gbc.gridy = 17;
            gbc.insets = new Insets(0, 70, 10, 70);
            panelAlta.add(contrasenaTF, gbc);

            JButton crearUsuarioB = new JButton("Crear cuenta");
            gbc.gridy = 18;
            gbc.insets = new Insets(20, 70, 40, 70);
            crearUsuarioB.addActionListener(new AltaCuentaListener());
            panelAlta.add(crearUsuarioB, gbc);

            panel.revalidate();
            panel.repaint();
        }

    }

    class AltaCuentaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre, apodo, email, sexo, contrasena;
            nombre = nombreTF.getText();
            apodo = apodoTF.getText();
            email = emailTF.getText();
            contrasena = contrasenaTF.getText();
            if (masculinoRB.isSelected()) {
                sexo = "Masculino";
            } else {
                sexo = "Femenino";
            }
            System.out.println(sexo);
            //Usuario usuario = new Usuario(nombre,sexo,apodo,contrasena,email);
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
