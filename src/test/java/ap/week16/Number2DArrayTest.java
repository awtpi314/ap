package ap.week16;

import org.junit.Test;

public class Number2DArrayTest {
    int[][] matrix = { { 1, 1, 2 }, { 0, 2, 3 }, { 3, 4, 5 } };

    @Test
    public void testNumberArray() {
        Number2DArray nA = new Number2DArray(3, 3);
        nA.print2DArray("Original", matrix);
        nA.print2DArray("Modified", nA.mirrorMinorDiagonalRightToLeft(matrix));
        // nA.print2DArray("Modified", matrix);
    }

}
