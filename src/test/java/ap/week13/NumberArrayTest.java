package ap.week13;

import java.util.Arrays;

import org.junit.Test;

import ap.Utils;

public class NumberArrayTest {
    @Test
    public void testSpeed() {
        System.out.println(Utils.timeit(() -> {
            int[] numbers = { 1, 5, 3, 76, 8, 345, 98, 24 };
            var nA = new NumberArray(8);
            nA.insertionSort(numbers);
        }));

        System.out.println(Utils.timeit(() -> {
            int[] numbers = { 1, 5, 3, 76, 8, 345, 98, 24 };
            var nA = new NumberArray(8);
            nA.mergeSort(numbers);
        }));
        
        System.out.println(Utils.timeit(() -> {
            int[] numbers = { 1, 5, 3, 76, 8, 345, 98, 24 };
            Arrays.sort(numbers);
        }));
    }
}
