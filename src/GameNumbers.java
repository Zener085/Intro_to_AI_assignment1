package src;

/**
 * Class, which provides magic numbers for characters
 * and objects in the game field.
 *
 * @author Zener
 * @version 1.0
 */
public class GameNumbers {
    /**
     * cell with nothing inside.
     */
    @SuppressWarnings("unused")
    public static final int EMPTY_CELL = 0;

    /**
     * cell, which is near Davy Jones or Kraken.
     */
    public static final int DANGER_ZONE = 1;

    /**
     * cell of Davy Jones.
     */
    public static final int DAVY_JONES_CELL = 2;

    /**
     * cell of Kraken.
     */
    public static final int KRAKEN_CELL = 3;

    /**
     * cell of Rock.
     */
    public static final int ROCK_CELL = 4;

    /**
     * cell of Dead Man's Chest.
     */
    public static final int DEAD_MAN_CHEST_CELL = 5;

    /**
     * cell of Tortuga island.
     */
    public static final int TORTUGA_CELL = 6;

    /**
     * cell of the Capitan Jack Sparrow.
     */
    public static final int THE_CAPITAN_JACK_SPARROW_CELL = 7;

    /**
     * length of the game field.
     */
    public static final int FIELD_LENGTH = 9;
}
