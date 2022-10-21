package src;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Implementation of the A* Algorithm for the game.
 *
 * @author Zener
 * @version 1.0
 */
public class AStar {
    /**
     * 1 cell in the field.
     */
    private final class Cell implements Comparable<Cell> {
        /**
         * Parent of the cell, i.e. where the Capitan Jack Sparrow came from.
         */
        private Cell parent;

        /**
         * What's in the cell.
         */
        private final int data;

        /**
         * A path from the initial position to the current node.
         */
        private int gN;

        /**
         * A path from the current node to the goal position.
         */
        private int hN;

        /**
         * Summary of hN and gN.
         */
        private final int fN;

        /**
         * Coordinates of the cell.
         */
        private final int[] coordinates = new int[2];

        /**
         * Standard constructor, translates parent of the cell
         * and it's coordinates.
         *
         * @param cellParent      parent of the cell
         * @param fieldData       data of the field, i.e. who is in the cell.
         * @param cellCoordinates coordinates of the cell
         * @param where           where the Capitan Jack Sparrow wants to move
         *                        - to the Tortuga island(1)
         *                        or to the Dead Man's Chest(0).
         */
        private Cell(final Cell cellParent, final int fieldData,
                     final int[] cellCoordinates,
                     final int where) {
            this.parent = cellParent;
            this.data = fieldData;
            this.coordinates[0] = cellCoordinates[0];
            this.coordinates[1] = cellCoordinates[1];
            setGN();
            setHN(where);
            fN = gN + hN;
        }

        /**
         * Sets the value for the gN.
         */
        private void setGN() {
            if (parent == null) {
                gN = 0;
            } else {
                gN = parent.gN + 1;
            }
        }

        /**
         * Sets the value for the hN.
         *
         * @param where where the Capitan Jack Sparrow wants to move.
         */
        private void setHN(final int where) {
            int x;
            int y;
            if (where == 0) {
                x = Math.abs(coordinates[0] - deadMansChest[0]);
                y = Math.abs(coordinates[1] - deadMansChest[1]);
            } else {
                x = Math.abs(coordinates[0] - tortuga[0]);
                y = Math.abs(coordinates[1] - tortuga[1]);
            }

            hN = Math.max(x, y);
        }

        /**
         * Compares this object with the specified object for order.  Returns a
         * negative integer, zero, or a positive integer as this object is less
         * than, equal to, or greater than the specified object.
         *
         * @param other the object to be compared.
         * @return a negative integer, zero, or a positive integer
         * as this object
         * is less than, equal to, or greater than the specified object.
         * @throws NullPointerException if the specified object is null
         * @throws ClassCastException   if the specified
         *                              object's type prevents it
         */
        @Override
        public int compareTo(final Cell other) {
            if (this.fN < other.fN) {
                return -1;
            }

            if (this.hN < other.hN) {
                return -1;
            }

            if (this.gN < other.gN) {
                return -1;
            }

            if (this.fN == other.fN && this.hN == other.hN
                    && this.gN == other.gN) {
                return 0;
            }

            return 1;
        }
    }

    /**
     * Scenario of the game.
     */
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final int scenario;

    /**
     * If the Capitan Jack Sparrow with command or not.
     */
    private boolean withCommand = false;

    /**
     * The game field.
     */
    private Cell[][] field;

    /**
     * Coordinates of the Dead Man's Chest.
     */
    private int[] deadMansChest;

    /**
     * Coordinates of the Tortuga island.
     */
    private int[] tortuga;

    /**
     * Set of the visited cells.
     */
    private final HashSet<Cell> cells = new HashSet<>();

    /**
     * Priority queue of cells the Capitan Jack Sparrow can move next.
     */
    private final PriorityQueue<Cell> nextCells = new PriorityQueue<>();

    /**
     * Standard constructor for the game.
     *
     * @param gameScenario scenario of the game.
     */
    public AStar(final int gameScenario) {
        this.scenario = gameScenario;
    }

    /**
     * Implementation of the field using Cell class.
     *
     * @param gameField field of the game.
     * @param where     where to go (to Tortuga or to the Chest)
     */
    private void implementField(final int[][] gameField, final int where) {
        field = new Cell[GameNumbers.FIELD_LENGTH][GameNumbers.FIELD_LENGTH];
        for (int x = 0; x < GameNumbers.FIELD_LENGTH; x++) {
            for (int y = 0; y < GameNumbers.FIELD_LENGTH; y++) {
                int[] coordinates = new int[2];
                coordinates[0] = x;
                coordinates[1] = y;
                field[x][y] =
                        new Cell(null, gameField[x][y], coordinates, where);
            }
        }
    }

    /**
     * Finds cell of the Dead Man's Chest.
     *
     * @param gameField field of the game.
     */
    private void findDeadManChest(final int[][] gameField) {
        for (int i = 0; i < GameNumbers.FIELD_LENGTH; i++) {
            for (int j = 0; j < GameNumbers.FIELD_LENGTH; j++) {
                if (gameField[i][j] == GameNumbers.DEAD_MAN_CHEST_CELL) {
                    deadMansChest = new int[2];
                    deadMansChest[0] = i;
                    deadMansChest[1] = j;
                    return;
                }
            }
        }
        throw new GameLost();
    }

    /**
     * Finds cell of Tortuga island.
     *
     * @param gameField field of the game.
     */
    private void findTortuga(final int[][] gameField) {
        for (int i = 0; i < GameNumbers.FIELD_LENGTH; i++) {
            for (int j = 0; j < GameNumbers.FIELD_LENGTH; j++) {
                if (gameField[i][j] == GameNumbers.TORTUGA_CELL) {
                    tortuga = new int[2];
                    tortuga[0] = i;
                    tortuga[1] = j;
                    return;
                }
            }
        }
    }

    /**
     * Analysis of the game using A* algorithm.
     *
     * @param gameField the game field.
     * @return path from the start to the Dead Man's Chest.
     */
    public char[][] analysis(final int[][] gameField) {
        findDeadManChest(gameField);
        findTortuga(gameField);
        implementField(gameField, 0);
        int[] startCell = {0, 0};
        Cell start = new Cell(null, GameNumbers.THE_CAPITAN_JACK_SPARROW_CELL,
                startCell, 0);
        nextCells.add(start);

        while (!nextCells.isEmpty()) {
            move();
        }

        if (!cells.contains(field[deadMansChest[0]][deadMansChest[1]])) {
            throw new GameLost();
        }

        char[][] path =
                new char[GameNumbers.FIELD_LENGTH][GameNumbers.FIELD_LENGTH];
        createPath(path);
        return path;
    }

    /**
     * One move of the Capitan Jack Sparrow.
     */
    private void move() {
        Cell cell = nextCells.poll();
        cells.add(cell);
        if (cell.data == GameNumbers.DEAD_MAN_CHEST_CELL) {
            nextCells.clear();
            return;
        }
        if (cell.data == GameNumbers.TORTUGA_CELL) {
            withCommand = true;
            if (cell.hN == 0) {
                int[][] simpleField = new int[GameNumbers.FIELD_LENGTH]
                        [GameNumbers.FIELD_LENGTH];
                for (int i = 0; i < GameNumbers.FIELD_LENGTH; i++) {
                    for (int j = 0; j < GameNumbers.FIELD_LENGTH; j++) {
                        simpleField[i][j] = field[i][j].data;
                    }
                }
                implementField(simpleField, 0);
                nextCells.clear();
            }
        }
        newCells(cell);
    }

    /**
     * Adds new cells to move to the priority queue.
     *
     * @param cell current cell where the Capitan Jack Sparrow is.
     */
    private void newCells(final Cell cell) {
        int[] coordinates = cell.coordinates;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (coordinates[0] + x < 0
                        || coordinates[0] + x >= GameNumbers.FIELD_LENGTH
                        || coordinates[1] + y < 0
                        || coordinates[1] + y >= GameNumbers.FIELD_LENGTH) {
                    continue;
                }

                Cell next = field[coordinates[0] + x][coordinates[1] + y];
                if (cells.contains(next)) {
                    if (cell.gN + 1 < next.gN || next.parent == null) {
                        next.parent = cell;
                        next.setGN();
                    }
                    continue;
                }
                int data = next.data;
                if (data != GameNumbers.DANGER_ZONE
                        && data != GameNumbers.DAVY_JONES_CELL
                        && data != GameNumbers.ROCK_CELL) {
                    if (data == GameNumbers.KRAKEN_CELL) {
                        if (withCommand) {
                            if (!nextCells.contains(next)) {
                                next.parent = cell;
                                nextCells.add(next);
                            }
                        }
                        continue;
                    }
                    next.parent = cell;
                    nextCells.add(next);
                }
            }
        }
    }

    /**
     * Translate path to the matrix to provide the answer.
     *
     * @param path path of the Capitan Jack Sparrow to the Dead Man's Chest.
     */
    private void createPath(final char[][] path) {
        Cell cell = field[deadMansChest[0]][deadMansChest[1]];

        for (int x = 0; x < GameNumbers.FIELD_LENGTH; x++) {
            for (int y = 0; y < GameNumbers.FIELD_LENGTH; y++) {
                path[x][y] = '-';
            }
        }

        while (cell != null) {
            path[cell.coordinates[0]][cell.coordinates[1]] = '*';
            cell = cell.parent;
        }
    }
}
