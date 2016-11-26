package solutions;

public class EditDistance2 {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == null || word2 == null) {
            return 0;
        }
        int len1 = word1.length(), len2 = word2.length();
        int[][] minDistance = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; ++i) {
            minDistance[i][0] = i;
        }
        for (int i = 0; i <= len2; ++i) {
            minDistance[0][i] = i;
        }
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minDistance[i][j] = minDistance[i - 1][j - 1];
                } else {
                    minDistance[i][j] = Math.min(Math.min(minDistance[i - 1][j],
                                                 minDistance[i][j - 1]),
                                                 minDistance[i - 1][j - 1]) + 1;
                }
            }
        }
        return minDistance[len1][len2];
    }

    static public class Test {
        static private EditDistance2 _solution = new EditDistance2();

        static public void randomTest() {
            String w1 = "mart", w2 = "karma";
            int rst = _solution.minDistance(w1, w2);
            System.out.println(rst);
        }
    }
}
