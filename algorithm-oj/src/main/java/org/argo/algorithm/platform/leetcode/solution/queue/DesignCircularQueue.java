package org.argo.algorithm.platform.leetcode.solution.queue;

import org.argo.algorithm.platform.leetcode.annotation.LeetcodeSolution;

@LeetcodeSolution(order = 622)
public class DesignCircularQueue {

    static class MyCircularQueue {
        private int[] data;
        private int capacity;
        private int front;
        private int back;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            capacity = k;
            data = new int[k];
            front = -1;
            back = -1;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            int pos = (++front) % capacity;
            data[pos] = value;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            ++back;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            int pos = (back + 1) % capacity;
            return data[pos];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            int pos = front % capacity;
            return data[pos];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return front < 0 || front == back;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return front >= 0 && (front - back) == capacity;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
