package solutions;

import com.sun.tools.javac.util.Assert;
import solutions.utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by James on 5/7/16.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode head = null, cur=null;
        int len = lists.length;
        PriorityQueue<ListNode> myQ = new PriorityQueue<ListNode>(len, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return  -1;
                else if (o1.val > o2.val)
                    return 1;
                return 0;
            }
        });
        for (ListNode node : lists) {
            if(node != null){
                myQ.add(node);
            }
        }
        while (!myQ.isEmpty()) {
            if (head == null) {
                head = myQ.poll();
                cur = head;
            }
            else {
                cur.next = myQ.poll();
                cur = cur.next;
            }
            if (cur.next != null)
                myQ.add(cur.next);
        }
        return head;
    }
    static public class Test {
        static private MergeKSortedLists _solution = new MergeKSortedLists();

        static public void randomTest() {
            ListNode n1 = new ListNode(1);
            n1.next = new ListNode(4);
            n1.next.next = new ListNode(9);
            ListNode n2 = new ListNode(4);
            n2.next = new ListNode (6);
            n2.next.next = new ListNode(8);
            ListNode n3 = new ListNode(7);
            ListNode[] lists = {n1, n2, n3};
            ListNode head = _solution.mergeKLists(lists);
            while (head != null){
                System.out.println(head.val);
                head = head.next;
            }

            System.out.println();

            ListNode n4 = new ListNode(5);
            n4.next = new ListNode(6);
            n4.next.next = new ListNode(9);
            ListNode n5 = new ListNode(4);
            ListNode n6 = new ListNode(7);
            ListNode[] lists2 = {n4, n5, n6};
            ListNode head2 = _solution.mergeKLists(lists2);
            while (head2 != null){
                System.out.println(head2.val);
                head2 = head2.next;
            }
        }
    }
}
