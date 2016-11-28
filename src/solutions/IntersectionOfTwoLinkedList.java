package solutions;

import solutions.utils.ListNode;

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptrA = headA, ptrB = headB;
        int lenA = 0, lenB = 0;
        //calculate length
        while (ptrA != null){
            ++lenA;
            ptrA = ptrA.next;
        }
        while (ptrB != null){
            ++lenB;
            ptrB = ptrB.next;
        }
        if (lenA <= lenB){
            int dif = lenB - lenA;
            //reset ptr position
            ptrA = headA;
            ptrB = headB;
            while (dif > 0){
                ptrB = ptrB.next;
                --dif;
            }
        }
        else {
            int dif = lenA - lenB;
            //reset ptr position
            ptrA = headA;
            ptrB = headB;
            while (dif > 0){
                ptrA = ptrA.next;
                --dif;
            }
        }
        while (ptrA != null && ptrA.val != ptrB.val){
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        if (ptrA == null)
            return null;
        return ptrA;
    }
}
