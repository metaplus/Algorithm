package problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class Lc146LRUCache {

    static class LRUCache {

        private final int capacity;
        private final Map<Integer, Integer> map;
        private final Map<Integer, Integer> orders;
        private final PriorityQueue<Integer> heap;
        private int order = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            this.orders = new HashMap<>(capacity);
            this.heap = new PriorityQueue<>(capacity, (a, b) -> Long.compare(orders.get(a), orders.get(b)));
        }

        public int get(int key) {
            Integer val = map.get(key);
            if (Objects.isNull(val)) {
                return -1;
            }
            heap.remove(key);
            orders.put(key, order++);
            heap.offer(key);
            return val;
        }

        public void put(int key, int value) {
            Integer val = map.get(key);
            if (Objects.isNull(val)) {
                if (map.size() + 1 > capacity) {
                    Integer remove = heap.remove();
                    orders.remove(remove);
                    map.remove(remove);
                }
                map.put(key, value);
                orders.put(key, order++);
                heap.offer(key);
                return;
            }
            map.replace(key, value);
            heap.remove(key);
            orders.put(key, order++);
            heap.offer(key);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
