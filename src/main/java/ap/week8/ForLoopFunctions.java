package ap.week8;

/**
 * <h3>ForLoopFunctions</h3>
 * 
 * <p>
 * This class implements the for loop functions that are detailed in the program
 * specs.
 * </p>
 * 
 * <ul>
 * <li><b>Class:</b>
 * <ul>
 * <li>TPS AP Java</li>
 * </ul>
 * </li>
 * </ul>
 * 
 * @author AlexanderTaylor
 * @version 1.0
 * @since October 16, 2020
 */
public class ForLoopFunctions {
    private int num1;
    private int num2;

    public ForLoopFunctions(int n1, int n2) {
        try {
            this.setNumbers(n1, n2);
        } catch (Exception e) {
            System.out.println("n2 needs to be greater than n1... Exiting...");
            System.exit(1);
        }
    }

    /**
     * <h4>SetNumbers</h4>
     * <p>
     * This function sets {@link #num1} and {@link #num2} according to the input
     * parameters.
     * </p>
     * 
     * @param n1 an integer
     * @param n2 an integer greater than n1
     * @throws Exception
     */
    public void setNumbers(int n1, int n2) throws Exception {
        if (n2 < n1) {
            throw new Exception("Number 2 must be greater than number 1.");
        }
        this.num1 = n1;
        this.num2 = n2;
    }

    public void displayRange() {
        System.out.printf("All integers from %d to %d%n", num1, num2);
        for (int i = num1, newline = 0; i <= num2; i++, newline++) {
            System.out.printf("%4d", i);
            if (newline % 10 == 0) {
                System.out.println();
            }
        }
    }

    public int rangeSum() {
        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            sum += i;
        }
        return sum;
    }

    public int rangeProduct() {
        int product = 1;
        for (int i = num1; i <= num2; i++) {
            product *= i;
        }
        return product;
    }

    public int power() {
        int product = num1;
        for (int i = 0; i < num2; i++) {
            product *= num1;
        }
        return product;
    }

    public int gcd() {
        int gcd = 1;
        int loopcount = Math.min(num1, num2) + 1;

        for (int i = 2; i < loopcount; i++) {
            if (num1 % i == 0 && num2 % i == 0)
                gcd = i;
        }

        return gcd;
    }

    public void printRectangle() {
        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
    }

    public void printTriangle1() {
        for (int i = 0; i < num1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printTriangle2() {
        for (int i = 0; i < num1; i++) {
            for (int j = num1 - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void printRectangleFrame() {
        for (int i = 1; i <= num1; i++) {
            for (int j = 1; j <= num2; j++) {
                if (i == 1 || i == num1 || j == 1 || j == num2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printTriangleFrame1() {
        for (int i = 1; i <= num2; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == 1 || i == num2 || j == 1 || j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public void printTriangleFrame2() {
        for (int i = num2; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                if (i == num2 || i == 1 || j == i || j == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
