import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class EvilHangman {

    private ArrayList<String> wordList;
    private HashSet<Character> previousGuesses;
    private TreeSet<Character> incorrectGuesses; // behaves like a hash set, but orders the entries!
    private Scanner inputScanner;
    private EvilSolution evilSolution;
    private ArrayList<Character> wordFamily;


    public EvilHangman() {
        this("engDictionary.txt");
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
        int targetWordLength = new Random().nextInt(maxLengthInList(wordList));
        inputScanner = new Scanner(System.in);
        evilSolution  = new EvilSolution(targetWordLength, wordList);
    }



    public void start() {
        while (!evilSolution.gotSolved()) {
            char thisGuess = askForGuess();
            evilSolution.placeGuess(thisGuess);

        }
    }



    // ask user to input a guess
    private char askForGuess() {
        while (true) {

            System.out.println("Guess a letter.\n");
            evilSolution.progress();

            System.out.println("Incorrect guesses:\n" + incorrectGuesses.toString());
            String input = inputScanner.next();
            if (input.length() != 1) {
                System.out.println("Please enter a single character.");
            } else if (previousGuesses.contains(input.charAt(0))) {
                System.out.println("You've already guessed that.");
            } else {
                return input.charAt(0);
            }
        }

    }


    // record what's being guessed
    private void recordGuess(char guess) {
        previousGuesses.add(guess);
        boolean isCorrect = evilSolution.placeGuess(guess);
        if (!isCorrect) {
            incorrectGuesses.add(guess);
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
        }
        return  maxLength;
    }





}
