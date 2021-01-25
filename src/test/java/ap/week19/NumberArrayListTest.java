package ap.week19;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import ap.Utils;

public class NumberArrayListTest {
    @Test
    public void testFindLongestConsecutive() {
        var nAL = new NumberArrayList(5);
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(new Integer[] { 3, 4, 5, 4, 3, 2, 34, 4, 5, 65, 6,
                6, 6, 6, 6, 6, 5, 4, 3, 2, 2, 2, 2, 3, 4, 5, 2, 2, 2 }));
        System.out.println(Utils.timeit(() -> {
            nAL.findLongestConsecutive(arrayList);
        }));
    }

    @Test
    public void testRemoveConsecutiveDuplicates() {
        var nAL = new NumberArrayList(5);
        ArrayList<Integer> arrayList = new ArrayList<>(
                Arrays.asList(new Integer[] { 0, 0, 0, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 9, 9, 9, 9 }));
        System.out.println(arrayList);
        System.out.println(nAL.removeConsecutiveDuplicates(arrayList));

    }

    @Test
    public void testReverseArray() {
        var nAL = new NumberArrayList(5);
        ArrayList<Integer> arrayList = new ArrayList<>(
                Arrays.asList(new Integer[] { 0, 0, 0, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 9, 9, 9, 9 }));
        System.out.println(arrayList);
        System.out.println(nAL.reversedArray(arrayList));

    }

    @Test
    public void testRotatedArray() {
        var nAL = new NumberArrayList(5);
        ArrayList<Integer> arrayList = new ArrayList<>(
                Arrays.asList(new Integer[] { 0, 0, 0, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 9, 9, 9, 9 }));
        System.out.println(arrayList);
        System.out.println(nAL.rotatedArray(arrayList, 3));
    }

    @Test
    public void testShuffle() {
        var nAL = new NumberArrayList(5);
        ArrayList<Integer> arrayList = new ArrayList<>(
                Arrays.asList(new Integer[] { 0, 0, 0, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 9, 9, 9, 9 }));
        System.out.println(arrayList);
        nAL.shuffle(arrayList);
        System.out.println(arrayList);
    }

    @Test
    public void testMerryGoRound() {
        var nAL = new NumberArrayList(5);
        ArrayList<Integer> arrayList = new ArrayList<>(
                Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }));
        System.out.println(arrayList);
        nAL.merryGoRound(arrayList, 10);
        System.out.println(arrayList);
    }

    @Test
    public void testConsolidated() {
        var nAL = new NumberArrayList(5);
        ArrayList<Integer> arrayList = new ArrayList<>(
                Arrays.asList(new Integer[] { 0, 1, 5, 8, 80, 0, 0, 8, 50, 4, 8, 0, 5, 8, 9, 80, 5 }));
        System.out.println(arrayList);
        nAL.consolidate(arrayList);
        System.out.println(arrayList);
    }
}
