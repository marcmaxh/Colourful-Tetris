package main;

import java.awt.*;
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

    /**
     * Constructor for the class PlayManager.
     */
    public PlayManager() {
        //Set playable board
        left_x = (GamePanel.WIDTH / 2) - (width / 2);
        right_x = left_x + width;
        top_y = 50;
        bottom_y = top_y + height;

        tetrominoStartX = left_x + (width / 2) - (Block.SIZE);
        tetrominoStartY = top_y + (Block.SIZE);

        // Set the starting Tetromino
        //can be taken out to a generateTetromino() method later somewhere appropriate
        switch (Shapes.pickTetrominoShape()){
            case I:
                currentTetromino = new TetrominoI();
                break;
            case J:
                currentTetromino = new TetrominoJ();
                break;
            case L:
                currentTetromino = new TetrominoL();
                break;
            case O:
                currentTetromino = new TetrominoO();
                break;
            case S:
                currentTetromino = new TetrominoS();
                break;
            case T:
                currentTetromino = new TetrominoT();
                break;
            case Z:
                currentTetromino = new TetrominoZ();
                break;
            default:
                break;
        }
        currentTetromino.setXY(tetrominoStartX, tetrominoStartY);
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

    }
}
