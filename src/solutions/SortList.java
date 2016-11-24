package solutions;

import solutions.utils.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    private  ListNode findMiddle(ListNode head){
        ListNode slow = head;
        //fast is head.next!!!!
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                ptr.next = head1;
                head1 = head1.next;
            }
            else{
                ptr.next = head2;
                head2 = head2.next;
            }
            ptr = ptr.next;
        }
        if (head1 != null){
            ptr.next = head1;
        }
        else{
            ptr.next = head2;
        }
        return dummy.next;
    }
}
