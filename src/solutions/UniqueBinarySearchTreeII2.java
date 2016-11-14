package solutions;

import solutions.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII2 {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        List<TreeNode> rst = new ArrayList<TreeNode>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int left, int right) {
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();

        if (left > right) {
            rst.add(null);
            return rst;
        }
        //pick root
        for (int i = left; i <= right; ++i) {
            List<TreeNode> leftSubTree = helper(left, i - 1);
            List<TreeNode> rightSubTree = helper(i + 1, right);
            //construct tree
            for (int j = 0; j < leftSubTree.size(); ++j) {
                for (int k = 0; k < rightSubTree.size(); ++k) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubTree.get(j);
                    root.right = rightSubTree.get(k);
                    rst.add(root);
                }
            }
        }
        return rst;
    }

    static public class Test {
        static private UniqueBinarySearchTreeII2 _solution = new
                UniqueBinarySearchTreeII2();

        static public void randomTest() {
           _solution.generateTrees(1);
        }
    }
}
