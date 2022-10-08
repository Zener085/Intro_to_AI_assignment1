package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main class of the program. Creates whole game-process
 */
public class TimofeyDidenko {
    private int[][] field; // Main field
    private int scenario; // Scenario of the game
    private String[] stringCoordinates; // Coordinates of all entities, String type

    public static void main(String[] args) {
        TimofeyDidenko game = new TimofeyDidenko();
        game.startGame();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(game.field[i][j]);
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

    /**
     * Starts game, measures time for completing and
     */
    public void startGame() {
        field = new int[9][9];
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
