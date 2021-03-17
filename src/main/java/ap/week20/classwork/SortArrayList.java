package ap.week20.classwork;

/*
 * Program:    Sort ArrayList
 * Class:      AP Java
 * Purpose:    Implement and Compare
 * @author     Zheng            
 * @since      1/15/2021
 */

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayList {

    /**
     * Sort by insertion sort of integers InsertionSort performs best when the list
     * is almost sorted.
     *
     * Postcondition: the int array is sorted increasingly
     * 
     * @param ArrayList<Integer>
     */
    public static int insertionSort(ArrayList<Integer> array, boolean debug) {
        int current = 0;
        int i = 0, j = 0;
        int insertionCount = 0;

        for (i = 1; i < array.size(); i++) {
            current = array.get(i);
            for (j = i - 1; j >= 0; j--) {
                insertionCount++; // count the number of comparisons
                if (current < array.get(j)) {
                    array.set(j + 1, array.get(j));
                } else {
                    break;
                } // end for
            } // end for
              // insert the current to the slot
            array.set(j + 1, current);

            // print for debug
            if (debug) {
                System.out.println(i + ": " + array);
            }
        } // end for
        return insertionCount;

    } // end method

    /**
     * Postcondition: The list is sorted from smallest to largest. Sort integers.
     * The number of comparisons: N*(N-1)/2, N is the size of the list.
     * 
     * @param ArrayList<Integer>
     */
    public static int selectionSort(ArrayList<Integer> array, boolean debug) {
        int startScan, index, minIndex;
        int minValue = 0;
        int selectionCount = 0;

        for (startScan = 0; startScan < (array.size() - 1); startScan++) {
            minIndex = startScan;
            minValue = array.get(startScan);
            for (index = startScan + 1; index < array.size(); index++) {
                selectionCount++; // count the number of comparisons
                if (array.get(index) < minValue) {
                    minValue = array.get(index);
                    minIndex = index;
                } // end for

            } // end inner for
            if (minIndex != startScan) {
                array.set(minIndex, array.get(startScan));
                array.set(startScan, minValue);
            }

            // print for debug
            if (debug) {
                System.out.println(startScan + ": " + array);
            }
        } // end for

        return selectionCount;
    } // end method

    /**
     * Sort by insertSort of integers InsertionSort performs best when the list is
     * almost sorted.
     *
     * Postcondition: the int array is sorted increasingly
     * 
     * @param int[]
     * @param debugOn if debugOn true, print intermediate results otherwise, no
     *                printing
     */
    public static int insertionSort(int[] array, boolean debugOn) {
        int current = 0;
        int i = 0, j = 0;
        int insertionCount = 0;

        for (i = 1; i < array.length; i++) {
            current = array[i];
            for (j = i - 1; j >= 0; j--) {
                insertionCount++; // count the number of comparisons
                if (current < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                } // end for
            } // end for
              // insert the current to the slot
            array[j + 1] = current;

            if (debugOn) {
                System.out.println(i + " : " + Arrays.toString(array));
            }
        } // end for

        return insertionCount;
    } // end method

} // end class