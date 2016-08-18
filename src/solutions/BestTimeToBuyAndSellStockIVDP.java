package solutions;

/**
 * Created by James on 8/18/16.
 */
public class BestTimeToBuyAndSellStockIVDP {
    public int maxProfit(int k, int[] prices) {
        // write your code here
        //BAT Algorithms Class Nine
        if (k <= 0 || prices == null || prices.length < 2) {
            return 0;
        }
        //dp[j][i] represents the maximum profit when complete at most j
        // transactions and sell stock before day i
        int[][] dp = new int[k + 1][prices.length];

        for (int r = 1; r <= k; ++r) {
            for (int i = 1; i < prices.length; ++i) {
                //if not sell on day i
                dp[r][i] = dp[r][i - 1];
                for (int j = 0; j < i; ++j) {
                    //sell on day i, buy stock on day j.
                    dp[r][i] = Math.max(dp[r][i],
                            dp[r - 1][j] + prices[i] - prices[j]);
                }
            }
        }
        return dp[k][prices.length - 1];
    }

    static public class Test {
        static private BestTimeToBuyAndSellStockIVDP _solution =
                new BestTimeToBuyAndSellStockIVDP();

        static public void randomTest() {
            int[] A = {1,2,4,2,5,7,2,4,9,0};
            int rst1 = _solution.maxProfit(4, A);
            System.out.println(rst1);
        }
    }
}
