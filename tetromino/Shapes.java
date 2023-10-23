package tetromino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Enum of all the tetromino shapes to allow for easier
 * randomization when generating shapes.
 */
public enum Shapes {
    I,
    J,
    L,
    O,
    S,
    T,
    Z;

    private static final ArrayList<Shapes> VALUES =
             (ArrayList<Shapes>) (Collections.unmodifiableList(Arrays.asList(values())));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    /**
     * Randomly picks a tetromino shape from an enum
     * of all existing possibilities.
     */
    public static Shapes pickTetrominoShape() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
