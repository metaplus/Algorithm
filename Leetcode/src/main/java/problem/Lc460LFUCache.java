package problem;

import java.util.*;

public class Lc460LFUCache {

    static class LFUCache {


        private final int capacity;
        private final Map<Integer, Node> map;
        private final PriorityQueue<Integer> heap;
        private int order = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            this.heap = new PriorityQueue<>(capacity,
                    Comparator.comparingLong(key -> map.get(key).freq)
                            .thenComparingLong(key -> map.get(key).order));
        }

        public int get(int key) {
            Node node = map.get(key);
            if (Objects.isNull(node)) {
                return -1;
            }
            heap.remove(key);
            node.freq++;
            node.order = order++;
            heap.offer(key);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (Objects.isNull(node)) {
                if (map.size() + 1 > capacity) {
                    Integer remove = heap.remove();
                    map.remove(remove);
                }
                node = new Node();
                node.freq = 1;
                node.order = order++;
                node.value = value;
                map.put(key, node);
                heap.offer(key);
                return;
            }
            heap.remove(key);
            node.value = value;
            node.order = order++;
            node.freq++;
            heap.offer(key);
        }

        static class Node {
            int value;
            int order;
            int freq;
        }
    }


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
