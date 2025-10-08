package dataStructure.LruCache;
import java.util.HashMap;

class LRU {
    DList head = new DList(0, 0);
    DList tail = new DList(0, 0);
    int capacity;
    HashMap<Integer, DList> mp;

    public LRU(int capacity) {
        mp = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    private void insert(DList node) {
        mp.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(DList node) {
        mp.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }
        DList node = mp.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            DList node = mp.get(key);
            node.val = value;
            remove(node);
            insert(node);
            return;
        }
        if (capacity == mp.size()) {
            remove(tail.prev);
        }
        DList node = new DList(key, value);
        insert(node);
    }

    class DList {
        int val;
        int key;
        DList next;
        DList prev;

        public DList(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

public class LRUCache {
    public static void main(String[] args) {
        LRU cache = new LRU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3);                  // evicts key 2
        System.out.println(cache.get(2)); // -1
        cache.put(4, 4);                  // evicts key 1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
