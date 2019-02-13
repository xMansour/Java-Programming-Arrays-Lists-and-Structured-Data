import edu.duke.FileResource;

import java.util.Arrays;

public class WordLengths {
    public static void main(String[] args) {
        WordLengths wordLengths = new WordLengths();
        wordLengths.testCountWordLengths();

    }

    //Write a void method countWordLengths that has two parameters, a FileResource named resource and
    // an integer array named counts. This method should read in the words from resource and
    // count the number of words of each length for all the words in resource, storing these counts in the array counts
    //after this method executes, counts[k] should contain the number of words of length k.
    //And, would be considered of length 3 (the comma is not counted)
    //“blue-jeans” would be considered of length 10 (the double quotes are not counted, but the hyphen is).
    public void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            int length = word.length();

            if (!Character.isLetter(word.charAt(0)))
                length--;

            if (!Character.isLetter(word.charAt(word.length() - 1)))
                length--;

            counts[length]++;

        }
        System.out.println(Arrays.toString(counts));
        for (int i = 0; i < counts.length; i++) {
            System.out.println("There are " + counts[i] + " words of length " + i);
        }

    }

    public void testCountWordLengths() {
        FileResource fileResource = new FileResource("datasets/smallHamlet.txt");
        int[] counts = new int[31];
        countWordLengths(fileResource, counts);
        System.out.println("\nIndex of max: " + indexOfMax(counts));        //max repeated word (most common)


    }


    //Write a method indexOfMax that has one parameter named values that is an integer array.
    // This method returns the index position of the largest element in values.
    public int indexOfMax(int[] values) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            if (max < values[i]) {
                max = values[i];
                index = i;
            }
        }

        return index;
    }

}
