package ap.week10;

import org.junit.Test;

public class FormLetterTest {
    @Test
    public void testFormLetter() {
        String[] strArray = { "Dear @,", "If you buy a garden gnome, you will",
                "have the best-looking house in you &, ", "heck, @, in the whole state of $! ",
                "@, @, @, don't delay!" };
        Customer c1 = new Customer("Adams", "Ithaca", "New York");
        Customer c2 = new Customer("Jack Smith", "Glendale", "California");
        Customer c3 = new Customer("Delgado", "Honolulu", "Hawaii");

        Customer[] custArray = { c1, c2, c3 };

        FormLetter fl = new FormLetter(strArray, custArray);

        // test replaceAll
        String line = fl.replaceAll("oh me oh my", "oh", "aah");
        System.out.println(line);
        line = fl.replaceAll("your God, your people", "your", "my");
        System.out.println(line);
        
        line = fl.replaceAll("ooh la la", "ah", "oh");
        System.out.println(line);
        // all is well

        // write letters now
        System.out.println("\nHere are the customized letters. \n");
        fl.createPersonalizedLetters();
    }
}
