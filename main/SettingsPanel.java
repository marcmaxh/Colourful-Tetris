package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * JPanel showing options and settings that can be adjusted to the player.
 */
public class SettingsPanel extends JPanel {
    //panel size
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    //layout
    GridLayout layout = new GridLayout(5, 5, 20, 20);

    //labels
    JLabel speed = new JLabel("SPEED");
    JLabel mode = new JLabel("MODE");
    JLabel dif = new JLabel("DIFFICULTY");

    //toggle buttons
    JToggleButton isCoulorfulButton = new JToggleButton("COLOURFUL MODE");

    /**
     * Constructor for the GamePanel class.
     */
    public SettingsPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        //rows and colums are subject to change
        this.setLayout(layout);
    }
    
}
