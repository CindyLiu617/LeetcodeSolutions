package solutions;

import solutions.utils.ListNode;

public class ReverseLinkedListII {
    /**
     * @param head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        //in-place && traverse only once
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int mptr = 0;
        int nptr = 0;
        ListNode temp;
        //let cur in pos m
        while (mptr < m-1 && cur != null){
            prev = prev.next;
            cur = cur.next;
            ++mptr;
            ++nptr;
        }
        ++nptr;
        //reverse list
        while (nptr < n && cur.next != null) {
            temp = cur.next.next;
            ListNode afterPre = prev.next;
            prev.next = cur.next;
            prev.next.next = afterPre;
            cur.next = temp;
        }
        return dummy.next;
    }

    static public class Test {
        static private ReverseLinkedListII _solution = new
                ReverseLinkedListII();

        static public void randomTest() {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            ListNode newHead = _solution.reverseBetween(head, 2, 4);
            for (ListNode ptr = newHead; ptr != null; ptr = ptr.next) {
                System.out.println(ptr.val);
            }
        }
    }
}
