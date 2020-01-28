package org.argo.algorithm.platform.leetcode.solution.dp;

import org.argo.algorithm.platform.leetcode.solution.common.AddDigits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddDigitsTest {

    @Test
    void addDigits() {
        AddDigits solution = new AddDigits();
        assertEquals(2, solution.addDigits(38));
    }
}