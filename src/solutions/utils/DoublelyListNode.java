package solutions.utils;

public class DoublelyListNode {
    public int value;
    public int key;
    public DoublelyListNode next;
    public DoublelyListNode prev;
    public DoublelyListNode(int key, int value) {
        this.value = value;
        this.key = key;
        next = null;
        prev = null;
    }
    public int getKey(){
        return this.key;
    }
}
