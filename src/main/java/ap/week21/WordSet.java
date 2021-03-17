package ap.week21;

import java.util.ArrayList;
import java.util.List;

public class WordSet {

    private List<String> wordList;

    public WordSet() {
        wordList = new ArrayList<String>();
    }

    public WordSet(String[] wordArray) {
        wordList = new ArrayList<>();

    }

    public int size() {
        return wordList.size();
    }

    public void insert(String word) {
        if (!contains(word)) {
            wordList.add(word.toUpperCase());
        }
    }

    public void remove(String word) {
        if (contains(word)) {
            wordList.remove(word.toUpperCase());
        }
    }

    public String findItem(int k) {
        String word = "";

        // Sort the list first

        // k-1 is index

        return word;

    }

    public boolean contains(String word) {
        for (String s : wordList) {
            if (s.toUpperCase().compareTo(word) == 0) {
                return true;
            }
        }

        return false;
    }

    public void insertionSort() {

    }

    public int countA() {
        int count = 0;

        for (String s : wordList) {
            if (s.charAt(0) == 'A') {
                count++;
            }
        }

        return count;
    }

    public void removeA() {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).charAt(0) == 'A') {
                wordList.remove(i);
            }
        }
    }

    public void display(String s) {
        System.out.println(s);
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(i + "\t" + wordList.get(i));
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return wordList.toString();
    }

} // end class