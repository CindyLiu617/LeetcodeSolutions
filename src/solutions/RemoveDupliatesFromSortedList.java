package solutions;

import com.sun.org.apache.regexp.internal.RE;
import solutions.utils.ListNode;

public class RemoveDupliatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode ptr = head;
        while (ptr.next != null){
            if (ptr.val == ptr.next.val){
                ptr.next = ptr.next.next;
            }
            else
                ptr = ptr.next;
        }
        return head;
    }

    static public class Test {
        static private RemoveDupliatesFromSortedList _solution = new RemoveDupliatesFromSortedList();

        static public void randomTest() {
          ListNode head = new ListNode(1);
          head.next = new ListNode(2);
          head.next.next = new ListNode(2);
          head.next.next.next = new ListNode(3);
          ListNode rst = _solution.deleteDuplicates(head);
          for (ListNode h = rst; h!= null; h = h.next) {
              System.out.println(h.val);
          }
        }
    }
}
