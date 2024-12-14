package challenges.lru_cache;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations:
 *  'get' and 'put'.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 *
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 *  it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 */
public class LRUCache<T> {

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public T get(String key) {
        return null;
    }

    public void put(String key, T value) {
    }

    public int size() {
        return 0;
    }
}
