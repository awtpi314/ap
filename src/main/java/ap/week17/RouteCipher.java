package ap.week17;

import java.util.Arrays;

/**
 * <h3>RouteCipher</h3>
 * <p>
 * RouteCipher is a class for encrypting string messages. The method of
 * encryption used is the block cipher. The block size can be specified in the
 * constructor.
 * </p>
 * 
 * @author Alexander Taylor
 * @version 1.0
 * @since 1/7/2020
 */
public class RouteCipher {
    private String[][] letterBlock;
    private int numRows;
    private int numColumns;

    /**
     * The constructor for RouteCipher.
     * 
     * @param nR the number of rows to have in a block
     * @param nC the number of columns to have in a block
     */
    public RouteCipher(int nR, int nC) {
        numRows = nR;
        numColumns = nC;
        letterBlock = new String[nR][nC];
    }

    /**
     * fillBlock is a private method used for filling {@link #letterBlock } in
     * row-major order.
     * <p>
     * If <i>s</i> is longer than the block, the end of the string is truncated. On
     * the other hand, if the string is shorter than the block, the remaining spaces
     * are filled with capital "A"s.
     * </p>
     * 
     * @param s the string with which to fill {@link #letterBlock}
     */
    private void fillBlock(String s) {
        int k = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numColumns; c++) {
                if (k < s.length()) {
                    letterBlock[r][c] = s.substring(k, k + 1);
                    k++;
                } else {
                    letterBlock[r][c] = "A";
                }
            }
        }
    }

    /**
     * encryptBlock is a private method used for reading the contents of
     * {@link #letterBlock} in column-major order
     * 
     * @return the string result of the column-major reading
     */
    private String encryptBlock() {
        String result = "";
        for (int c = 0; c < numColumns; c++) {
            for (int r = 0; r < numRows; r++) {
                result += letterBlock[r][c];
            }
        }
        return result;
    }

    /**
     * encryptMessage takes the parameter message and transforms it according to the
     * block cipher.
     * 
     * @param message the message to encrypt
     * @param debug   print intermediate steps
     * @return the encrypted message
     */
    public String encryptMessage(String message, boolean debug) {
        if (message.length() == 0 || numRows == 0 || numColumns == 0) {
            return "";
        }

        final int blockSize = numRows * numColumns;
        final int totalBlocks = message.length() % blockSize != 0 ? message.length() / blockSize + 1
                : message.length() / blockSize;
        String result = "";
        String str = "";

        str = message;
        for (int block = 0; block < totalBlocks; block++) {
            fillBlock(str);

            if (debug) {
                System.out.println("block = " + block + ":\n" + this.toString());
            }

            result += encryptBlock();
            if (str.length() > blockSize) {
                str = str.substring(blockSize);
            }
        }

        return result;
    }

    /**
     * fillBlockInColumnOrder is a private method designed to fill
     * {@link #letterBlock} in column order with <b>str</b>.
     * 
     * @param str the string to fill into {@link #letterBlock}
     */
    private void fillBlockInColumnOrder(String str) {
        int strIndex = 0;
        for (int c = 0; c < numColumns; c++) {
            for (int r = 0; r < numRows; r++) {
                letterBlock[r][c] = str.substring(strIndex, ++strIndex);
            }
        }
    }

    /**
     * decryptBlock is a private method for reading the contents of
     * {@link #letterBlock} in row-major order in order to decrypt the message.
     * 
     * @return the decrypted block
     */
    private String decryptBlock() {
        String result = "";

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numColumns; c++) {
                result += letterBlock[r][c];
            }
        }

        return result;
    }

    /**
     * decryptMessage takes the encrypted string <b>s</b> and decrypts it according
     * to the block cipher.
     * 
     * @param s the encrypted string
     * @return the decrypted string
     */
    public String decryptMessage(String s) {
        final int blockSize = numRows * numColumns;
        final int numBlocks = s.length() / blockSize;

        String result = "";

        for (int i = 0; i < numBlocks; i++) {
            final int currentPos = i * blockSize;
            if (currentPos + blockSize + 1 < s.length()) {
                fillBlockInColumnOrder(s.substring(currentPos, currentPos + blockSize));
            } else {
                fillBlockInColumnOrder(s.substring(currentPos));
            }
            result += decryptBlock();
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "";

        for (String[] s : letterBlock) {
            result += Arrays.toString(s);
            result += "\n";
        }

        return result;
    }
}
