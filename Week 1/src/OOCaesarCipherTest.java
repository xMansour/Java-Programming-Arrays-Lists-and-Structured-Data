public class OOCaesarCipherTest {

    public static void main(String[] args) {
        OOCaesarCipherTest ooCaesarCipherTest = new OOCaesarCipherTest();
        ooCaesarCipherTest.simpleTest();
    }

    public int[] countLetters(String encrypted) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] freqs = new int[26];
        for (int i = 0; i < encrypted.length(); i++) {
            int index = alphabet.indexOf(encrypted.charAt(i));
            if (index != -1) {
                freqs[index]++;
            }
        }
        return freqs;
    }

    public int maxIndex(int[] freqs) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < freqs.length; i++) {
            if (max < freqs[i]) {
                max = freqs[i];
                index = i;
            }
        }
        return index;       //should be the index of 'e'

    }

    //Write the void method simpleTests that has no parameters. This method should read in a file as a String,
    // create a CaesarCipher object with key 18, encrypt the String read in using the CaesarCipher object,
    // print the encrypted String,
    // and decrypt the encrypted String using the decrypt method.
    public void simpleTest() {
        int key = 18;
        String input = "Hello World";
        OOCaesarCipher ooCaesarCipher = new OOCaesarCipher(key);
        String encrypted = ooCaesarCipher.encrypt(input);
        System.out.println(encrypted + " is the encrypted version of " + input + " using a key = " + key);
        System.out.println("Decrypted using key of " + key + " " + ooCaesarCipher.decrypt(encrypted));
        System.out.println("Decrypted using breakCaesarCipher method " + breakCaesarCipher(input));

    }

    //Write the method breakCaesarCipher that has one String parameter named input.
    // This method should figure out which key was used to encrypt this message (in a similar manner as the previous lesson),
    // then create a CaesarCipher object with that key and decrypt the message.
    public String breakCaesarCipher(String input) {
        int[] freqs = countLetters(input);
        int maxIndex = maxIndex(freqs);     //index of 'e'
        int dKey = maxIndex - 4;            // -4 because the index of 'e' is 4. a b c d e
        if (maxIndex < 4)
            dKey = 26 - (4 - maxIndex);
        OOCaesarCipher ooCaesarCipher = new OOCaesarCipher(26 - dKey);
        return ooCaesarCipher.decrypt(input);
    }
}
