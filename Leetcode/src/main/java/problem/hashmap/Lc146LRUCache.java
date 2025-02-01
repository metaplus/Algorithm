package problem.hashmap;

import java.util.*;

public class Lc146LRUCache {

    public static class LRUCache {

        private int capacity;
        private Map<Integer, Cell> map;
        private Cell head;
        private Cell tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            this.head = new Cell();
            this.tail = head;
        }

        public int get(int key) {
            Cell cell = map.get(key);
            if (Objects.isNull(cell)) {
                return -1;
            }
            if (tail != cell) {
                cell.prev.next = cell.next;
                cell.next.prev = cell.prev;
                cell.prev = tail;
                cell.next = null;
                tail.next = cell;
                tail = cell;
            }
            return cell.value;
        }

        public void put(int key, int value) {
            Cell cell = map.get(key);
            if (Objects.isNull(cell)) {
                cell = new Cell();
                cell.key = key;
                cell.value = value;
                cell.prev = tail;
                tail.next = cell;
                tail = cell;
                map.put(key, cell);
                if (map.size() > capacity) {
                    Cell remove = head.next;
                    head.next = remove.next;
                    remove.next.prev = remove.prev;
                    map.remove(remove.key);
                }
                return;
            }
            cell.value = value;
            if (tail != cell) {
                cell.prev.next = cell.next;
                cell.next.prev = cell.prev;
                cell.prev = tail;
                cell.next = null;
                tail.next = cell;
                tail = cell;
            }
        }

        public static class Cell {

            private int key;
            private int value;
            private Cell prev;
            private Cell next;
        }
    }

    public static class LRUCache3 {

        private Map<Integer, Cell> map;
        private Deque<int[]> queue;
        private int capacity;
        private int orders;


        public LRUCache3(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity + 1);
            this.queue = new ArrayDeque<>(capacity * 2);
        }

        public int get(int key) {
            Cell cell = map.get(key);
            if (Objects.isNull(cell)) {
                return -1;
            }
            int order = orders++;
            cell.order = order;
            while (!queue.isEmpty() && queue.peek()[0] == key) {
                queue.poll();
            }
            queue.offer(new int[]{key, order});
            return cell.value;
        }

        public void put(int key, int value) {
            int order = orders++;
            if (!map.containsKey(key)) {
                map.put(key, new Cell(value, order));
            } else {
                Cell cell = map.get(key);
                cell.value = value;
                cell.order = order;
            }
            while (!queue.isEmpty()
                    && queue.peek()[0] == key
                    && queue.peek()[1] < order) {
                queue.poll();
            }
            queue.offer(new int[]{key, order});
            if (map.size() <= capacity) {
                return;
            }
            while (!queue.isEmpty() && map.size() > capacity) {
                int[] least = queue.poll();
                Cell cell = map.get(least[0]);
                if (Objects.isNull(cell) || cell.order > least[1]) {
                    continue;
                }
                map.remove(least[0]);
            }
        }

        private class Cell {

            private int value;
            private int order;

            public Cell(int value, int order) {
                this.value = value;
                this.order = order;
            }
        }
    }


    static class LRUCache2 {

        private final int capacity;
        private final Map<Integer, Integer> map;
        private final Map<Integer, Integer> orders;
        private final PriorityQueue<Integer> heap;
        private int order = 0;

        public LRUCache2(int capacity) {
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
