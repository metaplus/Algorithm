package org.argo.algorithm.platform.leetcode.solution.common;

import org.argo.algorithm.platform.leetcode.annotation.LeetcodeSolution;

import java.util.stream.IntStream;

@LeetcodeSolution(order = 258)
public class AddDigits {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = num;
        int char0 = '0';
        do {
            IntStream digits = Integer.toString(sum).chars()
                    .map(i -> i - char0);
            sum = digits.sum();
        } while (sum >= 10);
        return sum;
    }
}
