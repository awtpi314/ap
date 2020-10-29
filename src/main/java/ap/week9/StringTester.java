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
        StringBuilder sb = new StringBuilder(original);
        int index = 0;
        int toReplaceLength = searchString.length();
        while (true) {
            index = sb.indexOf(searchString, index);
            if (index != -1) {
                sb.delete(index, index + toReplaceLength);
            } else {
                break;
            }
        }

        return sb.toString();
    }

    private String removeSpecialChars() {
        String result = "";
        int length = result.length();
        char currentChar;
        for (int i = 0; i < length; i++) {
            currentChar = this.original.charAt(i);
            if (!((currentChar > '0' && currentChar < '9') || (currentChar > 'A' && currentChar < 'Z') || (currentChar > 'a' && currentChar < 'z'))) {
                result += currentChar;
            }
        }
        return result;
    }
}
