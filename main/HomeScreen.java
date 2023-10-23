package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * This class is responsible for the display and basic interaction of the home screen.
 */
public class HomeScreen extends JPanel {

    //window size
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    //layout
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    //buttons
    JButton start = new JButton("START GAME");
    JButton settings = new JButton("SETTINGS");
    JButton quit = new JButton("QUIT");

    //top score
    JLabel topScoreLabel = new JLabel();

    /**
     * Constructor of the HomePanel class.
     */
    public HomeScreen() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(layout);

        //setting background
        try {
            this.setBackground(ImageIO.read(
                getClass().getResource(".\\images\\TetrisHomeBackground.jpeg")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //managing layout
        c.insets = new Insets(2, 2, 2, 2);
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 15;
        c.ipady = 10;
        
        //adding the top score
        topScoreLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
        topScoreLabel.setForeground(Color.WHITE);
        topScoreLabel.setBackground(Color.BLACK);
        topScoreLabel.setOpaque(true);
        topScoreLabel.setHorizontalAlignment(0);
        int topScore;
        try {
            BufferedReader savedScore =
                        new BufferedReader(new FileReader(
                            new File("main\\save_files\\topScore.txt")));
            topScore = Integer.parseInt(savedScore.readLine());
        } catch (Exception e) {
            topScore = 0;
            e.printStackTrace();
        }
        topScoreLabel.setText("TOP SCORE: " + topScore);
        this.add(topScoreLabel, c);

        //adding the buttons
        c.gridy = 1;
        start.setFont(new Font("Monospaced", Font.BOLD, 25));
        start.setForeground(Color.WHITE);
        start.setBorder(BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        start.setBackground(Color.BLACK);
        this.add(start, c);
        start.addActionListener((l) -> {
            //start a new game
            Window window = SwingUtilities.getWindowAncestor(this);
            window.remove(this);
            GamePanel gamePanel = new GamePanel();
            window.add(gamePanel);
            window.pack();
            gamePanel.launchGame();
        });
        
        c.gridy = 2;
        c.ipadx = 45;
        settings.setFont(new Font("Monospaced", Font.BOLD, 25));
        settings.setForeground(Color.WHITE);
        settings.setBorder(BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        settings.setBackground(Color.BLACK);
        this.add(settings, c);
        settings.addActionListener((l) -> {
            //open settings panel
            Window window = SwingUtilities.getWindowAncestor(this);
            window.remove(this);
            SettingsPanel settingsPanel = new SettingsPanel();
            window.add(settingsPanel);
            window.pack();
        });

        c.gridy = 3;
        c.ipadx = 105;
        quit.setFont(new Font("Monospaced", Font.BOLD, 25));
        quit.setForeground(Color.WHITE);
        quit.setBorder(BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        quit.setBackground(Color.BLACK);
        this.add(quit, c);
        quit.addActionListener((l) -> {
            //close the program
            SwingUtilities.getWindowAncestor(this).dispose();     
        });
    }
    
    //image management
    private BufferedImage img;

    /**
     * Sets the background of the panel.
     */
    public void setBackground(BufferedImage value) {
        if (value != img) {
            this.img = value;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            int x = (getWidth() - img.getWidth()) / 2;
            int y = (getHeight() - img.getHeight()) / 2;
            g.drawImage(img, x, y, this);
        }
    }
}
