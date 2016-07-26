package solutions;



import java.util.Arrays;
import java.util.Stack;

/**
 * Created by James on 4/26/16.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights){
        if (heights == null || heights.length == 0)
                return 0;
        Stack<Integer> myStack = new Stack<Integer>();
        int curHighestIndex, maxArea = 0, i = 0;
        int[] helperArray = Arrays.copyOf(heights, heights.length + 1);
        while (i < helperArray.length){
            if (myStack.isEmpty() || helperArray[i] >= helperArray[myStack.peek()]){
                myStack.push(i);
                ++i;
            }
            else {
                curHighestIndex = myStack.peek();
                myStack.pop();
                if (!myStack.isEmpty())
                    maxArea = Math.max(helperArray[curHighestIndex] * (i - myStack.peek() - 1), maxArea);
//                BE CAREFUL!!
                else
                    maxArea = Math.max(helperArray[curHighestIndex] * i, maxArea);
            }
        }
        return maxArea;
    }
    static public class Test {
        static private LargestRectangleInHistogram _solution = new LargestRectangleInHistogram();

        static public void test(int[] s, int ans) {
            assert ans == (_solution.largestRectangleArea(s));
        }

        static public void randomTest() {
//            int[] array1 = {2,1,5,6,2,3};
//            test(array1, 10);
//
//            int[] array2 = {1};
//            test(array2, 1);
//
//            int[] array3 = {1,1};
//            test(array3, 2);
//
//            int[] array4 = {2,1,2};
//            test(array4, 3);
//
            int[] array5 = {4,2,0,3,2,5};
            test(array5, 6);
        }
    }
}
