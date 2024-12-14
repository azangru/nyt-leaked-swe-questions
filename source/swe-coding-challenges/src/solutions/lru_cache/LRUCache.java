package solutions.lru_cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
 * @author Alex Martins
 */
public class LRUCache<T> {

    private int capacity;
    private Map<String, T> map;
    private LinkedList<String> list = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public T get(String key) {
        T element = map.get(key);
        if (element != null) {
            list.remove(key);
            list.add(key);
        }
        return element;
    }

    public void put(String key, T value) {
        boolean overriding = map.containsKey(key);
        map.put(key, value);
        if (overriding) {
            list.remove(key);
        }

        list.add(key);
        dropLeastUsedKey();
    }

    public int size() {
        return map.size();
    }

    private void dropLeastUsedKey() {
        if (list.size() > capacity) {
            String key = list.removeFirst();
            map.remove(key);
        }
    }
}
