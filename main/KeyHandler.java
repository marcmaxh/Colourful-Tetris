package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class implements the KeyListener interface and handles key events for the game.
 */
public class KeyHandler implements KeyListener {

    /**
     * Boolean variables to keep track of whether certain keys are pressed.
     */
    public static boolean rotatePressed;
    public static boolean downPressed;
    public static boolean leftPressed;
    public static boolean rightPressed;
    public static boolean pausePressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            rotatePressed = true;
        }

        if (code == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_DOWN) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }

        if (code == KeyEvent.VK_SPACE) {
            if (pausePressed) {
                pausePressed = false;
            } else {
                pausePressed = true;
            }
        }

        if (code == KeyEvent.VK_W) {
            rotatePressed = true;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = true;
        }

        if (code == KeyEvent.VK_P) {
            if (pausePressed) {
                pausePressed = false;
            } else {
                pausePressed = true;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
