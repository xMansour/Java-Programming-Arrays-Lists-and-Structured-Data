import edu.duke.FileResource;
import edu.duke.URLResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MapsVersionOfGladLibs {
    private HashMap<String, ArrayList<String>> map;
    private ArrayList<String> usedLabels;
    private Random myRandom;

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public MapsVersionOfGladLibs() {
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    public MapsVersionOfGladLibs(String source) {
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {
        String[] labels = {"country", "noun", "animal", "adjective", "name", "color", "timeframe", "fruit", "verb", "number"};
        map = new HashMap<>();

        for (String label : labels) {
            ArrayList<String> words = readIt(source + "/" + label + ".txt");
            map.put(label, words);
        }
    }


    private String randomFrom(ArrayList<String> source) {
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        usedLabels = new ArrayList<>();

        if (map.containsKey(label)) {
            usedLabels.add(label);
            return randomFrom(map.get(label));

        } else
            return "UNKNOWN";
    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1) {
            return w;
        }
        String prefix = w.substring(0, first);
        String suffix = w.substring(last + 1);
        String sub = getSubstitute(w.substring(first + 1, last));
        return prefix + sub + suffix;
    }

    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for (String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }

    public void makeStory() {
        System.out.println("\n");
        String story = fromTemplate("dataset/data/madtemplate2.txt");
        printOut(story, 60);
    }

    public int totalWordsInMap() {
        int totalNum = 0;
        for (String label : map.keySet()) {
            totalNum += map.get(label).size();
        }

        return totalNum;
    }

    public int totalWordsConsidered() {
        int totalNum = 0;
        for (String label : map.keySet()) {
            if (usedLabels.contains(label)) {
                totalNum += map.get(label).size();
            }
        }
        return totalNum;
    }

}
