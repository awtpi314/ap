package ap.week9;

public class StringTester {
    private String original;

    public StringTester(String inString) {
        this.original = inString;
    }

    public String retrieveAllChars() {
        String result = "";
        int size = original.length();

        for (int i = 0; i < size; i++) {
            result += original.charAt(i) + " ";
        }

        return result;
    }

    public boolean isPalidrome() {
        int size, half;
        String noSpecialsString = removeSpecialChars();

        size = noSpecialsString.length();
        half = size / 2;
        size--;

        for (int i = 0; i < half; i++) {
            if (noSpecialsString.charAt(i) != noSpecialsString.charAt(size - i)) {
                return false;
            }
        }
        return true;
    }

    public String reversedString() {
        char[] chars = original.toCharArray();

        char tmp;
        int loopCount = chars.length / 2;

        for (int i = 0, j = chars.length - 1; i < loopCount; i++, j--) {
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }

        return String.copyValueOf(chars);
    }

    public int countSubstrings(String subString) {
        int index = 0;
        int length = subString.length();
        int count = 0;
        while (index != -1) {
            index = this.original.indexOf(subString, index + length);
            count++;
        }
        return --count;
    }

    public String removeAll(String searchString) {
        if (searchString == null || searchString.isBlank())
            return this.original;
        return this.original.replaceAll(searchString, "");
    }

    private String removeSpecialChars() {
        String result = "";
        int halfString = result.length() / 2;
        char currentChar;
        for (int i = 0; i < halfString; i++) {
            currentChar = this.original.charAt(i);
            if (!((currentChar > 0x40 && currentChar < 0x5B) || (currentChar > 0x60 && currentChar < 0x7B))) {
                result += currentChar;
            }
        }
        return result;
    }
}
