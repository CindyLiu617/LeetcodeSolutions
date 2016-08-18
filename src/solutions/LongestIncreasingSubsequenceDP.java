package solutions;

import java.util.Arrays;

/**
 * Created by James on 8/17/16.
 */
public class LongestIncreasingSubsequenceDP {
    //BAT Algorithms Class Nine
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int rst = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; ++i){
            for (int j = 0; j < i; ++j){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            rst = Math.max(rst, dp[i]);
        }
        return rst;
    }
    static public class Test {
        static private LongestIncreasingSubsequenceDP _solution = new
                LongestIncreasingSubsequenceDP();

        static public void randomTest() {
            int[] A = {1, 4, 6, 2, 8, 7};
            int rst1 = _solution.lengthOfLIS(A);
            System.out.println(rst1);
        }
    }
}
