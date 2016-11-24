package solutions;

import solutions.utils.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode newHead = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = newHead; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = newHead;
            cur = next;
        }

        return newHead.next;
    }

    static public class Test {
        static private InsertionSortList _solution = new InsertionSortList();

        static public void randomTest() {
            ListNode head = new ListNode(1);
            head.next = new ListNode(4);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(2);
            ListNode newHead = _solution.insertionSortList(head);
            for (ListNode ptr = newHead; ptr != null; ptr = ptr.next) {
                System.out.println(ptr.val);
            }
        }
    }
}
