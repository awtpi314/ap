package ap;

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
}
