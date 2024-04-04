package problem.array;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.jupiter.api.Test;
import problem.pointer.Lc438FindAnagrams;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc438FindAnagramsTest {

    @Test
    void findAnagrams() {
        assertEquals(FastList.newListWith(0, 1, 2),
                new Lc438FindAnagrams().findAnagrams("abab", "ab"));
    }
}