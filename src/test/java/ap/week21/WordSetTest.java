package ap.week21;

import org.junit.Test;

public class WordSetTest {
    @Test
    public void mainTest() {
        String[] wordArray = { "pear", "apple", "orange", "blueberry", "fig", "avocadoes", "apricot", "banana", "grape",
                "papaya" };

        String[] wordArray1 = { "pear", "date", "plum", "blueberry", "fig", "dragon fruit", "apricot", "clementine",
                "strawberry", "lime" };

        WordSet ws = new WordSet(wordArray);
        ws.display("initial state:");

        WordSet ws1 = new WordSet(wordArray1);

        // test contains:
        System.out.println("contains apple?  " + ws.contains("apple"));
        System.out.println("contains lychee?  " + ws.contains("lychee"));

        // test insert
        ws.insert("apple");
        ws.insert("lychee");
        ws.display("\nafter inserting apple and lychee:");

        ws.remove("lychee");
        ws.display("after removing lychee:");

        // test findKth
        System.out.println("findKth(1):\t " + ws.findItem(1));
        System.out.println("findKth(6):\t " + ws.findItem(6));
        System.out.println("findKth(0):\t " + ws.findItem(0));
        System.out.println("findKth(12):\t " + ws.findItem(12));
        ws.display("after findKth: ");

        // test countA
        System.out.println("countA = " + ws.countA());

        // test removeA
        ws.removeA();
        ws.display("after removeA: ");

        // test commonElements
        System.out.println("Testing commonElements ...");
        System.out.println("ws\t" + ws);
        System.out.println("ws1\t" + ws1);
        WordSet comm = commonElements(ws, ws1);
        comm.display("\nCommon elements: ");

    } // end main

    /**
     * Find common elements in two WordSets
     * 
     * @param s1 WordSet
     * @param s2 WordSet
     * @return the wordSet containing only the elements that occur in both s1 and
     *         s2.
     */
    public static WordSet commonElements(WordSet s1, WordSet s2) {
        WordSet comm = new WordSet();

        

        return comm;

    }
}
