package src;

/**
 * Exception, raised when the game cannot be won.
 *
 * @author Zener
 * @version 1.0
 */
public class GameLost extends RuntimeException {
    /**
     * Standard constructor to raise the exception.
     */
    public GameLost() {
        super("The game is lost!");
    }
}
