package tetromino;

import java.awt.*;

/**
 * Java class responsible for each individual block
 * that is part of a tetromino.
 */
public class Block extends Rectangle {
    private int x;
    private int y;
    public static final int SIZE = 30;
    private Color color;
    
    public Block(Color color) {
        this.color = color;
    }

    /**
     * Draws the block on the game display.
     */
    public void draw(Graphics2D g2d) {
        int margin = 2;
        g2d.setColor(color);
        g2d.fillRect(x + margin, y + margin, SIZE - (margin * 2), SIZE - (margin * 2));
    }

    public int getBlockX() {
        return x;
    }

    public void setBlockX(int x) {
        this.x = x;
    }

    public int getBlockY() {
        return y;
    }

    public void setBlockY(int y) {
        this.y = y;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
