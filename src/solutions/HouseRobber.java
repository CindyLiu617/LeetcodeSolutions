package solutions;

import solutions.utils.TreeNode;

public class HouseRobber {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1)
            return A[0];
        //maximum amount of money till i'th house
        long[] maxToPos = new long[A.length];
        maxToPos[0] = A[0];
        maxToPos[1] = Math.max(A[1], A[0]);
        for (int i = 2; i <= maxToPos.length-1; ++i){
            maxToPos[i] = Math.max(maxToPos[i - 1], maxToPos[i - 2] + A[i]);
        }
        return maxToPos[maxToPos.length - 1];
    }

    static public class Test {
        static private HouseRobber _solution = new
                HouseRobber();

        static public void randomTest() {
            int[] A = {3, 8, 4};
            long rst = _solution.houseRobber(A);
            System.out.println(rst);
        }
    }
}
