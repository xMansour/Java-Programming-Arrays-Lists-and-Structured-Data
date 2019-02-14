import edu.duke.FileResource;

public class OOCaesarCipherTwoTest {
    private String alphabet;

    public OOCaesarCipherTwoTest() {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
    }


    public static void main(String[] args) {
        OOCaesarCipherTwoTest ooCaesarCipherTwoTest = new OOCaesarCipherTwoTest();
        ooCaesarCipherTwoTest.simpleTests();

    }

    public int[] countLetters(String encrypted) {
        int[] freqs = new int[26];
        for (int i = 0; i < encrypted.length(); i++) {
            int index = alphabet.indexOf(encrypted.charAt(i));
            if (index != -1) {
                freqs[index]++;
            }
        }
        return freqs;
    }

    private int maxIndex(int[] freqs) {
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

    private String halfOfString(String message, int start) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i < message.length(); i += 2) {
            stringBuilder.append(message.charAt(i));
        }
        return stringBuilder.toString();
    }

    private int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxIndex = maxIndex(freqs);     //location of 'e'                    0 1 2 3 4
        int dKey = maxIndex - 4;            // -4 because the index of 'e' is 4. a b c d e
        if (maxIndex < 4)
            dKey = 26 - (4 - maxIndex);

        return dKey;
    }

    public void simpleTests() {
        FileResource fileResource = new FileResource("datasets/encrypted1.txt");
        int key1 = 17;
        int key2 = 3;
        OOCaesarCipherTwo caesarCipherTwo = new OOCaesarCipherTwo(key1, key2);
        String encrypted = caesarCipherTwo.encrypt(fileResource.asString());
        String decrypted = caesarCipherTwo.decrypt(encrypted);
        String decryptedNoKeys = breakCaesarCipher(fileResource.asString());
        System.out.println("Normal text: " + fileResource.asString());
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text using keys: " + decrypted);
        System.out.println("Decrypted text without keys: " + decryptedNoKeys);

    }

    public String breakCaesarCipher(String input) {
        String firstPart = halfOfString(input, 0);
        String secondPart = halfOfString(input, 1);
        int key1 = getKey(firstPart);
        int key2 = getKey(secondPart);
        OOCaesarCipherTwo ooCaesarCipherTwo = new OOCaesarCipherTwo(26 - key1, 26 - key2);
        return ooCaesarCipherTwo.encrypt(input);
    }
}
