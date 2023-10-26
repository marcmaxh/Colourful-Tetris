package main;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import tetromino.*;

/**
 * The PlayManager class manages the game play area, tetrominoes, and game
 * updates.
 */
public class PlayManager {

    // Main play area
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    // Tetromino
    Tetromino currentTetromino;
    final int tetrominoStartX;
    final int tetrominoStartY;
    Tetromino nexTetromino;
    final int nextTetrominoStartX;
    final int nextTetrominoStartY;
    public static ArrayList<Block> staticBlocks = new ArrayList<>();

    // Settings
    public static int dropInterval; //fps
    File settingsFile = new File("main\\save_files\\settings.txt");
    private boolean isCoulorfulMode = isColourful();
    private boolean isNightmareDifficulty = isNightmare();

    //Score
    public static int score = 0;
    public static int level = 1;
    public static int lines = 0;

    /**
     * Constructor for PlayManager class.
     * Initializes the playable board and sets the starting position of the current
     * tetromino.
     */
    public PlayManager() {

        // Set playable board
        left_x = (GamePanel.WIDTH / 2) - (WIDTH / 2);
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;

        // Set starting position of the current Tetromino
        tetrominoStartX = left_x + (WIDTH / 2) - (Block.SIZE);
        tetrominoStartY = top_y + (Block.SIZE);

        // Set next Tetromino position
        nextTetrominoStartX = right_x + 178;
        nextTetrominoStartY = top_y + 500;

        // Initialize the first Tetromino
        currentTetromino = pickTetromino();
        currentTetromino.setXY(tetrominoStartX, tetrominoStartY);

        // Initialize the next Tetromino
        nexTetromino = pickTetromino();
        nexTetromino.setXY(nextTetrominoStartX, nextTetrominoStartY);

        //Set speed
        dropInterval = calculateSpeed();
    }

    /**
     * Calculates the drop speed of the game
     * based on the saved settings.
     */
    private int calculateSpeed() {
        int speedSetting;
        try {
            BufferedReader savedSettings = new BufferedReader((new FileReader(settingsFile)));
            speedSetting = Integer.parseInt(savedSettings.readLine());
            savedSettings.close();
        } catch (Exception e) {
            e.printStackTrace();
            speedSetting = 5;
        }

        int speed;

        if (11 - speedSetting + level > 10) {
            speed = 10;
        } else {
            speed = 11 - speedSetting + level;
        }

        //default is 5 for 60 fps
        return (speed) * 12;
    }

    private boolean isNightmare() {
        int setting;
        try {
            BufferedReader savedSettings = new BufferedReader((new FileReader(settingsFile)));
            savedSettings.readLine();
            savedSettings.readLine();
            setting = Integer.parseInt(savedSettings.readLine());
            savedSettings.close();
        } catch (Exception e) {
            e.printStackTrace();
            setting = 0;
        }

        return (setting == 1);
    }

    private boolean isColourful() {
        int setting;
        try {
            BufferedReader savedSettings = new BufferedReader((new FileReader(settingsFile)));
            savedSettings.readLine();
            setting = Integer.parseInt(savedSettings.readLine());
            savedSettings.close();
        } catch (Exception e) {
            e.printStackTrace();
            setting = 0;
        }

        return (setting == 1);
    }

    /**
     * Picks a random Tetromino shape to be used in the game.
     *
     * @return a Tetromino object representing the chosen shape.
     */
    private Tetromino pickTetromino() {

        // Pick a Random Tetromino
        int randNo = new Random().nextInt(7);

        switch (randNo) {
            case 0:
                return new TetrominoI();
            case 1:
                return new TetrominoJ();
            case 2:
                return new TetrominoL();
            case 3:
                return new TetrominoO();
            case 4:
                return new TetrominoS();
            case 5:
                return new TetrominoT();
            case 6:
                return new TetrominoZ();
            default:
                return null;
        }
    }

    /**
     * Updates the moving tetromino.
     */
    public void update() {

        // Check if the current Tetromino has collided with the bottom of the play area
        // (is active)
        if (!currentTetromino.active) {
            // Add the current Tetromino to the static blocks
            //it it is a tetromino
            if (currentTetromino.b[1] != null) {
                for (int i = 0; i < 4; i++) {
                    staticBlocks.add(currentTetromino.b[i]);
                }
                findRows(currentTetromino);    
            }
            //if we get a star with only 1 block
            //remove it

            currentTetromino.deactivating = false;

            // replace the currentTetromino with the nextTetromino
            currentTetromino = nexTetromino;
            currentTetromino.setXY(tetrominoStartX, tetrominoStartY);

            //if the game is in colourful mode
            //add the possibility of generating stars
            if (isCoulorfulMode) {
                Random random = new Random();
                //1 is for tetromino
                //2 is for a star
                int[] elementProbabilityC = {1, 1, 1, 1, 1, 1, 1, 2, 2, 2};
                int[] elementProbabilityN = {1, 1, 1, 1, 2, 2, 2, 2, 2, 2};

                int elementCode;

                if (isNightmareDifficulty) {
                    elementCode = elementProbabilityN[random.nextInt(elementProbabilityN.length)];
                } else {
                    elementCode = elementProbabilityC[random.nextInt(elementProbabilityC.length)];
                }

                // pick a new nextTetromino
                if (elementCode == 1) {
                    nexTetromino = pickTetromino();
                } else {
                    nexTetromino = new Star();
                }
            } else {
                nexTetromino = pickTetromino();
            }

            //set next tetromino
            nexTetromino.setXY(nextTetrominoStartX, nextTetrominoStartY);
        } else {

            currentTetromino.update();
        }

    }

    /**
     * Draws the game.
     */
    public void draw(Graphics2D g2d) {

        // Draw main play area frame
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(4f));
        g2d.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8);

        // Draw next tetromino frame
        int x = right_x + 100;
        int y = bottom_y - 200;
        g2d.drawRect(x, y, 200, 200);
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 30));
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.drawString("NEXT", x + 60, y + 60);

        // Draw score frame
        g2d.drawRect(x, top_y, 300, 300);
        x += 40;
        y = top_y + 90;
        g2d.drawString("LEVEL: " + (level - 1), x, y);
        y += 70;
        g2d.drawString("LINES: " + lines, x, y);
        y += 70;
        g2d.drawString("SCORE: " + score, x, y);

        // Draw the current Tetromino
        if (currentTetromino != null) {
            currentTetromino.draw(g2d);
        }

        // Draw the next Tetromino
        nexTetromino.draw(g2d);

        // Draw the static blocks
        for (Block b : staticBlocks) {
            b.draw(g2d);
        }
        

        // Draw Pause menu

        g2d.setColor(Color.white);
        g2d.setFont(g2d.getFont().deriveFont(50f));
        if (KeyHandler.pausePressed) {
            g2d.drawString("PAUSED", left_x + 85, top_y + 300);
        }

    }

    /**
     * Looks for completed rows.
     * Then removes them and updates what is remaining.
     */
    private void findRows(Tetromino tetromino) {
        //amount of blocks in a given affected row
        int yBlocks = 0;
        ArrayList<Integer> removedRows = new ArrayList<Integer>();
        
        for (int i = 0; i < 4; i++) {
            for (Block b : staticBlocks) {
                if (tetromino.b[i].getBlockY() == b.getBlockY()) {
                    yBlocks++;
                }
            }
            if (yBlocks == 12) {
                if (tetromino.b[i] != null
                    && removeRow(tetromino.b[i].getBlockY())) {
                    removedRows.add(tetromino.b[i].getBlockY());
                }
            }
            yBlocks = 0;
        }

        // Add score for removed rows
        if (removedRows.size() > 0) {
            //add up score
            if (removedRows.size() == 1) {
                score += 40 * (level);
            }
            if (removedRows.size() == 2) {
                score += 100 * (level);
            }
            if (removedRows.size() == 3) {
                score += 300 * (level);
            }
            if (removedRows.size() == 4) {
                score += 1200 * (level);
            }

            updateRows(removedRows);
        }
    }

    /**
     * Removes a single given row at a set y level.
     * Adds bonuses to the score.
     * Adjusts for nightmare difficulty.
     */
    private boolean removeRow(int y) {

        // add 1 to lines to display on scoreboard
        lines++;

        if (lines % 10 == 0) {
            level++;
        }

        //getting all blocks in the row
        ArrayList<Block> row = new ArrayList<Block>(10);
        for (Block b : staticBlocks) {
            if (b.getBlockY() == y) {
                row.add(b);
            }
        }
        
        //sorting row so that the blocks are read consecutively
        //relative to how they are placed on the screen
        Collections.sort(row, new Comparator<Block>() {
            public int compare(Block b1, Block b2) {
                return b1.getBlockX() - b2.getBlockX();
            }
        });

        //manage scores for diffent modes
        boolean fullRow = false;
        int comboSize = 1;

        if (isCoulorfulMode) {
            Color comboColor = row.get(0).getColor();
            if (isNightmareDifficulty) {
                for (Block b : row) {
                    if (comboColor != b.getColor()) {
                        return false;
                    }
                }
                fullRow = true;
            }
            //add bonus scores for colour combos
            if (fullRow) {
                //add big bonus for full row of the same colour
                //in case we already have the data from nightmare difficulty
                score += 800 * level;
            } else {
                //add bonuses for 3, 6, 10 in a row

                for (int i = 1; i < 12; i++) {
                    Block b = row.get(i);
                    if (comboColor == b.getColor()) {
                        comboSize++;
                    } else {
                        if (comboSize >= 10) {
                            score += 500 * (level + 1);
                        } else {
                            if (comboSize >= 6) {
                                score += 300 * (level + 1);
                            } else {
                                if (comboSize >= 3) {
                                    score += 100 * (level + 1);
                                }
                            }
                        }
                        comboSize = 1;
                        comboColor = b.getColor();
                    }
                }
            }
        }
        //remove all the blocks in the row
        for (Block b : row) {
            staticBlocks.remove(b);
        }

        return true;
    }

    /**
     * Moves all the remaining rows above the removed ones down.
     */
    private void updateRows(ArrayList<Integer> removedRows) {
        //sorting by in descending order
        Collections.sort(removedRows);
        //moving down each block that is above each given removed row
        for (int i = 0; i < removedRows.size(); i++) {
            for (Block b : staticBlocks) {
                if (b.getBlockY() < removedRows.get(i)) {
                    b.setBlockY(b.getBlockY() + Block.SIZE);
                }
            }
        }
    }
}
