import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EvilSolution {
    private int solutionLength;
    private ArrayList<Character> wordPattern;
    private ArrayList<String> candidateList;

    /*
    the solution is dynamic, don't have a fixed solution
    loop through all words in the dictionary (stored in an ArrayList) and if word length equals the length that is passed in the constructor, it is a potential candidate
    this store all the words that have the solutionLength from the dictionary
    wordFamily original format --> _ _ _ _ (depends on the passed in length)
    candidateList is the remaining words in the dictionary that can be solution
    */

    public EvilSolution (int solutionLength, ArrayList<String> inputList) {
        this.solutionLength = solutionLength;
        this.candidateList = new ArrayList<>();

        for (String word : inputList) {
            if (word.length() == solutionLength) {
                candidateList.add(word);
            }
        }
        this.wordPattern = new ArrayList<>();
        for (int i = 0; i < solutionLength; i++) {
            wordPattern.add('_');
        }

    }


    // once we have the guess should split existing words in the candidatePool into word family
    // should have the key that is wordFamily and value is an ArrayList
    public ArrayList<String> getNewCandidateList(char guess) {
        // Return an empty list if candidateList is null or empty
        if (candidateList == null || candidateList.isEmpty()) {
            return new ArrayList<>();
        }
        HashMap<ArrayList<Character>, ArrayList<String>> intermediateResult = new HashMap<>();

        for (int i = 0; i < candidateList.size(); i++) {
            ArrayList<Character> testPattern = new ArrayList<>(wordPattern);
            for (int j = 0; j < candidateList.get(i).length(); j++) {
                if (testPattern.get(j) == '_' && candidateList.get(i).charAt(j) == guess) {
                    testPattern.set(j, guess);
                }
            }
            if (intermediateResult.containsKey(testPattern)) {
                intermediateResult.get(testPattern).add(candidateList.get(i));
            } else {
                intermediateResult.put(testPattern, new ArrayList<>());
                intermediateResult.get(testPattern).add(candidateList.get(i));

            }
        }




        int maxSize = 0;
        ArrayList<Character> tempKey = new ArrayList<>();
        // if we update maxSize, we also have to update put wordFamily
        for (ArrayList<Character> c : intermediateResult.keySet()) {
            if (intermediateResult.get(c).size() >= maxSize) {
                maxSize = intermediateResult.get(c).size();
                tempKey = c;
            } else if (intermediateResult.get(c).size() == maxSize) {
                int currNum = 0;
                int prevNum = 0;
                for (int i = 0; i < tempKey.size(); i++) {
                    if (tempKey.get(i) == '_') {
                        prevNum += 1;
                    }
                }
                for (int  i = 0; i < c.size(); i++) {
                    if (c.get(i) == '_') {
                        currNum += 1;
                    }
                }
                if (currNum > prevNum) {
                    tempKey = c;
                }
            }
        }
        wordPattern = tempKey;
        candidateList = intermediateResult.get(tempKey);
        return candidateList;
    }




    // print out the current progress
    public void progress() {
        for (char c : wordPattern) {
            System.out.print(c + " ");
        }
        System.out.println();
    }



    // check if the EvilHangman is solved
    public boolean gotSolved() {

        return !wordPattern.contains('_');
    }


    public String getFinalWord() {
        String finalWord = "";
        for (char c : wordPattern) {
            finalWord += c;
        }
        return finalWord;
    }



}