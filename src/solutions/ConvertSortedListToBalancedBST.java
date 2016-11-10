package solutions;

import solutions.utils.ListNode;
import solutions.utils.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertSortedListToBalancedBST {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        //copy list value and save them in array
        int size = _listSize(head, 0);
        int[] myArray = new int[size];
        ListNode ptr = head;
        for (int i = 0 ; i < size; ++i){
            myArray[i] = ptr.val;
            ptr = ptr.next;
        }
        return _constructor(myArray);
    }

    private TreeNode _constructor(int[] myArray) {
        //the value of middle position in array is the root value
        int size = myArray.length;
        if (size == 0)
            return null;
        else if (size == 1)
            return new TreeNode(myArray[0]);
        TreeNode root = new TreeNode(myArray[size/2]);
        root.left = _constructor(Arrays.copyOfRange(myArray, 0, size/2));
        root.right = _constructor(Arrays.copyOfRange(myArray, size/2 + 1,
                                                     size));
        return root;
    }

    public int _listSize(ListNode head, int size){
        if (head == null)
            return 0;
        for (ListNode i = head; i != null; i = i.next){
            ++size;
        }
        return size;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> rst = new ArrayList<String>();
        if (root == null){
            return rst;
        }
        helper(root, rst, "");
        return rst;
    }

    private void helper (TreeNode root, List<String> rst, String path) {
        //string is parse by value, which supports operation remove
        //can not use stringbuilder, since it is not support remove operation
        path += root.value;
        if (root.left == null && root.right == null) {
            rst.add(path);
            return;
        }
        if (root.left != null) {
            helper(root.left, rst, path + "->");
        }
        if (root.right != null){
            helper(root.right, rst, path + "->");
        }
    }

    static public class Test {
        static private ConvertSortedListToBalancedBST _solution = new ConvertSortedListToBalancedBST();

        static public void randomTest() {
            ListNode n1 = new ListNode(1);
            n1.next = new ListNode(2);
            n1.next.next = new ListNode(3);
            n1.next.next.next = new ListNode(4);
            TreeNode head = _solution.sortedListToBST(n1);
            List<String> printTree = _solution.binaryTreePaths(head);
            for (int i = 0; i < printTree.size(); ++i) {
                System.out.println(printTree.get(i));
            }
        }
    }
}
