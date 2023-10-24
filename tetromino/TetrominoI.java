package tetromino;

import java.awt.Color;

/**
 * Java class responsible for dealing with the specifics
 * of an I-shaped tetromino in particular.
 */
public class TetrominoI extends Tetromino {

    public TetrominoI() {
        super(Color.CYAN);
    }

    @Override
    public void setXY(int x, int y) {
        //Shape nubering:
        //Guide block: +
        // * * + *
        //b[1] b[2] b[0] b[3]
            
        b[0].setBlockX(x);
        b[0].setBlockY(y);;

        b[1].setBlockX(x - 2 * Block.SIZE);
        b[1].setBlockY(y);

        b[2].setBlockX(x - Block.SIZE);
        b[2].setBlockY(y);

        b[3].setBlockX(x + Block.SIZE);
        b[3].setBlockY(y);
    }

    @Override
    public void rotate() {
        //doing complete rotations
        //because of colour orientation in colour mode

        //if tetromino is vertical
        if (b[0].getBlockX() == b[1].getBlockX()) {

            //after one rotation
            if (b[2].getBlockY() < b[0].getBlockY()) {

                //Shape nubering:
                //Guide block: +
                // * + * *
                //b[3] b[0] b[2] b[1]

                tempB[0].setBlockX(b[0].getBlockX());
                tempB[0].setBlockY(b[0].getBlockY());

                tempB[1].setBlockX(b[0].getBlockX() + 2 * Block.SIZE);
                tempB[1].setBlockY(b[0].getBlockY());

                tempB[2].setBlockX(b[0].getBlockX() + Block.SIZE);
                tempB[2].setBlockY(b[0].getBlockY());

                tempB[3].setBlockX(b[0].getBlockX() - Block.SIZE);
                tempB[3].setBlockY(b[0].getBlockY());

            } else {
                //or after 3 rotations

                //following template in setXY

                tempB[0].setBlockX(b[0].getBlockX());
                tempB[0].setBlockY(b[0].getBlockY());

                tempB[1].setBlockX(b[0].getBlockX() - 2 * Block.SIZE);
                tempB[1].setBlockY(b[0].getBlockY());

                tempB[2].setBlockX(b[0].getBlockX() - Block.SIZE);
                tempB[2].setBlockY(b[0].getBlockY());

                tempB[3].setBlockX(b[0].getBlockX() + Block.SIZE);
                tempB[3].setBlockY(b[0].getBlockY());

            }

        } else {
            //if tetromino is horizontal

            //from defalut position
            if (b[2].getBlockX() > b[0].getBlockX()) {
                //Shape numbering:
                //Guide block: +
                // *  b[1]
                // *  b[2]
                // +  b[0]
                // *  b[3]

                tempB[0].setBlockX(b[0].getBlockX());
                tempB[0].setBlockY(b[0].getBlockY());

                tempB[1].setBlockX(b[0].getBlockX());
                tempB[1].setBlockY(b[0].getBlockY() + 2 * Block.SIZE);

                tempB[2].setBlockX(b[0].getBlockX());
                tempB[2].setBlockY(b[0].getBlockY() + Block.SIZE);

                tempB[3].setBlockX(b[0].getBlockX());
                tempB[3].setBlockY(b[0].getBlockY() - Block.SIZE);

            } else {
                //or after 2 rotations

                //Shape numbering:
                //Guide block: +
                // *  b[3]
                // +  b[0]
                // *  b[2]
                // *  b[1]

                tempB[0].setBlockX(b[0].getBlockX());
                tempB[0].setBlockY(b[0].getBlockY());

                tempB[1].setBlockX(b[0].getBlockX());
                tempB[1].setBlockY(b[0].getBlockY() - 2 * Block.SIZE);

                tempB[2].setBlockX(b[0].getBlockX());
                tempB[2].setBlockY(b[0].getBlockY() - Block.SIZE);

                tempB[3].setBlockX(b[0].getBlockX());
                tempB[3].setBlockY(b[0].getBlockY() + Block.SIZE);

            }
        }

        updateXY(Direction.ROTATE);

    }
    
}
