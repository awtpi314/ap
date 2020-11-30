package ap.week13;

/*
 * Program:    Array of Objects
 *             Run experimentes to test 
 *             1. array declaration and instantiation
 *             2. default values for arrays of different data types
 *             3. read-only property of for-each loop 
 *             4. passing-by-value with swap() methods 
 *
 * Class:      AP Java
 * Purpose:    Implement and Compare
 * @author     Zheng            
 * @since      11/16/2020
 */
import java.util.Arrays;

public class ClassDemoArrayObject {
    public static void main(String[] args) {
        int size = 5;

        int[] intArray; // only variable declared!
        double[] dArray;
        boolean[] bArray;
        char[] charArray;
        String[] strArray;

        // Test 1: Test that only variables are declared.
        // For the above array variables,
        // no array objects have been instantiated or initialized.
        // When invoking dot operator,
        // compile-time error will occur.
        System.out.println("Test 1");
        // System.out.println(intArray.length);
        // System.out.println(strArray.length);

        // Test 2: Discover default values for arrays
        // The new operator does two things:
        // Instantiation and initialation with default values
        intArray = new int[size];
        dArray = new double[size];
        bArray = new boolean[size];
        charArray = new char[size];
        strArray = new String[size];

        // System.out.println("\nTest 2");
        // System.out.println("int array:\t\t" + Arrays.toString(intArray));
        // System.out.println("double array:\t" + Arrays.toString(dArray));
        // System.out.println("boolean array:\t" + Arrays.toString(bArray));
        // System.out.println("char array:\t\t" + Arrays.toString(charArray));
        // System.out.println("object array:\t" + Arrays.toString(strArray));

        // Test 3: Test that the object array elements are null as default.
        // When invoking dot operator on an object array element;
        // NullPointerException will occur.
        System.out.println("\nTest 3");
        // use for-each loop
        // for (String str: strArray) {
        // System.out.println(str.length());
        // }

        // Test 4: Test for-each loop is for-read only!
        // Array of objects MUST be initiatialized!

        System.out.println("\nTest 4");
        // Try to initialize strArray with for-each loop
        // for (String str: strArray) {
        // str = "Hi?";
        // }
        // System.out.println("after for-each: " + Arrays.toString(strArray));

        // Do it again with for-loop
        // for (int k = 0; k < strArray.length; k++) {
        // strArray[k] = "Smile";
        // }
        // System.out.println("after for-loop: " + Arrays.toString(strArray));

        // Test 5: Test swap(int, int)
        System.out.println("\nTest 5");
        int n1 = 1;
        int n2 = 2;
        // System.out.println("In main before swap call:\t" + "n1 = " + n1 + ", n2 = " +
        // n2);
        // swap(n1, n2);
        // System.out.println("In main after swap call:\t" + "n1 = " + n1 + ", n2 = " +
        // n2);

        // Test 6: Test swap(String, String)
        System.out.println("\nTest 6");
        String s1 = "Hi!";
        String s2 = "Thanks!";
        // System.out.println("In main before swap call:\t" + "s1 = " + s1 + ", s2 = " +
        // s2);
        // swap(s1, s2);
        // System.out.println("In main after swap call:\t" + "s1 = " + s1 + ", s2 = " +
        // s2);

        // Test 7: Test swap(int[], int[])
        System.out.println("\nTest 7");
        int[] evenArray = { 2, 4, 6, 8 };
        int[] oddArray = { 1, 3, 5, 7 };
        // System.out.println("In main before swap call:\t" + "evenArray = " +
        // Arrays.toString(evenArray) + ", oddArray = " + Arrays.toString(oddArray));
        // swap(evenArray, oddArray);
        // System.out.println("In main after swap call:\t" + "evenArray = " +
        // Arrays.toString(evenArray) + ", oddArray = " + Arrays.toString(oddArray));

        // Test 8: Test swap(int[], int[], int j, int k)
        System.out.println("\nTest 8");
        // System.out.println("In main before swap call:\t" + "evenArray = " +
        // Arrays.toString(evenArray) + ", oddArray = " + Arrays.toString(oddArray));
        // swap(evenArray, oddArray, 0, evenArray.length - 1);
        // System.out.println("In main after swap call:\t" + "evenArray = " +
        // Arrays.toString(evenArray) + ", oddArray = " + Arrays.toString(oddArray));
        //

    } // end main

    public static void swap(int n1, int n2) {

        System.out.println("In swap before swapping:\t" + "n1 = " + n1 + ", n2 = " + n2);
        int temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println("In swap after swapping:\t\t" + "n1 = " + n1 + ", n2 = " + n2);

    } // end method

    public static void swap(String n1, String n2) {

        System.out.println("In swap before swapping:\t" + "n1 = " + n1 + ", n2 = " + n2);
        String temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println("In swap after swapping:\t\t" + "n1 = " + n1 + ", n2 = " + n2);

    } // end method

    public static void swap(int[] n1, int[] n2) {

        System.out.println(
                "In swap before swapping:\t" + "n1 = " + Arrays.toString(n1) + ", n2 = " + Arrays.toString(n2));
        int[] temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println(
                "In swap after swapping:\t\t" + "n1 = " + Arrays.toString(n1) + ", n2 = " + Arrays.toString(n2));

    } // end method

    public static void swap(int[] n1, int[] n2, int first, int last) {

        if (first < 0 || last < 0 || first >= n1.length || last >= n1.length || first > last) {
            return;
        }

        System.out
                .println("In swap before swapping:\t" + "n1 = " + Arrays.toString(n1) + " n2 = " + Arrays.toString(n2));
        for (int j = first; j <= last; j++) {
            int temp = n1[j];
            n1[j] = n2[j];
            n2[j] = temp;
        }
        System.out.println(
                "In swap after swapping:\t\t" + "n1 = " + Arrays.toString(n1) + " n2 = " + Arrays.toString(n2));

    } // end method

} // end class