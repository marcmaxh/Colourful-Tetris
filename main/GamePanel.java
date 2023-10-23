package main;

import java.awt.*;
import javax.swing.*;

/**
 * Class resonsible for management of the game panel -
 * the panel where the actual gameplay is displayed and executed.
 * Is that correct?
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
     * Updates through differnt frames of the game.
     */
    public void update() {

        requestFocus(true);

        // only update game if it is not paused
        if (!KeyHandler.pausePressed) {
            playManager.update();
        }
    }

    /**
     * Paints the start of the game?
     * Change if needed.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        playManager.draw(g2d);
    }

}
