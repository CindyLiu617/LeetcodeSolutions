package solutions;

/**
 * Created by James on 8/18/16.
 */
public class BestTimeToBuyAndSellStockDP {
    public int maxProfit(int[] prices) {
        // write your code here
        int rst = 0;
        if (prices == null || prices.length < 2)
            return rst;
        int[] dp = new int[prices.length + 1];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i <= prices.length; ++i){
            if (prices[i - 1] - min > dp[i - 1]){
              dp[i] = prices[i - 1] - min;
            }
            else {
                dp[i] = dp[i - 1];
            }
            min = Math.min(min, prices[i - 1]);
        }
        return dp[prices.length];
    }
    static public class Test {
        static private BestTimeToBuyAndSellStockDP _solution = new
                BestTimeToBuyAndSellStockDP();

        static public void randomTest() {
            int[] A = {1, 2};
            int rst1 = _solution.maxProfit(A);
            System.out.println(rst1);
        }
    }
}
