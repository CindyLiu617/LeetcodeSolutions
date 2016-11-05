package solutions;

/**
 * Created by James on 8/7/16.
 */
public class BackpackIII {
    public int backPackIII(int[] A, int[] V, int m) {
        // Write your code here
        if (A == null || A.length == 0 || V == null || V.length == 0 ||
                m <= 0) {
            return 0;
        }
        int[] dp = new int [m + 1];
        dp [0] = 0;
        for (int i = 1; i <= V.length; ++i){
            for (int j = 0; j <= m; ++j){
                if (j >= A[i - 1]){
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[m];
    }
    static public class Test {
        static private BackpackIII _solution = new BackpackIII();

        static public void randomTest() {
            int[] A = {1};
            int[] V = {1};
            int rst1 = _solution.backPackIII(A, V, 10);
            System.out.println(rst1);
        }
    }
}
