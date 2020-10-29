package ap.week10;

/**
 * Program: StringPool Class: AP Java
 * 
 * @author: Zheng
 * @version: since 10/22/2020
 */
public class ClassDemoWeek10StringPool {

    /**
     * Java String Pool example
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "Cat";
        String str2 = "Cat";
        String str3 = new String("Cat");
        
        // Print characters for numbers 48 to 122
        for (int j = 48; j <= 122; j++) {
            System.out.println(j + " = " + (char)j);
        }
        
        // test ==
//         System.out.println("str1 == str2 : " + (str1==str2));
//         System.out.println("str1 == str3 : " + (str1==str3));
//         System.out.println("str2 == str3 : " + (str2==str3));        
        
        // Testing equals()
//         System.out.println("\nTesing with equals");
//         System.out.println("str1.eqausl str2: " + str1.equals(str2));
//         System.out.println("str1.equals str3: " + str1.equals(str3));
//         System.out.println("str2.equals str3: " + str2.equals(str3));

        System.out.println();
        // Testing with compareTo
//         System.out.println("Testing with compareTo");
//         System.out.println("Mary".compareTo("Mark"));
//         System.out.println("Mark".compareTo("Mary"));
//         System.out.println();
//         System.out.println("MaryAnn".compareTo("Mary"));
//         System.out.println("Mary".compareTo("MaryAnn"));
        
         // Testing concatenation on numbers
         int one = 1; 
         int two = 2; 
         String three = "AND";
         String result; 
         
//          result = one + two + three + two + one; 
//          System.out.println("\n" + result);
        
        /* Testing Exception */
        
        // testing variable initialization        
        
        
        // testing null String object


        String input = "tempus fugit";
        int size = input.length();
        String sub = ""; 
        
        // Testing charAt

      
        // Testing substring(int) 
      
                
        // Testing substring(int, int)        
      

        //sub = input.substring(2, 5);      
        //System.out.println(sub);   
        //sub = input.substring(5, 2);      
        //System.out.println(sub);    
            
    } // end main
    

} // end class
