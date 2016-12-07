package solutions;

public class InterLeavingString {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     *
     * @param s1, s2, s3: As description.
     * @return: true or false.
     * Given three strings: s1, s2, s3, determine whether s3 is formed by
     * the interleaving of s1 and s2.
     * For s1 = "aabcc", s2 = "dbbca"
     * <p>
     * When s3 = "aadbbcbcac", return true.
     * When s3 = "aadbbbaccc", return false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1 == null || s2 == null || s3 == null ||
                s3.length() != s1.length() + s2.length()) {
            return false;
        }
        int len1 = s1.length(), len2 = s2.length();
        //isInterleave[i][j] indicates whether the substring(0 ~ i)in s1 and
        // substring(0 ~ j)in s2 is interleaving the first i + j chars in s3
        boolean[][] isInterleave = new boolean[len1 + 1][len2 + 1];
        isInterleave[0][0] = true;
        for (int i = 1; i <= len1; ++i) {
            if (isInterleave[i - 1][0] &&
                    (s1.charAt(i - 1) == s3.charAt(i - 1))) {
                isInterleave[i][0] = true;
            }
        }
        for (int i = 1; i <= len2; ++i) {
            if (isInterleave[0][i - 1] &&
                    (s2.charAt(i - 1) == s3.charAt(i - 1))) {
                isInterleave[0][i] = true;
            }
        }
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (isInterleave[i - 1][j] &&
                        s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    isInterleave[i][j] = true;
                }
                if (isInterleave[i][j - 1] &&
                        s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    isInterleave[i][j] = true;
                }
            }
        }
        return isInterleave[len1][len2];
    }

    static public class Test {
        static private InterLeavingString _solution = new InterLeavingString();

        static public void randomTest() {
            System.out.println(_solution.isInterleave("aa", "b", "aba"));
        }
    }

}
