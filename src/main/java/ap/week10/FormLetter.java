package ap.week10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FormLetter {
    private List<String> lines;
    private List<Customer> customers;

    public FormLetter(String[] letterLines, Customer[] customerArray) {
        lines = Arrays.asList(letterLines);
        customers = Arrays.asList(customerArray);
    }

    public List<String> makeCopy() {
        List<String> result = new ArrayList<>();
        lines.forEach(result::add);
        return result;
    }

    public String replaceAll(String text, String toReplace, String replaceWith) {
        StringBuilder sb = new StringBuilder(text);
        int currentIndex = sb.indexOf(toReplace);
        int replaceLength = toReplace.length();

        while (currentIndex != -1) {
            sb.replace(currentIndex, currentIndex + replaceLength, replaceWith);
            currentIndex = sb.indexOf(toReplace);
        }
        return sb.toString();
    }

    public void writeLetter(List<String> outList) {
        outList.forEach(System.out::println);
        System.out.println();
    }

    public void createPersonalizedLetters() {
        List<String> form = makeCopy();
        for (Customer customer : customers) {
            List<String> output = new ArrayList<String>();
            form.forEach((String line) -> {
                String finishedString = replaceAll(
                        replaceAll(replaceAll(line, "@", customer.getName()), "&", customer.getCity()), "$",
                        customer.getState());
                output.add(finishedString);
            });
            writeLetter(output);
        }
    }
}
