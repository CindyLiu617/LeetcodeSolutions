package solutions;

import com.sun.tools.javac.util.Assert;
import solutions.utils.TreeNode;

/**
 * Created by James on 3/29/16.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if (root.left == null && root.right == null)
            return  sum == root.value;
        return hasPathSum(root.left, sum - root.value) || hasPathSum(root.right, sum - root.value);
    }

    static public class Test {
        static private PathSum _solution = new PathSum();

        static public void test(TreeNode A, boolean ans, int sum) {
            Assert.check(ans == (_solution.hasPathSum(A, sum)));
        }

        static public void randomTest() {
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.right = new TreeNode(8);
            root.left.left = new TreeNode(11);
            root.right.right = new TreeNode(4);
            root.right.left = new TreeNode(13);
            root.right.right.right = new TreeNode(1);
            root.left.left.right = new TreeNode(2);
            root.right.right.left = new TreeNode(7);
            test(root, true, 22);
        }
    }
}
