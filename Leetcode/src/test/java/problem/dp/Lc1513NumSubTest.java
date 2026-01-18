package problem.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc1513NumSubTest {

    @Test
    void numSub() {
        assertEquals(62,new Lc1513NumSub().numSub("1111111111011010011"));
        assertEquals(9,new Lc1513NumSub().numSub("0110111"));
        assertEquals(21,new Lc1513NumSub().numSub("111111"));
    }
}