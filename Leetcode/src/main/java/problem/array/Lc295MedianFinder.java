package problem.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lc295MedianFinder {

    static class MedianFinder {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (minHeap.isEmpty()) {
                minHeap.add(num);
                return;
            }
            if (num >= minHeap.peek()) {
                minHeap.add(num);
                while (!minHeap.isEmpty()
                        && minHeap.size() - maxHeap.size() > 1) {
                    maxHeap.offer(minHeap.poll());
                }
                return;
            }
            maxHeap.add(num);
            while (!maxHeap.isEmpty() && maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.isEmpty()) {
                return 0;
            }
            if (maxHeap.isEmpty()) {
                return minHeap.peek();
            }
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            }
            return ((double) minHeap.peek() + maxHeap.peek()) / 2;
        }
    }
}
