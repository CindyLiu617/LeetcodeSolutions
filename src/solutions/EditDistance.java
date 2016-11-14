package solutions;

public class EditDistance {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        if (word1 == null || word1.length() == 0) {
            return word2 == null? 0: word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int len1 = word1.length(), len2 = word2.length();
        int[][] distance = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; ++i) {
            distance[i][0] = i;
        }
        for (int i = 0; i <= len2; ++i) {
            distance[0][i] = i;
        }
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(Math.min(distance[i - 1][j], distance[i][j - 1]),
                                              distance[i - 1][j - 1]) + 1;
                }

            }
        }
        return distance[len1][len2];
    }

    static public class Test {
        static private EditDistance _solution = new EditDistance();

        static public void randomTest() {
            System.out.println(_solution.minDistance("mart", "karma"));
        }
    }
}
