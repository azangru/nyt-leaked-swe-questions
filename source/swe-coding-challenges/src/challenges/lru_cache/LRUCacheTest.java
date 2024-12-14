package challenges.lru_cache;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class LRUCacheTest {

    @Test
    public void addAndRetrieveAnEntry() {
        LRUCache<Integer> cache = new LRUCache<>(10);
        assertThat(cache.size(), equalTo(0));

        cache.put("1", 1);

        assertThat(cache.size(), equalTo(1));
        assertThat(cache.get("1"), equalTo(1));
    }

    @Test
    public void evictingLRUEntries() {
        LRUCache<Integer> cache = new LRUCache<>(2);

        cache.put("1", 1);
        cache.put("2", 2);

        cache.get("1"); // make '1' the most recent used.

        cache.put("3", 3);
        assertThat(cache.size(), equalTo(2));
        assertThat(cache.get("2"), nullValue()); // evicted

        cache.put("4", 4);
        assertThat(cache.get("1"), nullValue()); // evicted
        assertThat(cache.get("3"), equalTo(3));
        assertThat(cache.get("4"), equalTo(4));
    }
}
