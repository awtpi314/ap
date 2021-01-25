package ap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GeneralTests {
    @Test
    public void testPerfReverseNum() {

        System.out.println(Utils.timeit(() -> {
            int num = Integer.MAX_VALUE / 100;
            int result = 0;
            for (int power = Integer.toString(num).length() - 1; num > 0; power--) {
                result += num % 10 * Math.pow(10, power);
                num /= 10;
            }
            System.out.println(result);
        }));

        System.out.println(Utils.timeit(() -> {
            int num = Integer.MAX_VALUE / 100;
            int result = 0;
            result = Integer.parseInt(new StringBuilder(Integer.toString(num)).reverse().toString());
            System.out.println(result);
        }));
    }

    @Test
    public void testEnhancedFor() {
        int[][] data = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        for (int[] dataLine : data) {
            for (int i = 0; i < dataLine.length; i++) {
                dataLine[i]++;
            }
        }

        for (int[] dataLine : data) {
            System.out.println(Arrays.toString(dataLine));
        }
    }

    @Test
    public void randomTest() {
        List<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(1);
        list.add(0, 2);
        list.add(1, 3);
        list.set(2, 4);
        list.remove(3);
        list.add(5);

        System.out.println(list);
    }
}
