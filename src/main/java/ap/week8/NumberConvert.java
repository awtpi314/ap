package ap.week8;

public class NumberConvert {
    private int decNum;
    private String binNum;
    private String hexNum;
    private int sumOfDigits;
    private int reversedNum;

    public NumberConvert(int decimalNumber) {
        this.decNum = decimalNumber;
        this.sumOfDigits = this.sumOfDigits();
        this.convertToBinary();
        this.convertToHex();
        this.packUpAllZeros();
    }

    public String getBinary() {
        return this.binNum;
    }

    public String getHex() {
        return this.hexNum;
    }

    @Override
    public String toString() {
        String outputString = String.format("%-30s%d%n", "Decimal number:", this.decNum)
                + String.format("%-30s%d%n", "Number of digits:", this.numberOfDigits())
                + String.format("%-30s%d%n", "Sum of digits:", this.sumOfDigits)
                + String.format("%-30s%d%n", "The reversed number:", this.reversedNum)
                + String.format("%d = %s = %s", this.decNum, this.binNum, this.hexNum);
        System.out.println(outputString);
        return outputString;
    }

    private void convertToBinary() {
        String workingBinNum = "";

        int currentNum = this.decNum;

        // Counter for binary array
        while (currentNum > 0) {
            workingBinNum += (currentNum % 2);

            currentNum /= 2;
        }

        this.binNum = workingBinNum;
    }

    private void convertToHex() {
        String workingHexNum = "";

        int currentNum = this.decNum;
        int currentDigit = 0;

        // Counter for binary array
        while (currentNum > 0) {
            currentDigit = (currentNum % 16);
            if (currentDigit < 10) {
                workingHexNum += currentDigit;
            } else {
                workingHexNum += (char)(currentDigit - 10 + 'A');
            }

            currentNum /= 16;
        }

        this.hexNum = workingHexNum;

    }

    private void packUpAllZeros() {
        this.binNum = this.packUpZeros(this.binNum);
        this.hexNum = this.packUpZeros(this.hexNum);
    }

    private String packUpZeros(String num) {
        String workingNum = "";

        int length = num.length();

        int packCounter = 0;
        if (length % 4 != 0) {
            for (int i = 0; i < 4 - length % 4; i++) {
                workingNum += "0";
            }
            packCounter = 4 - length % 4;
        }

        for (int j = length - 1; j >= 0; j--) {
            workingNum += num.charAt(j);

            packCounter++;
            if (packCounter >= 4) {
                workingNum += " ";
                packCounter = 0;
            }
        }

        return workingNum;
    }

    private int numberOfDigits() {
        return Integer.toString(this.decNum).length();
    }

    private int sumOfDigits() {
        int workingNum = this.decNum;
        int total = 0;

        while (workingNum > 0) {
            total += workingNum % 10;
            workingNum /= 10;
        }

        return total;
    }
}
