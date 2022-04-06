package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P460LfuCacheTest {

    P460LfuCache.LFUCache cache;

    @Test
    public void test1() {
        int capacity = 2;
        this.cache = new P460LfuCache().new LFUCache(capacity);

        this.cache.put(1, 1);
        this.cache.put(2, 2);
        assertEquals(1, this.cache.get(1));
        this.cache.put(3, 3);
        assertEquals(-1, this.cache.get(2));
        assertEquals(3, this.cache.get(3));
        this.cache.put(4, 4);
        assertEquals(-1, this.cache.get(1));
        assertEquals(3, this.cache.get(3));
        assertEquals(4, this.cache.get(4));
    }

    @Test
    public void test2() {
        int capacity = 0;
        this.cache = new P460LfuCache().new LFUCache(capacity);

        this.cache.put(0, 0);
        assertEquals(-1, this.cache.get(0));
    }
}