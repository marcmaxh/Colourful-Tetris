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
        //Shape nubering:
        //Guide block: +
        //  * b[1]
        //  + b[0]
        // ** b[3], b[2]
            
        b[0].setBlockX(x);
        b[0].setBlockY(y);;

        b[1].setBlockX(x);
        b[1].setBlockY(y + Block.SIZE);

        b[2].setBlockX(x);
        b[2].setBlockY(y - Block.SIZE);

        b[3].setBlockX(x - Block.SIZE);
        b[3].setBlockY(y - Block.SIZE);
    }

    @Override
    public void rotate(Direction direction) {
        switch (direction) {
            case ROTATE:
                //rotate right
                break;
            default:
                break;
        }
    }
    
}
