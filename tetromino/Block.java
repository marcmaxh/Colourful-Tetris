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
     * Constructor for a block with a randomised colour.
     */
    public Block(Colours color) {
        switch (color) {
            case R:
                this.color = Color.RED;
                break;
            case G:
                this.color = Color.GREEN;
                break;
            case B:
                this.color = Color.BLUE;
                break;
            case Y:
                this.color = Color.YELLOW;
                break;
            default:
                break;
        }
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

    @Override
    public boolean equals(Object blockObject) {
        if (blockObject.getClass() == Block.class) {
            if (this.x == ((Block) blockObject).getBlockX()
                && this.y == ((Block) blockObject).getBlockY()) {
                return true;
            }
        }
        return false;
    }
}
