package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Class for creating tests for the game.
 *
 * @author Zener
 * @version 1.0
 */
public class Test {
    /**
     * Object for generating random numbers.
     */
    private final Random random = new Random();

    /**
     * the Capitan Jack Sparrow's cell.
     */
    private final int[] jack;

    /**
     * Davy Jones' cell.
     */
    private final int[] davy;

    /**
     * Kraken's cell.
     */
    private final int[] kraken;

    /**
     * Rock's cell.
     */
    private final int[] rock;

    /**
     * Dead man's chest's cell.
     */
    private final int[] chest;

    /**
     * Tortuga's cell.
     */
    private final int[] tortuga;

    /**
     * Standard constructor.
     * There are initializations of all cells for whole characters.
     */
    public Test() {
        jack = new int[2];
        davy = new int[2];
        kraken = new int[2];
        rock = new int[2];
        chest = new int[2];
        tortuga = new int[2];
    }

    /**
     * Generates test for the game.
     * It generates field for the game.
     *
     * @param scenario scenario of the game, i.e. what type of spyglass
     *                 the Capitan Jack Sparrow will use.
     */
    public void generateTest(final int scenario) {
        generateCells();
        createInputFile(scenario);
    }

    /**
     * Creates input file and sends to it all coordinates and scenario.
     *
     * @param scenario scenario of the game
     */
    private void createInputFile(final int scenario) {
        BufferedWriter writer;
        FileWriter file;
        try {
            file = new FileWriter("src/input.txt");
            writer = new BufferedWriter(file);
            printCell(writer, jack);
            printCell(writer, davy);
            printCell(writer, kraken);
            printCell(writer, rock);
            printCell(writer, chest);
            printCell(writer, tortuga);
            writer.append("\n").append(String.valueOf(scenario));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints character's cell.
     *
     * @param writer    writer object
     * @param character one character
     * @throws IOException if it's not allowed to write to the file
     */
    private void printCell(final BufferedWriter writer, final int[] character)
            throws IOException {
        writer.append('[');
        writer.append(String.valueOf(character[0]));
        writer.append(',');
        writer.append(String.valueOf(character[GameNumbers.CELL_LENGTH - 1]));
        writer.append("] ");
    }

    /**
     * Generates cells for every character.
     */
    private void generateCells() {
        generateTheCapitanJackSparrowsCell();
        generateDavyJonesCell();
        generateKrakenCell();
        generateRockCell();
        generateDeadMansChestCell();
        generateTortugaCell();
    }

    /**
     * Generates the Capitan Jack Sparrow's cell.
     */
    private void generateTheCapitanJackSparrowsCell() {
        jack[0] = 0;
        jack[GameNumbers.CELL_LENGTH - 1] = 0;
    }

    /**
     * Generates cell for Davy Jones.
     */
    private void generateDavyJonesCell() {
        generateCell(davy);
        if (ifDavyJonesNearTheCapitanJackSparrow()) {
            generateDavyJonesCell();
        }
    }

    /**
     * Checks if Davy Jones' cell is generated with the Capitan Jack Sparrow.
     *
     * @return true if Davy Jones and the Capitan Jack Sparrow are in the same
     * cell, otherwise returns false.
     */
    private boolean ifDavyJonesNearTheCapitanJackSparrow() {
        return davy[0] == 0 && davy[GameNumbers.CELL_LENGTH - 1] == 0;
    }

    /**
     * Generates cell for Kraken.
     */
    private void generateKrakenCell() {
        generateCell(kraken);
        if (ifKrakenNearDavyJonesOrTheCapitanJackSparrow()) {
            generateKrakenCell();
        }
    }

    /**
     * Checks if Kraken is in the same cell with Davy Jones
     * or the Capitan Jack Sparrow.
     *
     * @return true if Kraken intersects Davy Jones
     * or the Capitan Jack Sparrow, otherwise returns false.
     */
    private boolean ifKrakenNearDavyJonesOrTheCapitanJackSparrow() {
        return (kraken[0] == davy[0]
                && kraken[GameNumbers.CELL_LENGTH - 1]
                == davy[GameNumbers.CELL_LENGTH - 1])
                || (kraken[0] == jack[0]
                && kraken[GameNumbers.CELL_LENGTH - 1]
                == jack[GameNumbers.CELL_LENGTH - 1]);
    }

    /**
     * Generates cell for Rock.
     */
    private void generateRockCell() {
        generateCell(rock);
        if (ifRockNearDavyJonesOrTheCapitanJackSparrow()) {
            generateRockCell();
        }
    }

    /**
     * Checks if Rock is in the same cell with Davy Jones
     * or the Capitan Jack Sparrow.
     *
     * @return true if Rock intersects Davy Jones
     * or the Capitan Jack Sparrow, otherwise false.
     */
    private boolean ifRockNearDavyJonesOrTheCapitanJackSparrow() {
        return (rock[0] == davy[0]
                && rock[GameNumbers.CELL_LENGTH - 1]
                == davy[GameNumbers.CELL_LENGTH - 1])
                || (rock[0] == jack[0]
                && rock[GameNumbers.CELL_LENGTH - 1]
                == jack[GameNumbers.CELL_LENGTH - 1]);
    }

    /**
     * Generates cell for Dead Man's Chest.
     */
    private void generateDeadMansChestCell() {
        generateCell(chest);
        if (
        ifDeadManChestOrTortugaNearRockKrakenDavyJonesTheCapitanJackSparrow(
                        chest)) {
            generateDeadMansChestCell();
        }
    }

    /**
     * Generates cell for Tortuga island.
     */
    private void generateTortugaCell() {
        generateCell(tortuga);
        if (
        ifDeadManChestOrTortugaNearRockKrakenDavyJonesTheCapitanJackSparrow(
                        tortuga)
        ) {
            generateTortugaCell();
        }
    }

    /**
     * Checks if Dead Man's Chest or Tortuga is in the same cell
     * with Davy Jones, Kraken, Rock or the Capitan Jack Sparrow.
     *
     * @param character Dead Man's Chest or Tortuga
     * @return true if the chest intersects Davy Jones or it's danger zone,
     * Kraken or it's danger zone, Rock or the Capitan Jack Sparrow.
     */
    private boolean
    ifDeadManChestOrTortugaNearRockKrakenDavyJonesTheCapitanJackSparrow(
            final int[] character) {
        // the Capitan Jack Sparrow
        if (character[0] == jack[0]
                && character[GameNumbers.CELL_LENGTH - 1]
                == jack[GameNumbers.CELL_LENGTH - 1]) {
            return true;
        }
        // Rock
        else if (character[0] == rock[0]
                && character[GameNumbers.CELL_LENGTH - 1]
                == rock[GameNumbers.CELL_LENGTH - 1]) {
            return true;
        }
        // Kraken and it's danger zone
        else if (character[0] == kraken[0]
                && kraken[GameNumbers.CELL_LENGTH - 1] - 1
                <= character[GameNumbers.CELL_LENGTH - 1]
                && character[GameNumbers.CELL_LENGTH - 1]
                <= kraken[GameNumbers.CELL_LENGTH - 1] + 1) {
            return true;
        } else if (character[GameNumbers.CELL_LENGTH - 1]
                == kraken[GameNumbers.CELL_LENGTH - 1]
                && kraken[0] - 1 <= character[0]
                && character[0] <= kraken[0] + 1) {
            return true;
        }
        // Davy Jones and it's danger zone
        else {
            return davy[0] - 1 <= character[0] && character[0] <= davy[0] + 1
                    && davy[GameNumbers.CELL_LENGTH - 1] - 1
                    <= character[GameNumbers.CELL_LENGTH - 1]
                    && character[GameNumbers.CELL_LENGTH - 1]
                    <= davy[GameNumbers.CELL_LENGTH - 1] + 1;
        }
    }

    /**
     * Generates cell for one character.
     *
     * @param character one of whole characters.
     */
    private void generateCell(final int[] character) {
        character[0] = random.nextInt(GameNumbers.FIELD_LENGTH);
        character[GameNumbers.CELL_LENGTH - 1]
                = random.nextInt(GameNumbers.FIELD_LENGTH);
    }
}
