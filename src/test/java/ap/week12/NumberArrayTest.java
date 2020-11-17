package ap.week12;

import java.util.Arrays;

import org.junit.Test;

public class NumberArrayTest {
    @Test
    public void testMerryGoRound() {
        NumberArray nA = new NumberArray(5);
        int[] numbers = { 16, 12, 14, 8, 4, 6, 2, 10 };
        nA.merryGoRound(numbers, 5);
        System.out.println(Arrays.toString(numbers));
    }
}
