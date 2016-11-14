package solutions;

import com.sun.scenario.effect.impl.sw.java.JSWPhongLighting_SPOTPeer;

public class DistinctSubsequences {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null)
            return 0;
        int sLen = S.length();
        int tLen = T.length();
        if (sLen < tLen)
            return 0;
        int[][] distinct = new int[sLen + 1][tLen + 1];
        distinct[0][0] = 0;
        for (int i = 0; i < sLen + 1; ++i) {
            distinct[i][0] = 1;
        }
        for (int i = 1; i < sLen + 1; ++i) {
            for (int j = 1; j < tLen + 1; ++j) {
                if (S.charAt(i - 1) != T.charAt(j - 1)) {
                    distinct[i][j] = distinct[i - 1][j];
                } else {
                    distinct[i][j] = distinct[i - 1][j - 1] + distinct[i
                             - 1][j];
                }
            }
        }
        return distinct[sLen][tLen];
    }

    static public class Test {
        static private DistinctSubsequences _solution = new DistinctSubsequences();

        static public void randomTest() {
            System.out.println(_solution.numDistinct("rabbbit", "rabbit"));
        }
    }
}
