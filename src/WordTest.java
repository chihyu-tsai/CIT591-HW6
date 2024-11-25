import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class WordTest {

    @Test
    void testGetNewCandidateList1() {

        //assume test word length is 11
        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("abbreviated");
        inputList.add("unprintable");
        inputList.add("biographies");
        inputList.add("departments");
        inputList.add("derogations");
        inputList.add("saxophonist");
        inputList.add("typescripts");
        inputList.add("unrecognise");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("biographies");
        expected.add("departments");
        expected.add("derogations");

        EvilSolution evilSolution = new EvilSolution(11, inputList);
        ArrayList<String> actual = evilSolution.getNewCandidateList('s');

        assertEquals(expected, actual);

    }

    @Test
    void testGetNewCandidateList2() {

        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("nagasaki");
        inputList.add("quackish");
        inputList.add("landowner");
        inputList.add("exchanger");
        inputList.add("than");
        inputList.add("analogues");
        inputList.add("schematic");
        inputList.add("presiding");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("analogues");
        expected.add("schematic");

        // also checks if we get the words with right length
        EvilSolution evilSolution = new EvilSolution(9, inputList);
        ArrayList<String> actual = evilSolution.getNewCandidateList('r');

        assertEquals(expected, actual);

    }

    @Test
    void testGetNewCandidateList3() {

        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("hypocrisy");
        inputList.add("effortless");
        inputList.add("schematic");
        inputList.add("restorative");
        inputList.add("glued");
        inputList.add("presiding");
        inputList.add("fleetingly");
        inputList.add("fitters");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("hypocrisy");
        expected.add("presiding");

        // also checks if we get the words with right length
        EvilSolution evilSolution = new EvilSolution(9, inputList);
        ArrayList<String> actual = evilSolution.getNewCandidateList('t');

        assertEquals(expected, actual);

    }


    @Test
    void testGetFinalWord1() {
        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("apple");

        EvilSolution solution = new EvilSolution(5, inputList);

        solution.getNewCandidateList('a');
        solution.getNewCandidateList('p');
        solution.getNewCandidateList('l');
        solution.getNewCandidateList('e');

        assertEquals("apple", solution.getFinalWord());
    }

    @Test
    void testGetFinalWord2() {
        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("banana");

        EvilSolution evilSolution = new EvilSolution(6, inputList);

        // Simulate some correct guesses
        evilSolution.getNewCandidateList('b');
        evilSolution.getNewCandidateList('a');

        String expected = "ba_a_a";
        String actual = evilSolution.getFinalWord();

        assertEquals(expected, actual);
    }

    @Test
    void testGetFinalWord3() {
        ArrayList<String> inputList = new ArrayList<>();
        EvilSolution evilSolution = new EvilSolution(5, inputList);

        String expected = "_____";
        String actual = evilSolution.getFinalWord();

        assertEquals(expected, actual);
    }



    @Test
    void testGotSolved1() {
        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("apple");
        EvilSolution solution = new EvilSolution(5, inputList);

        assertFalse(solution.gotSolved());

        solution.getNewCandidateList('a');
        solution.getNewCandidateList('p');
        solution.getNewCandidateList('l');
        solution.getNewCandidateList('e');

        assertTrue(solution.gotSolved());

    }

    @Test
    void testGotSolved2() {
        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("banana");
        EvilSolution evilSolution = new EvilSolution(6, inputList);

        // Simulate some correct guesses
        evilSolution.getNewCandidateList('b');
        evilSolution.getNewCandidateList('a');

        assertFalse(evilSolution.gotSolved());
    }

    @Test
    void testGotSolved3() {
        ArrayList<String> inputList = new ArrayList<>();
        EvilSolution evilSolution = new EvilSolution(5, inputList);

        assertFalse(evilSolution.gotSolved());
    }


    @Test
    void testWordPattern1() {
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("apple");
        dictionary.add("arrow");
        dictionary.add("align");
        EvilSolution evilSolution = new EvilSolution(5, dictionary);

        ArrayList<Character> expected = new ArrayList<>();
        expected.add('_');
        expected.add('_');
        expected.add('_');
        expected.add('_');
        expected.add('_');

        ArrayList<Character> actual = evilSolution.getWordPattern();
        assertEquals(expected, actual);
    }

    @Test
    void testWordPattern2() {
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("apple");
        dictionary.add("arrow");
        dictionary.add("align");
        EvilSolution evilSolution = new EvilSolution(5, dictionary);

        evilSolution.getNewCandidateList('a');
        evilSolution.getNewCandidateList('l');

        ArrayList<Character> expected = new ArrayList<>();
        expected.add('a');
        expected.add('l');
        expected.add('_');
        expected.add('_');
        expected.add('_');

        ArrayList<Character> actual = evilSolution.getWordPattern();
        assertEquals(expected, actual);
    }

    @Test
    void testWordPattern3() {
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("apple");
        dictionary.add("arrow");
        dictionary.add("align");
        EvilSolution evilSolution = new EvilSolution(5, dictionary);

        // Simulate an incorrect guess 'z'
        evilSolution.getNewCandidateList('z');

        ArrayList<Character> expected = new ArrayList<>();
        expected.add('_');
        expected.add('_');
        expected.add('_');
        expected.add('_');
        expected.add('_');

        ArrayList<Character> actual = evilSolution.getWordPattern();
        assertEquals(expected, actual);
    }


}


