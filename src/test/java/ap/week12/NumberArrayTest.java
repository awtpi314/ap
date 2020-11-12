package ap.week12;

import java.util.Arrays;

import org.junit.Test;

public class NumberArrayTest {
    @Test
    public void testGetMode() {
        NumberArray nA = new NumberArray(5);
        int[] numbers = { 1, 1, 5, 4, 5, 5, 1 };
        nA.merryGoRound(numbers, 3);
        System.out.println(Arrays.toString(numbers));
    }
}
