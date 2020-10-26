package ap.week8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ForLoopFunctionsTest {
    @Test
    public void testRectangle() {
        ForLoopFunctions flf = new ForLoopFunctions(4, 5);
        flf.printRectangle();
    }

    @Test
    public void testTriangle1() {
        ForLoopFunctions flf = new ForLoopFunctions(4, 4);
        flf.printTriangle1();
    }

    @Test
    public void testTriangle2() {
        ForLoopFunctions flf = new ForLoopFunctions(4, 4);
        flf.printTriangle2();
    }

    @Test
    public void testRectangleFrame() {
        ForLoopFunctions flf = new ForLoopFunctions(4, 5);
        flf.printRectangleFrame();
    }

    @Test
    public void testTriangleFrame1() {
        ForLoopFunctions flf = new ForLoopFunctions(4, 5);
        flf.printTriangleFrame1();
    }

    @Test
    public void testTriangleFrame2() {
        ForLoopFunctions flf = new ForLoopFunctions(4, 5);
        flf.printTriangleFrame2();
    }

    @Test
    public void testGCD() {
        ForLoopFunctions flf = new ForLoopFunctions(9, 18);
        assertEquals(9, flf.gcd());
        try {
            flf.setNumbers(9, 24);
        } catch (Exception e) {
        }
        assertEquals(3, flf.gcd());
    }
}
