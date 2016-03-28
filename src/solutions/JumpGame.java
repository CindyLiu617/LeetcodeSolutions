package solutions;

import com.sun.tools.javac.util.Assert;

/**
 * Created by James on 3/26/16.
 */
public class JumpGame {
    //DP
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0)
            return false;
        boolean[] canReach = new boolean[A.length];
        canReach[0] = true;
        for (int i = 1; i < A.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (canReach[i - 1] && j + A[i - 1] >= i)
                    canReach[i] = true;
            }
        }
        return canReach[A.length - 1];
    }

    //greedy
    public boolean canJumpGreedy(int[] nums){
        if(nums == null || nums.length == 0)
            return false;
        int rangeStart = 0, rangeEnd = 0;
        while (rangeEnd < nums.length && rangeStart <= rangeEnd){
            int farthest = rangeEnd;
            for(int i = rangeStart; i <= rangeEnd; ++i){
                if(nums[i] + i > farthest){
                    farthest = nums[i] + i;
                }
            }
            rangeStart = rangeEnd + 1;
            rangeEnd = farthest;
        }
        return rangeEnd >=  nums.length - 1;
    }

    static public class Test {
        static private JumpGame _solution = new JumpGame();

        static public void test(int[] A, boolean ans) {
            Assert.check(ans == _solution.canJumpGreedy(A));
        }

        static public void randomTest() {
            int[] A = {2, 3, 1, 1, 4};
            test(A, true);

            int[] B = {3, 2, 1, 0, 4};
            test(B, false);
        }
    }
}
