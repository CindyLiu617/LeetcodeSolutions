package solutions;

import com.sun.tools.javac.util.Assert;

/**
 * Created by James on 3/27/16.
 */
public class JumpGameII {
    //greedy
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        int steps = 0, rangeStart = 0, rangeEnd = 0;
        while (rangeEnd < nums.length - 1){
            ++steps;
            int farthest = rangeEnd;
            for(int i = rangeStart; i <= rangeEnd; ++i){
                if(nums[i] + i > farthest){
                    farthest = nums[i] + i;
                }
            }
            rangeStart = rangeEnd + 1;
            rangeEnd = farthest;
        }
        return steps;
    }
    static public class Test {
        static private JumpGameII _solution = new JumpGameII();

        static public void test(int[] A, int ans) {
            Assert.check(ans == _solution.jump(A));
        }

        static public void randomTest() {
//            int[] A = {2, 3, 1, 1, 4};
//            test(A, 2);

            int[] B = {3, 2, 1, 0, 4};
            test(B, -1);

            int[] C = {0};
            test(C, 0);
        }
    }
}
