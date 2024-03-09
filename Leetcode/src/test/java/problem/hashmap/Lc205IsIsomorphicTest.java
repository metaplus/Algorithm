package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc205IsIsomorphicTest {

    @Test
    void isIsomorphic() {
        assertFalse(new Lc205IsIsomorphic().isIsomorphic("bbbaaaba","aaabbbba"));
        assertFalse(new Lc205IsIsomorphic().isIsomorphic("foo","bar"));
    }
}