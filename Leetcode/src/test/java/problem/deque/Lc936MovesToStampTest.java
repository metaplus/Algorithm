package problem.deque;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc936MovesToStampTest {

    @Test
    void movesToStamp() {
        assertArrayEquals(ArrayParse.parseIntArray("[]"),
                new Lc936MovesToStamp().movesToStamp("afc", "aafcaafacc"));
        assertArrayEquals(ArrayParse.parseIntArray("[]"),
                new Lc936MovesToStamp().movesToStamp("de", "ddeddeddee"));
        assertArrayEquals(ArrayParse.parseIntArray("[]"),
                new Lc936MovesToStamp().movesToStamp("wokks", "kokks"));
        assertArrayEquals(ArrayParse.parseIntArray("[]"),
                new Lc936MovesToStamp().movesToStamp("lemk", "lleme"));

        assertArrayEquals(ArrayParse.parseIntArray("[3,0,1,2]"),
                new Lc936MovesToStamp().movesToStamp("oz", "ooozz"));
        assertArrayEquals(ArrayParse.parseIntArray("[2,1,0]"),
                new Lc936MovesToStamp().movesToStamp("cab", "cabbb"));
        assertArrayEquals(ArrayParse.parseIntArray("[]"),
                new Lc936MovesToStamp().movesToStamp("aye", "eyeye"));
        assertArrayEquals(ArrayParse.parseIntArray("[4,3,2,1,0]"),
                new Lc936MovesToStamp().movesToStamp("h", "hhhhh"));
        assertArrayEquals(ArrayParse.parseIntArray("[0,3,1]"),
                new Lc936MovesToStamp().movesToStamp("abca", "aabcaca"));
        assertArrayEquals(ArrayParse.parseIntArray("[0,2]"),
                new Lc936MovesToStamp().movesToStamp("abc", "ababc"));
    }
}