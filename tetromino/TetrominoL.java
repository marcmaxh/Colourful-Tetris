package tetromino;

import java.awt.*;

/**
 * Java class responsible for dealing with the specifics
 * of a L-shaped tetromino in particular.
 */
public class TetrominoL extends Tetromino {

    public TetrominoL() {
        super(Color.ORANGE);
    }

    /**
     * Coordinates the initial positions of each block
     * in the tetromino based on its shape.
     */
    @Override
    public void setXY(int x, int y) {
            
        //Shape nubering:
        //Guide block: +
        // *  b[1]
        // +  b[0]
        // ** b[2], b[3]
            
        b[0].setBlockX(x);
        b[0].setBlockY(y);;

        b[1].setBlockX(x);
        b[1].setBlockY(y + Block.SIZE);

        b[2].setBlockX(x);
        b[2].setBlockY(y - Block.SIZE);

        b[3].setBlockX(x + Block.SIZE);
        b[3].setBlockY(y - Block.SIZE);
    }

    @Override
    public void rotate(Direction direction) {

        switch (direction) {
            case RIGHTROTATE:
                //rotate right
                break;
            case LEFTROTATE:
                //rotate left
                break;
            default:
                break;
        }
    }

}
