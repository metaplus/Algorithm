package org.argo.algorithm.platform.leetcode.solution.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingTest {

    @Test
    void isMatch() {
        RegularExpressionMatching matching = new RegularExpressionMatching();
        assertTrue(matching.isMatch("aa", "a*"));
    }
}