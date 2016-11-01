package solutions;

import solutions.utils.TreeNode;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTreeIterator implements Iterator<TreeNode> {
    private TreeNode ptr;
    private Stack<TreeNode> stack;
    private TraverseOrder ord;

    public BinaryTreeIterator(TreeNode root, TraverseOrder ord) {
        this.stack = new Stack<TreeNode>();
        this.ord = ord;
        switch (ord) {
            case IN_ORDER:
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                break;
            case PRE_ORDER:
                stack.push(root);
                break;
            case POST_ORDER:
                while (root != null) {
                    stack.push(root);
                    if (root.left != null) {
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

    @Override
    public TreeNode next() {
        switch (ord) {
            case IN_ORDER:
                return inOrderNext();
            case PRE_ORDER:
                return preOrderNext();
            case POST_ORDER:
                return postOrderNext();
            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public void remove() {
        throw new NotImplementedException();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private TreeNode inOrderNext() {
        try {
            ptr = stack.pop();
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
        TreeNode nxt = ptr;
        ptr = ptr.right;
        while (ptr != null) {
            stack.push(ptr);
            ptr = ptr.left;
        }
        return nxt;
    }

    private TreeNode preOrderNext() {
        try {
            ptr = stack.pop();
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
        TreeNode nxt = ptr;
        if (ptr.right != null) {
            stack.push(ptr.right);
        }
        if (ptr.left != null) {
            stack.push(ptr.left);
        }
        return nxt;
    }

    private TreeNode postOrderNext() {
        try {
            ptr = stack.pop();
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
        if (!stack.isEmpty()) { // check stack after pop out peek element
            TreeNode peek = stack.peek();
            if (ptr == peek.left) {
                postOrderHelper(peek.right);
            }
        }
        return ptr;
    }

    private void postOrderHelper(TreeNode cur) {
        while (cur != null) {
            stack.push(cur);
            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    public enum TraverseOrder {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER
    }

    static public class Test {

        static public void randomTest(TraverseOrder order) {

            TreeNode n1 = new TreeNode(1);
            n1.left = new TreeNode(2);
            n1.right = new TreeNode(3);
            n1.left.left = new TreeNode(4);
            n1.left.right = new TreeNode(5);
            BinaryTreeIterator _solution = new BinaryTreeIterator(n1, order);

            while (_solution.hasNext()) {
                System.out.print(
                        Integer.toString(_solution.next().value) + " ");
            }
            System.out.println();
        }
    }
}

