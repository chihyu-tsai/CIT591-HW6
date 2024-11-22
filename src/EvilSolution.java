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
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i).length() == solutionLength) {
                candidateList.add(inputList.get(i));
            }
        }
        this.wordPattern = new ArrayList<>();
        for (int i = 0; i < solutionLength; i++) {
            wordPattern.add('_');
        }

    }


    // once we have the guess should split existing words in the candidatePool into word family
    // should have the key that is wordFamily and value is an ArrayList
    public ArrayList<String> getNewCandidateList(char guess, ArrayList<String> currentList) {

        HashMap<ArrayList<Character>, ArrayList<String>> intermediateResult = new HashMap<>();
        ArrayList<String> possibleCandidateList = new ArrayList<>();

        for (int i = 0; i < currentList.size(); i++ ) {
            for (int j = 0; j < currentList.get(i).length(); j++) {
                if (tempCopy.get(j) == '_' && candidateList.get(i).charAt(j) == guess) {
                    tempCopy.set(j, guess);
                }
            }
            tempCopy.clear();
            for (int k = 0; k < wordFamily.size(); k++) {
                tempCopy.add(wordFamily.get(k));
            }
            possibleCandidateList.add(candidateList.get(i));
            intermediateResult.put(tempCopy, possibleCandidateList);
            System.out.println("intermediarte result");
            System.out.println(intermediateResult);
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
        wordFamily = tempKey;
        System.out.println("word fam set at end: " + wordFamily);
        candidateList = intermediateResult.get(intermediateResult.get(tempKey));
        System.out.println("candidate list at the end");
        System.out.println(candidateList);
        return true;
    }
//    return false;




    // print out the current progress
    public void progress() {
        for (char c : wordFamily) {
            System.out.print(c + " ");
        }
        System.out.println();
    }



    // check if the EvilHangman is solved
    public boolean gotSolved() {
        return !wordFamily.contains('_');
    }



}