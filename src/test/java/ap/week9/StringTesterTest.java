package ap.week9;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ap.Utils;

public class StringTesterTest {
    @Test
    public void testWhitespaceInsert() {
        StringTester st = new StringTester("abcdefghijklmnop");
        System.out.println(st.retrieveAllChars());
    }

    @Test
    public void testIsPalidrome() {
        StringTester st = new StringTester("a bc123def$g fed345c&*@ba");
        assertEquals(true, st.isPalidrome());
    }

    @Test
    public void testCountSubstrings() {
        StringTester st = new StringTester("greeandn egandgs and haandm");
        assertEquals(4, st.countSubstrings("and"));
    }

    @Test
    public void testRemoveAllStrings() {
        StringTester st = new StringTester("greeandn egandgs and haandm");
        System.out.println(st.removeAll("and"));
    }

    @Test
    public void testSpeed() {
        String original = "greeandn egandgs and haandm";
        String toReplace = "and";

        System.out.println(Utils.timeit(() -> {
            String result = "";

            for (int i = 0; i < original.length(); i++) {
                if (original.charAt(i) == toReplace.charAt(0)) {
                    int j;
                    for (j = 0; j < toReplace.length(); j++) {
                        if (original.charAt(i + j) != toReplace.charAt(j)) {
                            result += original.substring(i, i + j);
                            break;
                        }
                    }
                    i += j - 1;
                } else {
                    result += original.charAt(i);
                }
            }
        }));

        System.out.println(Utils.timeit(() -> {
            char[] originalChars = original.toCharArray();
            char[] toReplaceChars = toReplace.toCharArray();
            List<Character> charResult = new ArrayList<>();

            for (int i = 0; i < originalChars.length; i++) {
                if (originalChars[i] == toReplaceChars[0]) {
                    int j;
                    for (j = 0; j < toReplaceChars.length; j++) {
                        if (originalChars[i + j] != toReplaceChars[j]) {
                            for (int k = i; k < i + j; k++) {
                                charResult.add(originalChars[k]);
                            }
                            break;
                        }
                    }
                    i += j - 1;
                } else {
                    charResult.add(originalChars[i]);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (Character c : charResult) {
                stringBuilder.append(c);
            }
            String strResult = stringBuilder.toString();
        }));

        System.out.println(Utils.timeit(() -> {
            StringBuilder sb = new StringBuilder(original);
            int index = 0;
            int toReplaceLength = toReplace.length();
            while (true) {
                index = sb.indexOf(toReplace, index);
                if (index != -1) {
                    sb.delete(index, index + toReplaceLength);
                } else {
                    break;
                }
            }
        }));
    }

    @Test
    public void testSpeedReverse() {
        String original = "abcdefghijk";

        System.out.println(Utils.timeit(() -> {
            char[] originalChars = original.toCharArray();
            char[] reversedChars = new char[originalChars.length];
            int length = originalChars.length;

            for (int i = 0, j = length - 1; i < length; i++, j--) {
                reversedChars[i] = originalChars[j];
            }
        }));

        System.out.println(Utils.timeit(() -> {
            char[] chars = original.toCharArray();

            char tmp;
            int loopCount = chars.length / 2;

            for (int i = 0, j = chars.length - 1; i < loopCount; i++, j--) {
                tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
        }));
    }

    @Test
    public void test() {
        String input = "tempus fugit";
        int size = input.length();
        String sub = "";

        sub = input.substring(0, size + 1);
        System.out.println(sub);
    }
}
