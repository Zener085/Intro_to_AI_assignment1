/**
 * Interface for the class of the Capitan Jack Sparrow.
 */
package src;

/**
 * Actions which the capitan Jack Sparrow can perform.
 *
 * @author Zener
 * @version 1.0
 */
public interface CapitanJackSparrowActions {
    /**
     * The Capitan Jack Sparrow moves for 1 cell.
     */
    void move();

    /**
     * The Capitan Jack Sparrow looks at the nearest cells and analyze them (depends on his type of spyglass).
     */
    void look();
}
