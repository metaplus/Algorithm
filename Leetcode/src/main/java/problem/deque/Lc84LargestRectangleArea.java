package problem.deque;

import java.util.*;

public class Lc84LargestRectangleArea {


    // timeout 98/99
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> deque = new ArrayDeque<>(heights.length);
        int areaMax = 0;
        for (int i = 0; i < heights.length; i++) {
            areaMax = Math.max(heights[i], areaMax);
            int remove = -1;
            while (!deque.isEmpty() && deque.peekLast()[0] >= heights[i]) {
                int area = heights[i] * (i - deque.peekLast()[1] + 1);
                areaMax = Math.max(area, areaMax);
                remove = deque.pollLast()[1];
            }
            for (int[] left : deque) {
                int area = left[0] * (i - left[1] + 1);
                areaMax = Math.max(area, areaMax);
            }
            if (remove >= 0) {
                deque.addLast(new int[]{heights[i], remove});
            }
            if (deque.isEmpty() || heights[i] > deque.peekLast()[0]) {
                deque.addLast(new int[]{heights[i], i});
            }
        }
        return areaMax;
    }

    public int largestRectangleArea3(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Arrays.fill(left, -1);
        Arrays.fill(right, heights.length);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
//           right[deque.peek()] = i;
                right[deque.peek()] = i;
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
