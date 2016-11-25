package solutions;

import solutions.utils.RandomListNode;
import solutions.utils.TreeNode;

import java.util.HashMap;

/**
 * Created by James on 10/31/16.
 */
public class CopyListWithRadomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        //key: new node, value: corresponded old node
        HashMap<RandomListNode, RandomListNode> map = new
                HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(newHead, head);
        RandomListNode newPtr = newHead, oldPtr = head.next;
        //generate new nodes with only next pointers
        while (oldPtr != null) {
            newPtr.next = new RandomListNode(oldPtr.label);
            newPtr = newPtr.next;
            map.put(newPtr, oldPtr);
            oldPtr = oldPtr.next;
        }
        //generate random pointers
        newPtr = newHead;
        oldPtr = head;
        while (oldPtr != null) {
            newPtr.random = map.get(newPtr).random;
            newPtr = newPtr.next;
            oldPtr = oldPtr.next;
        }
        return newHead;
    }

    static public class Test {
        static private CopyListWithRadomPointer _solution = new
                CopyListWithRadomPointer();

        static public void randomTest() {
            RandomListNode n1 = new RandomListNode(1);
            n1.next = new RandomListNode(2);
            n1.next.next = new RandomListNode(3);
            n1.next.next.next = new RandomListNode(4);
            n1.next.next.next.next = new RandomListNode(5);
            n1.random = n1.next.next;
            n1.next.next.random = n1.next.next.next.next;
            RandomListNode newHead = _solution.copyRandomList(n1);
            for (RandomListNode ptr = newHead; ptr != null; ptr = ptr.next) {
                System.out.println(ptr.label);
            }
        }
    }
}
