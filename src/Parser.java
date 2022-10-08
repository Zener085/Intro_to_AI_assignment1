package src;

/**
 * Class for parsing coordinates in string form
 * Enters all characters to the field with their danger zone if it exists
 */
public class Parser {
    private final int[][] field; // the game field
    private final String[] stringCoordinates; // string format of coordinates of characters of game

    /**
     * Standard constructor for Parser. It imports field and coordinates in string format
     *
     * @param field             the field of the game
     * @param stringCoordinates the coordinates of game's characters
     */
    public Parser(int[][] field, String[] stringCoordinates) {
        this.field = field;
        this.stringCoordinates = stringCoordinates;
    }

    /**
     * Parses all coordinates to put characters to the game's field
     */
    public void parseCoordinates() {
        field[0][0] = 7; // the Capitan Jack Sparrow
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
     * Parses coordinates of Davy Jones to put him to the game's field
     *
     * @param coordinatesDavyJones coordinates of Davy Jones, string form
     */
    private void parseDavyJonesCoordinates(String coordinatesDavyJones) {
        int x, y;
        x = Integer.parseInt(String.valueOf(coordinatesDavyJones.charAt(1)));
        y = Integer.parseInt(String.valueOf(coordinatesDavyJones.charAt(3)));

        field[x][y] = 2;

        // Define Moore neighborhood
        if (x > 0) field[x - 1][y] = 1;
        if (x < 8) field[x + 1][y] = 1;
        if (y > 0) field[x][y - 1] = 1;
        if (y < 8) field[x][y + 1] = 1;
        if (x > 0 && y > 0) field[x - 1][y - 1] = 1;
        if (x < 8 && y > 0) field[x + 1][y - 1] = 1;
        if (x > 0 && y < 8) field[x - 1][y + 1] = 1;
        if (x < 8 && y < 8) field[x + 1][y + 1] = 1;
    }

    /**
     * Parses coordinates of Kraken to put him to the game's field
     *
     * @param coordinatesKraken coordinates of Kraken, string form
     */
    private void parseKrakenCoordinates(String coordinatesKraken) {
        int x, y;
        x = Integer.parseInt(String.valueOf(coordinatesKraken.charAt(1)));
        y = Integer.parseInt(String.valueOf(coordinatesKraken.charAt(3)));

        field[x][y] = 3;

        // Define von Neumann neighborhood
        if (x > 0) field[x - 1][y] = 1;
        if (x < 8) field[x + 1][y] = 1;
        if (y > 0) field[x][y - 1] = 1;
        if (y < 8) field[x][y + 1] = 1;
    }

    /**
     * Parses coordinates of Rock to put it to the game's field
     *
     * @param coordinatesRock coordinates of Rock, string form
     */
    private void parseRockCoordinates(String coordinatesRock) {
        int x, y;
        x = Integer.parseInt(String.valueOf(coordinatesRock.charAt(1)));
        y = Integer.parseInt(String.valueOf(coordinatesRock.charAt(3)));

        field[x][y] = 4;
    }

    /**
     * Parses coordinates of Dead Man's Chest to put it to the game's field
     *
     * @param coordinatesDeadManChest coordinates of Dead Man's Chest, string form
     */
    private void parseDeadManChestCoordinates(String coordinatesDeadManChest) {
        int x, y;
        x = Integer.parseInt(String.valueOf(coordinatesDeadManChest.charAt(1)));
        y = Integer.parseInt(String.valueOf(coordinatesDeadManChest.charAt(3)));

        field[x][y] = 5;
    }

    /**
     * Parses coordinates of Tortuga to put it to the game's field
     *
     * @param coordinatesTortuga coordinates of Tortuga, string form
     */
    private void parseTortugaCoordinates(String coordinatesTortuga) {
        int x, y;
        x = Integer.parseInt(String.valueOf(coordinatesTortuga.charAt(1)));
        y = Integer.parseInt(String.valueOf(coordinatesTortuga.charAt(3)));

        field[x][y] = 6;
    }
}
