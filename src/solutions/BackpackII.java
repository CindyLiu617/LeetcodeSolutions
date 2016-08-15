package solutions;

import java.util.Arrays;

/**
 * Created by James on 8/6/16.
 */
public class BackpackII {
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if (A == null || A.length == 0 || V == null || V.length == 0 ||
                m <= 0) {
            return 0;
        }
        //dp[i][j] represents the maximum value I can get by choosing first i
        // items with bag size j.
        int[][] dp = new int[A.length + 1][m + 1];
        dp[0][0] = 0;
        if (A[0] < m) {
            Arrays.fill(dp[1], A[0], m + 1, V[0]);
        }
        for (int i = 2; i <= A.length; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (j < A[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j >= A[i - 1] &&
                        dp[i][j] < dp[i - 1][j - A[i - 1]] + V[i - 1]) {
                    dp[i][j] = dp[i - 1][j - A[i - 1]] + V[i - 1];
                }
                //                if (j >= A[i - 1]) {
                //                    dp[i][j] = Math.max(dp[i - 1][j - A[i - 1]] + V[i - 1],
                //                            dp[i - 1][j]);
                //                }
            }
        }
        return dp[A.length][m];
    }

    static public class Test {
        static private BackpackII _solution = new BackpackII();

        static public void randomTest() {
            int[] A = {3, 68, 24, 80, 76, 9, 24, 2, 46, 75, 56, 41, 95, 46, 23,
                    34, 64, 76, 6, 48, 25, 73, 87, 67, 58, 7, 93, 66, 55, 75,
                    38, 27, 53, 6, 100, 36, 26, 17, 53, 88, 21, 9, 34, 90, 32,
                    47, 4, 6, 57, 50, 30, 25, 41, 24, 12, 74, 92, 17, 32, 96,
                    35, 76, 52, 93, 64, 55, 1, 70, 26, 35, 2, 97, 82, 22, 41,
                    37, 63, 28, 90, 13, 18, 55, 28, 58, 59, 74, 71, 32, 71, 66,
                    4, 5, 48, 52, 70, 62, 28, 36, 39, 48};
            int[] V =
                    {38, 16, 29, 47, 22, 25, 17, 49, 15, 15, 75, 11, 56, 99, 51,
                            92, 59, 37, 13, 98, 61, 50, 32, 17, 44, 79, 41, 53,
                            45, 29, 62, 64, 2, 23, 31, 45, 57, 68, 57, 26, 51,
                            26, 86, 83, 94, 20, 98, 24, 91, 89, 1, 63, 21, 46,
                            74, 56, 64, 72, 58, 8, 74, 24, 27, 35, 94, 49, 65,
                            21, 16, 25, 1, 45, 63, 4, 37, 25, 39, 68, 49, 11,
                            31, 95, 5, 79, 20, 21, 52, 50, 8, 19, 67, 21, 24,
                            89, 28, 88, 38, 96, 64, 84};
            int rst1 = _solution.backPackII(1000, A, V);
            System.out.println(rst1);
        }
    }
}
