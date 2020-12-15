package ap.week16;

import java.util.Arrays;

/**
 * Program: Number2DArray Write methods for 2D arrays
 * 
 * References: Barron's 2018 P30 Practice Exam 1 #36
 * 
 * Class: AP Java
 * 
 * @author Zheng
 * @version 12/10/2020
 */

public class Number2DArray {

    private int[][] randomArray;
    private int[][] evenArray;

    /**
     * constructor Precondition: size > 0
     */
    public Number2DArray(int totalRows, int totalCols) {
        int count = 0;

        // Create an array of fixed sizes
        randomArray = new int[totalRows][totalCols];
        evenArray = new int[totalRows][totalRows];

        // Fill the array with random integers
        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < totalCols; c++) {
                randomArray[r][c] = generateRandomNumber(10, 25);
            }
        }

        // Fill the evenArray with consecutive even numbers
        count = 0;
        for (int r = 0; r < totalRows; r++) {
            for (int c = 0; c < totalRows; c++) {
                count++;
                evenArray[r][c] = count * 2 + 8;
            }
        }

    } // end constructor

    /**
     * Display the results.
     *
     * Please do not change this method! Thank you!
     *
     */
    public void display() {

        print2DArray("random array: ", randomArray);

        System.out.printf("%-30s%d\n", "\t sum: ", findSum(randomArray));
        System.out.printf("%-30s%d\n", "\t major diagonal sum: ", findMajorDiagonalSum(randomArray));
        System.out.printf("%-30s%d\n", "\t minor diagonal sum: ", findMinorDiagonalSum(randomArray));
        System.out.printf("%-30s%d\n", "\t highest: ", findHighest(randomArray));
        System.out.printf("%-30s%d\n", "\t lowest: ", findLowest(randomArray));

        System.out.printf("%-30s%d\n", "\t consecutive value in row: ", findConsecutivePairInRow(randomArray));
        System.out.printf("%-30s%d\n", "\t consecutive value in col: ", findConsecutivePairInCol(randomArray));

        swapDiagonals(randomArray);
        print2DArray("\nafter swapDiagonals: ", randomArray);

        removeRow(randomArray, 1);
        print2DArray("after removeRow(randomArray, 1)", randomArray);

        print2DArray("\neven array: ", evenArray);

        System.out.println("row-major order:\n\t " + Arrays.toString(readRowMajorOrder(evenArray)));
        System.out.println("column-major order:\n\t " + Arrays.toString(readColumnMajorOrder(evenArray)));

        // reverse the 2D array
        reverseMatrix(evenArray);
        print2DArray("\nevenArray is reversed: ", evenArray);

        System.out.println();
        printTopLeft(evenArray);
        printTopRight(evenArray);
        printBottomLeft(evenArray);
        printBottomRight(evenArray);

        print2DArray("Reflect left to right: ", mirrorLeftToRight(evenArray));
        print2DArray("Reflect right to left: ", mirrorRightToLeft(evenArray));

        print2DArray("Reflect top to bottom: ", mirrorTopToBottom(evenArray));
        print2DArray("Reflect bottom to top: ", mirrorBottomToTop(evenArray));

        print2DArray("Reflect major diagonal left to right: ", mirrorMajorDiagonalLeftToRight(evenArray));
        print2DArray("Reflect major diagonal right to left: ", mirrorMajorDiagonalRightToLeft(evenArray));

        print2DArray("Reflect minor diagonal left to right: ", mirrorMinorDiagonalLeftToRight(evenArray));
        print2DArray("Reflect minor diagonal right to left: ", mirrorMinorDiagonalRightToLeft(evenArray));

    } // end method

    /**
     * Print a 2D array.
     * 
     * @param str   String
     * @param array int[][]
     */
    public void print2DArray(String str, int[][] array) {

        System.out.println(str);

        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
    } // end method

    /* generate random numbers */
    public int generateRandomNumber(int min, int max) {
        int range;
        range = max - min + 1;
        return (int) (range * Math.random() + min);
    } // end method

    /**
     * Find sum of the whole array
     *
     * Implement with double for-each loops
     *
     * @param array int[][]
     * @return sum int
     */
    public int findSum(int[][] array) {
        int sum = 0;

        for (var row : array) {
            for (int column : row) {
                sum += column;
            }
        }

        return sum;
    } // end method

    /**
     * Find major diagonal sum Major diagonals: array[r][r]
     */
    public int findMajorDiagonalSum(int[][] array) {
        int sum = 0;

        int loops = array.length < array[0].length ? array.length : array[0].length;
        for (int i = 0; i < loops; i++) {
            sum += array[i][i];
        }

        return sum;
    } // end method

    /**
     * Find minor diagonal sum Minor diagonals: array[r][size - 1 - r]
     */
    public int findMinorDiagonalSum(int[][] array) {
        int sum = 0;

        int loops = array.length < array[0].length ? array.length : array[0].length;
        for (int i = 0; i < loops; i++) {
            sum += array[i][loops - i - 1];
        }

        return sum;
    } // end method

    /**
     * Find highest value of the whole array
     *
     * Implement with double for-each loops
     *
     * @param array int[][]
     * @return result int
     */
    public int findHighest(int[][] array) {
        int result = Integer.MIN_VALUE;

        for (var row : array) {
            for (int column : row) {
                if (column > result) {
                    result = column;
                }
            }
        }

        return result;
    } // end method

    /**
     * Find lowest value of the whole array
     *
     * Implement with double for-each loops
     *
     * @param array int[][]
     * @return result int
     */
    public int findLowest(int[][] array) {
        int result = Integer.MAX_VALUE;

        for (var row : array) {
            for (int column : row) {
                if (column < result) {
                    result = column;
                }
            }
        }

        return result;
    } // end method

    /**
     * Find the consecutive pairs in a row
     */
    public int findConsecutivePairInRow(int[][] array) {
        for (int[] row : array) {
            for (int i = 1; i < array.length; i++) {
                if (row[i] == row[i - 1]) {
                    return row[i];
                }
            }
        }

        return -1; // not found
    } // end method

    /**
     * Find the consecutive pairs in a column
     */
    public int findConsecutivePairInCol(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                if (array[j][i] == array[j - 1][i]) {
                    return array[j][i];
                }
            }
        }

        return -1; // not found
    } // end method

    /**
     * Swap the major diagonal with the minor Postcondition: Diagonals in array are
     * swapped.
     */
    public void swapDiagonals(int[][] array) {
        int size = array.length;
        int half = size / 2;

        for (int r = 0; r < half; r++) {
            for (int c = r; c < half; c++) {
                int temp = array[r][c];
                array[r][c] = array[r][size - c - 1];
                array[r][size - c - 1] = temp;
                int calcRow = size - r - 1;
                temp = array[calcRow][c];
                array[calcRow][c] = array[calcRow][size - c - 1];
                array[calcRow][size - c - 1] = temp;
            }
        }
    } // end method

    /**
     * This method removes the row, and moves all rows from (row + 1) to the top.
     * The last row will be replaced with zero.
     * 
     * Example: Initial: [6, 2, 4, 2] [7, 6, 7, 5] [3, 0, 1, 9] [5, 8, 5, 6]
     * 
     * after the call removeRow(mat, 2) [6, 2, 4, 2] [7, 6, 7, 5] [5, 8, 5, 6] [0,
     * 0, 0, 0]
     * 
     * Postconditions: matrix will be altered.
     * 
     * @param matrix int[][]
     * @param row    int the row index to be removed
     */
    public void removeRow(int[][] matrix, int row) {
        for (int i = row; i < matrix.length; i++) {

        }
    } // end method

    /**
     * Return a 1D array traversing the 2D array by row-major order
     */
    public int[] readRowMajorOrder(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int[] temp = new int[rows * cols];
        int tempWriteIndex = 0;

        for (var row : array) {
            for (int column : row) {
                temp[tempWriteIndex++] = column;
            }
        }

        return temp;
    } // end method

    /**
     * Return a 1D array traversing the 2D array by column-major order
     */
    public int[] readColumnMajorOrder(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int[] temp = new int[rows * cols];
        int tempWriteIndex = 0;

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                temp[tempWriteIndex++] = array[r][c];
            }
        }

        return temp;
    } // end method

    /**
     * Reverse the array int[]. Postcondition: array is reversed.
     */
    private void reverseArray(int[] array) {
        int size = array.length;
        int half = size / 2;

        for (int i = 0; i < half; i++) {
            int temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }

    } // end method

    /**
     * Reverse the elements in each row of the 2D array
     * 
     * Must call reverseArray()
     *
     * Postcondition: the elements in each row have been reversed.
     */
    private void reverseAllRows(int[][] array) {
        for (var row : array) {
            reverseArray(row);
        }
    } // end method

    /**
     * Reverse the elements of a matrix. Before call: [1, 2] [3, 4] [5, 6]
     * 
     * After call: [6, 5] [4, 3] [2, 1]
     * 
     * Must call reverseAllRows() and reverseArray()
     *
     * Postcondition: The final elements of matrix, when read in row-major order,
     * are the same as the original when read from bottom corner, right to left,
     * going upward.
     */
    public void reverseMatrix(int[][] array) {
        // first reverse elements in all rows in the matrix
        reverseAllRows(array);

        int size = array.length;
        int half = size / 2;

        for (int i = 0; i < half; i++) {
            var row = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = row;
        }

    } // end method

    /**
     * Print the top-left of the 2D array
     */
    public void printTopLeft(int[][] array) {

        System.out.println("Top Left:");
        int rows = array.length;
        int cols = array[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols - r; c++) {
                System.out.print(array[r][c] + " ");
            }
            System.out.println(); // next line
        }
        System.out.println(); // empty line
    } // end method

    /**
     * Print the top-right of the 2D array
     */
    public void printTopRight(int[][] array) {

        System.out.println("Top Right:");

        int rows = array.length;
        int cols = array[0].length;
        for (int r = 0; r < rows; r++) {
            for (int i = 0; i < r; i++) {
                System.out.print("\t");
            }

            for (int c = r; c < cols; c++) {
                System.out.print(array[r][c] + "\t");
            }

            System.out.println();
        }

        System.out.println();

    } // end method

    /**
     * Print the bottom-left of the 2D array
     */
    public void printBottomLeft(int[][] array) {

        System.out.println("Bottom Left:");

        int rows = array.length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c <= r; c++) {
                System.out.print(array[r][c] + " ");
            }
            System.out.println(); // next line
        }
        System.out.println(); // empty line

    } // end method

    /**
     * Print the bottom-right of the 2D array
     */
    public void printBottomRight(int[][] array) {

        System.out.println("Bottom Right:");

        int rows = array.length;
        int cols = array[0].length;
        for (int r = 0; r < rows; r++) {
            int loopTimes = rows - r - 1;
            for (int i = 0; i < loopTimes; i++) {
                System.out.print("\t");
            }

            for (int c = loopTimes; c < cols; c++) {
                System.out.print(array[r][c] + "\t");
            }

            System.out.println();
        }

        System.out.println();

    } // end method

    /**
     * Return a new array as a result of vertical reflection from left to right
     */
    public int[][] mirrorLeftToRight(int[][] array) {
        int[][] newArray = copyArray(array);

        int size = array.length;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size / 2; c++) {
                newArray[r][size - 1 - c] = newArray[r][c];
            }
        }
        return newArray;
    } // end method

    /**
     * Return a new array as a result of vertical reflection from right to left.
     */
    public int[][] mirrorRightToLeft(int[][] array) {
        int[][] newArray = copyArray(array);

        int size = array.length;
        int half = size / 2;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < half; c++) {
                newArray[r][c] = newArray[r][size - c - 1];
            }
        }

        return newArray;
    } // end method

    /**
     * Return a new array as a result of horizontal reflection from top to bottom.
     */
    public int[][] mirrorTopToBottom(int[][] array) {
        int[][] newArray = copyArray(array);

        int size = array.length;
        int half = size / 2;
        for (int r = 0; r < half; r++) {
            for (int c = 0; c < size; c++) {
                newArray[size - r - 1][c] = newArray[r][c];
            }
        }

        return newArray;
    } // end method

    /**
     * Return a new array as a result of horizontal reflection from bottom to top.
     */
    public int[][] mirrorBottomToTop(int[][] array) {
        int[][] newArray = copyArray(array);

        int size = array.length;
        int half = size / 2;
        for (int r = 0; r < half; r++) {
            for (int c = 0; c < size; c++) {
                newArray[r][c] = newArray[size - r - 1][c];
            }
        }

        return newArray;
    } // end method

    /**
     * Return a new array as a result of reflection with major diagonal axis from
     * left to right.
     * 
     * symmetric axis: major diagonal [0][0] -> [size-1][size-1]
     */
    public int[][] mirrorMajorDiagonalLeftToRight(int[][] array) {
        int[][] newArray = copyArray(array);

        int size = array.length;
        for (int r = 1; r < size; r++) {
            for (int c = 0; c < r; c++) {
                newArray[c][r] = newArray[r][c];
            }
        }
        return newArray;
    } // end method

    /**
     * Return a new array as a result of reflection with major diagonal axis from
     * right to left.
     * 
     * symmetric axis: major diagonal [0][0] -> [size-1][size-1]
     */
    public int[][] mirrorMajorDiagonalRightToLeft(int[][] array) {
        int[][] newArray = copyArray(array);

        int size = array.length;
        for (int r = 1; r < size; r++) {
            for (int c = 0; c < r; c++) {
                newArray[r][c] = newArray[c][r];
            }
        }

        return newArray;
    } // end method

    /**
     * Return a new array as a result of reflection with minor diagonal axis from
     * left to right.
     *
     * symmetric axis: minor diagonal [0][size-1] -> [size-1][0]
     */
    public int[][] mirrorMinorDiagonalLeftToRight(int[][] array) {
        int[][] newArray = copyArray(array);

        int times = array.length - 1;
        for (int r = 0; r < times; r++) {
            for (int c = 0; c <= r + 1; c++) {
                newArray[times - c][times - r] = newArray[r][c];
            }
        }

        return newArray;
    } // end method

    /**
     * Return a new array as a result of reflection with minor diagonal axis from
     * right to left.
     * 
     * symmetric axis: minor diagonal [0][size-1] -> [size-1][0]
     */
    public int[][] mirrorMinorDiagonalRightToLeft(int[][] array) {
        int[][] newArray = copyArray(array);

        int times = array.length - 1;
        for (int r = 0; r < times; r++) {
            for (int c = 0; c <= r + 1; c++) {
                newArray[c][r] = newArray[times - r][times - c];
            }
        }

        return newArray;
    } // end method

    /**
     * Return a new copy of array
     * 
     * @param array int[][]
     * @return newArray int[][]
     */
    private int[][] copyArray(int[][] array) {
        int[][] newArray = new int[array.length][array[0].length];

        for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[0].length; c++) {
                newArray[r][c] = array[r][c];
            }
        }
        return newArray;
    } // end method
}
