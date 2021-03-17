package ap.week21;

/*  program: class mechanicalArm
*           Barron's 2018
*           Exam 1: #4, P41- 45
*  Class:   AP Java
*  @author  Zheng
*  @since   11/20/2020
*/

public class MechanicalArm {
    private int index; // current index
    private boolean arrowFacingRight; // true = right; false = left

    /**
     * Constructor
     */
    public MechanicalArm() {
        this(0, true);
    }

    /**
     * Overloaded Constructor
     */
    public MechanicalArm(int index, boolean b) {
        this.index = index;
        this.arrowFacingRight = b;
    }

    /**
     * @return the index of the current location of the mechanical arm
     */
    int getCurrentIndex() {
        return index;
    }

    /**
     * @return true if the arm is facing right towards solutions with large PH
     *         values false if the arm is facing left towards solutions with small
     *         PH values
     */
    boolean isFacingRight() {
        return arrowFacingRight;
    }

    /**
     * change the current direction of the arm
     */
    void changeDirection() {
        arrowFacingRight = !arrowFacingRight;
    }

    /**
     * Moves the arm forward in its current direction by the number of locations
     * specified.
     * 
     * @param numLocs the number of locations to move Precondition: numLocs >=0
     *                Function as setIndex()
     */
    void moveForward(int numLocs) {
        if (arrowFacingRight) {
            index += numLocs;
        } else {
            index -= numLocs;
        }

    } // end method

    public void moveToIndex(int i) {
        index = i;
    }

} // end class