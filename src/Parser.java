/**
 * Implementation of class Parser, which has to parse the data from string form to coordinates form.
 */
package src;

/**
 * Class for parsing coordinates in string form.
 * Enters all characters to the field with their danger zone if it exists.
 *
 * @author Zener
 * @version 1.0
 */
public class Parser {
    /**
     * Main field of the game.
     */
    private final int[][] field;

    /**
     * Coordinates of characters of game.
     */
    private final String[] stringCoordinates;

    /**
     * Standard constructor for Parser.
     * It imports field and coordinates in string format.
     *
     * @param gameField the field of the game
     * @param gameStringCoordinates the coordinates of game's characters
     */
    public Parser(final int[][] gameField, final String[] gameStringCoordinates) {
        this.field = gameField;
        this.stringCoordinates = gameStringCoordinates;
    }

    /**
     * Parses all coordinates to put characters to the game's field.
     */
    public void parseCoordinates() {
        field[0][0] = GameNumbers.THE_CAPITAN_JACK_SPARROW_CELL; // the Capitan Jack Sparrow
        String coordinatesDavyJones = stringCoordinates[1];
        parseDavyJonesCoordinates(coordinatesDavyJones);

        String coordinatesKraken = stringCoordinates[2];
        parseKrakenCoordinates(coordinatesKraken);

        String coordinatesRock = stringCoordinates[3];
        parseRockCoordinates(coordinatesRock);

        String coordinatesDeadManChest = stringCoordinates[4];
        parseDeadManChestCoordinates(coordinatesDeadManChest);

        String coordinatesTortuga = stringCoordinates[5];
        parseTortugaCoordinates(coordinatesTortuga);
    }

    /**
     * Parses coordinates of Davy Jones to put him to the game's field.
     *
     * @param coordinatesDavyJones coordinates of Davy Jones, string form
     */
    private void parseDavyJonesCoordinates(final String coordinatesDavyJones) {
        int x, y;
        x = Integer.parseInt(String.valueOf(coordinatesDavyJones.charAt(1)));
        y = Integer.parseInt(String.valueOf(coordinatesDavyJones.charAt(3)));

        field[x][y] = GameNumbers.DAVY_JONES_CELL;

        // Define Moore neighborhood
        if (x > 0) {
            field[x - 1][y] = GameNumbers.DANGER_ZONE;
        }
        if (x < 8) {
            field[x + 1][y] = GameNumbers.DANGER_ZONE;
        }
        if (y > 0) {
            field[x][y - 1] = GameNumbers.DANGER_ZONE;
        }
        if (y < 8) {
            field[x][y + 1] = GameNumbers.DANGER_ZONE;
        }
        if (x > 0 && y > 0) {
            field[x - 1][y - 1] = GameNumbers.DANGER_ZONE;
        }
        if (x < 8 && y > 0) {
            field[x + 1][y - 1] = GameNumbers.DANGER_ZONE;
        }
        if (x > 0 && y < 8) {
            field[x - 1][y + 1] = GameNumbers.DANGER_ZONE;
        }
        if (x < 8 && y < 8) {
            field[x + 1][y + 1] = GameNumbers.DANGER_ZONE;
        }
    }

    /**
     * Parses coordinates of Kraken to put him to the game's field.
     *
     * @param coordinatesKraken coordinates of Kraken, string form
     */
    private void parseKrakenCoordinates(final String coordinatesKraken) {
        int x, y;
        x = Integer.parseInt(String.valueOf(coordinatesKraken.charAt(1)));
        y = Integer.parseInt(String.valueOf(coordinatesKraken.charAt(3)));

        field[x][y] = GameNumbers.KRAKEN_CELL;

        // Define von Neumann neighborhood
        if (x > 0) {
            field[x - 1][y] = GameNumbers.DANGER_ZONE;
        }
        if (x < 8) {
            field[x + 1][y] = GameNumbers.DANGER_ZONE;
        }
        if (y > 0) {
            field[x][y - 1] = GameNumbers.DANGER_ZONE;
        }
        if (y < 8) {
            field[x][y + 1] = GameNumbers.DANGER_ZONE;
        }
    }

    /**
     * Parses coordinates of Rock to put it to the game's field.
     *
     * @param coordinatesRock coordinates of Rock, string form
     */
    private void parseRockCoordinates(final String coordinatesRock) {
        int x, y;
        x = Integer.parseInt(String.valueOf(coordinatesRock.charAt(1)));
        y = Integer.parseInt(String.valueOf(coordinatesRock.charAt(3)));

        field[x][y] = GameNumbers.ROCK_CELL;
    }

    /**
     * Parses coordinates of Dead Man's Chest to put it to the game's field.
     *
     * @param coordinatesDeadManChest coordinates of Dead Man's Chest, string form
     */
    private void parseDeadManChestCoordinates(final String coordinatesDeadManChest) {
        int x, y;
        x = Integer.parseInt(String.valueOf(coordinatesDeadManChest.charAt(1)));
        y = Integer.parseInt(String.valueOf(coordinatesDeadManChest.charAt(3)));

        field[x][y] = GameNumbers.DEAD_MAN_CHEST_CELL;
    }

    /**
     * Parses coordinates of Tortuga to put it to the game's field.
     *
     * @param coordinatesTortuga coordinates of Tortuga, string form
     */
    private void parseTortugaCoordinates(final String coordinatesTortuga) {
        int x, y;
        x = Integer.parseInt(String.valueOf(coordinatesTortuga.charAt(1)));
        y = Integer.parseInt(String.valueOf(coordinatesTortuga.charAt(3)));

        field[x][y] = GameNumbers.TORTUGA_CELL;
    }
}
