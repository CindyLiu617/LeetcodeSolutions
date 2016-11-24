package solutions;

import solutions.utils.ListNode;

public class ReverseLinkedList {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = head.next;
        while (head.next != null) {
            ListNode tmp = dummy.next;
            head.next = ptr.next;
            dummy.next = ptr;
            ptr.next = tmp;
            ptr = head.next;
        }
        return dummy.next;
    }

    static public class Test {
        static private ReverseLinkedList _solution = new ReverseLinkedList();

        static public void randomTest() {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            ListNode newHead = _solution.reverse(head);
            for (ListNode ptr = newHead; ptr != null; ptr = ptr.next) {
                System.out.println(ptr.val);
            }
        }
    }
}
