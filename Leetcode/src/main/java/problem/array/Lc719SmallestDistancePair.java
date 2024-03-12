package problem.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc719SmallestDistancePair {


    public int smallestDistancePair(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int min = 0;
        int max = nums[nums.length - 1] - nums[0];
        while (min <= max) {
            int mid = min + max >> 1;
            int left = 0;
            int count = 0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = left; j < i && nums[i] - nums[j] > mid; j++) {
                    left = j + 1;
                }
                count += i - left;
            }
            if (count >= k) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public int smallestDistancePair2(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= left; j--) {
                int dist = nums[i] - nums[j];
                if (maxHeap.size() < k) {
                    maxHeap.offer(dist);
                    continue;
                }
                if (dist >= maxHeap.peek()) {
                    left = j + 1;
                    break;
                }
                maxHeap.remove();
                maxHeap.offer(dist);
            }

        }
        return maxHeap.peek();
    }
}
