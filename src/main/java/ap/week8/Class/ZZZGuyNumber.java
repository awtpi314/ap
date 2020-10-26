package ap.week8.Class;

/**
 * Program: Number.java
 * 
 * @Author: ZZZGuy
 * @Version: since 10/15/2020 Testbook p.167-168 create methods: 1. Number 2.
 *           getBinary 3. getHex 4. toString 5. convertToBinary 6. convertToHex
 *           7. getHexDigit 8. packUpZeros 9. numOfDigits
 */

public class ZZZGuyNumber {
    private int myNum, sumOfDigits = 0, reversedNum = 0;
    private String myBinary, myHex;

   /**
   *  Constructor
   *  @param input int
   */
   public ZZZGuyNumber(int input){
      myNum=input;
      myBinary=convertToBinary();
      myBinary=packUpZeros();
      myHex=convertToHex(); 
   }

    /**
     * @param none
     * @return myBinary String
     */
    public String getBinary() {
        return myBinary;
    }

    /**
     * @param none
     * @return myHex String
     */
    public String getHex() {
        return myHex;
    }

    /**
     * @param none
     * @return result String
     */
    public String toString() {
        String result = "input number: " + myNum + "\nnumber of digits: " + numberOfDigits() + "\nsum of digits: "
                + sumOfDigits + "\nthe reversed num: " + reversedNum + "\n" + myNum + " = ";
        for (int i = 0; i < (myBinary.length()) / 4; i++) {
            result = result + myBinary.substring(4 * i, 4 * i + 4) + " ";
        }
        result += "= " + myHex;
        return result;
    }

    /**
     * @param none
     * @return result String
     */
    private String convertToBinary() {
        int quotient = myNum;
        String result = "";
        while (quotient != 0) {
            result = quotient % 2 + result;
            quotient /= 2;
        }
        if (result == "")
            result = "0";
        return result;
    }

    /**
     * @param none
     * @return result String
     */
    private String convertToHex() {
        int quotient = myNum;
        String result = "";
        while (quotient != 0) {
            result = getHexDigit(quotient % 16) + result;
            quotient /= 16;
        }
        if (result == "")
            result = "0";
        return result;
    }

    /**
     * @param num int
     * @return letter char
     */
    private char getHexDigit(int num) {
        char letter = '\0';
        if (num < 10)
            letter = (char) (num + '0');
        else
            letter = (char) (num - 10 + 'A');
        return letter;
    }

    /**
     * @param none
     * @return result String
     */
    private String packUpZeros() {
        String result = "";
        result = myBinary;
        while (result.length() % 4 != 0) {
            result = "0" + result;
        }
        return result;
    }

    /**
     * Get number of digits, but also count sum of digits and reverse the number.
     * 
     * @param none
     * @return digit int
     */
    private int numberOfDigits() {
        int digit;
        String n = Integer.toString(myNum);
        for (digit = 0; digit < n.length(); digit++) {
            sumOfDigits += n.charAt(digit) - '0';
            reversedNum += (n.charAt(digit) - '0') * Math.pow(10, digit);
            Integer.parseInt(new StringBuilder(myNum).reverse().toString());
        }
        return digit;
    }
}