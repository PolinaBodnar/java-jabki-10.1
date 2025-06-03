import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testAreAnagramsTrue() {
        assertTrue(Main.areAnagrams("listen", "silent"));
    }

    @Test
    void testAreAnagramsFalse() {
        assertFalse(Main.areAnagrams("hello", "world"));
    }

    @Test
    void testHasDuplicatesTrue() {
        List<Integer> list = Arrays.asList(1, 2, 3, 2);
        assertTrue(Main.hasDuplicates(list));
    }

    @Test
    void testHasDuplicatesFalse() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        assertFalse(Main.hasDuplicates(list));
    }

    @Test
    void testBestStudent() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Anna", 90);
        scores.put("Bob", 95);
        scores.put("Clara", 85);
        assertEquals("Bob", Main.bestStudent(scores));
    }

    @Test
    void testAddSynonym() {
        Map<String, Set<String>> dict = new HashMap<>();
        Main.addSynonym(dict, "happy", "joyful");
        Main.addSynonym(dict, "happy", "cheerful");

        Set<String> expected = new HashSet<>(Arrays.asList("joyful", "cheerful"));
        assertEquals(expected, dict.get("happy"));
    }
}