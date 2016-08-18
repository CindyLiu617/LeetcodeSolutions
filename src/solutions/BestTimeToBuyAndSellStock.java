package solutions;

/**
 * Created by James on 8/17/16.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int rst = 0;
        // write your code here
        if (prices == null || prices.length == 0)
            return rst;
        int max, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i){
            for (int j = 0; j < i; ++j){
                if (prices[j] < min){
                    min = prices[j];
                }
            }
            max = prices[i] - min;
            if (max > rst){
                rst = max;
            }
        }
        return rst;
    }
    static public class Test {
        static private BestTimeToBuyAndSellStock _solution = new BestTimeToBuyAndSellStock();

        static public void randomTest() {
            int[] A = {3, 2, 3, 1, 2};
            int rst1 = _solution.maxProfit(A);
            System.out.println(rst1);
        }
    }
}
