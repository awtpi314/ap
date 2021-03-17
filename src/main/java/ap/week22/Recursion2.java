package ap.week22;

public class Recursion2 {
    public int gcd_1(int n1, int n2) {
        return 0;
    }

    public int gcd_2(int n1, int n2) {
        return 0;
    }

    public int fib(int n) {
        
        return 0;
    }

    public long factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    public int numOfDigits(long n) {
        if (n < 10) {
            return 1;
        } else {
            return numOfDigits(n / 10) + 1;
        }
    }

    public boolean isPalindrome(String s) {
        String tmp = s.toLowerCase();

        for (int i = tmp.length() - 1; i >= 0; i--) {
            if (tmp.charAt(i) < 'a' || tmp.charAt(i) > 'z') {
                tmp = tmp.substring(0, i) + tmp.substring(i + 1);
            }
        }

        return isPalindrome(tmp, 0, tmp.length() - 1);
    }

    private boolean isPalindrome(String s, int first, int last) {
        if (first >= last) {
            return true;
        } else if (s.charAt(first) != s.charAt(last)) {
            return false;
        } else {
            return isPalindrome(s, first + 1, last - 1);
        }
    }

    public String getStringReverseTail(String s) {
        int size = s.length();

        if (size == 1) {
            return s;
        } else {
            return s.substring(size - 1, size) + getStringReverseTail(s.substring(0, size - 1));
        }
    }

    public String getStringReverseHead(String s) {
        int size = s.length();

        if (size == 1) {
            return s;
        } else {
            return getStringReverseHead(s.substring(1)) + s.substring(0, 1);
        }
    }

    public String getMirror(String s) {
        return s + getStringReverseTail(s);
    }
}
