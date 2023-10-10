/**
 * The Tetris class represents the game of Tetris.
 */
public class Tetris {
    private Board board;
    private Tetromino shape;
    private boolean isGameOver;

    /**
     * Constructs a new Tetris game with a new board and a new piece.
     */
    public Tetris() {
        board = new Board();
        shape = new Tetromino();
        isGameOver = false;
    }

    /**
     * Starts the game loop, which prints the board and the current piece until the game is over.
     */
    public void startGame() {
        while (!isGameOver) {
            board.printBoard();
            shape.printTetromino();
        }
    }

    /**
     * The main method creates a new Tetris game and starts it.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        tetris.startGame();
    }
}