package tetromino;

import java.awt.Color;

/**
 * Java class responsible for dealing with the specifics
 * of a S-shaped tetromino in particular.
 */
public class TetrominoS extends Tetromino {

    public TetrominoS() {
        super(Color.GREEN);
    }

    @Override
    public void setXY(int x, int y) {
        // Shape nubering:
        // Guide block: +
        //   * * b[1], b[2]
        // * + b[3], b[0]

        b[0].setBlockX(x);
        b[0].setBlockY(y);

        b[1].setBlockX(x);
        b[1].setBlockY(y - Block.SIZE);

        b[2].setBlockX(x + Block.SIZE);
        b[2].setBlockY(y - Block.SIZE);

        b[3].setBlockX(x - Block.SIZE);
        b[3].setBlockY(y);
    }

    @Override
    public void rotate() {
        // proper rotation for the shape
        // to adjust for colour mode

        //if the shape is vertical
        if (b[0].getBlockX() != b[1].getBlockX()) {

            //from 3 rotations
            if (b[0].getBlockX() > b[1].getBlockX()) {
                //return to deafult
                tempB[0].setBlockX(b[0].getBlockX());
                tempB[0].setBlockY(b[0].getBlockY());

                tempB[1].setBlockX(b[0].getBlockX());
                tempB[1].setBlockY(b[0].getBlockY() - Block.SIZE);

                tempB[2].setBlockX(b[0].getBlockX() + Block.SIZE);
                tempB[2].setBlockY(b[0].getBlockY() - Block.SIZE);

                tempB[3].setBlockX(b[0].getBlockX() - Block.SIZE);
                tempB[3].setBlockY(b[0].getBlockY());
            } else {
                //or 1 rotation

                // Shape numbering:
                // Guide block: +
                //   + * b[0], b[3]
                // * * b[2], b[1]

                tempB[0].setBlockX(b[0].getBlockX());
                tempB[0].setBlockY(b[0].getBlockY());

                tempB[1].setBlockX(b[0].getBlockX());
                tempB[1].setBlockY(b[0].getBlockY() + Block.SIZE);

                tempB[2].setBlockX(b[0].getBlockX() - Block.SIZE);
                tempB[2].setBlockY(b[0].getBlockY() + Block.SIZE);

                tempB[3].setBlockX(b[0].getBlockX() + Block.SIZE);
                tempB[3].setBlockY(b[0].getBlockY());
            }


        } else {
            //if the shape is horizontal

            //at default orientation
            if (b[0].getBlockX() > b[3].getBlockX()) {
                // Shape numbering:
                // Guide block: +
                // * b[3]
                // + * b[0], b[1]
                //   * b[2]

                tempB[0].setBlockX(b[0].getBlockX());
                tempB[0].setBlockY(b[0].getBlockY());
            
                tempB[1].setBlockX(b[0].getBlockX() + Block.SIZE);
                tempB[1].setBlockY(b[0].getBlockY());

                tempB[2].setBlockX(b[0].getBlockX() + Block.SIZE);
                tempB[2].setBlockY(b[0].getBlockY() + Block.SIZE);

                tempB[3].setBlockX(b[0].getBlockX());
                tempB[3].setBlockY(b[0].getBlockY() - Block.SIZE);

            } else {
                //or after 2 rotations
                
                // Shape numbering:
                // Guide block: +
                // * b[2]
                // * + b[1], b[0]
                //   * b[3]

                tempB[0].setBlockX(b[0].getBlockX());
                tempB[0].setBlockY(b[0].getBlockY());
            
                tempB[1].setBlockX(b[0].getBlockX() - Block.SIZE);
                tempB[1].setBlockY(b[0].getBlockY());

                tempB[2].setBlockX(b[0].getBlockX() - Block.SIZE);
                tempB[2].setBlockY(b[0].getBlockY() - Block.SIZE);

                tempB[3].setBlockX(b[0].getBlockX());
                tempB[3].setBlockY(b[0].getBlockY() + Block.SIZE);
            }           
            
        }
        updateXY(Direction.ROTATE);
    }

}
