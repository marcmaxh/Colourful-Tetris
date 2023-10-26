package tetromino;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * Stars are elements that sometimes generate instead of tetrominos.
 * Only appear in colour mode.
 * Change the colour of the block they land on to their own.
 */
public class Star extends Tetromino {

    /**
     * Makes a 1-block tetromino to serve as the star.
     * Enables for implemented collision,etc.
     */
    public Star() {
        Colours blockColour = Colours.pickBlockColour();
        b[0] = new Block(blockColour);
        tempB[0] = new Block(blockColour);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(this.b[0].getColor());
        g2d.fill(createDefaultStar(Block.SIZE / 4,
            this.b[0].getBlockX() + 15, this.b[0].getBlockY() + 15));
    }

    private static Shape createDefaultStar(double radius, double centerX,
        double centerY) {
        return createStar(centerX, centerY, radius, radius * 2.63, 5,
            Math.toRadians(-18));
    }

    private static Shape createStar(double centerX, double centerY,
        double innerRadius, double outerRadius, int numRays,
        double startAngleRad) {
        Path2D path = new Path2D.Double();
        double deltaAngleRad = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++) {
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0) {
                relX *= outerRadius;
                relY *= outerRadius;
            } else {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0) {
                path.moveTo(centerX + relX, centerY + relY);
            } else {
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }

    @Override
    public void setXY(int x, int y) {
        b[0].setBlockX(x);
        b[0].setBlockY(y);
    }

    @Override
    public void rotate() {}
    
}
