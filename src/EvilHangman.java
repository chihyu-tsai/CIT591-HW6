import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class EvilHangman {

    private ArrayList<String> wordList;
    private HashSet<Character> previousGuesses;
    private TreeSet<Character> incorrectGuesses; // behaves like a hash set, but orders the entries!
    private Scanner inputScanner;


    public EvilHangman() {

    }




    public EvilHangman(String filename) {
        try {
            wordList = dictionaryToList(filename);
        } catch (IOException e) {
            System.out.printf(
                    "Couldn't read from the file %s. Verify that you have it in the right place and try running again.",
                    filename);
            e.printStackTrace();
            System.exit(0); // stop the program--no point in trying if you don't have a dictionary
        }

        previousGuesses = new HashSet<>();
        incorrectGuesses = new TreeSet<>();
        //int randomIndex = new Random().nextInt(wordList.size());
        //String target = wordList.get(randomIndex);

        inputScanner = new Scanner(System.in);

    }












    public void start() {
        while (!EvilSolution.isSolved()) {

        }




    }






    private static ArrayList<String> dictionaryToList(String filename) throws IOException {
        FileInputStream fs = new FileInputStream(filename);
        Scanner scnr = new Scanner(fs);

        ArrayList<String> wordList = new ArrayList<>();

        while (scnr.hasNext()) {
            wordList.add(scnr.next());
        }

        return wordList;
    }


    // get the maximum length of the pass in dictionary
    public int maxLengthInList (ArrayList<String> dictionary) {
        int maxLength = dictionary.get(0).length();
        for (int i = 1; i < dictionary.size(); i++) {
            if (dictionary.get(i).length() > maxLength) {
                maxLength = dictionary.get(i).length();
            }
            return  maxLength;
        }
    }




}
