package problem;

import org.junit.jupiter.api.Test;
import problem.hashmap.Lc146LRUCache;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc146LRUCacheTest {


    @Test
    void LRUCache() {
        Lc146LRUCache.LRUCache cache = new Lc146LRUCache.LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void LRUCache2() {
        Lc146LRUCache.LRUCache cache = new Lc146LRUCache.LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        assertEquals(4, cache.get(4));
        assertEquals(3, cache.get(3));
        assertEquals(2, cache.get(2));
        assertEquals(-1, cache.get(1));
        cache.put(5, 5);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
        assertEquals(3, cache.get(3));
        assertEquals(-1, cache.get(4));
        assertEquals(5, cache.get(5));
    }
}