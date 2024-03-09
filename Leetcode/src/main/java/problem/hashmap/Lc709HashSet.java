package problem.hashmap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Lc709HashSet {

    class MyHashSet {

        private static final int MOD = 769;
        private List<Integer>[] buckets;

        public MyHashSet() {
            buckets = new LinkedList[MOD];
        }

        public void add(int key) {
            int index = key % MOD;
            if (Objects.isNull(buckets[index])) {
                buckets[index] = new LinkedList<>();
            }
            Iterator<Integer> iterator = buckets[index].iterator();
            while (iterator.hasNext()) {
                if (key == iterator.next()) {
                    return;
                }
            }
            buckets[index].add(key);
        }

        public void remove(int key) {
            int index = key % MOD;
            if (Objects.isNull(buckets[index])) {
                return;
            }
            Iterator<Integer> iterator = buckets[index].iterator();
            while (iterator.hasNext()) {
                if (key == iterator.next()) {
                    iterator.remove();
                    return;
                }
            }
        }

        public boolean contains(int key) {
            int index = key % MOD;
            if (Objects.isNull(buckets[index])) {
                return false;
            }
            Iterator<Integer> iterator = buckets[index].iterator();
            while (iterator.hasNext()) {
                if (key == iterator.next()) {
                    return true;
                }
            }
            return false;
        }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
    }
}
