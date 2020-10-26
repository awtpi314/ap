package ap.week9;

/**
 * Program: StringTester Class: AP Java
 * 
 * @author Zheng
 * @version since 10/5/2020
 *
 *          Testing data set:
 * 
 *          write, code, praise A fat cat sat on a mat, chatting with a rat.
 *          madam racecar eye A man a plan a canal Panama
 */
public class SkeletonWeek9StringTester{
   private String original; 

   /**
   *  Constructor
   */
   public SkeletonWeek9StringTester(String original){
       this.original = original; 
   }

   /**
   *  Change the implmentation with substring(i, i+1) to retrieve 
   *  characters in the original string
   *  
   *  Separate characters with spaces.
   *  @return String
   */
   public String retrieveAllChars(){
      String result = ""; 
      for (int i = 0; i < original.length(); i++) {
         result += original.charAt(i) + " ";
      }
      return result;
   }


   /**
   *  Remove white spaces or any characters other than digits and letters.
   *  Check if the string is a palindrome.
   *  Return true if it is a palindrome; 
   *  Otherwise, return false.
   *  @return boolean
   */
   public boolean isPalindrome(){
      int size, half; 
      
      String str = removeSpacesAndSymbols();
      str = str.toLowerCase();
      size = str.length();
      half = size / 2; 
      for(int i = 0; i < half; i++){
         if(str.charAt(i) != str.charAt(size - 1 - i)){
            return false;
         }
      }
     return true;
   }
   
   
   /**
   *  Remove white spaces and any characters other than digits and letters.
   *  Using Unicode for digits, uppper case letters and lowercase letters
   *  @return String
   */
   private String removeSpacesAndSymbols(){
      char theChar;
      String result = ""; 
      //System.out.println(original);  // to debug
      
      /* to be implemented */ 
      result = original;
      
      //System.out.println(result);    // to debug
      return result;
   }
   
   /**
   *  Reverse the original string
   *  @return the reversed String
   */
   public String reversedString(){
      String result = ""; 
      int size, half; 
      String firstHalf = ""; 
      String secondHalf = ""; 
      
      size = original.length();
      half = size / 2; 
      
      /* to be implemented */ 
      result = original.substring(0, half) + original.substring(half);
      
      return result;
   }
   
   /**
   *  Count how many sub in the original string
   *  @return int the number of substrings in original
   */
   public int countSubstrings(String sub){
      int count = 0; 
      int index; 
      
      if(sub == null || sub.length() == 0)
         return 0; 
         
      String str = original;     // keep original intact
      index = str.indexOf(sub);
      while(index != -1){
         count ++; 
         str = str.substring(index + 1);     // or index + sub.length()
         index = str.indexOf(sub);
      }
        
      return count;
   }
 
 
   /**
   *  Remove all oldStr substrings in the original string
   *  @return String 
   */
   public String removeAll(String oldStr){
      String result = ""; 
      int index = 0; 
      
      // input checking:
      if(oldStr == null || oldStr.length() == 0){
         return original;
      }
      
      result = original;
      
      /* to be implemented */
     
      return result;
   }
   
   /**
   *  Replace the oldStr with newStr in the original string
   *  @return String 
   */
   public String replaceAll(String oldStr, String newStr){
      String result = ""; 
      int index = 0; 
      
      // input checking:
      if(oldStr == null || oldStr.length() == 0){
         return original;
      }
      
      result = original;
      index = result.indexOf(oldStr);

      /* to be implemented */ 
      
      return result;
   }
   
   /**
   *  Write the result
   *  @return String 
   */
   public String toString(){
   
      String result = ""; 
  
      result = "\n" + retrieveAllChars();
      result += "\nisPalindrome = \t\t" + isPalindrome();
      result += "\n" + "the reversed string: " + reversedString();
      result += "\n";
       
      return result;
   }
   
} // end class