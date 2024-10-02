package src.scaler.lld.crashCourse.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer,Node> cache;
    private Node head;
    private Node tail;

    LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value){
//        if cache contains remove the earlier one.
        if(cache.containsKey(key)){
            Node oldNode = cache.get(key);
            remove(oldNode);
        }
//        Add to cache.
        Node node = new Node(key, value);
        cache.put(key, node);
        add(node);

//        if Capacity Exceeds
        if (cache.size() > capacity) {
            Node nodeToDelete = tail.prev;
            remove(nodeToDelete);
            cache.remove(nodeToDelete.key);
        }
    }

    private void remove(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;

    }
    private void add(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }

}
