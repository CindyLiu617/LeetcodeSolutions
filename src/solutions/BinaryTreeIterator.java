package solutions;
import solutions.utils.TreeNode;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Created by James on 10/27/16.
 */
public class BinaryTreeIterator {
    public enum TraverseOrder {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER
    }
    private TraverseOrder ord = TraverseOrder.IN_ORDER;
    private TreeNode ptr;
    private Stack<TreeNode> stack;

    public BinaryTreeIterator(TreeNode root, TraverseOrder ord){
        stack = new Stack<TreeNode>();
        switch (ord){
            case IN_ORDER:
                while (root != null){
                    stack.push(root);
                    root = root.left;
                }
                break;
            case PRE_ORDER:
                stack.push(root);
                break;
            case POST_ORDER:
                while (root != null){
                    stack.push(root);
                    if (root.left != null){
                        root = root.left;
                    } else {
                        root = root.right;
                    }
                }
                break;
            default:
                break;
        }
    }

    public Integer next(TraverseOrder ord){
        switch (ord){
            case IN_ORDER:
                return inOrderIterator().value;
            case PRE_ORDER:
                return preOrderIterator().value;
            case POST_ORDER:
                return postOrderIterator().value;
            default:
               throw new IllegalStateException();
        }
    }

    public boolean hasNext()
    {
        return !stack.isEmpty();
    }

    private TreeNode inOrderIterator(){
        ptr = stack.pop();
        TreeNode nxt = ptr;
        if (ptr.right != null) {
            ptr = ptr.right;
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
        }
        if (nxt != null) //?? how to write
            return nxt;
        throw new NoSuchElementException();
    }

    private TreeNode preOrderIterator(){
        ptr = stack.pop();
        TreeNode nxt = ptr;
        if (ptr.right != null){
            stack.push(ptr.right);
        }
        if (ptr.left != null){
            stack.push(ptr.left);
        }
        if (nxt != null){ //how to write
            return nxt;
        }
        throw new NoSuchElementException();
    }

    private TreeNode postOrderIterator(){
        ptr = stack.pop();
        if (!stack.isEmpty()){ // check stack after pop out peek element
            TreeNode peek = stack.peek();
            if (ptr == peek.left){
                postOrderHelper(peek.right);
            }
        }
        if (ptr != null){
            return ptr;
        }
        throw new NoSuchElementException();
    }

    private void postOrderHelper(TreeNode cur){
        while (cur != null) {
            stack.push(cur);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(3);
        n1.left.left = new TreeNode(4);
        n1.left.right = new TreeNode(5);
        BinaryTreeIterator test = new BinaryTreeIterator(n1, TraverseOrder
                .POST_ORDER);

        while (test.hasNext()){
            System.out.println(test.next(TraverseOrder.POST_ORDER));
        }
    }
}

