package tetromino;

import java.awt.*;

public class Tetromino {

    public Block b[] = new Block[4];
    public Block tempB[] = new Block[4];

    public void create(Color color) {
        for (int i = 0; i < 4; i++) {
            b[i] = new Block(color);
        }

        for (int i = 0; i < 4; i++) {
            tempB[i] = new Block(color);
        }
    }

    public void SetXY(int x, int y) {
    }

    public void updateXY(int direction) {
    }

    public void update() {

    }

    public void draw(Graphics2D g2d) {

        g2d.setColor(b[0].color);
        g2d.fillRect(b[0].x, b[0].y, Block.size, Block.size);
        g2d.fillRect(b[1].x, b[1].y, Block.size, Block.size);
        g2d.fillRect(b[2].x, b[2].y, Block.size, Block.size);
        g2d.fillRect(b[3].x, b[3].y, Block.size, Block.size);

    }
}