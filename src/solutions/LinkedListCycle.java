package solutions;

import solutions.utils.ListNode;

public class LinkedListCycle {
    //check if a linked list has cycle
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head, slow = head;
        while (fast != null && slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //Given a linked list, return the node where the cycle begins.
    // If there is no cycle, return null.
    public ListNode detectCycle(ListNode head) {
        if (head ==  null)
            return null;
        ListNode fast = head, slow = head;
        while(fast != null && slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                break;
        }
        //no cycle
        if (fast == null || fast.next == null)
            return null;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    static public class Test {
        static private LinkedListCycle _solution = new LinkedListCycle();

        static public void randomTest() {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next= new ListNode(5);
            head.next.next.next.next.next= new ListNode(2);
            ListNode rst1 = _solution.detectCycle(head);
            System.out.println(rst1.val);
        }
    }
}
