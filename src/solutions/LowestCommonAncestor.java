package solutions;

import solutions.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode LCAofBST(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }
        if (A.value < root.value && B.value < root.value) {
            return LCAofBST(root.left, A, B);
        } else if (A.value > root.value && B.value > root.value) {
            return LCAofBST(root.right, A, B);
        }
        else {
            return root;
        }
    }

    public TreeNode LCAofBT(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        List<TreeNode> path1 = new ArrayList<TreeNode>();
        List<TreeNode> path2 = new ArrayList<TreeNode>();
        BFSgetPath(root, p, path1);
        BFSgetPath(root, q, path2);

        int size1 = path1.size();
        int size2 = path2.size();
        int minLen = size1 < size2 ? size1: size2;
        int k = 0;
        for (int i = 0; i < minLen; ++i){
            if (path1.get(i) != path2.get(i)){
                break;
            }
            ++k;
        }
        return path1.get(k - 1);
    }

    private boolean BFSgetPath(TreeNode root, TreeNode target, List<TreeNode> path){
        if (root == target){
            path.add(root);
            return true;
        }
        if(root != null){
            path.add(root);
            if (BFSgetPath(root.left, target, path) || BFSgetPath(root.right, target, path))
                return true;
            path.remove(path.size() - 1);
        }
        return false;
    }

    static public class Test {
        static private LowestCommonAncestor _solution =
                new LowestCommonAncestor();

        static public void randomTest() {
            TreeNode n1 = new TreeNode(1);
            TreeNode n2 = new TreeNode(2);
            n1.left = n2;
            n1.right = new TreeNode(3);
            n1.left.right = new TreeNode(6);
            TreeNode n4 = new TreeNode(4);
            n1.right.left = n4;
            n1.right.right = new TreeNode(5);
            TreeNode rst = _solution.LCAofBT(n1, n2, n4);
            System.out.println(rst.value);
        }
    }
}
