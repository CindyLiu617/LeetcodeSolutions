package solutions;

/**
 * Created by James on 8/18/16.
 */
public class BestTimeToBuyAndSellStockIVDP2 {
    public int maxProfit(int k, int[] prices) {
        // write your code here
        //BAT Algorithms Class Nine
        if (k <= 0 || prices == null || prices.length < 2) {
            return 0;
        }
        //dp[j][i] represents the maximum profit when complete at most j
        // transactions and sell stock before day i
        int[][] dp = new int[k + 1][prices.length];
        int max;
        for (int r = 1; r <= k; ++r) {
            max = dp[r - 1][0] - prices[0];
            for (int i = 1; i < prices.length; ++i) {
                //Optimize: since price[i] is known, we can extract out
                // of max function. Besides, we can calculate dp[r-1][j]
                // - prices[j] in advance which can save time.
                //sell on day i, buy stock on day j.
                dp[r][i] = Math.max(dp[r][i - 1], max + prices[i]);
                max = Math.max(max, dp[r - 1][i] - prices[i]);
                }
            }
        return dp[k][prices.length - 1];
    }
    static public class Test {
        static private BestTimeToBuyAndSellStockIVDP2 _solution =
                new BestTimeToBuyAndSellStockIVDP2();

        static public void randomTest() {
            int[] A = {0,3,8,6,8,6,6,8,2,0,2,7};
            int rst1 = _solution.maxProfit(5, A);
            System.out.println(rst1);
        }
    }
}
