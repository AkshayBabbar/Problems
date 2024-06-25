The internal implementation of `ConcurrentHashMap` in Java underwent significant changes in JDK 8 to improve performance and scalability. Here's an overview of these changes and how `ConcurrentHashMap` works:

### ConcurrentHashMap in JDK 7

In JDK 7, `ConcurrentHashMap` was implemented using a technique called "segmentation". It divided the map into multiple segments, each of which was a separately locked `HashMap`. This allowed multiple threads to perform operations on different segments concurrently without locking the entire map. Key points about this implementation:

1. **Segmentation:** The map was divided into 16 segments by default.
2. **Locking:** Each segment had its own lock, allowing for more granular locking.
3. **Concurrency Level:** The number of segments was defined by the concurrency level, which could be specified during the map's construction.

### ConcurrentHashMap in JDK 8

In JDK 8, the internal structure of `ConcurrentHashMap` was significantly redesigned to improve performance, especially under high contention. The major changes include:

1. **Bucket-Level Locking:** Instead of segments, `ConcurrentHashMap` uses finer-grained locking at the bucket (or bin) level. Each bin can be individually locked, allowing more concurrent operations.
2. **CAS Operations:** `ConcurrentHashMap` uses Compare-And-Swap (CAS) operations extensively to update the map without locking. This reduces the need for explicit locks and improves performance.
3. **Tree Bins:** When a bin exceeds a certain threshold of elements (default is 8), it is transformed into a balanced tree (similar to `TreeMap`) to improve lookup performance. This reduces the time complexity of operations from O(n) to O(log n) for highly populated bins.
4. **Improved Resizing:** The resizing mechanism was improved to be more efficient and to minimize contention. Threads cooperate during the resize process.

### Internal Implementation Details

1. **Data Structure:**
    - The map is backed by an array of `Node<K, V>[]` called `table`.
    - Each entry in the table is a linked list of `Node<K, V>` objects, similar to a traditional `HashMap`.
    - When a bin becomes too large, it is converted into a tree structure using `TreeNode<K, V>` objects.

2. **Node Class:**
   ```java
   static class Node<K, V> implements Map.Entry<K, V> {
       final int hash;
       final K key;
       volatile V val;
       volatile Node<K, V> next;
       // Constructor and methods
   }
   ```

3. **TreeNode Class:**
   ```java
   static final class TreeNode<K, V> extends Node<K, V> {
       TreeNode<K, V> parent;  // Red-black tree links
       TreeNode<K, V> left;
       TreeNode<K, V> right;
       TreeNode<K, V> prev;    // Needed to unlink next upon deletion
       boolean red;
       // Constructor and methods
   }
   ```

4. **Locking Mechanism:**
    - For most operations, CAS is used to ensure atomic updates without locking.
    - When necessary (e.g., during bin expansion or treeification), the map uses a `ReentrantLock` for finer-grained control.

5. **Table Initialization and Resizing:**
    - The table is lazily initialized upon the first insertion.
    - Resizing is handled incrementally by multiple threads to reduce contention. Each thread helps in transferring entries from the old table to the new one.

### Example Usage

Here's a simple example of how to use `ConcurrentHashMap`:

```java
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Insert some values
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Retrieve a value
        System.out.println("Value for 'two': " + map.get("two"));

        // Iterate over the entries
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
```

### Summary

- **JDK 7 Implementation:**
    - Segmented locking for concurrency.
    - Limited scalability due to segment-level locking.

- **JDK 8 Implementation:**
    - Finer-grained locking at the bucket level.
    - Extensive use of CAS operations for lock-free updates.
    - Tree bins for improved performance on high-collision scenarios.
    - Efficient resizing with cooperative thread involvement.

These changes made `ConcurrentHashMap` in JDK 8 significantly more efficient and scalable, particularly under high contention and large datasets.