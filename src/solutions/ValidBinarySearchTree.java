package solutions;

import apple.laf.JRSUIUtils;
import solutions.utils.TreeNode;

import java.util.ArrayList;

/**
 * Created by James on 11/6/16.
 */
public class ValidBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        // Double.NEGATIVE_INFINITY is -infinity and Double.POSITIVE_INFINITY
        // is infinity, if I use Integer.MAX_VALUE or INTEGER.MIN_VALUE then
        // root.vale <= min || root.value >= max is true when root.vale is
        // Integer.MAX_value or Integer.MIN_VALUE
        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    //helper return true is root.val is in the right range (min ~ max)which
    //is legal for bst
    private boolean helper(TreeNode root, double min, double max) {
        if (root.value <= min || root.value >= max){
            return false;
        }

        if (root.left != null && !helper(root.left, min, root.value)) {
            return false;
        }
        if (root.right != null && !helper(root.right, root.value, max)) {
            return false;
        }
        return true;
    }

    static public class Test {
        static private ValidBinarySearchTree _solution = new ValidBinarySearchTree();

        static public void randomTest() {
//            TreeNode n1 = new TreeNode(2);
//            n1.left = new TreeNode(1);
//            n1.right = new TreeNode(4);
//            n1.right.left = new TreeNode(3);
//            n1.right.right = new TreeNode(5);
//            System.out.println(_solution.isValidBST(n1));

            TreeNode n11 = new TreeNode(2147483647);
            System.out.println(Double.NEGATIVE_INFINITY);
            System.out.println(_solution.isValidBST(n11));
        }
    }
}
