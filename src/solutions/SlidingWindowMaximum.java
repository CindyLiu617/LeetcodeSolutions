package solutions;

import com.sun.tools.javac.util.Assert;

import java.util.LinkedList;

/**
 * Created by James on 5/20/16.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums ==null || nums.length == 0 || nums.length - k < 0)
            return nums;
        int[] result = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; ++i){
            int data = nums[i];
            while (!queue.isEmpty() && queue.getLast() < data){
                queue.removeLast();
            }
            queue.add(data);
            if (i < k - 1)
                continue;
            result[i - k + 1] = queue.get(0);
            if (nums[i - k + 1] == result[i - k + 1])
                queue.removeFirst();
        }
        return result;
    }
    static public class Test {
        static private SlidingWindowMaximum _solution = new SlidingWindowMaximum();

        static public void randomTest() {
            int[] nums = {1,3,-1,-3,5,3,6,7};
            int k = 3;
            int[] rst = _solution.maxSlidingWindow(nums, k);
            for (int i : rst){
                System.out.print(i);
            }
        }
    }
}
