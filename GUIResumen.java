/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garmin;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class GUIResumen {
    private JPanel panel;
    
    public GUIResumen(){
        this.panel = new JPanel();
        this.panel.setBackground(Color.BLUE);
    }
    
    public JPanel refresh(){
        return this.panel;
    }
    
}
