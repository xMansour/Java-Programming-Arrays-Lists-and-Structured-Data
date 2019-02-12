public class WordPlay {
    public static void main(String[] args) {
        WordPlay wordPlay = new WordPlay();
        //wordPlay.testIsVowel();
        //wordPlay.testReplaceVowels();
        wordPlay.testEmphasize();
    }

    //Write a method isVowel that has one Char parameter named ch.
    // This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise.
    // You should write a tester method to see if this method works correctly.
    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public void testIsVowel() {
        char ch = 'a';
        if (isVowel(ch))
            System.out.println(ch + " is a vowel");
        else
            System.out.println(ch + " is not a vowel");

        ch = 'F';
        if (isVowel(ch))
            System.out.println(ch + " is a vowel");
        else
            System.out.println(ch + " is not a vowel");

    }

    //Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch.
    // This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch.
    public String replaceVowels(String phrase, char ch) {
        StringBuilder stringBuilder = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            if (isVowel(stringBuilder.charAt(i)))
                stringBuilder.setCharAt(i, ch);
        }
        return stringBuilder.toString();
    }


    public void testReplaceVowels() {
        String phrase = "Hello World";
        String result = replaceVowels(phrase, '*');
        System.out.println(phrase + " is " + result + " when replaceVowels method is called using it");
    }

    //Write a method emphasize with two parameters, a String named phrase and a character named ch.
    // This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by
    //‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or
    //‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).
    public String emphasize(String phrase, char ch) {
        StringBuilder stringBuilder = new StringBuilder(phrase);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == Character.toLowerCase(ch) || stringBuilder.charAt(i) == Character.toUpperCase(ch))
                if (i % 2 == 0)
                    stringBuilder.setCharAt(i, '*');        //the replaced character is reversed because we are using the location at the string not the index
                else
                    stringBuilder.setCharAt(i, '+');

        }
        return stringBuilder.toString();
    }

    public void testEmphasize() {
        String phrase = "dna ctgaaactga";
        char ch = 'a';
        System.out.println(emphasize(phrase, ch));
        phrase = "Mary Bella Abracadabra";
        System.out.println(emphasize(phrase, ch));
    }

}
