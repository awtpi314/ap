package ap.week20.classwork;

/*
 * Program:    SortComparison
 * Class:      AP Java
 * Purpose:    Implement and Compare
 * @author     Zheng            
 * @since      1/15/2021
 */
import java.util.Scanner;
import java.util.ArrayList;

public class SortComparison {
    static Scanner keyboard;

    public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        int choice = 3;
        int size = 100;
        // int[] myArray;
        ArrayList<Integer> myArray = new ArrayList<Integer>();

        System.out.println("Please enter the array size: ");
        // size = readInt();
        if (size > 0) {
            // myArray = new int[size];

            System.out.println("Please enter 1, 2 or 3\n");
            System.out.println("\t\t 1: increasing order");
            System.out.println("\t\t 2: decreasing order");
            System.out.println("\t\t 3: random");
            // choice = readInt();
            switch (choice) {
                case 1:
                    System.out.println("initial: increasing order");
                    createIncreasingArray(myArray, size);
                    break;
                case 2:
                    System.out.println("initial: decreasing order");
                    createDecreasingArray(myArray, size);
                    break;
                case 3:
                    System.out.println("initial: random");
                    createRandomArray(myArray, size);
                    break;
                default:
            }

            // Make a copy of myArray
            ArrayList<Integer> myArray1 = new ArrayList<Integer>(myArray);

            System.out.println("initial list: " + myArray);
            System.out.println("initial list: " + myArray1);

            // insertion sort
            System.out.println("\ninsertion sort ...");
            // System.out.println("insertion comparison count: " +
            // SortArrayList.insertionSort(myArray, true));
            System.out.println("insertion comparison count: " + SortArrayList.insertionSort(myArray, false));

            // selection sort
            System.out.println("\nselection sort ...");
            // System.out.println("selection comparison count: " +
            // SortArrayList.selectionSort(myArray1, true));
            System.out.println("selection comparison count: " + SortArrayList.selectionSort(myArray1, true));

        }

    } // end main

    /**
     * Initialize an ArrayList with an increasing list
     */
    public static void createIncreasingArray(ArrayList<Integer> array, int size) {
        for (int counter = 0; counter < size; counter++) {

            // array[counter] = counter;
            array.add(counter);
        }
    }

    /**
     * Initialize an ArrayList with a decreasing list
     */
    public static void createDecreasingArray(ArrayList<Integer> array, int size) {
        for (int counter = 0; counter < size; counter++) {
            // array[counter] = size - counter;
            array.add(size - counter);
        }
    }

    /**
     * Create an array with random numbers [0, 2 * size)
     */
    public static void createRandomArray(ArrayList<Integer> array, int size) {
        int num;
        for (int counter = 0; counter < size; counter++) {
            // array[counter] = (int)(2 * size * Math.random()); // initial list of random
            // numbers
            num = (int) (2 * size * Math.random());
            array.add(num);
        }
    }

    /**
     * @return int
     */
    public static int readInt() {
        String temp = "";
        int number = -999;

        temp = keyboard.nextLine();
        try {
            number = Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return number;
    } // end method

} // end class

/*
 * ----jGRASP exec: java SortComparison Please enter the array size: 5 Please
 * enter 1, 2 or 3
 * 
 * 1: increasing order 2: decreasing order 3: random 3 initial: random initial
 * list: [9, 8, 3, 0, 3] initial list: [9, 8, 3, 0, 3] 1: [8, 9, 3, 0, 3] 2: [3,
 * 8, 9, 0, 3] 3: [0, 3, 8, 9, 3] 4: [0, 3, 3, 8, 9] insertion count: 9 0: [0,
 * 8, 3, 9, 3] 1: [0, 3, 8, 9, 3] 2: [0, 3, 3, 9, 8] 3: [0, 3, 3, 8, 9]
 * 
 * selection count: 10
 * 
 * ----jGRASP: operation complete.
 */
/*
 * ----jGRASP exec: java SortComparison Please enter the array size: 5 Please
 * enter 1, 2 or 3
 * 
 * 1: increasing order 2: decreasing order 3: random 3 initial: random initial
 * list: [7, 4, 3, 8, 1] initial list: [7, 4, 3, 8, 1]
 * 
 * insertin sort ... 1: [4, 7, 3, 8, 1] 2: [3, 4, 7, 8, 1] 3: [3, 4, 7, 8, 1] 4:
 * [1, 3, 4, 7, 8] insertion count: 8
 * 
 * selectin sort ... 0: [1, 4, 3, 8, 7] 1: [1, 3, 4, 8, 7] 2: [1, 3, 4, 8, 7] 3:
 * [1, 3, 4, 7, 8] selection count: 10
 * 
 * ----jGRASP: operation complete.
 * 
 */