package tetromino;

import java.awt.Color;

/**
 * Java class responsible for dealing with the specifics
 * of an O-shaped tetromino in particular.
 */
public class TetrominoO extends Tetromino {

    public TetrominoO() {
        super(Color.YELLOW);
    }

    @Override
    public void setXY(int x, int y) {
        //Shape nubering:
        //Guide block: +
        // + * b[0], b[1]
        // * * b[2], b[3]
            
        b[0].setBlockX(x);
        b[0].setBlockY(y);;

        b[1].setBlockX(x + Block.SIZE);
        b[1].setBlockY(y);

        b[2].setBlockX(x);
        b[2].setBlockY(y - Block.SIZE);

        b[3].setBlockX(x + Block.SIZE);
        b[3].setBlockY(y - Block.SIZE);
    }

    @Override
    public void rotate() {
        // rotate to adjust for colours for colour mode

        tempB[0].setBlockX(b[2].getBlockX());
        tempB[0].setBlockY(b[2].getBlockY());;

        tempB[1].setBlockX(b[0].getBlockX());
        tempB[1].setBlockY(b[0].getBlockY());

        tempB[2].setBlockX(b[3].getBlockX());
        tempB[2].setBlockY(b[3].getBlockY());

        tempB[3].setBlockX(b[1].getBlockX());
        tempB[3].setBlockY(b[1].getBlockY());

        updateXY(Direction.ROTATE);
    }
    
}
