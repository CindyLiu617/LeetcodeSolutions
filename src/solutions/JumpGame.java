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

    static public class Test {
        static private JumpGame _solution = new JumpGame();

        static public void test(int[] A, boolean ans) {
            Assert.check(ans == _solution.canJump(A));
        }

        static public void randomTest() {
            int[] A = {2, 3, 1, 1, 4};
            test(A, true);

            int[] B = {3, 2, 1, 0, 4};
            test(B, false);
        }
    }
}
