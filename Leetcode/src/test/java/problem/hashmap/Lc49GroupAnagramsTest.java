package problem.hashmap;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc49GroupAnagramsTest {

    @Test
    void groupAnagrams() {

        assertEquals(
                FastList.newListWith(
                        FastList.newListWith("bat"),
                        FastList.newListWith("nat", "tan"),
                        FastList.newListWith("ate", "eat", "tea")
                )
                , new Lc49GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}