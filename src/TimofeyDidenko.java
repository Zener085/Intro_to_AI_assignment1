package src;

import java.io.BufferedReader;
import java.io.FileReader;
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
     * Field, which will be used for answer.
     */
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private char[][] path;

    /**
     * Scenario of the game.
     */
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private int scenario;

    /**
     * Coordinates of all entities.
     */
    private String[] stringCoordinates;

    /**
     * Single test of the game.
     * @param args null list of arguments
     */
    public static void main(final String[] args) {
        Test test = new Test();
        TimofeyDidenko game = new TimofeyDidenko();
        test.generateTest(1);
        game.startGame();
        for (int i = 0; i < GameNumbers.FIELD_LENGTH; i++) {
            for (int j = 0; j < GameNumbers.FIELD_LENGTH; j++) {
                System.out.print(game.field[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    /**
     * Starts game.
     */
    public void startGame() {
        field = new int[GameNumbers.FIELD_LENGTH][GameNumbers.FIELD_LENGTH];
        path = new char[GameNumbers.FIELD_LENGTH][GameNumbers.FIELD_LENGTH];
        loadData();
    }

    /**
     * Loads field for the game.
     */
    private void loadData() {
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
        Parser parser = new Parser(field, stringCoordinates);
        parser.parseCoordinates();
    }
}
