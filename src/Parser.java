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
     * X-ordinate of the object.
     */
    private int x;

    /**
     * Y-ordinate of the object.
     */
    private int y;

    /**
     * Index for the 1st number of coordinates.
     */
    private static final int NUM1_INDEX = 1;

    /**
     * Index for the 2nd number of coordinates.
     */
    private static final int NUM2_INDEX = 3;

    /**
     * Standard constructor for Parser.
     * It imports field and coordinates in string format.
     *
     * @param gameField             the field of the game
     * @param gameStringCoordinates the coordinates of game's characters
     */
    public Parser(final int[][] gameField,
                  final String[] gameStringCoordinates) {
        this.field = gameField;
        this.stringCoordinates = gameStringCoordinates;
    }

    /**
     * Parses all coordinates to put characters to the game's field.
     */
    public void parseCoordinates() {
        // the Capitan Jack Sparrow
        field[0][0] = GameNumbers.THE_CAPITAN_JACK_SPARROW_CELL;
        String coordinatesDavyJones =
                stringCoordinates[GameNumbers.DAVY_JONES_CELL - 1];
        parseDavyJonesCoordinates(coordinatesDavyJones);

        String coordinatesKraken =
                stringCoordinates[GameNumbers.KRAKEN_CELL - 1];
        parseKrakenCoordinates(coordinatesKraken);

        String coordinatesRock = stringCoordinates[GameNumbers.ROCK_CELL - 1];
        parseRockCoordinates(coordinatesRock);

        String coordinatesDeadManChest =
                stringCoordinates[GameNumbers.DEAD_MAN_CHEST_CELL - 1];
        parseDeadManChestCoordinates(coordinatesDeadManChest);

        String coordinatesTortuga =
                stringCoordinates[GameNumbers.TORTUGA_CELL - 1];
        parseTortugaCoordinates(coordinatesTortuga);
    }

    /**
     * Parses coordinates of Davy Jones to put him to the game's field.
     *
     * @param coordinatesDavyJones coordinates of Davy Jones, string form
     */
    private void parseDavyJonesCoordinates(final String coordinatesDavyJones) {
        x = Integer.
                parseInt(String.
                        valueOf(coordinatesDavyJones.charAt(NUM1_INDEX)));
        y = Integer.
                parseInt(String.
                        valueOf(coordinatesDavyJones.charAt(NUM2_INDEX)));

        field[x][y] = GameNumbers.DAVY_JONES_CELL;

        // Define Moore neighborhood
        defineNeumannNeighborhood();
        if (x > 0 && y > 0) {
            field[x - 1][y - 1] = GameNumbers.DANGER_ZONE;
        }
        if (x < GameNumbers.FIELD_LENGTH - 1 && y > 0) {
            field[x + 1][y - 1] = GameNumbers.DANGER_ZONE;
        }
        if (x > 0 && y < GameNumbers.FIELD_LENGTH - 1) {
            field[x - 1][y + 1] = GameNumbers.DANGER_ZONE;
        }
        if (x < GameNumbers.FIELD_LENGTH - 1
                && y < GameNumbers.FIELD_LENGTH - 1) {
            field[x + 1][y + 1] = GameNumbers.DANGER_ZONE;
        }
    }

    /**
     * Parses coordinates of Kraken to put him to the game's field.
     *
     * @param coordinatesKraken coordinates of Kraken, string form
     */
    private void parseKrakenCoordinates(final String coordinatesKraken) {
        x = Integer.
                parseInt(String.valueOf(coordinatesKraken.charAt(NUM1_INDEX)));
        y = Integer.
                parseInt(String.valueOf(coordinatesKraken.charAt(NUM2_INDEX)));

        field[x][y] = GameNumbers.KRAKEN_CELL;
        defineNeumannNeighborhood();
    }

    /**
     * Defines von Neumann neighborhood.
     */
    private void defineNeumannNeighborhood() {
        if (x > 0) {
            field[x - 1][y] = GameNumbers.DANGER_ZONE;
        }
        if (x < GameNumbers.FIELD_LENGTH - 1) {
            field[x + 1][y] = GameNumbers.DANGER_ZONE;
        }
        if (y > 0) {
            field[x][y - 1] = GameNumbers.DANGER_ZONE;
        }
        if (y < GameNumbers.FIELD_LENGTH - 1) {
            field[x][y + 1] = GameNumbers.DANGER_ZONE;
        }
    }

    /**
     * Parses coordinates of Rock to put it to the game's field.
     *
     * @param coordinatesRock coordinates of Rock, string form
     */
    private void parseRockCoordinates(final String coordinatesRock) {
        x = Integer.
                parseInt(String.valueOf(coordinatesRock.charAt(NUM1_INDEX)));
        y = Integer.
                parseInt(String.valueOf(coordinatesRock.charAt(NUM2_INDEX)));

        field[x][y] = GameNumbers.ROCK_CELL;
    }

    /**
     * Parses coordinates of Dead Man's Chest to put it to the game's field.
     *
     * @param coordinatesDeadManChest coordinates of Dead Man's Chest
     */
    private void parseDeadManChestCoordinates(
            final String coordinatesDeadManChest) {
        x = Integer.
                parseInt(String.
                        valueOf(coordinatesDeadManChest.charAt(NUM1_INDEX)));
        y = Integer.
                parseInt(String.
                        valueOf(coordinatesDeadManChest.charAt(NUM2_INDEX)));

        field[x][y] = GameNumbers.DEAD_MAN_CHEST_CELL;
    }

    /**
     * Parses coordinates of Tortuga to put it to the game's field.
     *
     * @param coordinatesTortuga coordinates of Tortuga, string form
     */
    private void parseTortugaCoordinates(final String coordinatesTortuga) {
        x = Integer.
                parseInt(String.
                        valueOf(coordinatesTortuga.charAt(NUM1_INDEX)));
        y = Integer.
                parseInt(String.
                        valueOf(coordinatesTortuga.charAt(NUM2_INDEX)));

        field[x][y] = GameNumbers.TORTUGA_CELL;
    }
}
