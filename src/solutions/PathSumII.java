package solutions;


import solutions.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by James on 3/29/16.
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null)
            return rst;
        List<Integer> path = new ArrayList<Integer>();
        constructor(sum, path, root, rst);
        return rst;
    }

    private void constructor(int sum, List<Integer> path, TreeNode root, List<List<Integer>> rst) {
        if (root == null)
            return;
        path.add(root.value);
        //if reach leaf and sum == root.val, add path into result
        if (sum == root.value && root.left == null && root.right == null)
            rst.add(new ArrayList<Integer>(path));

        constructor(sum - root.value, path, root.left, rst);
        constructor(sum - root.value, path, root.right, rst);
        path.remove(path.size() - 1);
    }

    static public class Test {
        static private PathSumII _solution = new PathSumII();

        static public void test(TreeNode A, int sum, List<List<Integer>> ans) {
            assert ans == (_solution.pathSum(A, sum));
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
            test(root, 22, new ArrayList<List<Integer>>(Collections.singletonList(Arrays.asList(5, 4, 11, 2))));
        }
    }
}
