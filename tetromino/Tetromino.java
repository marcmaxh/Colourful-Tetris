package tetromino;

import java.awt.*;

/**
 * Java class responsible for the management of each
 * individual tetromino during gameplay.
 */
public abstract class Tetromino {

    public Block[] b = new Block[4];
    public Block[] tempB = new Block[4];

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

        switch (direction) {
            case DOWN:
                for (int i = 0; i < 4; i++) {
                    b[i].setBlockY(b[i].getBlockY() - 1);
                }
                break;
            case RIGHTMOVE:
                for (int i = 0; i < 4; i++) {
                    b[i].setBlockX(b[i].getBlockX() + 1);
                }
                break;
            case LEFTMOVE:
                for (int i = 0; i < 4; i++) {
                    b[i].setBlockX(b[i].getBlockX() - 1);
                }
                break;
            default:
                rotate(direction);
                break;
        }
    }

    //method responsible for the unique rotation of each shape
    public abstract void rotate(Direction direction);



    //Is this method sopposed to make the changes visible all at once
    //in order to avoid wonky movement on the diplay?
    public void update() {

    }

    /**
     * Draws a tetromino on the screen.
     */
    public void draw(Graphics2D g2d) {

        g2d.setColor(b[0].getColor());
        g2d.fillRect(b[0].getBlockX(), b[0].getBlockY(), Block.SIZE, Block.SIZE);
        g2d.fillRect(b[1].getBlockX(), b[1].getBlockY(), Block.SIZE, Block.SIZE);
        g2d.fillRect(b[2].getBlockX(), b[2].getBlockY(), Block.SIZE, Block.SIZE);
        g2d.fillRect(b[3].getBlockX(), b[3].getBlockY(), Block.SIZE, Block.SIZE);

    }
}