package solutions;

/**
 * Created by James on 8/16/16.
 */
public class BackPackIV {
    public int backPackIV(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0 || target <= 0)
            return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; ++i){
            for (int j = 1; j <= target; ++j){
                if (j == nums[i]){
                    ++dp[j];
                }
                if (j > nums[i]){
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
    static public class Test {
        static private BackPackIV _solution = new BackPackIV();

        static public void randomTest() {
            int[] A = {2, 3, 6, 7};
            int rst1 = _solution.backPackIV(A, 7);
            System.out.println(rst1);
        }
    }
}
