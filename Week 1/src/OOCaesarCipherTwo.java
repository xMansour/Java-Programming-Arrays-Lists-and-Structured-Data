public class OOCaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;

    public OOCaesarCipherTwo(int key1, int key2) {
        mainKey1 = key1;
        mainKey2 = key2;
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet1 = alphabet.substring(mainKey1) + alphabet.substring(0, mainKey1);
        shiftedAlphabet2 = alphabet.substring(mainKey2) + alphabet.substring(0, mainKey2);
    }


    public String encrypt(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int index = alphabet.indexOf(input.charAt(i));
            if (index != -1) {
                if (i % 2 == 0) {
                    stringBuilder.append(shiftedAlphabet1.charAt(alphabet.indexOf(input.charAt(i))));
                } else {
                    stringBuilder.append(shiftedAlphabet2.charAt(alphabet.indexOf(input.charAt(i))));
                }
            } else {
                stringBuilder.append(input.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public String decrypt(String input) {
        OOCaesarCipherTwo ooCaesarCipherTwo = new OOCaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        return ooCaesarCipherTwo.encrypt(input);
    }
}
