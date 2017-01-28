package solutions;

public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }

    static public class Test {
        static private PredictTheWinner _solution = new PredictTheWinner();

        static public void randomTest() {
            int[] nums = {1, 5, 2};
            System.out.println(_solution.PredictTheWinner(nums));
        }
    }
}
