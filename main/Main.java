package main;

import javax.swing.*;

/**
 * Main class of the program.
 * Responsible for manageing its launch.
 */
public class Main {

    public static void main(String[] args) {
        
        JFrame window = new JFrame("Tetris");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // Add GamePanel to window
        //Should be removed to add a home screen after implementation
        // GamePanel gamePanel = new GamePanel();
        // window.add(gamePanel);
        // window.pack();

        //Adding home screen to window
        HomeScreen homeScreen = new HomeScreen();
        window.add(homeScreen);
        window.pack();
        
        //Displays the game on the monitor
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Launch the game
        //gamePanel.launchGame();

    }
}