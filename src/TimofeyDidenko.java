package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Main class of the program. Creates whole game-process.
 *
 * @author Zener
 * @version 1.0
 */
public class TimofeyDidenko {
    /**
     * Main field for the game.
     */
    private int[][] field;

    /**
     * Path of the game (if the game is won).
     */
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private char[][] path;

    /**
     * Scenario of the game.
     */
    private int scenario;

    /**
     * Coordinates of all entities.
     */
    private String[] stringCoordinates;

    /**
     * The Backtracking algorithm.
     */
    @SuppressWarnings("FieldCanBeLocal")
    private Backtracking backtracking;

    /**
     * Measure time of execution of work of 1 algorithm.
     */
    private long executionTime;

    /**
     * Single test of the game.
     *
     * @param args null list of arguments
     */
    public static void main(final String[] args) {
        Test test = new Test();
        TimofeyDidenko game = new TimofeyDidenko();
        long totalTime = 0;
        test.generateTest(1);
        game.startGame();
        totalTime += game.executionTime;
        for (int i = 0; i < GameNumbers.FIELD_LENGTH; i++) {
            for (int j = 0; j < GameNumbers.FIELD_LENGTH; j++) {
                System.out.print(game.field[i][j] + " ");
            }
            System.out.print('\n');
        }
        System.out.println(totalTime + " millis");
    }

    /**
     * Starts game.
     */
    public void startGame() {
        field = new int[GameNumbers.FIELD_LENGTH][GameNumbers.FIELD_LENGTH];
        path = new char[GameNumbers.FIELD_LENGTH][GameNumbers.FIELD_LENGTH];
        loadData();
        backtracking = new Backtracking(scenario, field, path);
        long start = System.nanoTime();
        try {
            path = backtracking.analysis();
            executionTime = System.nanoTime() - start;
            backtrackingWonGame();
        } catch (GameLost e) {
            executionTime = System.nanoTime() - start;
            backtrackingLostGame();
        }
    }

    /**
     * Loads field for the game.
     */
    private void loadData() {
        // taking scenario and coordinates from file
        BufferedReader reader;
        FileReader file;
        try {
            file = new FileReader("src/input.txt");
            reader = new BufferedReader(file);
            stringCoordinates = reader.readLine().split(" ");
            scenario = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Parsing coordinates
        Parser parser = new Parser(field, stringCoordinates);
        parser.parseCoordinates();
        // Preparing path matrix for the game
        for (int i = 0; i < GameNumbers.FIELD_LENGTH; i++) {
            for (int j = 0; j < GameNumbers.FIELD_LENGTH; j++) {
                path[i][j] = '-';
            }
        }
        path[0][0] = '*';
    }

    /**
     * Creates output file for the game using Backtracking algorithm.
     * Called only when the game is lost.
     */
    private void backtrackingLostGame() {
    }

    /**
     * Creates output file for the game using Backtracking algorithm.
     * Called only when the game is won.
     */
    private void backtrackingWonGame() {
        BufferedWriter writer;
        FileWriter file;
        try {
            file = new FileWriter("src/outputBacktracking.txt");
            writer = new BufferedWriter(file);
            writer.write("Win\n");
            countMoves(writer);
            printCells(writer);
            writer.append("-------------------\n");
            printPath(writer);
            writer.append("-------------------\n");
            writer.append(String.valueOf(executionTime)).append(" millis");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates output file for the game using A* algorithm.
     * Called only when the game is lost.
     */
    @SuppressWarnings("unused")
    private void aStartLostGame() {
    }

    /**
     * Creates output file for the game using A* algorithm.
     * Called only when the game is won.
     */
    @SuppressWarnings("unused")
    private void aStarWonGame() {
    }

    /**
     * Counts number of moves to win the game and prints that to the file.
     * @param writer objects, which prints to the output file.
     * @throws IOException raised if the file cannot be used to print
     */
    private void countMoves(final BufferedWriter writer) throws IOException {
        int moves = 0;
        for (int i = 0; i < GameNumbers.FIELD_LENGTH; i++) {
            for (int j = 0; j < GameNumbers.FIELD_LENGTH; j++) {
                if (path[i][j] == '*') {
                    moves += 1;
                }
            }
        }
        writer.append(String.valueOf(moves)).append('\n');
    }

    /**
     * Prints cells of characters in the start of the game.
     * @param writer object, which prints to the output file.
     * @throws IOException raised if the file is cannot be used to print.
     */
    private void printCells(final BufferedWriter writer) throws IOException {
        for (String cell : stringCoordinates) {
            writer.append(cell).append(" ");
        }
        writer.append('\n');
    }

    /**
     * Prints path to the output file.
     * @param writer object, which prints to the file.
     * @throws IOException raised if the file cannot be used to print.
     */
    private void printPath(final BufferedWriter writer) throws IOException {
        writer.append("  0 1 2 3 4 5 6 7 8\n");
        for (int i = 0; i < GameNumbers.FIELD_LENGTH; i++) {
            writer.append(String.valueOf(i));
            for (int j = 0; j < GameNumbers.FIELD_LENGTH; j++) {
                writer.append(" ").append(String.valueOf(path[i][j]));
            }
            writer.append('\n');
        }
    }
}
