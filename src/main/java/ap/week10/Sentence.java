package ap.week10;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private String sentence;

    public Sentence(String s) {
        setSetence(s);
    }

    public void setSetence(String s) {
        sentence = s;
    }

    public List<Integer> getBlankPositions() {
        List<Integer> positions = new ArrayList<>();
        int index = sentence.indexOf(' ');
        while (index != -1) {
            positions.add(index);
            index = sentence.indexOf(' ', index + 1);
        }
        return positions;
    }

    public int countWords() {
        if (sentence == null || sentence.equals("")) {
            return 0;
        }

        int count = 1;

        int index = sentence.indexOf(' ');
        while (index != -1) {
            count++;
            index = sentence.indexOf(' ', index + 1);
        }

        return count;
    }

    public String[] getWords() {
        return sentence.split(" ");
    }
}
