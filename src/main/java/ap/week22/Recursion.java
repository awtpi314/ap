package ap.week22;

/**
 * Program: Recursion Class: AP Java Session 1
 * 
 * @author: Zheng
 * @since: 1/27/2021
 */
public class Recursion {

    /****************************************
     *** Recursions for int ***
     *****************************************/
    public static int gcd(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        } else if (n == m) {
            return n;
        } else if (n > m) {
            return gcd(n - m, m);
        } else {
            return gcd(n, m - n);
        }
    } // end method

    /**
     * Another method for calculating GCD.
     */
    public static int GCD(int n, int m) {

        /* to be implemented */
        return 0;

    }

    /**
     * Read Textbook 14.3 P481 - 483
     * 
     * @param n positive int
     * @return the nth Fibonacci number
     */
    public static int fib(int n) {

        /* to be implemented */
        return 0;

    }

    /**
     * Return factorial of n
     */
    public static long factorial(int n) {

        /* to be implemented */
        return 0;

    } // end method

    /**
     * @param num long
     * @return int num of digits
     */
    public static int numOfDigits(long num) {

        /* to be implemented */
        return 0;

    }

    /**
     * Precondition: num > 0
     * 
     * @param num long
     * @return int sum of digits
     */
    public static long sumOfDigits(long num) {

        /* to be implemented */
        return 0;

    }

    /**
     * Determine if the number is divisible by 9
     * 
     * @param num int
     * @return true if it is divisible by 9 false if it is not.
     */
    public static boolean divisibleBy9(long num) {
        return sumUpDigits(num) % 9 == 0;
    }

    /**
     * Helping method for divisibleBy9
     * 
     * For example: sumOfDigits(81) returns 9 sumOfDigits(123) returns 6
     *
     * sum of digits (457829) ---> 35 ---> 8 sumOfDigits(457829) returns 8
     * 
     * @param num int
     * @return int
     */
    private static long sumUpDigits(long num) {
        long sum = 0;

        // while loop to calculate the sum of digits
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }

        if (sum <= 9)
            return sum;
        else
            return sumUpDigits(sum);
    } // end method

    /**
     * For a call of getMirror(720), it returns a string of 027720.
     */
    public static String getMirror(long num) {
        String result = "";

        /* to be implemented */
        return result;

    } // end method

    /**
     * Reverse the digits of a num
     * 
     * @param int
     * @return String
     */
    public static String reverseDigits(int num) {
        String result = "";

        /* to be implemented */
        return result;

    } // end method

    /**
     * Return the binary string. Precondition: num > 0
     * 
     * @param int
     * @param String
     */
    public static String toBinary(int num) {

        String result = "";

        /* to be implemented */
        return result;

    }

    /**
     * Calculate power of base to the exponent of expo int expo can be positive or
     * negative. For example: 2^3 = 2 * 2^2 2^(-3) = 2^(-1) * 2^(-2) Precondition:
     * base != 0
     * 
     * @param double base
     * @param expo   int
     * @return double
     */
    public static double power(double base, int expo) {
        if (expo == 0) {
            return 1;
        } else if (expo > 0) {
            return base * power(base, expo - 1);
        } else { // expo < 0

            /* to be implemented */
            return 0;

        }
    }// end method

    /****************************************
     *** Recursions for int[] ***
     *****************************************/

    /**
     * Calculate the sum of all integers in array
     * 
     * @param int[]
     * @param int   length of the array
     * @return the sum of the array
     */
    public static int sum(int[] array, int size) {

        /* to be implemented */
        return 0;

    } // end method

    /**
     * Find the smallest int in the array
     * 
     * @param int[]
     * @param the   length of the array
     * @return int the smallest int
     */
    public static int smallest(int[] array, int size) {
        int smaller = 0;

        if (size == 1) {
            return array[0];
        } else {
            smaller = smallest(array, size - 1);
            if (smaller < array[size - 1]) {
                return smaller;
            } else {
                return array[size - 1];
            }
        } // end if
    } // end method

    /*
     * Find the largest int in the array
     * 
     * @param int[]
     * 
     * @param the length of the array
     * 
     * @return int the largest int
     */
    public static int largest(int[] array, int size) {

        /* to be implemented */
        return 0;

    } // end method

    /**
     * Reverse the items in the array
     * 
     * @param int[]
     * @param size  the length of the array
     */
    public static void reverseArray(int[] array, int size) {
        int temp;
        if (size <= array.length / 2 + 1) {
            return;
        } else {
            // swap the first and the last
            temp = array[size - 1];
            array[size - 1] = array[array.length - size];
            array[array.length - size] = temp;
            reverseArray(array, size - 1);
        }
    } // end method

    /**
     * Return the frequency of key int the array
     */
    public static int frequency(int[] array, int key, int size) {

        /* to be implemented */
        return 0;

    }

    /****************************************
     *** Recursions for String ***
     *****************************************/

    /**
     * Return true if the string is in alphebetical order, otherwise return false.
     */
    public static boolean isABCOrder(String str) {

        /* to be implemented */
        return false;

    }

    /**
     * Prepare a str to be check by isPalindrome convert to lowercase remove
     * non-letters including space
     * 
     * @param String
     * @return boolean true for palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        // convert to lower case
        String s = str.toLowerCase();
        int index = 0;
        char c;

        // remove space and any non-letter characters
        index = 0;
        while (index < s.length()) {
            c = s.charAt(index);
            if (c >= 'a' && c <= 'z') {
                index++;
            } else {
                s = s.substring(0, index) + s.substring(index + 1);
            }
        } // end while

        return isPalindrome(s, 0, s.length() - 1);

    } // end method

    /**
     * Return true if the string is a palindrome; otherwise, return false.
     * Precondition: str is all lowercase or uppercase. Palindrome examples: hannah,
     * racecar, madam, "A man, a plan, a canal - Panama" "Madam, I'm Adam" "Never
     * odd or even"
     * 
     * @param string
     * @param int    start
     * @param int    end
     * @return boolean
     */
    private static boolean isPalindrome(String str, int start, int end) {

        /* to be implemented */
        return false;

    } // end method

    /**
     * Return the reverse of the string
     *
     * tail-recursion
     *
     * @param String
     * @return reversed String
     */
    public static String reverseStringTail(String str) {
        int size = str.length();

        if (size == 1) {
            return str;
        } else {
            return str.substring(size - 1, size) + reverseStringTail(str.substring(0, size - 1));
        }
    } // end method

    /**
     * Return the reverse of the string.
     *
     * head-recursion
     *
     * @param String
     * @return reversed String
     */
    public static String reverseStringHead(String str) {

        /* to be implemented */
        return "";

    } // end method

    /**
     * For a call of getMirror("hello"), it returns: ollehhello
     */
    public static String getMirror(String str) {

        /* to be implemented */
        return "";

    } // end method

}// end class