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
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

/**
 * JPanel showing options and settings that can be adjusted to the player.
 */
public class SettingsPanel extends JPanel {
    //panel size
    public static final int WIDTH = 720;
    public static final int HEIGHT = 750;

    //layout
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    //labels
    JLabel speed = new JLabel("SPEED");
    JLabel mode = new JLabel("MODE");
    JLabel dif = new JLabel("DIFFICULTY");

    //toggle buttons
    JToggleButton isCoulorfulMode = new JToggleButton("COLOURFUL MODE");
    JToggleButton isNightmareDifficulty = new JToggleButton("NIGHTMARE MODE");

    //speed selection slider
    JSlider speedSlider = new JSlider(1, 10, 5);

    //exit buttons
    JButton saveButton = new JButton("SAVE");
    JButton cancelButton = new JButton("CANCEL");

    //settings file
    File settingsFile = new File("main\\save_files\\settings.txt");

    /**
     * Constructor for the GamePanel class.
     */
    public SettingsPanel() {
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

        //layout management
        c.insets = new Insets(2, 2, 2, 2);
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 15;
        c.ipady = 10;

        //saved settings reading
        int[] settingsList = new int[3];
        try {
            BufferedReader savedSettings = new BufferedReader((new FileReader(settingsFile)));
            String s;
            for (int i = 0; (s = savedSettings.readLine()) != null; i++) {
                settingsList[i] = Integer.parseInt(s);
            }
            savedSettings.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //adding contents
        speed.setFont(new Font("Monospaced", Font.BOLD, 25));
        speed.setForeground(Color.WHITE);
        speed.setBackground(Color.BLACK);
        speed.setOpaque(true);
        speed.setHorizontalAlignment(0);
        this.add(speed, c);

        c.gridy = 1;
        speedSlider.setBorder(BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        speedSlider.setBackground(Color.BLACK);
        this.add(speedSlider, c);
        speedSlider.addChangeListener((l) -> {
            settingsList[0] = speedSlider.getValue();
        });

        c.gridy = 2;
        mode.setFont(new Font("Monospaced", Font.BOLD, 25));
        mode.setForeground(Color.WHITE);
        mode.setBackground(Color.BLACK);
        mode.setOpaque(true);
        mode.setHorizontalAlignment(0);
        this.add(mode, c);

        c.gridy = 3;
        isCoulorfulMode.setFont(new Font("Monospaced", Font.BOLD, 25));
        isCoulorfulMode.setForeground(Color.WHITE);
        isCoulorfulMode.setBorder(BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        isCoulorfulMode.setBackground(Color.BLACK);
        this.add(isCoulorfulMode, c);
        isCoulorfulMode.addItemListener((l) -> {
            if (isCoulorfulMode.isSelected()) {
                //changing appearance
                isCoulorfulMode.setForeground(Color.BLACK);
                isCoulorfulMode.setBorder(
                    BorderFactory.createEtchedBorder(10, Color.BLACK, Color.BLACK));
                isCoulorfulMode.setBackground(Color.WHITE);
                
                //actual functionality
                //allows nightmare difficulty to be toggled
                isNightmareDifficulty.setEnabled(true);

                //turns on colourful mode
                settingsList[1] = 1;
            } else {
                //changing appearance back
                isCoulorfulMode.setForeground(Color.WHITE);
                isCoulorfulMode.setBorder(
                    BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
                isCoulorfulMode.setBackground(Color.BLACK);

                //actual functionality

                //prevents nightmare difficulty from being toggled
                //and toggles it off
                isNightmareDifficulty.setEnabled(false);
                isNightmareDifficulty.setSelected(false);
                //turns off nightmare dfficulty
                settingsList[2] = 0;
                //apearance reflecting change
                isNightmareDifficulty.setForeground(Color.WHITE);
                isNightmareDifficulty.setBorder(
                    BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
                isNightmareDifficulty.setBackground(Color.BLACK);

                //turns off colourful mode
                settingsList[1] = 0;
            }
        });        

        c.gridy = 4;
        dif.setFont(new Font("Monospaced", Font.BOLD, 25));
        dif.setForeground(Color.WHITE);
        dif.setBackground(Color.BLACK);
        dif.setOpaque(true);
        dif.setHorizontalAlignment(0);
        this.add(dif, c);

        c.gridy = 5;
        isNightmareDifficulty.setFont(new Font("Monospaced", Font.BOLD, 25));
        isNightmareDifficulty.setForeground(Color.WHITE);
        isNightmareDifficulty.setBorder(
            BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        isNightmareDifficulty.setBackground(Color.BLACK);
        this.add(isNightmareDifficulty, c);
        isNightmareDifficulty.setEnabled(false);
        isNightmareDifficulty.addActionListener((l) -> {
            if (isNightmareDifficulty.isSelected()) {
                //changing appearance
                isNightmareDifficulty.setForeground(Color.BLACK);
                isNightmareDifficulty.setBorder(
                    BorderFactory.createEtchedBorder(10, Color.BLACK, Color.BLACK));
                isNightmareDifficulty.setBackground(Color.WHITE);
                
                //actual functionality
                //turns on nightmare mode
                settingsList[2] = 1;
            } else {
                //changing appearance back
                isNightmareDifficulty.setForeground(Color.WHITE);
                isNightmareDifficulty.setBorder(
                    BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
                isNightmareDifficulty.setBackground(Color.BLACK);

                //actual functionality
                //turns off nightmare mode
                settingsList[2] = 0;
            }
        });

        c.gridy = 6;
        saveButton.setFont(new Font("Monospaced", Font.BOLD, 25));
        saveButton.setForeground(Color.WHITE);
        saveButton.setBorder(BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        saveButton.setBackground(Color.BLACK);
        this.add(saveButton, c);
        saveButton.addActionListener((l) -> {
            //saves changes to file
            try {
                FileWriter savingSettings = new FileWriter(settingsFile);
                savingSettings.write(settingsList[0] + "\n"
                                     + settingsList[1] + "\n"
                                     + settingsList[2]);
                savingSettings.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //sends back to home page
            Window window = SwingUtilities.getWindowAncestor(this);
            window.remove(this);
            HomeScreen homePanel = new HomeScreen();
            window.add(homePanel);
            window.pack();
        });

        c.gridy = 7;
        cancelButton.setFont(new Font("Monospaced", Font.BOLD, 25));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBorder(BorderFactory.createEtchedBorder(10, Color.WHITE, Color.WHITE));
        cancelButton.setBackground(Color.BLACK);
        this.add(cancelButton, c);
        cancelButton.addActionListener((l) -> {
            //sends back to home page without savnig changes
            Window window = SwingUtilities.getWindowAncestor(this);
            window.remove(this);
            HomeScreen homePanel = new HomeScreen();
            window.add(homePanel);
            window.pack();
        });

        presetSettings(settingsList);
    }

    /**
     * Presets the visual side of the settings based
     * off a list of data representing the saved settings.
     */
    private void presetSettings(int[] settingsList) {
        //speed
        speedSlider.setValue(settingsList[0]);

        //colourful and nightmare
        if (settingsList[1] == 0) {
            isNightmareDifficulty.setEnabled(false);
        } else {
            isCoulorfulMode.setSelected(true);
            isCoulorfulMode.setForeground(Color.BLACK);
            isCoulorfulMode.setBorder(
                BorderFactory.createEtchedBorder(10, Color.BLACK, Color.BLACK));
            isCoulorfulMode.setBackground(Color.WHITE);

            if (settingsList[2] == 1) {
                isNightmareDifficulty.setSelected(true);
                isNightmareDifficulty.setForeground(Color.BLACK);
                isNightmareDifficulty.setBorder(
                    BorderFactory.createEtchedBorder(10, Color.BLACK, Color.BLACK));
                isNightmareDifficulty.setBackground(Color.WHITE);
            }
        }
    }

    //background image management
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
