package ap.week17;

import org.junit.Test;

public class RouteCipherTest {
    @Test
    public void testRouteCipher() {
        String message = "Hide my gold";
        String cipheredMessage = "";
        String decipheredMessage = "";
        RouteCipher rC = new RouteCipher(2, 3);

        cipheredMessage = rC.encryptMessage(message, true);
        System.out.println(cipheredMessage);
        decipheredMessage = rC.decryptMessage(cipheredMessage);
        System.out.println(decipheredMessage);
    }
}
