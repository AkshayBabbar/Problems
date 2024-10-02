package src.scaler.lld.crashCourse.LRU;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheDLL {
    public int capacity;
    private LinkedList<Integer> lruList;

    private Map<Integer, Integer> cacheMap;

    LRUCacheDLL(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.lruList = new LinkedList<>();
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        lruList.remove(key);
        // Add key to the front
        lruList.addFirst(key);

        return cacheMap.get(key);
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {

            // Update the value
            cacheMap.put(key, value);

            // Move the accessed key to the front
            lruList.remove(Integer.valueOf(key));
        }
        else {

            // Add new key-value pair
            if (cacheMap.size() >= capacity) {

                // Remove the least recently used item
                int leastUsedKey = lruList.removeLast();
                cacheMap.remove(leastUsedKey);
            }
            cacheMap.put(key, value);
        }
        // Add the key to the front (most recently used
        // position)
        lruList.addFirst(key);
    }
}
