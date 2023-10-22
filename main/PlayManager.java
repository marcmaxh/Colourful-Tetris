package main;

import java.awt.*;
import java.util.*;
import tetromino.*;

/**
 * Java class responsible for manageing the gameplay itself.
 * Change if needed?
 */
public class PlayManager {

    // Main play area
    final int width = 360;
    final int height = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    // Tetromino
    Tetromino currentTetromino;
    final int tetrominoStartX;
    final int tetrominoStartY;

    // Others
    public static int dropInterval = 60; // 60 frames per second = 1 second


    /**
     * Constructor for PlayManager class.
     * Initializes the playable board and sets the starting position of the current tetromino.
     */
    public PlayManager() {
        //Set playable board
        left_x = (GamePanel.WIDTH / 2) - (width / 2);
        right_x = left_x + width;
        top_y = 50;
        bottom_y = top_y + height;

        tetrominoStartX = left_x + (width / 2) - (Block.SIZE);
        tetrominoStartY = top_y + (Block.SIZE);

        currentTetromino = pickTetromino();
        currentTetromino.setXY(tetrominoStartX, tetrominoStartY);
    }

    /**
     * Picks a random Tetromino shape to be used in the game.
     *
     * @return a Tetromino object representing the chosen shape.
     */
    private Tetromino pickTetromino() {

        // Pick a Random Tetromino
        int randNo = new Random().nextInt(7);

        switch (randNo) {
            case 0:
                return new TetrominoI();
            case 1:
                return new TetrominoJ();
            case 2: 
                return new TetrominoL();
            case 3: 
                return new TetrominoO();
            case 4:
                return new TetrominoS();
            case 5:
                return new TetrominoT();
            case 6: 
                return new TetrominoZ();
            default:
                return null;
        }
    }

    /**
     * Updates the moving tetromino.
     */
    public void update() {

        currentTetromino.update();
    }

    /**
     * Draws the inital frame at the start of a new game?
     * Change if incorrect.
     */
    public void draw(Graphics2D g2d) {

        // Draw the play area
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(4f));
        g2d.drawRect(left_x - 4, top_y - 4, width + 8, height + 8);

        // Draw next Tetromino Frame
        int x = right_x + 100;
        int y = bottom_y - 200;
        g2d.drawRect(x, y, 200, 200);
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.drawString("Next", x + 60, y + 60);

        // Draw the current Tetromino
        if (currentTetromino != null) {
            currentTetromino.draw(g2d);
        }

        // Draw Pause menu

        g2d.setColor(Color.white);
        g2d.setFont(g2d.getFont().deriveFont(50f));
        if (KeyHandler.pausePressed) {
            g2d.drawString("PAUSED", left_x + 70, top_y + 300);
        }

    }
}
