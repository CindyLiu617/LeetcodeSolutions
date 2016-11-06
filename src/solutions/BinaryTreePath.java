package solutions;

import solutions.utils.ListNode;
import solutions.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Example
 Given the following binary tree:

   1
 /   \
 2   3
 \
 5
 All root-to-leaf paths are:

 [
 "1->2->5",
 "1->3"
 ]
 */
public class BinaryTreePath {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> rst = new ArrayList<String>();
        if (root == null){
            return rst;
        }
        helper(root, rst, "");
        return rst;
    }

    private void helper (TreeNode root, List<String> rst, String path) {
        //string is parse by value, which supports operation remove
        //can not use stringbuilder, since it is not support remove operation
        path += root.value;
        if (root.left == null && root.right == null) {
           rst.add(path);
           return;
        }
        if (root.left != null) {
            helper(root.left, rst, path + "->");
        }
        if (root.right != null){
            helper(root.right, rst, path + "->");
        }
    }

    static public class Test {
        static private BinaryTreePath _solution = new BinaryTreePath();

        static public void randomTest() {
            TreeNode n1 = new TreeNode(1);
            n1.left = new TreeNode(2);
            n1.right = new TreeNode(3);
            n1.left.right = new TreeNode(5);
            List<String> rst = _solution.binaryTreePaths(n1);
            for (int i = 0; i < rst.size(); ++i){
                System.out.println(rst.get(i));
            }
        }
    }
}
