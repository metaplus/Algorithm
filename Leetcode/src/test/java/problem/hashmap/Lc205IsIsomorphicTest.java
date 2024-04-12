package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc205IsIsomorphicTest {

    @Test
    void isIsomorphic() {
        assertFalse(new Lc205IsIsomorphic().isIsomorphic("badc", "baba"));
        assertTrue(new Lc205IsIsomorphic().isIsomorphic("13", "42"));
        assertTrue(new Lc205IsIsomorphic().isIsomorphic("paper", "title"));
        assertFalse(new Lc205IsIsomorphic().isIsomorphic("bbbaaaba", "aaabbbba"));
        assertFalse(new Lc205IsIsomorphic().isIsomorphic("foo", "bar"));
    }
}