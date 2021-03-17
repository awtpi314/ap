package ap.week22;

/**
* Program:  Driver Program for 
* Class:    AP Java Session 1
* @author:  Zheng
* @since:   1/27/2021
*/
import java.util.Scanner; 
import java.util.Arrays;

public class DriverRecursion{
   static Scanner keyboard; 
   
   public static void main(String[] args){
      keyboard = new Scanner(System.in);
      int m = 0; 
      int n = 0; 
      long bigNum = 0; 
      String str; 
      
      System.out.print("Please input an integer: ");
      m = readInt();

      System.out.print("Please input another integer: ");
      n = readInt();
      
      int min = Math.min(m, n);
      int max = Math.max(m, n);
      
      System.out.println("gcd = " + Recursion.gcd(m, n));
      System.out.println("GCD = " + Recursion.GCD(m, n));
      
      //System.out.println("fib(6) =  " + Recursion.fib(6) );
      //System.out.println("\n\nfib(10) = " + Recursion.fib(10) );
      System.out.println("fib(2) =  " + Recursion.fib(2) );
      System.out.println("fib(3) =  " + Recursion.fib(3) );      
      System.out.println("fib(4) =  " + Recursion.fib(4) );
      System.out.println("fib(5) =  " + Recursion.fib(5) );
      System.out.println("fib(6) =  " + Recursion.fib(6) );
      System.out.println("fib(7) =  " + Recursion.fib(7) );
      System.out.println("fib(10) = " + Recursion.fib(10) );
    
      bigNum = Recursion.factorial(min);
      
      System.out.println("\nfactorial of " + min + " = " + bigNum);    
      System.out.println("numOfDigits: " + Recursion.numOfDigits(bigNum) );
      System.out.println("sumOfDigits: " + Recursion.sumOfDigits(bigNum) );
      System.out.println("divisibleBy9: " + Recursion.divisibleBy9(bigNum) );
      
      System.out.println("getMirror: " + Recursion.getMirror(bigNum) );
       
      System.out.println("\nm * n = " + m * n);
      System.out.println("reverse m * n: " + Recursion.reverseDigits(m * n));
      System.out.println("binary String: " + Recursion.toBinary (m * n) );
      
      System.out.println("\nbase = " + max + ", expo = " + min + ", power = " + Recursion.power(max, min));
      System.out.println("base = " + m + ", expo = -2, power = " + Recursion.power(m, -2));      
      System.out.println("base = " + m + ", expo = -3, power = " + Recursion.power(m, -3));
      
      int[] array = new int[10];
      
      for (int j = 0; j < array.length; j++) {
         array[j] = (int)(10 * Math.random()); 
      }
      
      System.out.println("\ninitial array: " + Arrays.toString(array)); 
      System.out.println("sum of array: " + Recursion.sum(array, array.length)); 
      System.out.println("smallest = " + Recursion.smallest(array, array.length));
      System.out.println("largest = " + Recursion.largest(array, array.length));
      
      Recursion.reverseArray(array, array.length);     
      System.out.println("reversed: " + Arrays.toString(array));
      
      System.out.println("frequency of 1: " + Recursion.frequency(array, 1, array.length) );
      System.out.println("frequency of 5: " + Recursion.frequency(array, 5, array.length) );

      System.out.print("\nPlease input a string: ");
      str = keyboard.nextLine();
      str = str.toLowerCase();
      
      System.out.println("isABCOrder: " + Recursion.isABCOrder(str) );
      System.out.println(str + " is palindrome: " + Recursion.isPalindrome(str));
      System.out.println("reverseStringTail: " + Recursion.reverseStringTail(str) );
      System.out.println("reverseStringHead: " + Recursion.reverseStringHead(str) );
      
      System.out.println("getMirror: " + Recursion.getMirror(str) );

   }
   
   
   /** 
   * @return int
   */
   public static int readInt(){
      String temp = ""; 
      int number = -999;      
      
      temp = keyboard.nextLine();
      try {
         number = Integer.parseInt(temp);
      }catch(NumberFormatException e) {
         System.out.println("ERROR: " + e.getMessage());
      }
      return number;
   } // end method
   
}