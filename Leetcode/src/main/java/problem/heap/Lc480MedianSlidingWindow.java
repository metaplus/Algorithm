package problem.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Lc480MedianSlidingWindow {

    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<long[]> minHeap = new TreeSet<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] < b[1] ? -1 : 1;
            }
            return (int) (a[0] - b[0]);
        });
        TreeSet<long[]> maxHeap = new TreeSet<>((a, b) -> {
            if (a[1] != b[1]) {
                return a[1] < b[1] ? 1 : -1;
            }
            return (int) (a[0] - b[0]);
        });
        double[] res = new double[nums.length - k + 1];
        int id = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k == 1) {
                res[id++] = nums[i];
                continue;
            }
            if (minHeap.size() + maxHeap.size() == k) {
                if (nums[i - k] > minHeap.first()[1]
                        || (nums[i - k] == minHeap.first()[1] && i - k >= minHeap.first()[0])) {
                    minHeap.remove(new long[]{i - k, nums[i - k]});
                } else {
                    maxHeap.remove(new long[]{i - k, nums[i - k]});
                }
            }
            if ((minHeap.isEmpty() && maxHeap.isEmpty())
                    || (!minHeap.isEmpty() && nums[i] > minHeap.first()[1])) {
                minHeap.add(new long[]{i, nums[i]});
                while (minHeap.size() - maxHeap.size() > 1) {
                    maxHeap.add(minHeap.pollFirst());
                }
            } else {
                maxHeap.add(new long[]{i, nums[i]});
                while (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.pollFirst());
                }
            }
            if (minHeap.size() + maxHeap.size() < k) {
                continue;
            }
            if (k % 2 == 1) {
                res[id++] = minHeap.first()[1];
                continue;
            }
            long sum = maxHeap.first()[1] + minHeap.first()[1];
            res[id++] = ((double) sum) / 2;
        }
        return res;
    }

    public double[] medianSlidingWindow2(int[] nums, int k) {
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
