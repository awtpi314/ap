package ap.week8.Class;

/**
 * Program: Number This program converts an integer to a binary, hex string. Has
 * other numerical calculations Class: AP Java
 * 
 * @author Shepardo Da Vinci
 * @author Zheng
 * @version since 10/12/2020
 */

public class DaVinciNumber {
    private int myNum;
    private String myBinary;
    private String myHex;
    private int sumOfDigits;
    private int reversedNum;

   /**
    * constructor Precondition: num >= 0
    */
   public DaVinciNumber(int num) {
      myNum = num;
      myBinary = convertToBinary();
      myBinary = packUpZeros();
      myHex = convertToHex();
   } // end constructor

    /**
     * Get the string output of Number class
     */
    public String toString() {
        sumOfDigits = sumDigits(myNum);
        reversedNum = reverseNumber(myNum);
        if (reversedNum == -1) {
            return "input number:\t" + myNum + "\nnumber of digits:\t" + numOfDigits() + "\nsum of digits:\t"
                    + sumOfDigits + "\nthe reversed num:\t Number too big\n" + myNum + " = " + myBinary + " = " + myHex;
        } else {
            return "input number:\t" + myNum + "\nnumber of digits:\t" + numOfDigits() + "\nsum of digits:\t"
                    + sumOfDigits + "\nthe reversed num:\t" + reversedNum + "\n" + myNum + " = " + myBinary + " = "
                    + myHex;
        }
    } // end method

    /**
     * @return Polished binary string
     */
    public String getBinary() {
        return myBinary;
    } // end method

    /**
     * @return Hex string
     */
    public String getHex() {
        return myHex;
    } // end method

    /**
     * Convert myNum to binary
     * 
     * @return Binary string
     */
    private String convertToBinary() {
        return convertToBase(myNum, 2);
    } // end method

    /**
     * Convert myNum to Hexadecimal
     * 
     * @return Hex string
     */
    private String convertToHex() {
        return convertToBase(myNum, 16);
    } // end method

    /**
     * @param num Number to convert to hexadecimal digit
     * @return the digit in hexadecimal (or beyond) for any decimal number
     */
    private char getHexDigit(int num) {
        char letter = '\0';

        if (num < 10) {
            letter = (char) (num + '0');
        } else {
            letter = (char) (num - 10 + 'A');
        }
        return letter;
    } // end method

    /**
     * Precondition: base > 0 && base <= 26
     *
     * @param number Number to convert
     * @param base   Base system to convert to
     * @return Converted number to inputted base system
     */
    private String convertToBase(int number, int base) {
        if (number == 0) {
            return "0";
        }

        int quotient = 0;
        int remainder = 0;
        String result = "";

        quotient = number;

        while (quotient != 0) {
            remainder = quotient % base;
            // Protects edge case where digit >= 10
            if (remainder >= 10) {
                result = getHexDigit(remainder) + result;
            } else {
                result = remainder + result;
            }
            quotient /= base;
        } // end while
        return result;
    } // end method

    /**
     * Postcondition: The length of the binary string is a multiple of 4. Combined
     * toString function from BinaryNumber class
     *
     * @return Polished binary string with packed up zeroes and spaces every 4 bits
     */
    private String packUpZeros() {
        String binaryNum = myBinary;
        while ((binaryNum.length() % 4 != 0)) {
            binaryNum = "0" + binaryNum;
        } // end while

        int i = 0;
        String result = "";

        // pack an empty space after every 4 bits to enhance reading
        for (i = 0; i < (binaryNum.length()) / 4; i++) {
            result = result + binaryNum.substring(4 * i, 4 * i + 4) + " ";
        } // end for

        return result;
    } // end method

    /**
     * 
     * @return Number of Digits in myNum
     */
    private int numOfDigits() {

        // one way --- return Integer.toString(myNum).length();

        int numDigits = 0;
        for (int quotient = myNum; quotient > 0; quotient /= 10) {
            numDigits++;
        } // end for

        return numDigits;
    } // end method

    /**
     * 
     * @param num Number to sum
     * @return Sum of digits of num
     */
    private int sumDigits(int num) {
        int sum = 0;
        int quotient = num;

        for (int i = 0, length = numOfDigits(); i < length; i++) {
            sum += quotient % 10;
            quotient /= 10;
        } // end for

        return sum;
    } // end method

    /**
     * 
     * @param num Num to reverse
     * @return Reversed num or -1 if number too large
     */
    private int reverseNumber(int num) {
        long reversed = 0;
        int quotient = num;

        for (int power = 1, length = numOfDigits(); power <= length; power++) {
            reversed += (quotient % 10) * Math.pow(10, length - power);
            quotient /= 10;
        } // end for

        if (reversed > Integer.MAX_VALUE) {
            return -1;
        }
        return (int) reversed;
    } // end method

} // end class