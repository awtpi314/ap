package ap.week6;

import org.junit.Before;
import org.junit.Test;

public class BinaryNumberTest {
    private BinaryNumber binNum;

    @Before
    public void initialize() {
        binNum = new BinaryNumber(31);
    }

    @Test
    public void testGetBinary() {
        System.out.println(binNum.decimalToBinary());
    }

    @Test
    public void testValues() {
        int numDigits = 0;
        int number = 123456;
        while (number % 10 > 0) {
            number /= 10;
            numDigits++;
        }
        System.out.println(numDigits);
    }
}
