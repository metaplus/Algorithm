package problem.search.bfs;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc752OpenLockTest {

    @Test
    void openLock() {
        assertEquals(6, new Lc752OpenLock().openLock(ArrayParse.parseStringArray("[\"0201\",\"0101\",\"0102\",\"1212\",\"2002\"]"), "0202"));
    }
}