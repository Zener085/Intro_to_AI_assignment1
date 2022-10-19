package src;

/**
 * Exception, raised when the game cannot be won.
 *
 * @author Zener
 * @version 1.0
 */
public class GameLost extends RuntimeException {
    public GameLost() {
        super("The game is lost!");
    }
}
