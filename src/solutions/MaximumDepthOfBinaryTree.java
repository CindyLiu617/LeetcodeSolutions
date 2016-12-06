package solutions;

import solutions.utils.TreeNode;

import java.util.ArrayList;

public class MaximumDepthOfBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
         if (root == null) {
             return 0;
         }
         return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    static public class Test {
        static private MaximumDepthOfBinaryTree _solution = new MaximumDepthOfBinaryTree();

        static public void randomTest() {
            TreeNode n1 = new TreeNode(1);
            n1.left = new TreeNode(2);
            n1.right = new TreeNode(3);
            n1.right.left = new TreeNode(4);
            n1.right.right = new TreeNode(5);
            int rst = _solution.maxDepth(n1);
            System.out.println(rst);
        }
    }
}
