package ap.week17;

import java.util.Arrays;

/**
 * <h3>MagicSquare</h3>
 * <p>
 * This class is a representation of a potential magic square. The array passed
 * to the {@link #MagicSquare(int[][]) constructor} must be a square matrix,
 * with the length and height being equal, non-zero numbers. If this condition
 * is not satisfied, the constructor will throw an exception.
 * </p>
 * 
 * @author Alexander Taylor
 * @version 0.0.1
 * @since Version 0.0.1 - January 2021
 */
public class MagicSquare {
    /**
     * The matrix to hold the magic square
     */
    private int[][] matrix;
    /**
     * The size in both width and height of the {@link #matrix}
     */
    private final int SIZE;

    /**
     * <p>
     * This constructor checks to be sure that the 2D array passed is able to be
     * placed into a magic square format for validation.
     * </p>
     * 
     * <p>
     * It then assigns the member constant {@link #SIZE} to the length of the array.
     * Finally, it will copy the 2D array into {@link #matrix} for validation.
     * </p>
     * 
     * @param m the matrix with which to create the square
     * @throws Exception if the array is null, not a square, or has zero length
     */
    public MagicSquare(int[][] m) throws Exception {
        if (m == null || m.length != m[0].length || m.length == 0) {
            throw new Exception("2D array is either null, zero length, or a non-square.");
        }

        SIZE = m.length;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = m[i][j];
            }
        }
    }

    /**
     * Sums a row of the potential magic square
     * 
     * @param rowNumber the row to sum
     * @return the sum of the row
     * @throws ArrayIndexOutOfBoundsException if the row number is larger than the
     *                                        number of rows in the matrix.
     */
    private int rowSum(int rowNumber) throws ArrayIndexOutOfBoundsException {
        if (rowNumber >= matrix.length) {
            throw new ArrayIndexOutOfBoundsException(
                    "Index " + rowNumber + " out of bounds for length " + matrix.length + ".");
        }

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[rowNumber][i];
        }

        return sum;
    }

    /**
     * Sums a column of the potential magic square
     * 
     * @param columnNumber the column to sum
     * @return the sum of the column
     * @throws ArrayIndexOutOfBoundsException if the row number is larger than the
     *                                        number of rows in the matrix/
     */
    private int columnSum(int columnNumber) throws ArrayIndexOutOfBoundsException {
        if (columnNumber >= matrix.length) {
            throw new ArrayIndexOutOfBoundsException(
                    "Index " + columnNumber + " out of bounds for length " + matrix.length + ".");
        }

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][columnNumber];
        }

        return sum;
    }

    /**
     * Gets the sum of the major diagonal of the square
     * 
     * @return the sum of the major diagonal
     */
    private int majorDiagonalSum() {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        return sum;
    }

    /**
     * Gets the sum of the minor diagonal of the square
     * 
     * @return the sum of the minor diagonal
     */
    private int minorDiagonalSum() {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - i - 1];
        }

        return sum;
    }

    /**
     * Checks to see whether the numbers contained in {@link #matrix} form a magic
     * square. This method uses {@link #rowSum(int) rowSum}, {@link #columnSum(int)
     * columnSum}, {@link #majorDiagonalSum() majorDiagonalSum}, and
     * {@link #minorDiagonalSum() minorDiagonalSum} to validate the square.
     * 
     * @return whether the numbers in {@link matrix} form a magic square
     */
    public boolean isMagicSquare() {
        final int testSum = rowSum(0);
        for (int i = 1; i < matrix.length; i++) {
            if (rowSum(i) != testSum) {
                return false;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (columnSum(i) != testSum) {
                return false;
            }
        }

        if (majorDiagonalSum() != testSum) {
            return false;
        }

        if (minorDiagonalSum() != testSum) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int[] n : matrix) {
            sb.append(Arrays.toString(n));
            sb.append("\n");
        }

        return sb.toString();
    }
}
