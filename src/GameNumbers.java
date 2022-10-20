package src;

/**
 * Class, which provides magic numbers for characters
 * and objects in the game field.
 *
 * @author Zener
 * @version 1.0
 */
public final class GameNumbers {
    /**
     * Cell with nothing inside.
     */
    @SuppressWarnings("unused")
    public static final int EMPTY_CELL = 0;

    /**
     * Cell, which is near Davy Jones or Kraken.
     */
    public static final int DANGER_ZONE = 1;

    /**
     * Cell of Davy Jones.
     */
    public static final int DAVY_JONES_CELL = 2;

    /**
     * Cell of Kraken.
     */
    public static final int KRAKEN_CELL = 3;

    /**
     * Cell of Rock.
     */
    public static final int ROCK_CELL = 4;

    /**
     * Cell of Dead Man's Chest.
     */
    public static final int DEAD_MAN_CHEST_CELL = 5;

    /**
     * Cell of Tortuga island.
     */
    public static final int TORTUGA_CELL = 6;

    /**
     * Cell of the Capitan Jack Sparrow.
     */
    public static final int THE_CAPITAN_JACK_SPARROW_CELL = 7;

    /**
     * Length of the game field.
     */
    public static final int FIELD_LENGTH = 9;

    /**
     * Cell in the answer, which was unvisited.
     */
    public static final char UNVISITED = '-';

    /**
     * Cell in the answer, which was visited.
     */
    public static final char VISITED = '*';

    /**
     * Number of coordinates of the cell.
     */
    public static final int CELL_LENGTH = 2;

    /**
     * Default constructor.
     * It's never called.
     */
    private GameNumbers() {
        //not called
    }
}
