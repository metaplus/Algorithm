package problem.greedy;

import java.util.Arrays;

public class Lc455FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        radixSort(g);
        radixSort(s);
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                count++;
                continue;
            }
            j++;
        }
        return count;
    }


    private void radixSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int digit = findDigit(max);
        int[] counts = new int[10];
        int[] sort = new int[nums.length];
        int div = 1;
        for (int i = 0; i < digit; i++) {
            for (int num : nums) {
                counts[(num / div) % 10]++;
            }
            for (int j = 1; j < counts.length; j++) {
                counts[j] += counts[j - 1];
            }
            for (int j = nums.length - 1; j >= 0; j--) {
                sort[--counts[(nums[j] / div) % 10]] = nums[j];
            }
            div *= 10;
            Arrays.fill(counts, 0);
            System.arraycopy(sort, 0, nums, 0, nums.length);
        }
    }

    private int findDigit(int max) {
        int digit = 0;
        for (int i = max; i > 0; i /= 10) {
            digit++;
        }
        return digit;
    }
}
