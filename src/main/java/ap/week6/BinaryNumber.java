package ap.week6;

public class BinaryNumber {
    private int num;
    private String binary;
    private String hex;

    /**
     * Constructs the binary number
     * 
     * @param decNum must be >= zero
     */
    public BinaryNumber(int decNum) {
        this.num = decNum;
        this.binary = decimalToBinary();
    }

    /**
     * Converts the private variable {@link #num} to a binary string
     * 
     * @return a string that represents a binary number
     */
    public String decimalToBinary() {
        // Array to store binary number
        byte[] binaryNum = new byte[32];

        int currentNum = this.num;

        // Counter for binary array
        int i = 0;
        while (currentNum > 0) {
            binaryNum[i] = (byte) (currentNum % 2);
            
            currentNum /= 2;
            i++;
        }

        this.binary = "";
        for (int j = 0; j < 4 - i % 4; j++) {
            this.binary += "0";
        }
        int packCounter = 4 - i % 4;

        for (int j = i - 1; j >= 0; j--) {
            this.binary += Byte.toString(binaryNum[j]);

            packCounter++;
            if (packCounter >= 4) {
                this.binary += " ";
                packCounter = 0;
            }
        }
        return this.binary;
    }

    public String getHex() {
        return hex;
    }
}
