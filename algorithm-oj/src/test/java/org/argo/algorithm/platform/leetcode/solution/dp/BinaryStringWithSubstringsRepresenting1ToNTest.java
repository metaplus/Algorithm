package org.argo.algorithm.platform.leetcode.solution.dp;

import org.argo.algorithm.platform.leetcode.solution.common.BinaryStringWithSubstringsRepresenting1ToN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryStringWithSubstringsRepresenting1ToNTest {

    @Test
    void queryString() {
        BinaryStringWithSubstringsRepresenting1ToN solution = new BinaryStringWithSubstringsRepresenting1ToN();
        assertFalse(solution.queryString("110101011011000011011111000000", 15));
        assertTrue(solution.queryString("1", 1));
    }
}