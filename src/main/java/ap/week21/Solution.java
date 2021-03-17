package ap.week21;

/**
 * program: class Solution Barron's 2018 Exam 1: #4, P41- 45 Class: AP Java
 * 
 * @author Zheng
 * @since 1/21/2021
 */

public class Solution {
    private int phValue; // value in [0, 14]

    /**
     * constructor
     */
    public Solution(int newValue) {
        setPH(newValue);
    }

    /**
     * @return an integer value in the range [1, 14] 1 - very acidic 7 - neutral 14
     *         - very alkali (noun alkaline)
     */
    public int getPH() {
        return this.phValue;
    }

    /**
     * set PH value
     * 
     * @param newValue the new PH value
     */
    public void setPH(int newValue) {
        if (newValue >= 1 && newValue <= 14) {
            this.phValue = newValue;
        }
    }

}