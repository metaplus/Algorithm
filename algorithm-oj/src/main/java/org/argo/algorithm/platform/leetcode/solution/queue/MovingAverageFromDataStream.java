package org.argo.algorithm.platform.leetcode.solution.queue;

import org.argo.algorithm.platform.leetcode.annotation.LeetcodeSolution;

import java.util.ArrayDeque;
import java.util.Deque;

@LeetcodeSolution(order = 346)
public class MovingAverageFromDataStream {

    static class MovingAverage {
        private Deque<Integer> deque;
        private int capacity;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            deque = new ArrayDeque<>(size);
            capacity = size;
        }

        public double next(int val) {
            if (deque.size() == capacity) {
                deque.poll();
            }
            deque.add(val);
            double sum = 0;
            for (Integer value : deque) {
                sum += value.doubleValue();
            }
            return sum / deque.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
