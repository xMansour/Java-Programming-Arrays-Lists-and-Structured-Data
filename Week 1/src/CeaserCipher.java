import edu.duke.FileResource;

public class CeaserCipher {
    public static void main(String[] args) {
        CeaserCipher ceaserCipher = new CeaserCipher();
        //ceaserCipher.testEncrypt();
        ceaserCipher.testEncryptTwoKeys();
    }

    //Write the method encrypt that has two parameters, a String named input and an int named key.
    // This method returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos.
    // Assume that all the alphabetic characters are uppercase letters.
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);

        for (int i = 0; i < encrypted.length(); i++) {

            char ch = encrypted.charAt(i);
            int index = alphabet.indexOf(Character.toUpperCase(ch));

            if (index != -1 && Character.isUpperCase(ch)) {
                encrypted.setCharAt(i, shiftedAlphabet.charAt(index));

            } else if (index != -1 && Character.isLowerCase(ch)) {
                encrypted.setCharAt(i, Character.toLowerCase(shiftedAlphabet.charAt(index)));
            }
        }

        return encrypted.toString();
    }

    public void testEncrypt() {
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        System.out.println(encrypt("First Legion", 23));
        System.out.println(encrypt("First Legion", 17));
        /*FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);*/

    }

    //Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2.
    // This method returns a String that has been encrypted using the following algorithm.
    // Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm,
    // starting with the first character, and key2 is used to encrypt every other character, starting with the second character.
    public String encryptTwoKeys(String input, int key1, int key2) {
        String encryptedFirstKey = encrypt(input, key1);
        String encryptedSecondKey = encrypt(input, key2);
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0)
                encrypted.append(encryptedFirstKey.charAt(i));
            else
                encrypted.append(encryptedSecondKey.charAt(i));
        }
        return encrypted.toString();
    }

    public void testEncryptTwoKeys() {
        System.out.println(encryptTwoKeys("First Legion", 23, 17));
    }
}
