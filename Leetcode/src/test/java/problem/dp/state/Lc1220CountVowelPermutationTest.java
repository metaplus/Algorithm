package problem.dp.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc1220CountVowelPermutationTest {

    @Test
    void countVowelPermutation() {
        assertEquals(18208803,new Lc1220CountVowelPermutation().countVowelPermutation(144));
        assertEquals(68,new Lc1220CountVowelPermutation().countVowelPermutation(5));
        assertEquals(5,new Lc1220CountVowelPermutation().countVowelPermutation(1));
        assertEquals(10,new Lc1220CountVowelPermutation().countVowelPermutation(2));
    }
}