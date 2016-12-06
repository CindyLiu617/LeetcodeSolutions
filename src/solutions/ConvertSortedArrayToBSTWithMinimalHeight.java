package solutions;

import solutions.utils.TreeNode;

public class ConvertSortedArrayToBSTWithMinimalHeight {
    /**
     * @param : an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int size = A.length;
        return constructor(A, 0, size - 1);
    }
    private TreeNode constructor(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = constructor(num, start, mid-1);
        root.right = constructor(num, mid+1, end);
        return root;
    }
}
