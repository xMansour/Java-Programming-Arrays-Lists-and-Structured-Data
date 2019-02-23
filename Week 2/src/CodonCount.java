import edu.duke.FileResource;

import java.util.HashMap;

public class CodonCount {
    private HashMap<String, Integer> map;

    public CodonCount() {
        this.map = new HashMap<>();
    }

    /*
    Write a void method named buildCodonMap that has two parameters, an int named start and a String named dna.
    This method will build a new map of codons mapped to their counts from the string dna with the reading frame with the position start (a value of 0, 1, or 2).
    You will call this method several times, so make sure your map is empty before building it.
     */
    private void buildCodonMap(int start, String dna) {
        map.clear();

        while (!dna.isEmpty() && dna.length() >= 3) {
            String codon = dna.substring(start, 3);
            if (map.containsKey(codon)) {
                map.put(codon, map.get(codon) + 1);
            } else {
                map.put(codon, 1);
            }
            dna = dna.substring(3);

        }
    }

    /*
    Write a method named getMostCommonCodon that has no parameters. This method returns a String, the codon in a reading frame that has the largest count.
    If there are several such codons, return any one of them. This method assumes the HashMap of codons to counts has already been built.
     */
    private String getMostCommonCodon() {
        int maxValue = 0;
        String maxCodon = null;
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (value > maxValue) {
                maxValue = value;
                maxCodon = key;
            }
        }

        return maxCodon;
    }

    /*
    Write a void method named printCodonCounts that has two int parameters, start and end. This method prints all the codons in
    the HashMap along with their counts if their count is between start and end, inclusive.
     */
    private void printCodonCounts(int start, int end) {
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (value > start && value < end) {
                System.out.println("\"" + key + "\" " + " occurrence: " + value);
            }
        }
    }


    /*
    Write a tester method that prompts the user for a file that contains a DNA strand (could be upper or lower case letters in the file,
    convert them all to uppercase, since case should not matter). Then for each of the three possible reading frames,
    this method builds a HashMap of codons to their number of occurrences in the DNA strand, prints the total number of unique codons in the reading frame,
    prints the most common codon and its count, and prints the codons and their number of occurrences for those codons whose number of
    occurrences in this reading frame are between two numbers inclusive.
     */

    public void tester() {
        //FileResource fileResource = new FileResource();
        //String dna = fileResource.asString().toUpperCase();
        String dna = "CGTTCAAGTTCAA";
        buildCodonMap(0, dna);
        printCodonCounts(0, 5);
        System.out.println("Most common codon: " + getMostCommonCodon());
    }


}
