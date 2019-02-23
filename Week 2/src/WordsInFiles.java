import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> map;

    public WordsInFiles() {
        this.map = new HashMap<>();
    }

    /*
    Write a private void method named addWordsFromFile that has one parameter f of type File. This method should add all the words from f into the map.
    If a word is not in the map, then you must create a new ArrayList of type String with this word, and have the word map to this ArrayList.
    If a word is already in the map, then add the current filename to its ArrayList, unless the filename is already in the ArrayList.
    You can use the File method getName to get the filename of a file.
     */
    private void addWordsFromFile(File f) {
        FileResource fileResource = new FileResource(f);
        for (String word : fileResource.words()) {
            if (!map.containsKey(word)) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(f.getName());
                map.put(word, arrayList);
            } else {
                ArrayList<String> arrayList = map.get(word);
                if (!arrayList.contains(f.getName())) {
                    arrayList.add(f.getName());
                }
            }
        }
    }


    /*
    Write a void method named buildWordFileMap that has no parameters.
    This method first clears the map, and then uses a DirectoryResource to select a group of files. For each file,
    it puts all of its words into the map by calling the method addWordsFromFile. The remaining methods to write all assume that the HashMap has been built.
     */
    private void buildWordFileMap() {
        map.clear();

        DirectoryResource directoryResource = new DirectoryResource();

        for (File file : directoryResource.selectedFiles()) {
            addWordsFromFile(file);
        }
    }

    /*
    Write the method maxNumber that has no parameters. This method returns the maximum number of files any word appears in,
    considering all words from a group of files. In the example above, there are four files considered. No word appears in all four files.
    Two words appear in three of the files, so maxNumber on those four files would return 3. This method assumes that the HashMap has already been constructed.
     */
    private int maxNumber() {
        int max = 0;
        for (String word : map.keySet()) {
            int size = map.get(word).size();
            if (size > max)
                max = size;
        }

        return max;
    }

    /*
    Write the method wordsInNumFiles that has one integer parameter called number. This method returns an ArrayList of words that appear in exactly number files.
    In the example above, the call wordsInNumFiles(3) would return an ArrayList with the words “cats” and “and”, and the call wordsInNumFiles(2)
    would return an ArrayList with the words “love”, “are”, and “dogs”, all the words that appear in exactly two files.
     */
    private ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> words = new ArrayList<>();

        for (String word : map.keySet()) {
            if (map.get(word).size() == number)
                words.add(word);
        }

        return words;
    }


    /*
    Write the void method printFilesIn that has one String parameter named word. This method prints the names of the files this word appears in,
    one filename per line. For example, in the example above, the call printFilesIn(“cats”) would print the
    three filenames: brief1.txt, brief3.txt, and brief4.txt, each on a separate line.
     */
    private void printFilesIn(String word) {
        ArrayList<String> fileNames = map.get(word);
        for (String fileName : fileNames) {
            System.out.println(word + " appears in: " + fileName);
        }
    }


    /*
    Write the void method tester that has no parameters. This method should call buildWordFileMap to select a group of files and build a HashMap of words,
    with each word mapped to an ArrayList of the filenames this word appears in, determine the maximum number of files any word is in, considering all words,
     and determine all the words that are in the maximum number of files and for each such word, print the filenames of the files it is in.
     (optional) If the map is not too big, then you might want to print out the complete map, all the keys, and for each key its ArrayList.
     This might be helpful to make sure the map was built correctly.
     */

    public void tester() {
        buildWordFileMap();
        int max = maxNumber();

        ArrayList<String> words = wordsInNumFiles(max);

        for (String word : words) {
            System.out.print(word);
            printFilesIn(word);
        }
    }

}
