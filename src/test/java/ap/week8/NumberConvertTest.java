package ap.week8;

import org.junit.Before;
import org.junit.Test;

import ap.week8.Class.ZZZGuyNumber;

public class NumberConvertTest {
    NumberConvert nc;

    @Before
    public void initialize() {
        this.nc = new NumberConvert(4095);
    }

    @Test
    public void testToString() {
        this.nc.toString();
    }

    @Test
    public void testZZZGuyNumber() {
        ZZZGuyNumber number = new ZZZGuyNumber(4000);
        System.out.println(number.toString());
    }
}
