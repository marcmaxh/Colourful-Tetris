package tetromino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Enum for the colours each block in a tetromino can have
 * in colourful mode.
 */
public enum Colours {
    R,
    G,
    B,
    Y;

    private static final ArrayList<Colours> VALUES =
             new ArrayList<Colours>(Collections.unmodifiableList(Arrays.asList(values())));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    /**
     * Randomly picks a block colour for colourful mode.
     */
    public static Colours pickBlockColour() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
