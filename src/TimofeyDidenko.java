/**
 * Main file of the program - starts game, using input.txt file and print if the Capitan Jack Sparrow lost or won.
 */
package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main class of the program. Creates whole game-process
 *
 * @author Zener
 * @version 1.0
 */
public class TimofeyDidenko {
    /**
     * Main field for the game
     */
    private int[][] field;

    /**
     * Scenario of the game
     */
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private int scenario;

    /**
     * Coordinates of all entities
     */
    private String[] stringCoordinates;

    public static void main(String[] args) {
        TimofeyDidenko game = new TimofeyDidenko();
        game.startGame();
        for (int i = 0; i < GameNumbers.FIELD_LENGTH; i++) {
            for (int j = 0; j < GameNumbers.FIELD_LENGTH; j++) {
                System.out.print(game.field[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    /**
     * Starts game, measures time for completing and
     */
    public void startGame() {
        field = new int[GameNumbers.FIELD_LENGTH][GameNumbers.FIELD_LENGTH];
        loadData();
    }

    /**
     * Loads field for the game
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
