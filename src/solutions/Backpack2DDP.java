package solutions;

import java.util.Arrays;

/**
 * Created by James on 8/5/16.
 */
public class Backpack2DDP {
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0 || m <= 0) {
            return 0;
        }
        // dp[i][j] means the maximum size I can get using bag with size j and
        // taking the first i items in A.
        int[][] dp = new int[2][m + 1];
        if (A[0] < m) {
            Arrays.fill(dp[1], A[0], m + 1, A[0]);
        }
        int tmp = 0;
        for (int i = 2; i <= A.length; ++i) {
            for (int j = 0; j <= m; ++j) {
                dp[tmp][j] = dp[1 - tmp][j];
                if (j >= A[i - 1] &&
                        dp[1 - tmp][j - A[i - 1]] + A[i - 1] > dp[tmp][j]) {
                    dp[tmp][j] = dp[1 - tmp][j - A[i - 1]] + A[i - 1];
                }
            }
            tmp = 1 - tmp;
        }
        return dp[1 - tmp][m];
    }

    static public class Test {
        static private Backpack2DDP _solution = new Backpack2DDP();

        static public void randomTest() {
            int[] items = {2, 3, 5, 7};
            int rst1 = _solution.backPack(11, items);
            System.out.println(rst1);
        }
    }
}
