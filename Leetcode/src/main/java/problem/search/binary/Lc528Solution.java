package problem.search.binary;

import java.util.Random;

public class Lc528Solution {

    class Solution {

        int[][] prefix;
        int sum = 0;
        Random random = new Random();

        public Solution(int[] w) {
            prefix = new int[w.length][2];
            for (int i = 0; i < w.length; i++) {
                prefix[i][0] = i;
                prefix[i][1] = sum;
                sum += w[i];
            }
        }

        public int pickIndex() {
            int next = random.nextInt(0, sum);
            int left = 0;
            int right = prefix.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid][1] <= next) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return prefix[left - 1][0];
        }
    }
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
