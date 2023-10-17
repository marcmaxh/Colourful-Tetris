package tetromino;

import java.awt.Color;

/**
 * Java class responsible for dealing with the specifics
 * of a Z-shaped tetromino in particular.
 */
public class TetrominoZ extends Tetromino {

    public TetrominoZ() {
        super(Color.RED);
    }

    @Override
    public void setXY(int x, int y) {
        //Shape nubering:
        //Guide block: +
        // * *    b[1], b[2]
        //   + *  b[0], b[3]

            
        b[0].setBlockX(x);
        b[0].setBlockY(y);;

        b[1].setBlockX(x - Block.SIZE);
        b[1].setBlockY(y + Block.SIZE);

        b[2].setBlockX(x);
        b[2].setBlockY(y + Block.SIZE);

        b[3].setBlockX(x + Block.SIZE);
        b[3].setBlockY(y);
    }

    @Override
    public void rotate(Direction direction) {
        //if the tetromino is vertical, make it horizontal
        //and vice versa
        if (b[0].getBlockX() == b[1].getBlockX()) {

            //following template in setXY

            b[1].setBlockX(b[0].getBlockX() - Block.SIZE);
            b[1].setBlockY(b[0].getBlockY() + Block.SIZE);

            b[2].setBlockX(b[0].getBlockX());
            b[2].setBlockY(b[0].getBlockY() + Block.SIZE);

            b[3].setBlockX(b[0].getBlockX() + Block.SIZE);
            b[3].setBlockY(b[0].getBlockY());

        } else {

            //Shape numbering:
            //Guide block: +
            //   *  b[1]
            // + *  b[0], b[2]
            // *    b[3]

            b[1].setBlockX(b[0].getBlockX() + Block.SIZE);
            b[1].setBlockY(b[0].getBlockY() + Block.SIZE);

            b[2].setBlockX(b[0].getBlockX() + Block.SIZE);
            b[2].setBlockY(b[0].getBlockY());

            b[3].setBlockX(b[0].getBlockX());
            b[3].setBlockY(b[0].getBlockY() - Block.SIZE);
        }
    }
    
}
