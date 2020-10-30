package ap.week10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SentenceTest {
    Sentence sentence = new Sentence("");

    @Test
    public void testCountWords() {
        sentence.setSetence("hello, there!");
        assertEquals(2, sentence.countWords());
        sentence.setSetence("the fat cat sat on a rat");
        assertEquals(7, sentence.countWords());
        sentence.setSetence("fourscore and twenty years ago our forefathers founded this country");
        assertEquals(10, sentence.countWords());
    }

    @Test
    public void testGetBlankPositions() {
        sentence.setSetence("hello, there!");
        int expectedPositionsA[] = { 6 };
        assertTrue(compare(expectedPositionsA, sentence.getBlankPositions()));
        sentence.setSetence("the fat cat sat on a rat");
        int expectedPositionsB[] = { 3, 7, 11, 15, 18, 20 };
        assertTrue(compare(expectedPositionsB, sentence.getBlankPositions()));
        sentence.setSetence("fourscore and twenty years ago our forefathers founded this country");
        int expectedPositionsC[] = { 9, 13, 20, 26, 30, 34, 46, 54, 59 };
        assertTrue(compare(expectedPositionsC, sentence.getBlankPositions()));
    }

    @Test
    public void testGetWords() {
        
    }

    private boolean compare(int[] intArray, List<Integer> intList) {
        if (intArray.length != intList.size()) {
            return false;
        }

        for (int i = intList.size() - 1; i >= 0; i--) {
            if (intArray[i] != intList.get(i)) {
                return false;
            }
        }

        return true;
    }
}
