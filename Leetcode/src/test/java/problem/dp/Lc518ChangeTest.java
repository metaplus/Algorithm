package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.dp.bag.Lc518Change;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc518ChangeTest {

    @Test
    void change() {
        assertEquals(4, new Lc518Change().change(5, ArrayParse.parseIntArray("[1, 2, 5]")));
        assertEquals(0, new Lc518Change().change(3, ArrayParse.parseIntArray("[2]")));
    }
}