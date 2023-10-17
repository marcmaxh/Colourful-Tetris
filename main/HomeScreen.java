package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 * This class is responsible for the display and basic interaction of the home screen.
 */
public class HomeScreen extends JPanel{
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    /**
     * Constructor of the HomePnale class.
     */
    public HomeScreen(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);
    }
}
