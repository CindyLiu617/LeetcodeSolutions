package solutions;

/**
 * Created by James on 8/4/16.
 */
public class BackPackDP {
    public int backPack(int bagSize, int[] items) {
        if (items == null || items.length == 0 || bagSize <= 0)
            return 0;
        int[] dp = new int[bagSize + 1];
        for (int j = 0; j < items.length; ++j){
            for (int i = bagSize; i >= items[j]; --i){
                dp[i] = Math.max(dp[i], dp[i - items[j]] + items[j]);
            }
        }
        return dp[bagSize];
    }
    static public class Test {
        static private BackPackDP _solution = new BackPackDP();
        static public void randomTest() {
            int[] items = {2, 3};
            int rst1 = _solution.backPack(12, items);
            System.out.println(rst1);
        }
    }
}
