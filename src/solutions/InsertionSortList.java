package solutions;

import solutions.utils.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode after = dummy, front = head, next;
        while (front != null) {
            //next pointer is always points to the next of front pointer
           next = front.next;
           //insert cur between after and after.next
           while (after.next != null && after.next.val < front.val) {
               after = after.next;
           }
            after.next = front;
            front.next = after.next;
            after = dummy;
            front = next;
        }
        return dummy.next;
    }

    static public class Test {
        static private InsertionSortList _solution = new InsertionSortList();

        static public void randomTest() {
            ListNode head = new ListNode(1);
            head.next = new ListNode(4);
            head.next.next = new ListNode(2);
            head.next.next.next = new ListNode(3);
            ListNode newHead = _solution.insertionSortList(head);
            for (ListNode ptr = newHead; ptr != null; ptr = ptr.next) {
                System.out.println(ptr.val);
            }
        }
    }
}
