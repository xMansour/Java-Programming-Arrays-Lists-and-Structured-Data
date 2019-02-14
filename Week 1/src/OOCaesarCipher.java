public class OOCaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    public OOCaesarCipher(int key) {
        mainKey = key;
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);

        for (int i = 0; i < encrypted.length(); i++) {

            char ch = encrypted.charAt(i);
            int index = alphabet.indexOf(Character.toLowerCase(ch));

            if (index != -1 && Character.isUpperCase(ch)) {
                encrypted.setCharAt(i, shiftedAlphabet.charAt(index));

            } else if (index != -1 && Character.isLowerCase(ch)) {
                encrypted.setCharAt(i, Character.toLowerCase(shiftedAlphabet.charAt(index)));
            }
        }

        return encrypted.toString();
    }

    public String decrypt(String input) {
        OOCaesarCipher ooCaesarCipher = new OOCaesarCipher(26 - mainKey);
        return ooCaesarCipher.encrypt(input);

    }
}
