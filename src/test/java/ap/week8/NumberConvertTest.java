package ap.week8;

import org.junit.Before;
import org.junit.Test;

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
}
