package ap;

import java.util.Arrays;

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
        String original = "bake and code";
        String oldStr = "e";
        String newStr = "ing";
        String result = "";

        final int oldStrLen = oldStr.length();
        final int loopTimes = original.length() - oldStrLen + 1;

        int i = 0;
        do {
            if (original.substring(i, i + oldStrLen).compareTo(oldStr) == 0) {
                result += newStr;
                i += oldStrLen;
            } else {
                result += original.charAt(i);
                i++;
            }
        } while (i < loopTimes);

        System.out.println(result);
    }
}
