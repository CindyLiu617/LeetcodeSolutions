package solutions;

import solutions.utils.TreeNode;

public class Subtree {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T2 == null) {
            return true;
        }
        if (T1 == null) {
            return false;
        }
        if (helper(T1, T2)) {
            return true;
        } else if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2)) {
            return true;
        }
        return false;
    }

    private boolean helper(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (t1.value != t2.value) {
            return false;
        }
        return helper(t1.left, t2.left) && helper(t1.right, t2.right);
    }
    static public class Test {
        static private Subtree _solution = new Subtree();

        static public void randomTest() {
            TreeNode n1 =  new TreeNode(1);
            n1.left = new TreeNode(2);
            TreeNode n2 = new TreeNode(1);
            n2.left = new TreeNode(2);
            System.out.println(_solution.isSubtree(n1, n2));
        }
    }
}
