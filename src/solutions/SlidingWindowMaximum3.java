package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum3 {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    //priority queue
    public ArrayList<Integer> maxSlidingWindow3(final int[] nums, int k) {
        // write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k <= 0) {
            return rst;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nums.length - k + 1,
                                                               new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (nums[o1] > nums[o2]) {
                    return -1;
                } else if (nums[o1] < nums[o2]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < nums.length; ++i) {
            //put index into queue
            pq.add(i);
            if (i < k - 1) {
                continue;
            }
            //invalid max number if indexOfMax < i - k + 1: out of range of
            // window
            int indexOfMax = pq.peek();
            while (!pq.isEmpty() && indexOfMax < i - k + 1) {
                pq.poll();
                indexOfMax = pq.peek();
            }
            rst.add(nums[indexOfMax]);
        }
        return rst;
    }

    static public class Test {
        static private SlidingWindowMaximum3 _solution = new
                SlidingWindowMaximum3();

        static public void randomTest() {
            int[] nums = {8, 2, 7, 7, 8};
            int k = 3;
            ArrayList<Integer> rst = _solution.maxSlidingWindow3(nums, k);
            for (int i : rst){
                System.out.print(i);
            }
        }
    }
}
