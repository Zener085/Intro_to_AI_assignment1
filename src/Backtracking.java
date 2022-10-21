package src;

import java.util.ArrayList;

/**
 * Implementation of backtracking algorithm.
 * Not optimize well, very close to Brute-force algorithm.
 *
 * @author Zener
 * @version 1.0
 */
public class Backtracking {
    /**
     * if the Capitan Jack Sparrow already visited the Tortuga island.
     */
    private boolean withCommand = false;

    /**
     * The game field.
     */
    private final int[][] field;

    /**
     * Path of the Capitan Jack Sparrow to win the game.
     */
    private final char[][] path;

    /**
     * Standard constructor for Backtracking algorithm.
     *
     * @param gameField the game field.
     * @param gamePath path of the Capitan Jack Sparrow.
     */
    public Backtracking(final int[][] gameField,
                        final char[][] gamePath) {
        this.field = gameField;
        this.path = gamePath;
    }

    /**
     * One try to win the game using Backtracking algorithm.
     *
     * @return path of the Jack Sparrow if he won.
     * @throws GameLost if the game is lost by the Capitan Jack Sparrow.
     */
    public char[][] analysis() {
        int[] start = {0, 0};
        findPath(start);
        return path;
    }

    /**
     * Finds path to win.
     *
     * @param actualCell where the Capitan Jack Sparrow is now
     * @return 0 is nothing special happened, if we finished
     * @throws GameLost if the Capitan Jack Sparrow cannot move.
     */
    private int findPath(final int[] actualCell) throws GameLost {
        if (field[actualCell[0]][actualCell[1]]
                == GameNumbers.DEAD_MAN_CHEST_CELL) {
            return 1;
        }

        ArrayList<int[]> moves = whereToMove(actualCell);
        if (moves.size() == 0) {
            if (actualCell[0] == 0 && actualCell[1] == 0) {
                throw new GameLost();
            } else {
                back(actualCell);
                return 0;
            }
        }
        for (int[] move : moves) {
            move(move);
            if (field[move[0]][move[1]] == GameNumbers.TORTUGA_CELL) {
                withCommand = true;
            }
            if (findPath(move) == 1) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * The Capitan Jack Sparrow moves to another cell.
     *
     * @param cell a new cell for the Jack Sparrow
     */
    private void move(final int[] cell) {
        path[cell[0]][cell[1]] = GameNumbers.VISITED;
    }

    /**
     * The Capitan Jack Sparrow moves back.
     *
     * @param cell cell where the Capitan Jack Sparrow is
     */
    private void back(final int[] cell) {
        path[cell[0]][cell[1]] = GameNumbers.UNVISITED;
    }

    /**
     * Collect all possible cells to next move.
     *
     * @param cell cell of the Capitan Jack Sparrow (current move)
     * @return list of cells, where the Capitan Jack Sparrow can move to
     */
    private ArrayList<int[]> whereToMove(final int[] cell) {
        ArrayList<int[]> variants = new ArrayList<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (cell[0] + x < 0
                        || cell[0] + x >= GameNumbers.FIELD_LENGTH
                        || cell[1] + y < 0
                        || cell[1] + y >= GameNumbers.FIELD_LENGTH) {
                    continue;
                }
                int zone = field[cell[0] + x][cell[1] + y];
                char newCell = path[cell[0] + x][cell[1] + y];
                if (zone != GameNumbers.DANGER_ZONE
                        && zone != GameNumbers.DAVY_JONES_CELL
                        && zone != GameNumbers.KRAKEN_CELL
                        && zone != GameNumbers.ROCK_CELL
                        && newCell != GameNumbers.VISITED) {
                    int[] variant = new int[2];
                    variant[0] = cell[0] + x;
                    variant[1] = cell[1] + y;
                    variants.add(variant);
                }
            }
        }

        return variants;
    }
}
