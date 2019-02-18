import edu.duke.FileResource;

import java.util.ArrayList;

/**
 * Write a program to print out the main characters in one of Shakespeare’s plays,
 * those with the most speaking parts. You should identify a speaking part by reading the file line-by-line
 * and finding the location of the first period on the line. Then you will assume that everything up to the
 * first period is the name of a character and count how many times that occurs in the file.
 * You will only print those characters that appear more often than others. Notice our method is somewhat error prone.
 * For example, a period is also used to indicate the end of a sentence. By printing out only those characters that appear a lot,
 * we will get rid of most of the errors. Periods that indicate the end of a sentence will likely
 * be a unique phrase so you won’t print that as it would just occur once or maybe twice.
 */

public class CharacterNames {
    private ArrayList<String> namesList;
    private ArrayList<Integer> freqs;

    public CharacterNames() {
        namesList = new ArrayList<>();
        freqs = new ArrayList<>();
    }

    /*
    Write a void method named update that has one String parameter named person. This method should update the two ArrayLists,
    adding the character’s name if it is not already there, and counting this line as one speaking part for this person.
    */
    private void update(String person) {
        int index = namesList.indexOf(person);
        int personFreqs;
        if (index != -1) {
            personFreqs = freqs.get(index);
            personFreqs++;
            freqs.set(index, personFreqs);
        } else {
            namesList.add(person);
            freqs.add(1);
        }
    }

    /*
    Write a void method called findAllCharacters that opens a file, and reads the file line-by-line.
    For each line, if there is a period on the line, extract the possible name of the speaking part,
    and call update to count it as an occurrence for this person. Make sure you clear the appropriate instance variables before each new file.

    Note that each speaking part is at the beginning of the line (there may be some blanks before it) and has a period immediately following it.
    Shakespeare used this format in many of his plays. Sometimes the name of the person to speak was all capitalized and sometimes it was not.
    */
    private void findAllCharacters() {
        FileResource fileResource = new FileResource("dataset/macbethSmall.txt");
        for (String line : fileResource.lines()) {
            int periodIndex = line.indexOf(".");
            if (periodIndex != -1) {
                String characterName = line.substring(0, periodIndex);
                if (characterName.equals(characterName.toUpperCase()))
                    update(characterName);
            }

        }
    }

    /*
    Write a void method called charactersWithNumParts that has two int parameters named num1 and num2,
    where you can assume num1 should be less than or equal to num2.
    This method should print out the names of all those characters that have exactly number speaking parts,
    where number is greater than or equal to num1 and less than or equal to num2. Add code in tester to test this method out.
    */
    private void charactersWithNumParts(int num1, int num2) {
        for (int i = 0; i < freqs.size(); i++) {
            if (freqs.get(i) >= num1 && freqs.get(i) <= num2) {
                System.out.println("\"" + namesList.get(i) + "\" has parts greater than or equal to" + num1 + " and less than or equal to " + num2);
            } else {
                System.out.println("There are no character name with such a frequency");
            }
        }

    }


    public void tester() {
        findAllCharacters();
        for (int i = 0; i < namesList.size(); i++) {
            System.out.println(namesList.get(i) + " " + freqs.get(i));
        }
        charactersWithNumParts(1, 2);
    }


}
