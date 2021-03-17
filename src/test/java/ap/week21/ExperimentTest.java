package ap.week21;

import org.junit.Test;

public class ExperimentTest {
    @Test
    public void test() {
        final int MAX_SIZE = 7;
        int i = 0;
        int index = 0;

        // int[] phArr = {7, 4, 10, 5, 6, 7, 13};
        // int[] phArr = {7, 4, 10, 5, 6, 1, 13};
        // int[] phArr = {7, 9, 8, 8, 12, 13, 14};

        int[] phArr = new int[MAX_SIZE];

        // initialization
        for (i = 0; i < MAX_SIZE; i++) {
            int ph = (int) (15 * Math.random()); // [0, 14]
            // int ph = (int)(8 * Math.random() + 7); // [7, 14]
            phArr[i] = ph;
        }

        int num = (int) (1000 * Math.random());
        index = num % MAX_SIZE;
        boolean b = (num % 2 == 0) ? true : false;
        Experiment epm = new Experiment(phArr, index, b);

        System.out.println("initial index: " + index);
        System.out.println("initial isFacingRight: " + b);
        System.out.println("initial state: ");
        epm.display();

        // find the most acidic index
        index = epm.mostAcidic();
        System.out.println("\nThe most acidic index = " + index);
        epm.display();

        // reset
        System.out.println("\nafter reset ...");
        epm.reset();
        epm.display();
    }

    public static void main(String[] args) {
        (new ExperimentTest()).test();
    }
}
