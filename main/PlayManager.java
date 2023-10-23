package main;

import java.awt.*;
import java.util.*;
import tetromino.*;

/**
 * The PlayManager class manages the game play area, tetrominoes, and game
 * updates.
 */
public class PlayManager {

    // Main play area
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    // Tetromino
    Tetromino currentTetromino;
    final int tetrominoStartX;
    final int tetrominoStartY;
    Tetromino nexTetromino;
    final int nextTetrominoStartX;
    final int nextTetrominoStartY;
    public static ArrayList<Block> staticBlocks = new ArrayList<>();

    // Others
    public static int dropInterval = 60; // 60 frames per second = 1 second

    /**
     * Constructor for PlayManager class.
     * Initializes the playable board and sets the starting position of the current
     * tetromino.
     */
    public PlayManager() {

        // Set playable board
        left_x = (GamePanel.WIDTH / 2) - (WIDTH / 2);
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;

        // Set starting position of the current Tetromino
        tetrominoStartX = left_x + (WIDTH / 2) - (Block.SIZE);
        tetrominoStartY = top_y + (Block.SIZE);

        // Set next Tetromino position
        nextTetrominoStartX = right_x + 178;
        nextTetrominoStartY = top_y + 500;

        // Initialize the first Tetromino
        currentTetromino = pickTetromino();
        currentTetromino.setXY(tetrominoStartX, tetrominoStartY);

        // Initialize the next Tetromino
        nexTetromino = pickTetromino();
        nexTetromino.setXY(nextTetrominoStartX, nextTetrominoStartY);
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

        // Check if the current Tetromino has collided with the bottom of the play area
        // (is active)
        if (!currentTetromino.active) {
            // Add the current Tetromino to the static blocks
            for (int i = 0; i < 4; i++) {
                staticBlocks.add(currentTetromino.b[i]);
            }

            currentTetromino.deactivating = false;

            // replace the currentTetromino with the nextTetromino
            currentTetromino = nexTetromino;
            currentTetromino.setXY(tetrominoStartX, tetrominoStartY);

            // pick a new nextTetromino
            nexTetromino = pickTetromino();
            nexTetromino.setXY(nextTetrominoStartX, nextTetrominoStartY);

        } else {

            currentTetromino.update();
        }

    }

    /**
     * Draws the inital frame at the start of a new game?
     * Change if incorrect.
     */
    public void draw(Graphics2D g2d) {

        // Draw main play area frame
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(4f));
        g2d.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8);

        // Draw next tetromino frame
        int x = right_x + 100;
        int y = bottom_y - 200;
        g2d.drawRect(x, y, 200, 200);
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 30));
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.drawString("NEXT", x + 60, y + 60);

        // Draw score frame
        g2d.drawRect(x, top_y, 250, 300);
        x += 40;
        y = top_y + 90;
        g2d.drawString("LEVEL: ", x, y);
        y += 70;
        g2d.drawString("LINES: ", x, y);
        y += 70;
        g2d.drawString("SCORE: ", x, y);

        // Draw the current Tetromino
        if (currentTetromino != null) {
            currentTetromino.draw(g2d);
        }

        // Draw the next Tetromino
        nexTetromino.draw(g2d);

        // Draw the static blocks
        for (Block b : staticBlocks) {
            b.draw(g2d);
        }
        

        // Draw Pause menu

        g2d.setColor(Color.white);
        g2d.setFont(g2d.getFont().deriveFont(50f));
        if (KeyHandler.pausePressed) {
            g2d.drawString("PAUSED", left_x + 70, top_y + 300);
        }

    }
}
