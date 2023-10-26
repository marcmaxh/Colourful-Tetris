package main;

import java.awt.*;
import javax.swing.*;


/**
 * The GamePanel class represents the panel where the game is played. 
 * It extends JPanel and implements Runnable.
 * It contains the game loop, which updates and repaints the game at a fixed frame rate.
 * It also contains the PlayManager object, which manages the game logic and drawing.
 */
public class GamePanel extends JPanel implements Runnable {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    final int fps = 60;
    Thread gameThread;
    PlayManager playManager;

    /**
     * Constructor for the GamePanel class.
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);

        // Implement Keylistener
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);

        playManager = new PlayManager();

    }

    /**
     * Launches a new game of Tetris.
     */
    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * This method runs the game loop which updates
     * and repaints the game panel at a fixed frame rate.
     * The frame rate is determined by the fps variable.
     */
    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    /**
     * Updates through different frames of the game.
     */
    public void update() {

        requestFocus(true);

        // only update game if it is not paused
        if (!KeyHandler.pausePressed && !playManager.gameOver) {
            playManager.update();
        }

        checkGameOver();
    }


    /**
     * Checks if the game is over and switches to the HomeScreen if it is.
     * Removes this GamePanel from the top-level window that contains it and adds the HomeScreen.
     */
    private void checkGameOver() {
        // Check if the game is over...
        if (playManager.gameOver) {
            // Get the top-level window that contains this GamePanel
            Window window = SwingUtilities.getWindowAncestor(this);

            if (window != null) {
                // Remove this GamePanel from the window
                window.remove(this);
    
                // Switch to the HomeScreen
                HomeScreen homeScreen = new HomeScreen();
                window.add(homeScreen);
                window.pack();
                window.setLocationRelativeTo(null);
                homeScreen.requestFocusInWindow();
            }
        }
    }

    /**
     * Overrides the paintComponent method to draw the game panel.
     * 
     * @param g the Graphics object to be painted
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        playManager.draw(g2d);
    }

}
