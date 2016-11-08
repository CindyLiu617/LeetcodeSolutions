package solutions;
import solutions.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 11/6/16.
 */
public class SlidingWindowMaximum2 {
    //BST
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return rst;
        }
        TreeNode root = new TreeNode (Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; ++i) {
            _insert(root, nums[i]);
            if (i < k - 1) {
                continue;
            }

            rst.add(_max(root));
            //delete first value node, move window to right
            root = _delete(root, nums[i - k + 1]);
            if (i >= 36) {
                _binaryTreePaths(root);
            }
            System.out.println(">>>>>>>>");
        }
        return rst;
    }


    private void _insert(TreeNode root, int value) {
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            if (value < cur.value) {
                pre = cur;
                cur = cur.left;
            } else if (value >= cur.value) {
                pre = cur;
                cur = cur.right;
            } else { // fail
                return;
            }
        }
        //find position
        TreeNode insertNode = new TreeNode(value);
        if (pre != null) {
            if (value >= pre.value) {
                pre.right = insertNode;
            } else {
                pre.left = insertNode;
            }
        } else {
            root = cur;
        }
        insertNode.left = null;
        insertNode.right = null;
    }

    //delete node reference: http://blog.csdn.net/dc_726/article/details/7391869
    //return new root node
    private TreeNode _delete (TreeNode root, int value) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;

        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.value == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.value == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }

        _deleteNode(parent, node);

        return dummy.left;
    }

    //return target node's parent node
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        }

        if (node.value == value) {
            return parent;
        }
        if (value < node.value) {
            return findNode(node, node.left, value);
        } else {
            return findNode(node, node.right, value);
        }
    }


    private void _deleteNode(TreeNode parent, TreeNode node) {
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode temp = node.right;
            TreeNode father = node;

            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }

            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }

            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }

            temp.left = node.left;
            temp.right = node.right;
        }
    }

    private int _max(TreeNode root) {
        if (root == null ) {
            return Integer.MIN_VALUE;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.value;
    }

    public List<String> _binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> rst = new ArrayList<String>();
        if (root == null){
            return rst;
        }
        _helper(root, rst, "");
        return rst;
    }

    private void _helper(TreeNode root, List<String> rst, String path) {
        //string is parse by value, which supports operation remove
        //can not use stringbuilder, since it is not support remove operation
        path += root.value;
        if (root.left == null && root.right == null) {
            rst.add(path);
            return;
        }
        if (root.left != null) {
            _helper(root.left, rst, path + "->");
        }
        if (root.right != null){
            _helper(root.right, rst, path + "->");
        }
    }

    static public class Test {
            static private SlidingWindowMaximum2 _solution = new SlidingWindowMaximum2();

            static public void randomTest() {
                int[] array = {1577,330,1775,206,296,356,219,999,790,1435,1218};
                System.out.println(array.length);
                ArrayList<Integer> rst = _solution.maxSlidingWindow(array, 8);
                System.out.println(rst);
            }
        }
}
