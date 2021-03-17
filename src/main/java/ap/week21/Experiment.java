package ap.week21;

import java.util.ArrayList;
import java.util.List;

public class Experiment {

    private MechanicalArm arm;
    private List<Solution> solutionList;

    public Experiment(int[] phArr) {

        this(phArr, 0, true);
    }

    public Experiment(int[] phArr, int index, boolean b) {

        if (phArr == null || phArr.length == 0)
            return;

        // create objects
        arm = new MechanicalArm(index, b);
        solutionList = new ArrayList<Solution>();

        for (int n : phArr) {
            solutionList.add(new Solution(n));
        }
    } // end method

    /**
     * Reset the experiment Postcondition: The arm has a current location index of 0
     * The arm is facing right.
     */
    public void reset() {
        arm.moveToIndex(0);
        if (!arm.isFacingRight()) {
            arm.changeDirection();
        }
    };

    /**
     * Finds and returns the index of the most acidic solution
     * 
     * @return index the location of the most acidic solution or -1 is there are no
     *         acidic solutions
     *
     *         A solution is acidic if pH is less than 7. The mostAcidic must be
     *         less than 7!!!
     *
     *         Postconditions: The arm is facing right. Its current index is at the
     *         most acidic solution or at zero if there are no acidic solutions.
     */
    public int mostAcidic() {
        int lowestPH = 7;
        int lowestIndex = -1;

        for (int i = 0; i < solutionList.size(); i++) {
            if (solutionList.get(i).getPH() < lowestPH) {
                lowestIndex = i;
                lowestPH = solutionList.get(i).getPH();
            }
        }

        arm.moveToIndex(lowestIndex < 0 ? 0 : lowestIndex);
        if (!arm.isFacingRight()) {
            arm.changeDirection();
        }

        return lowestIndex;

    } // end method

    /**
     * Display the solution list.
     * 
     * DO NOT CHANGE THIS METHOD! THANK YOU!
     * 
     */
    public void display() {
        Solution s;
        int index;

        // display the index
        for (int i = 0; i < solutionList.size(); i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();

        // display the PH value
        for (int i = 0; i < solutionList.size(); i++) {
            s = solutionList.get(i);
            System.out.printf("%5d", s.getPH());
        }
        System.out.println();

        // display the arrow
        index = arm.getCurrentIndex();
        // error checking
        // System.out.println("in display: current index = " + index);

        for (int i = 0; i < index; i++) {
            System.out.printf("%5s", " ");
        }
        // print the arrow
        if (arm.isFacingRight()) {
            System.out.printf("%5s", "-->");
        } else {
            System.out.printf("%5s", "<--");
        }
        System.out.println();
    } // end method

} // end class