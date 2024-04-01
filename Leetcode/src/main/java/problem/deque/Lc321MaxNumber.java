package problem.deque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class Lc321MaxNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        Arrays.fill(res, -1);
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        for (int size1 = 0; size1 <= nums1.length; size1++) {
            if (k - size1 < 0 || k - size1 > nums2.length) {
                continue;
            }
            deque1.clear();
            deque2.clear();
            maxSeq(deque1, nums1, size1);
            maxSeq(deque2, nums2, k - size1);
            int id = 0;
            boolean greater = false;
            while (!deque1.isEmpty() || !deque2.isEmpty()) {
                int val;
                if (deque1.isEmpty()) {
                    val = deque2.pollFirst();
                } else if (deque2.isEmpty()) {
                    val = deque1.pollFirst();
                } else {
                    if (deque1.peekFirst() < deque2.peekFirst()) {
                        val = deque2.pollFirst();
                    } else if (deque1.peekFirst() > deque2.peekFirst()) {
                        val = deque1.pollFirst();
                    } else if (compareSeq(deque1, deque2) > 0) {
                        val = deque1.pollFirst();
                    } else {
                        val = deque2.pollFirst();
                    }
                }
                if (res[id] < 0) {
                    res[id++] = val;
                    greater = true;
                    continue;
                }
                if (res[id] > val && !greater) {
                    break;
                }
                if (res[id] < val) {
                    greater = true;
                }
                res[id++] = val;
            }
        }
        return res;
    }

    private void maxSeq(Deque<Integer> deque, int[] nums, int size) {
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty()
                    && deque.peekLast() < nums[i]
                    && deque.size() + nums.length - i - 1 >= size) {
                deque.pollLast();
            }
            if (deque.size() + 1 > size) {
                continue;
            }
            deque.offerLast(nums[i]);
        }
    }

    private int compareSeq(Deque<Integer> deque1, Deque<Integer> deque2) {
        Iterator<Integer> iterator1 = deque1.iterator();
        Iterator<Integer> iterator2 = deque2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            Integer val1 = iterator1.next();
            Integer val2 = iterator2.next();
            if (!val2.equals(val1)) {
                return val1 - val2;
            }
        }
        return iterator1.hasNext() ? 1 : -1;
    }
}
