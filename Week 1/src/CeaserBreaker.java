import edu.duke.FileResource;

public class CeaserBreaker {
    public static void main(String[] args) {
        CeaserBreaker ceaserBreaker = new CeaserBreaker();
        //ceaserBreaker.testDecrypt();
        ceaserBreaker.testDecryptTwoKeys();


    }

    //Complete the decryption method shown in the lesson by creating a CaesarBreaker class with the methods countLetters,
    // maxIndex, and decrypt. Recall that the decrypt method creates a CaesarCipher object in order to use the encrypt method
    // you wrote for the last lesson. Make sure that your CaesarCipher class is in the same folder as CaesarBreaker!
    // You may want to use the following code as part of your decrypt method.
    public String decrypt(String encrypted) {
        CeaserCipher ceaserCipher = new CeaserCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dKey = maxDex - 4;
        if (maxDex < 4)
            dKey = 26 - (4 - maxDex);

        return ceaserCipher.encrypt(encrypted, 26 - dKey);
    }

    public void testDecrypt() {
        System.out.println(decrypt("def"));
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

    //Write the method halfOfString in the CaesarBreaker class that has two parameters, a String parameter named message and an int parameter named start.
    // This method should return a new String that is every other character from message starting with the start position.
    //halfOfString(“Qbkm Zgis”, 0) returns the String “Qk gs” and the call halfOfString(“Qbkm Zgis”, 1) returns the String “bmZi”.
    public String halfOfString(String message, int start) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i < message.length(); i += 2) {
            stringBuilder.append(message.charAt(i));
        }
        return stringBuilder.toString();
    }

    //Write the method getKey in the CaesarBreaker class that has one parameter, a String s.
    // This method should call countLetters to get an array of the letter frequencies in String s and then use maxIndex to
    // calculate the index of the largest letter frequency, which is the location of the encrypted letter ‘e’, which leads to the key, which is returned.
    public int getKey(String s) {
        int[] freqs = countLetters(s);
        int maxIndex = maxIndex(freqs);     //location of 'e'                    0 1 2 3 4
        int dKey = maxIndex - 4;            // -4 because the index of 'e' is 4. a b c d e
        if (maxIndex < 4)
            dKey = 26 - (4 - maxIndex);

        return dKey;
    }

    //Write the method decryptTwoKeys in the CaesarBreaker class that has one parameter,
    // a String parameter named encrypted that represents a String that was encrypted with the two key algorithm discussed
    // in the previous lesson. This method attempts to determine the two keys used to encrypt the message, prints the two keys,
    // and then returns the decrypted String with those two keys. More specifically, this method should:
    //- Calculate a String of every other character starting with the first character of the encrypted String by calling halfOfString.
    //- Calculate a String of every other character starting with the second character of the encrypted String.
    //- Then calculate the key used to encrypt each half String.
    //- You should print the two keys found.
    //- Calculate and return the decrypted String using the encryptTwoKeys method from your CaesarCipher class,
    // again making sure it is in the same folder as your CaesarBreaker class.
    public void decryptTwoKeys(String encrypted) {
        String firstPart = halfOfString(encrypted, 0);
        String secondPart = halfOfString(encrypted, 1);
        int dKey1 = getKey(firstPart);
        int dKey2 = getKey(secondPart);
        System.out.println("Key 1: " + dKey1 + " Key 2: " + dKey2);
        CeaserCipher ceaserCipher = new CeaserCipher();
        System.out.println(ceaserCipher.encryptTwoKeys(encrypted, 26 - dKey1, 26 - dKey2));
    }

    public void testDecryptTwoKeys() {
        FileResource fileResource = new FileResource("datasets/encrypted1.txt");
        decryptTwoKeys(fileResource.toString());
    }

}
