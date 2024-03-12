package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc1358NumberOfSubstringsTest {

    @Test
    void numberOfSubstrings() {
        assertEquals(10,new Lc1358NumberOfSubstrings().numberOfSubstrings("abcabc"));
    }
}