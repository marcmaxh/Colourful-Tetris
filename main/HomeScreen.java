package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class is responsible for the display and basic interaction of the home screen.
 */
public class HomeScreen extends JPanel {

    //should be responsible for the background image
    //doesn't work
    @Override
    protected void paintComponent(Graphics g) {
        Image background;
        try {
            background = ImageIO.read(new File("/images/TetrisHomeBackground.jpeg"));
            super.paintComponent(g);
            g.drawImage(background, 0, 0, null);
        } catch (IOException e) {
            System.out.println("The image is crashing something!!!");
        }
    }

    //window size
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    //layout
    GridLayout layout = new GridLayout(3, 1, 50, 30);

    //buttons
    JButton start = new JButton("START GAME");
    JButton settings = new JButton("SETTINGS");
    JButton quit = new JButton("QUIT");

    /**
     * Constructor of the HomePanel class.
     */
    public HomeScreen() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(layout);

        start.setFont(new Font("Monospaced", Font.BOLD, 25));
        start.setForeground(Color.WHITE);
        start.setBorder(BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        start.setBackground(Color.BLACK);
        start.setSize(50, 50);
        this.add(start);
        start.addActionListener((l) -> {
            //start a new game
        });
        
        settings.setFont(new Font("Monospaced", Font.BOLD, 25));
        settings.setForeground(Color.WHITE);
        settings.setBorder(BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        settings.setBackground(Color.BLACK);
        settings.setSize(50, 50);
        this.add(settings);
        settings.addActionListener((l) -> {
            //open settings panel
        });

        quit.setFont(new Font("Monospaced", Font.BOLD, 25));
        quit.setForeground(Color.WHITE);
        quit.setBorder(BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        quit.setBackground(Color.BLACK);
        quit.setPreferredSize(new Dimension(50, 50));
        this.add(quit);
        quit.addActionListener((l) -> {
            //close the program
            
        });
    }

}
