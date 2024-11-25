import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class WordTest {
    @Test
    void testGetNewCandidateList() {

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
    void testGotSolved() {
        WordRecommender wr = new WordRecommender("engDictionary.txt");
        String word1 = "surfer";
        String word2 = "surf";

        double expected = 2.0;
        double actual = wr.getSimilarity(word1, word2);

        assertEquals(expected, actual);
    }

    @Test
    void testGetFinalWord() {
        WordRecommender wr = new WordRecommender("engDictionary.txt");
        String word1 = "";
        String word2 = "school";

        double expected = 0.0;
        double actual = wr.getSimilarity(word1, word2);

        assertEquals(expected, actual);
    }

    @Test
    void testGotSolved() {
        WordRecommender wr = new WordRecommender("engDictionary.txt");
        String word1 = "prank";
        String word2 = "rank";

        double expected = 2.0;
        double actual = wr.getSimilarity(word1, word2);

        assertEquals(expected, actual);
    }

    @Test
    void testGetSimilarity5() {
        WordRecommender wr = new WordRecommender("engDictionary.txt");
        String word1 = "crave";
        String word2 = "save";

        double expected = 1.5;
        double actual = wr.getSimilarity(word1, word2);

        assertEquals(expected, actual);
    }

    @Test
    void getFinalWord() {
        WordRecommender wr = new WordRecommender("engDictionary.txt");
        String word = "broun";
        int tolerance = 2;
        double commonPercent = 0.5;
        int topN = 4;

        ArrayList<String> expected = new ArrayList<>();
        expected.add("brown");
        expected.add("croon");
        expected.add("trout");
        expected.add("bosun");
        ArrayList<String> actual = wr.getWordSuggestions(word, tolerance, commonPercent, topN);

        assertEquals(expected, actual);
    }

    @Test
    void getWordSuggestions2() {
        WordRecommender wr = new WordRecommender("engDictionary.txt");
        String word = "flamme";
        int tolerance = 2;
        double commonPercent = 0.5;
        int topN = 4;

        ArrayList<String> expected = new ArrayList<>();
        expected.add("flames");
        expected.add("flamed");
        expected.add("flange");
        expected.add("framed");
        ArrayList<String> actual = wr.getWordSuggestions(word, tolerance, commonPercent, topN);

        assertEquals(expected, actual);
    }

    @Test
    void getWordSuggestions3() {
        WordRecommender wr = new WordRecommender("engDictionary.txt");
        String word = "strwwbery";
        int tolerance = 2;
        double commonPercent = 0.5;
        int topN = 4;

        ArrayList<String> expected = new ArrayList<>();
        expected.add("shrubbery");
        expected.add("strawberry");
        expected.add("shrewdest");
        expected.add("remembers");
        ArrayList<String> actual = wr.getWordSuggestions(word, tolerance, commonPercent, topN);

        assertEquals(expected, actual);
    }

    @Test
    void getWordSuggestions4() {
        WordRecommender wr = new WordRecommender("engDictionary.txt");
        String word = "brodcatt";
        int tolerance = 2;
        double commonPercent = 0.5;
        int topN = 4;

        ArrayList<String> expected = new ArrayList<>();
        expected.add("braggart");
        expected.add("birdbath");
        expected.add("browbeat");
        expected.add("handcart");
        ArrayList<String> actual = wr.getWordSuggestions(word, tolerance, commonPercent, topN);

        assertEquals(expected, actual);
    }

    @Test
    void getWordSuggestions5() {
        WordRecommender wr = new WordRecommender("engDictionary.txt");
        String word = "calorii";
        int tolerance = 2;
        double commonPercent = 0.5;
        int topN = 4;

        ArrayList<String> expected = new ArrayList<>();
        expected.add("calorie");
        expected.add("caldron");
        expected.add("canonic");
        expected.add("colonic");
        ArrayList<String> actual = wr.getWordSuggestions(word, tolerance, commonPercent, topN);

        assertEquals(expected, actual);
    }
}


