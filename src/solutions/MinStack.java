package solutions;

import javafx.scene.input.Mnemonic;
import solutions.utils.TreeNode;

import java.util.Stack;

/**
 * Created by James on 11/3/16.
 */
public class MinStack {
    //use minRecord to record the minimum num each in every state.
    Stack<Integer> minStack;
    Stack<Integer> minRecord;
    public MinStack() {
        // do initialize if necessary
        minRecord = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        minStack.push(number);
        if (minRecord.isEmpty()){
            minRecord.push(number);
        } else{
            minRecord.push(Math.min(minRecord.peek(), number));
        }
    }

    public int pop() {
        // write your code here
        minRecord.pop();
       return minStack.pop();
    }

    public int min() {
        // write your code here
        return minRecord.peek();
    }

    static public class Test {

        static public void randomTest() {
            MinStack ms = new MinStack();
            ms.push(1);
            System.out.println(ms.pop());
            ms.push(2);
            ms.push(3);
            System.out.println(ms.min());
            ms.push(1);
            System.out.println(ms.min());
        }
    }
}

