package solutions;

import solutions.utils.TreeNode;

public class BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        return helper(root) > 0;
    }


    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        if (leftHeight < 0 || rightHeight < 0 ||Math.abs(leftHeight -
                                                               rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
