package src;

/**
 * Implementation of backtracking algorithm.
 *
 * @author Zener
 * @version 1.0
 */
public class Backtracking {
    /**
     * The Capitan Jack Sparrow.
     */
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final CapitanJackSparrow jack;

    /**
     * The game field.
     */
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final int[][] field;

    /**
     * Path of the Capitan Jack Sparrow to win the game.
     */
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final char[][] path;

    /**
     * Standard constructor for Backtracking algorithm.
     *
     * @param scenario  scenario of the game.
     * @param gameField the game field.
     */
    public Backtracking(final int scenario, final int[][] gameField,
                        final char[][] path) {
        this.jack = new CapitanJackSparrow(scenario, gameField);
        this.field = gameField;
        this.path = path;
    }

    /**
     * One try to win the game using Backtracking algorithm.
     *
     * @return path of the Jack Sparrow if he won.
     * @throws GameLost if the game is lost by the Capitan Jack Sparrow.
     */
    @SuppressWarnings("unused")
    public char[][] analysis() {
//        throw new GameLost(); // When game is lost
        return path;
    }

    /**
     * 1 move in the game.
     */
    @SuppressWarnings("unused")
    private void move() {

    }

    /**
     * Analysis of one move in the game.
     *
     * @return true if we can continue the game, otherwise false.
     */
    @SuppressWarnings("unused")
    private boolean analysisOneMove() {
        return true;
    }

    /**
     * Back move.
     */
    @SuppressWarnings("unused")
    private void back() {

    }
}
