package solutions;

/**
 * Created by James on 8/16/16.
 */
public class BackpackVI {
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0 || target <= 0)
            return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; ++j){
            for (int i = 0; i < nums.length; ++i){
                if (j >= nums[i]){
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
    static public class Test {
        static private BackpackVI _solution = new BackpackVI();

        static public void randomTest() {
            int[] A = {1,2,4};
            int rst1 = _solution.backPackVI(A, 4);
            System.out.println(rst1);
        }
    }
}
