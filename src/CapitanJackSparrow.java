package src;

/**
 * Main actor - the Capitan Jack Sparrow.
 *
 * @author Zener
 * @version 1.0
 */
public class CapitanJackSparrow {
    /**
     * Initial cell, where the Capitan Jack Sparrow starts.
     */
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final int[] cell = {0, 0};

    /**
     * The game field.
     */
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final int[][] field;

    /**
     * Known field for Jack Sparrow.
     */
    @SuppressWarnings("FieldCanBeLocal")
    private final int[][] knownField;

    /**
     * scenario of the Capitan Jack Sparrow, i.e. type of spyglass he has.
     */
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final int scenario;

    /**
     * Standard constructor for the Capitan Jack Sparrow.
     *
     * @param gameScenario scenario of the game
     */
    @SuppressWarnings("unused")
    CapitanJackSparrow(final int gameScenario, final int[][] gameField) {
        this.scenario = gameScenario;
        this.field = gameField;
        this.knownField =
                new int[GameNumbers.FIELD_LENGTH][GameNumbers.FIELD_LENGTH];
        this.knownField[cell[0]][cell[1]] =
                GameNumbers.THE_CAPITAN_JACK_SPARROW_CELL;
    }


}
