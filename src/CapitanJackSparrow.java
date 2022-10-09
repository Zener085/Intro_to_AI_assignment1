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
    @SuppressWarnings("unused")
    private final int[] cell = {0, 0};

    /**
     * scenario of the Capitan Jack Sparrow, i.e. type of spyglass he has.
     */
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final int scenario;

    /**
     * Standard constructor for the Capitan Jack Sparrow.
     * @param gameScenario scenario of the game
     */
    @SuppressWarnings("unused")
    CapitanJackSparrow(final int gameScenario) {
        this.scenario = gameScenario;
    }
}
