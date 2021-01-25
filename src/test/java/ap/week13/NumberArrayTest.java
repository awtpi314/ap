package ap.week13;

import java.util.Arrays;

import org.junit.Test;

import ap.Utils;

public class NumberArrayTest {
    @Test
    public void testSpeed() {
        System.out.println(Utils.timeit(() -> {
            int[] numbersA = { 1, 2, 3, 4, 5, 6, 7, 8 };
            var nA = new NumberArray(8);
            nA.insertionSort(numbersA);
        }));

        System.out.println(Utils.timeit(() -> {
            int[] numbersB = { 1, 2, 3, 4, 5, 6, 7, 8 };
            var nA = new NumberArray(8);
            nA.sort(numbersB);
        }));

        System.out.println(Utils.timeit(() -> {
            int[] numbersC = { 1, 2, 3, 4, 5, 6, 7, 8 };
            Arrays.sort(numbersC);
        }));
    }

    @Test
    public void testInsertionSort() {
        int[] numbers = { 5, 1, 8, 3, 1 };
        var nA = new NumberArray(5);
        nA.insertionSort(numbers);
    }

    @Test
    public void testMode() {
        int[] nums = { 1, 7, 5, 7, 10, 7, 7, 10, 10 };
        var nA = new NumberArray(5);
        System.out.println(nA.findMode(nums));
    }

    @Test
    public void testFindLongestConsecutive() {
        int[] nums = new int[] { 3, 4, 5, 4, 3, 2, 34, 4, 5, 65, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 2, 2, 2, 3, 4, 5, 2, 2,
                2 };
        var nA = new NumberArray(5);
        System.out.println(Utils.timeit(() -> {
            nA.findLargestConsecutive(nums);
        }));
    }

    @Test
    public void testRotatedArray() {
        int[] nums = { 1, 7, 5, 7, 10, 7, 7, 10, 10 };
        var nA = new NumberArray(5);
        System.out.println(Arrays.toString(nA.rotateArray(nums, 3)));
    }
}
