package solutions;

import com.sun.tools.javac.util.Assert;
import solutions.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 3/30/16.
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generator(1, n);
    }
    private ArrayList<TreeNode> generator(int left, int right){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (left > right){
            result.add(null);
            return result;
        }
        //pick up number as root in order
        for (int i = left; i <= right; ++i){
            //create left subtree and right subtree of selected root
            ArrayList<TreeNode> leftList = generator(left, i - 1);
            ArrayList<TreeNode> rightList = generator(i + 1, right);
            //create tree
            for (TreeNode aLeftList : leftList) {
                for (TreeNode aRightList : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = aLeftList;
                    root.right = aRightList;
                    result.add(root);
                }
            }
        }
        return result;
    }
    static public class Test {
        static private UniqueBinarySearchTrees _solution = new UniqueBinarySearchTrees();

        static public void test(int A, int ans) {
            Assert.check(ans == _solution.numTrees(A));
        }

        static public void randomTest() {
            test(3, 5);
            test(1, 1);
        }
    }
}
