package solutions;

import solutions.utils.TreeNode;

public class CountCompleteTreeNodes {
    /*
    Given a complete binary tree, count the number of nodes.
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode ptr = root;
        int leftCount = 0, rightCount = 0;
        while (ptr != null) {
            ptr = ptr.left;
            ++leftCount;
        }
        ptr = root;
        while (ptr != null) {
            ptr = ptr.right;
            ++rightCount;
        }
        //(2 ^ h) - 1 = n
        if (leftCount == rightCount) {
            return (1 << leftCount) - 1;
        }
        //else recursion count all nodes and add all
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    static public class Test {
        static private CountCompleteTreeNodes _solution = new
                CountCompleteTreeNodes();

        static public void randomTest() {
            TreeNode root = new TreeNode(0);
            root.left = new TreeNode(1);
            root.right = new TreeNode(2);
            root.left.left = new TreeNode (3);
            root.left.right = new TreeNode (4);
            root.right.left = new TreeNode(5);
//            root.right.right = new TreeNode(6);
            System.out.println(_solution.countNodes(root));
            System.out.println(1 << 3);
        }
    }
}
