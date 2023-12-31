package tetromino;

import java.awt.Color;

/**
 * Java class responsible for dealing with the specifics
 * of a J-shaped tetromino in particular.
 */
public class TetrominoJ extends Tetromino {

    public TetrominoJ() {
        super(Color.BLUE);
    }

    @Override
    public void setXY(int x, int y) {
        // Shape numbering:
        // Guide block: +
        //   * b[1]
        //   + b[0]
        // * * b[3], b[2]

        b[0].setBlockX(x);
        b[0].setBlockY(y);

        b[1].setBlockX(x);
        b[1].setBlockY(y - Block.SIZE);

        b[2].setBlockX(x);
        b[2].setBlockY(y + Block.SIZE);

        b[3].setBlockX(x - Block.SIZE);
        b[3].setBlockY(y + Block.SIZE);
    }

    @Override
    public void rotate() {
        // rotate the tetromino 90 degrees right around the guide block

        // if the shape is in its default state
        if (b[0].getBlockY() > b[1].getBlockY()) {
            // stage 1
            // Shape numbering:
            // Guide block: +
            // * b[3]
            // * + * b[2], b[0], b[1]

            tempB[0].setBlockX(b[0].getBlockX());
            tempB[0].setBlockY(b[0].getBlockY());

            tempB[1].setBlockX(b[1].getBlockX() + Block.SIZE);
            tempB[1].setBlockY(b[1].getBlockY() + Block.SIZE);

            tempB[2].setBlockX(b[2].getBlockX() - Block.SIZE);
            tempB[2].setBlockY(b[2].getBlockY() - Block.SIZE);

            tempB[3].setBlockX(b[3].getBlockX());
            tempB[3].setBlockY(b[3].getBlockY() - (2 * Block.SIZE));

        } else if (b[0].getBlockX() < b[1].getBlockX()) {
            // if the shape has been rotated once

            // stage 2
            // Shape numbering:
            // Guide block: +
            // * * b[2], b[3]
            // + b[0]
            // * b[1]

            tempB[0].setBlockX(b[0].getBlockX());
            tempB[0].setBlockY(b[0].getBlockY());

            tempB[1].setBlockX(b[1].getBlockX() - Block.SIZE);
            tempB[1].setBlockY(b[1].getBlockY() + Block.SIZE);

            tempB[2].setBlockX(b[2].getBlockX() + Block.SIZE);
            tempB[2].setBlockY(b[2].getBlockY() - Block.SIZE);

            tempB[3].setBlockX(b[3].getBlockX() + (2 * Block.SIZE));
            tempB[3].setBlockY(b[3].getBlockY());
        } else if (b[0].getBlockY() < b[1].getBlockY()) {
            // if the shape has been rotated twice

            // stage 3
            // Shape numbering:
            // Guide block: +
            // * + * b[1], b[0], b[2]
            //     * b[3]

            tempB[0].setBlockX(b[0].getBlockX());
            tempB[0].setBlockY(b[0].getBlockY());

            tempB[1].setBlockX(b[1].getBlockX() - Block.SIZE);
            tempB[1].setBlockY(b[1].getBlockY() - Block.SIZE);

            tempB[2].setBlockX(b[2].getBlockX() + Block.SIZE);
            tempB[2].setBlockY(b[2].getBlockY() + Block.SIZE);

            tempB[3].setBlockX(b[3].getBlockX());
            tempB[3].setBlockY(b[3].getBlockY() + (2 * Block.SIZE));

        } else {
            // reset to default at final rotation

            tempB[0].setBlockX(b[0].getBlockX());
            tempB[0].setBlockY(b[0].getBlockY());

            tempB[1].setBlockX(b[0].getBlockX());
            tempB[1].setBlockY(b[0].getBlockY() - Block.SIZE);

            tempB[2].setBlockX(b[0].getBlockX());
            tempB[2].setBlockY(b[0].getBlockY() + Block.SIZE);

            tempB[3].setBlockX(b[0].getBlockX() - Block.SIZE);
            tempB[3].setBlockY(b[0].getBlockY() + Block.SIZE);

        }
        updateXY(Direction.ROTATE);
    }
}
