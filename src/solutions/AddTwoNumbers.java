package solutions;
import solutions.utils.ListNode;

/**
 * Created by James on 7/1/16.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null){
            return l1 == null? l2: l1;
        }
        ListNode head = new ListNode(0), ptr = head;
        int carrier = 0, temp;
        while (l1 != null && l2 != null){
            temp = l1.val + l2.val + carrier;
            ptr.next = new ListNode(temp % 10);
            carrier = temp / 10;
            ptr = ptr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            temp = l1.val + carrier;
            ptr.next = new ListNode(temp % 10);
            carrier = temp / 10;
            ptr = ptr.next;
            l1 = l1.next;
        }
        while (l2 != null){
            temp = l2.val + carrier;
            ptr.next = new ListNode(temp % 10);
            carrier = temp / 10;
            ptr = ptr.next;
            l2 = l2.next;
        }
        if (carrier == 1)
            ptr.next = new ListNode(1);
        return head.next;
    }
    static public class Test {
        static private AddTwoNumbers _solution = new AddTwoNumbers();

        static public void randomTest() {
//            ListNode l1 = new ListNode(7);
//            l1.next = new ListNode(1);
//            l1.next.next = new ListNode(6);
//            ListNode l2 = new ListNode(5);
//            l2.next = new ListNode(9);
//            l2.next.next = new ListNode(2);
//            ListNode rst = _solution.addTwoNumbers(l1, l2);

            ListNode l11 = new ListNode(3);
            l11.next = new ListNode(1);
            l11.next.next = new ListNode(5);
            ListNode l21 = new ListNode(5);
            l21.next = new ListNode(9);
            l21.next.next = new ListNode(2);
            ListNode rst1 = _solution.addTwoNumbers(l11, l21);

            ListNode ptr = rst1;
            while (ptr != null){
                System.out.println(ptr.val);
                ptr = ptr.next;
            }
        }
    }
}
