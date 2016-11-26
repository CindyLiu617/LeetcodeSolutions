package solutions;

import solutions.utils.DoublelyListNode;

import java.util.HashMap;

public class LRUCache {
    // @param capacity, an integer
    private HashMap<Integer, DoublelyListNode> map;
    private int capacity;
    private DoublelyListNode dummy;
    private DoublelyListNode tail;


    public LRUCache(int capacity) {
        // write your code here
        this.capacity = capacity;
        this.map = new HashMap<Integer, DoublelyListNode>(capacity);
        this.dummy = new DoublelyListNode(-1, -1);
        this.tail = null;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            DoublelyListNode getNode = map.get(key);
            //relocate getNode to head
            //if newnode is head, dp nothing
            if (getNode != dummy.next) {
                _renew(getNode);
            }
            return getNode.value;
        } else {
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        //set value
        if (map.containsKey(key)) {
            DoublelyListNode node = map.get(key);
            _renew(node);
            //if renewed value is tail, don't forget to update tail
            if (node.next == null) {
                tail = node;
            }
            node.value = value;
        } else {
            DoublelyListNode newNode = new DoublelyListNode(key, value);
            _insertToHead(newNode);
            map.put(key, newNode);
            //create tail. if tail is not null, tail remains same unless tail
            // is gotten
            if (tail == null) {
                tail = newNode;
            }
            if (map.size() > capacity) {
                _evict();
            }
        }
    }

    private void _renew(DoublelyListNode node) {
        _remove(node);
        _insertToHead(node);
    }

    private void _insertToHead(DoublelyListNode node) {
        node.next = dummy.next;
        node.prev = dummy;
        if (dummy.next != null) {
            dummy.next.prev = node;
        }
        dummy.next = node;
    }

    private void _remove(DoublelyListNode node){
        if (node == tail) { // if node.next == null
            tail = tail.prev;
        } else { // if node.next != null
            node.next.prev = node.prev;
        }
        node.prev.next = node.next;
    }

    private void _evict() {
        //remove before renew tail
        map.remove(tail.getKey());
        tail = tail.prev;
        tail.next = null;
    }

    static public class Test {

        static public void randomTest() {
            LRUCache lruCache = new LRUCache(2);
            lruCache.set(2, 1);
            lruCache.set(2, 2);
            System.out.println(lruCache.get(2));
            lruCache.set(1, 1);
            lruCache.set(4, 1);
            System.out.println(lruCache.get(2));

        }
    }

}
