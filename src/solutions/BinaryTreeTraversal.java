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
        while (!stack.isEmpty()) {
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

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root !=null){
            preorderhelper(root, result);
        }
        return result;
    }

    public void preorderhelper(TreeNode p, List<Integer> result){
        result.add(p.value);
        if(p.left!=null)
            preorderhelper(p.left, result);
        if(p.right!=null)
            preorderhelper(p.right, result);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root !=null){
            inorderhelper(root, result);
        }
        return result;
    }

    public void inorderhelper(TreeNode p, List<Integer> result){
        if(p.left!=null)
            inorderhelper(p.left, result);
        result.add(p.value);
        if(p.right!=null)
            inorderhelper(p.right, result);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (true) {
            TreeNode ptr = stack.peek().left;
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            TreeNode prev = null;
            while (stack.peek().right == prev || stack.peek().right == null) {
                prev = stack.pop();
                rst.add(prev.value);
                if (stack.isEmpty()) {
                    return rst;
                }
            }
            stack.push(stack.peek().right);
        }
    }

    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        posthelper(root, res);
        return res;
    }
    private void posthelper(TreeNode root, ArrayList<Integer> res)
    {
        if(root == null)
            return;
        posthelper(root.left,res);
        posthelper(root.right,res);
        res.add(root.value);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    static public class Test {
        static private BinaryTreeTraversal _solution =
                new BinaryTreeTraversal();

        static public void randomTest() {
            TreeNode n1 = new TreeNode(1);
            n1.left = new TreeNode(2);
            n1.right = new TreeNode(3);
            n1.left.right = new TreeNode(6);
            n1.right.left = new TreeNode(4);
            n1.right.right = new TreeNode(5);
            List<Integer> rst = _solution.postorderTraversal(n1);
            for (int i = 0; i < rst.size(); ++i) {
                System.out.println(rst.get(i));
            }
        }
    }
}
