package problem.dp.sequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc647CountSubstringsTest {

    @Test
    void countSubstrings() {
        assertEquals(3,new Lc647CountSubstrings().countSubstrings("abc"));
        assertEquals(6,new Lc647CountSubstrings().countSubstrings("aaa"));
    }
}