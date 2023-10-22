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
        //Shape nubering:
        //Guide block: +
        // * + *  b[1], b[0], b[2]
        //   *    b[3]
            
        b[0].setBlockX(x);
        b[0].setBlockY(y);;

        b[1].setBlockX(x - Block.SIZE);
        b[1].setBlockY(y);

        b[2].setBlockX(x + Block.SIZE);
        b[2].setBlockY(y);

        b[3].setBlockX(x);
        b[3].setBlockY(y - Block.SIZE);
    }

    @Override
    public void rotate() {

    }
}
