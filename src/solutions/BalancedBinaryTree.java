package solutions;

import solutions.utils.TreeNode;

public class BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return root == null || getHeight(root) > 0;
    }

    private int getHeight (TreeNode root) {
        //bottom return
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left), rightHeight = getHeight(root.right);
        //leftheight == -1, rightheight == -1 is the result returned from
        // previous loop
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight -
                                                               rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static public class Test {
        static private BalancedBinaryTree _solution = new BalancedBinaryTree();

        static public void randomTest() {
//            TreeNode n1 = new TreeNode(3);
//            n1.left = new TreeNode(9);
//            n1.right = new TreeNode(20);
//            n1.right.left = new TreeNode(15);
//            n1.right.right = new TreeNode(7);
//            boolean rst = _solution.isBalanced(n1);
//            System.out.println(rst);
//
//            TreeNode n11 = new TreeNode(3);
//            n11.right = new TreeNode(20);
//            n11.right.left = new TreeNode(15);
//            n11.right.right = new TreeNode(7);
//            boolean rst1 = _solution.isBalanced(n11);
//            System.out.println(rst1);

            TreeNode n12 = new TreeNode(1);
            n12.left = new TreeNode(2);
            n12.left.right= new TreeNode(3);
            n12.left.right.left = new TreeNode(4);
            boolean rst2 = _solution.isBalanced(n12);
            System.out.println(rst2);
        }
    }

}
