package problem.deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lc84LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(left, -1);
        Arrays.fill(right, heights.length);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
//           right[deque.peek()] = i;
                right[deque.peek()] = heights[deque.peek()] > heights[i] ? i : i + 1;
                deque.pop();
            }
            left[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(i);
        }
        int areaMax = 0;
        for (int i = 0; i < heights.length; i++) {
            areaMax = Math.max(areaMax, heights[i] * (right[i] - left[i] - 1));
        }
        return areaMax;
    }


    // timeout
    public int largestRectangleArea2(int[] heights) {
        int[] dp = new int[heights.length];
        int areaMax = 0;
        for (int i = 0; i < heights.length; i++) {
//            dp[i][i] = heights[i];
            areaMax = Math.max(areaMax, heights[i]);
        }
        dp[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            int[] clone = dp.clone();
            dp[i] = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
//                dp[i][j] = Math.min(dp[i][i], dp[i + 1][j]);
                dp[j] = Math.min(heights[i], clone[j]);
                areaMax = Math.max(areaMax, dp[j] * (j - i + 1));
            }
        }
        return areaMax;
    }
}
