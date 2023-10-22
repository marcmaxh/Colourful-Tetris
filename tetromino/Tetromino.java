package tetromino;

import java.awt.*;
import main.*;

/**
 * Java class responsible for the management of each
 * individual tetromino during gameplay.
 */
public abstract class Tetromino {

    public Block[] b = new Block[4];
    public Block[] tempB = new Block[4];
    int autoDropCounter = 0;
    boolean leftCollision;
    boolean rightCollision;
    boolean bottomCollision;

    /**
     * Creates a new tetromino with a set colour.
     * Chaned to a constructor becaus it makes more sense like that.
     */
    public Tetromino(Color color) {
        for (int i = 0; i < 4; i++) {
            b[i] = new Block(color);
        }

        for (int i = 0; i < 4; i++) {
            tempB[i] = new Block(color);
        }
    }

    /**
     * Abstract class to make sure all shapes of tetronominos
     * have implenemted their shape construction.
     */
    public abstract void setXY(int x, int y);

    /**
     * Updates the position of the teronomino based on
     * its directed movement.
     */
    public void updateXY(Direction direction) {

        checkRotationCollision();

        if (!leftCollision && !rightCollision && !bottomCollision) {
            switch (direction) {
                case DOWN:
                    for (int i = 0; i < 4; i++) {
                        b[i].setBlockY(b[i].getBlockY() + Block.SIZE);
                    }
                    break;
                case RIGHTMOVE:
                    for (int i = 0; i < 4; i++) {
                        b[i].setBlockX(b[i].getBlockX() + Block.SIZE);
                    }
                    break;
                case LEFTMOVE:
                    for (int i = 0; i < 4; i++) {
                        b[i].setBlockX(b[i].getBlockX() - Block.SIZE);
                    }
                    break;
                default:
                    for (int i = 0; i < 4; i++) {
                        b[i].setBlockX(tempB[i].getBlockX());
                        b[i].setBlockY(tempB[i].getBlockY());
                    }
                    break;
            }
        }
    }

    // method responsible for the unique rotation of each shape
    public abstract void rotate(Direction direction);

    /**
     * Checks for collision with the left, right and bottom boundaries of the game
     * board.
     * Sets the corresponding collision flags if a collision is detected.
     */
    public void checkMovementCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        // check for left collision
        for (int i = 0; i < b.length; i++) {
            if (b[i].getBlockX() == PlayManager.left_x) {
                leftCollision = true;
            }
        }

        // check for right collision
        for (int i = 0; i < b.length; i++) {
            if (b[i].getBlockX() + Block.SIZE == PlayManager.right_x) {
                rightCollision = true;
            }
        }

        // check for bottom collision
        for (int i = 0; i < b.length; i++) {
            if (b[i].getBlockY() + Block.SIZE == PlayManager.bottom_y) {
                bottomCollision = true;
            }
        }

    }

    public void checkRotationCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;

        // check for left collision
        for (int i = 0; i < b.length; i++) {
            if (tempB[i].getBlockX() < PlayManager.left_x) {
                leftCollision = true;
            }
        }

        // check for right collision
        for (int i = 0; i < b.length; i++) {
            if (tempB[i].getBlockX() + Block.SIZE > PlayManager.right_x) {
                rightCollision = true;
            }
        }

        // check for bottom collision
        for (int i = 0; i < b.length; i++) {
            if (tempB[i].getBlockY() + Block.SIZE > PlayManager.bottom_y) {
                bottomCollision = true;
            }
        }
    }

    /**
     * Updates the position of the tetromino based on user input and automatic
     * downward movement.
     * Checks for collisions with the game board and prevents movement if a
     * collision is detected.
     * Also handles rotation of the tetromino.
     */
    public void update() {

        checkMovementCollision();

        // move the tetromino down
        if (KeyHandler.downPressed) {

            // If the tetromino is not hitting anything, it can go down.
            if (!bottomCollision) {
                updateXY(Direction.DOWN);
            }

            // reset the auto drop counter
            autoDropCounter = 0;

            KeyHandler.downPressed = false;
        }

        // move the tetromino left
        if (KeyHandler.leftPressed) {

            // If the tetromino is not hitting anything, it can go left.
            if (!leftCollision) {
                updateXY(Direction.LEFTMOVE);
            }

            KeyHandler.leftPressed = false;
        }

        // move the tetromino right
        if (KeyHandler.rightPressed) {

            // If the tetromino is not hitting anything, it can go right.
            if (!rightCollision) {
                updateXY(Direction.RIGHTMOVE);
            }

            KeyHandler.rightPressed = false;
        }

        checkRotationCollision();

        // rotate the tetromino
        if (KeyHandler.rotatePressed) {

            // If the tetromino is not hitting anything, it can rotate.
            if (!leftCollision && !rightCollision && !bottomCollision) {
                rotate(Direction.ROTATE);
            }

            KeyHandler.rotatePressed = false;
        }

        // move the tetromino down automatically

        autoDropCounter++;
        if (autoDropCounter == PlayManager.dropInterval && !bottomCollision) {
            updateXY(Direction.DOWN);

            autoDropCounter = 0;
        }
    }

    /**
     * Draws a tetromino on the screen.
     */
    public void draw(Graphics2D g2d) {

        int margin = 2;

        g2d.setColor(b[0].getColor());
        g2d.fillRect(b[0].getBlockX() + margin, b[0].getBlockY() + margin, Block.SIZE
                - (margin * 2), Block.SIZE - (margin * 2));
        g2d.fillRect(b[1].getBlockX() + margin, b[1].getBlockY() + margin, Block.SIZE
                - (margin * 2), Block.SIZE - (margin * 2));
        g2d.fillRect(b[2].getBlockX() + margin, b[2].getBlockY() + margin, Block.SIZE
                - (margin * 2), Block.SIZE - (margin * 2));
        g2d.fillRect(b[3].getBlockX() + margin, b[3].getBlockY() + margin, Block.SIZE
                - (margin * 2), Block.SIZE - (margin * 2));

    }
}