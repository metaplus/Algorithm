package problem.array;

import java.util.PriorityQueue;

public class Lc239MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k * 2, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            if (queue.size() < k) {
                continue;
            }
            while (queue.peek()[1] < i - k + 1) {
                queue.poll();
            }
            res[i - k + 1]=queue.peek()[0];
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] windows = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int[] counts = new int[20000 + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] + 10000]++;
            if (nums[i] > max) {
                max = nums[i];
            }
            if (i < k - 1) {
                continue;
            }
            if (i == k - 1) {
                windows[i - k + 1] = max;
                continue;
            }
            if (counts[nums[i - k] + 10000]-- > 1) {
                windows[i - k + 1] = max;
                continue;
            }
            if (nums[i - k] != max) {
                windows[i - k + 1] = max;
                continue;
            }
            for (int val = max - 1; val >= -10000; val--) {
                if (counts[val + 10000] > 0) {
                    max = val;
                    windows[i - k + 1] = max;
                    break;
                }
            }
        }
        return windows;
    }
}
