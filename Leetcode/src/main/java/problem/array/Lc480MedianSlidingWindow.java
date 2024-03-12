package problem.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc480MedianSlidingWindow {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] wins = new double[nums.length - k + 1];
        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                wins[i] = nums[i];
            }
            return wins;
        }
        int size = (k + 1) / 2;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(size);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() + maxHeap.size() < k) {
                minHeap.offer(nums[i]);
                if (minHeap.size() == k) {
                    for (int j = 0; j < k / 2; j++) {
                        maxHeap.offer(minHeap.poll());
                    }
                    wins[i - k + 1] = k % 2 == 1 ? minHeap.peek() : ((double) minHeap.peek() + maxHeap.peek()) / 2;
                }
                continue;
            }
            if (nums[i] >= minHeap.peek()) {
                minHeap.offer(nums[i]);
            } else {
                maxHeap.offer(nums[i]);
            }
            if (nums[i - k] >= minHeap.peek()) {
                minHeap.remove(nums[i - k]);
            } else {
                maxHeap.remove(nums[i - k]);
            }

            while (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
            while (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
            wins[i - k + 1] = k % 2 == 1 ? minHeap.peek() : ((double) minHeap.peek() + maxHeap.peek()) / 2;
        }
        return wins;
    }
}
