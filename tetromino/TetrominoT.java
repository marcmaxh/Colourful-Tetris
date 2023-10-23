package tetromino;

import java.awt.Color;

/**
 * Java class responsible for dealing with the specifics
 * of a T-shaped tetromino in particular.
 */
public class TetrominoT extends Tetromino {

    public TetrominoT() {
        super(Color.MAGENTA);
    }

    @Override
    public void setXY(int x, int y) {
        // Shape numbering:
        // Guide block: +
        // * + * b[1], b[0], b[2]
        // * b[3]

        b[0].setBlockX(x);
        b[0].setBlockY(y);

        b[1].setBlockX(x - Block.SIZE);
        b[1].setBlockY(y);

        b[2].setBlockX(x + Block.SIZE);
        b[2].setBlockY(y);

        b[3].setBlockX(x);
        b[3].setBlockY(y + Block.SIZE);
    }

    @Override
    public void rotate() {
        // rotate the tetromino 90 degrees right around the guide block

        // if the shape is in its default state
        if (b[0].getBlockY() < b[3].getBlockY()) {
            
            // stage 1
            // Shape numbering:
            // Guide block: +
            // * b[1]
            // * + b[3], b[0]
            // * b[2]

            tempB[0].setBlockX(b[0].getBlockX());
            tempB[0].setBlockY(b[0].getBlockY());

            tempB[1].setBlockX(b[1].getBlockX() + Block.SIZE);
            tempB[1].setBlockY(b[1].getBlockY() - Block.SIZE);

            tempB[2].setBlockX(b[2].getBlockX() - Block.SIZE);
            tempB[2].setBlockY(b[2].getBlockY() + Block.SIZE);

            tempB[3].setBlockX(b[3].getBlockX() - Block.SIZE);
            tempB[3].setBlockY(b[3].getBlockY() - Block.SIZE);
            // if the shape has been rotated once
        } else if (b[0].getBlockX() > b[3].getBlockX()) {

            // print out the current state of the tetromino
            // stage 2
            // Shape numbering:
            // Guide block: +
            //   * b[3]
            // * + * b[2], b[0], b[1]

            tempB[0].setBlockX(b[0].getBlockX());
            tempB[0].setBlockY(b[0].getBlockY());

            tempB[1].setBlockX(b[1].getBlockX() + Block.SIZE);
            tempB[1].setBlockY(b[1].getBlockY() + Block.SIZE);

            tempB[2].setBlockX(b[2].getBlockX() - Block.SIZE);
            tempB[2].setBlockY(b[2].getBlockY() - Block.SIZE);

            tempB[3].setBlockX(b[3].getBlockX() + Block.SIZE);
            tempB[3].setBlockY(b[3].getBlockY() - Block.SIZE);
        } else if (b[0].getBlockY() > b[3].getBlockY()) {
            // if the shape has been rotated twice

            // stage 3
            // Shape numbering:
            // Guide block: +
            // * b[2]
            // + * b[0], b[3]
            // * b[1]

            tempB[0].setBlockX(b[0].getBlockX());
            tempB[0].setBlockY(b[0].getBlockY());

            tempB[1].setBlockX(b[1].getBlockX() - Block.SIZE);
            tempB[1].setBlockY(b[1].getBlockY() + Block.SIZE);

            tempB[2].setBlockX(b[2].getBlockX() + Block.SIZE);
            tempB[2].setBlockY(b[2].getBlockY() - Block.SIZE);

            tempB[3].setBlockX(b[3].getBlockX() + Block.SIZE);
            tempB[3].setBlockY(b[3].getBlockY() + Block.SIZE);
        } else {
            // set to deafult for final rotation

            tempB[0].setBlockX(b[0].getBlockX());
            tempB[0].setBlockY(b[0].getBlockY());

            tempB[1].setBlockX(b[0].getBlockX() - Block.SIZE);
            tempB[1].setBlockY(b[0].getBlockY());

            tempB[2].setBlockX(b[0].getBlockX() + Block.SIZE);
            tempB[2].setBlockY(b[0].getBlockY());

            tempB[3].setBlockX(b[0].getBlockX());
            tempB[3].setBlockY(b[0].getBlockY() + Block.SIZE);
        }

        updateXY(Direction.ROTATE);
    }

}
