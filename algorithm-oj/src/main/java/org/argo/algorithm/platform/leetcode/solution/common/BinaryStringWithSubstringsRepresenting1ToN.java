package org.argo.algorithm.platform.leetcode.solution.common;

import org.argo.algorithm.platform.leetcode.annotation.LeetcodeSolution;

@LeetcodeSolution(order = 1016)
public class BinaryStringWithSubstringsRepresenting1ToN {

    public boolean queryString(String S, int N) {
        for (int i = N; i > N / 2; i--) {
            String binary = Integer.toBinaryString(i);
            if (!S.contains(binary)) {
                return false;
            }
        }
        return true;
    }
}
