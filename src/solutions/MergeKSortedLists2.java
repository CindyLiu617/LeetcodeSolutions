package solutions;
import solutions.utils.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists2 {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0){
            return null;
        }
        ListNode dummy = new ListNode(-1), ptr = dummy;
        int numberOfList = lists.size();
        //how to initialize capacity
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>
                (numberOfList,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode list: lists){
            if(list!=null)
                pq.offer(list);
        }

        while(!pq.isEmpty()){
            ListNode n = pq.poll();
            p.next = n;
            p=p.next;

            if(n.next!=null)
                pq.offer(n.next);
        }

        return head.next;

    }
    static public class Test {
        static private MergeKSortedLists2 _solution = new MergeKSortedLists2();

        static public void randomTest() {
            ListNode n1 = new ListNode(1);
            n1.next = new ListNode(4);
            n1.next.next = new ListNode(9);
            ListNode n2 = new ListNode(4);
            n2.next = new ListNode (6);
            n2.next.next = new ListNode(8);
            ListNode n3 = new ListNode(7);
            List<ListNode> lists = new ArrayList<ListNode>();
            lists.add(n1);
            lists.add(n2);
            lists.add(n3);
            ListNode head = _solution.mergeKLists(lists);
            while (head != null){
                System.out.println(head.val);
                head = head.next;
            }

            System.out.println();

        }
    }
}
