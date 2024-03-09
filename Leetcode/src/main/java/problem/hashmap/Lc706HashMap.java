package problem.hashmap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Lc706HashMap {

    class MyHashMap {

        private static final int MOD = 769;
        private final List<Entry>[] entries;

        public MyHashMap() {
            entries = new LinkedList[MOD];
        }

        public void put(int key, int value) {
            int hash = key % MOD;
            if (Objects.isNull(entries[hash])) {
                entries[hash] = new LinkedList<>();
            }
            for (Entry entry : entries[hash]) {
                if (key == entry.key) {
                    entry.value = value;
                    return;
                }
            }
            Entry entry = new Entry();
            entry.key = key;
            entry.value = value;
            entries[hash].add(entry);
        }

        public int get(int key) {
            int hash = key % MOD;
            if (Objects.isNull(entries[hash])) {
                return -1;
            }
            for (Entry entry : entries[hash]) {
                if (key == entry.key) {
                    return entry.value;
                }
            }
            return -1;
        }

        public void remove(int key) {
            int hash = key % MOD;
            if (Objects.isNull(entries[hash])) {
                return;
            }
            Iterator<Entry> iterator = entries[hash].iterator();
            while (iterator.hasNext()) {
                Entry entry = iterator.next();
                if (entry.key == key) {
                    iterator.remove();
                    return;
                }
            }
        }

        private class Entry {

            private int key;
            private int value;
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}


