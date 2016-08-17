package solutions.utils;

/**
 * Created by James on 8/16/16.
 */
public class BackPackV {
    public int backPackV(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0 || target <= 0)
            return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; ++i){
            for (int j = target; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
    static public class Test {
        static private BackPackV _solution = new BackPackV();

        static public void randomTest() {
            int[] A = {1,2,3, 3, 7};
            int rst1 = _solution.backPackV(A, 7);
            System.out.println(rst1);
        }
    }
}
