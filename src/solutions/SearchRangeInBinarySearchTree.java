package solutions;

import solutions.utils.TreeNode;
import java.util.ArrayList;
import java.util.Collections;

public class SearchRangeInBinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Collections.sort(helper(root, k1, k2, rst));
        return rst;
    }

    private ArrayList<Integer> helper(TreeNode root, int small, int large,
                                      ArrayList<Integer> rst) {
        if (root == null) {
            return rst;
        }
        if (small <= root.value && root.value <= large) {
            rst.add(root.value);
            helper(root.left, small, large, rst);
            helper(root.right, small, large, rst);
        } else if (root.value <= small) {
            helper(root.right, small, large, rst);
        } else {
            helper(root.left, small, large, rst);
        }
        return rst;
    }

    static public class Test {
        static private SearchRangeInBinarySearchTree _solution = new SearchRangeInBinarySearchTree();

        static public void randomTest() {
//            TreeNode n1 = new TreeNode(20);
//            n1.left = new TreeNode(8);
//            n1.left.left = new TreeNode(4);
//            n1.right = new TreeNode(22);
//            n1.left.right = new TreeNode(12);
//            ArrayList<Integer> rst = _solution.searchRange(n1, 10, 22);
//            for (int i = 0; i < rst.size(); ++i) {
//                System.out.println(rst.get(i));
//            }

            TreeNode n11 = new TreeNode(20);
            n11.left = new TreeNode(8);
            n11.left.left = new TreeNode(4);
            n11.right = new TreeNode(22);
            n11.left.right = new TreeNode(12);
            n11.right.left = new TreeNode(21);
            n11.right.right = new TreeNode(25);
            ArrayList<Integer> rst = _solution.searchRange(n11, 10, 22);
            for (int i = 0; i < rst.size(); ++i) {
                System.out.println(rst.get(i));
            }
        }
    }
}
