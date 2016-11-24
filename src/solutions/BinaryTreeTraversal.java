package solutions;

import solutions.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode ptr = root;
        while (ptr != null) {
            rst.add(ptr.value);
            stack.add(ptr);
            ptr = ptr.left;
        }
        while (!stack.isEmpty()){
            ptr = stack.pop();
            ptr = ptr.right;
            while (ptr != null) {
                rst.add(ptr.value);
                stack.add(ptr);
                ptr = ptr.left;
            }
        }
        return rst;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode ptr = root;
        while (ptr != null) {
            stack.add(ptr);
            ptr = ptr.left;
        }
        while (!stack.isEmpty()) {
            ptr = stack.pop();
            rst.add(ptr.value);
            ptr = ptr.right;
            while (ptr != null) {
                stack.add(ptr);
                ptr = ptr.left;
            }
        }
        return rst;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> reverseRst = new Stack<Integer>();
        TreeNode ptr = root;
        while (ptr != null) {
            reverseRst.add(ptr.value);
            stack.add(ptr);
            ptr = ptr.right;
        }
        while (!stack.isEmpty()){
            ptr = stack.pop();
            ptr = ptr.left;
            while (ptr != null) {
                reverseRst.add(ptr.value);
                stack.add(ptr);
                ptr = ptr.right;
            }
        }
        while (!reverseRst.isEmpty()){
            rst.add(reverseRst.pop());
        }
        return rst;
    }
}
