package problem.deque;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Lc373KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>(k);
        PriorityQueue<Cell> queue = new PriorityQueue<>(k, Comparator.comparingInt(c -> -c.sum));
        for (int i = 0; i < nums1.length; i++) {
            if (queue.size() == k && nums1[i] + nums2[0] >= queue.peek().sum) {
                break;
            }
            for (int j = 0; j < nums2.length; j++) {
                if (queue.size() < k) {
                    queue.add(new Cell(nums1[i], nums2[j], nums1[i] + nums2[j]));
                    continue;
                }
                int sum = nums1[i] + nums2[j];
                if (sum < queue.peek().sum) {
                    queue.remove();
                    queue.add(new Cell(nums1[i], nums2[j], sum));
                    continue;
                }
                break;
            }
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>(2);
            Cell cell = queue.remove();
            list.add(cell.left);
            list.add(cell.right);
            res.add(list);
        }
        return res;
    }

    class Cell {

        int left;
        int right;
        int sum;

        public Cell(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }
    }
}
