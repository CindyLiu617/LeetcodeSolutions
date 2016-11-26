package solutions;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        //DP
        if (s == null || s.length() == 0)
            return dict.isEmpty();
        //find the longest string in dictionary
        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            //j is the length of match segment. all ends at i
            for (int j = 1; j <= maxLength && j <= i; j++) {
                if (!canSegment[i - j]) {
                    continue;
                }
                //dp[i] == true 表示0 ~ i-1 至少有一个可划分点j
                //如果dp[i - j] == true 并且恰好i - j ~ i字段在字典中有，则说明
                //dp[i] == true
                String word = s.substring(i - j, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
    }
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    static public class Test {
        static private WordBreak _solution = new WordBreak();

        static public void randomTest() {
            Set<String> dict = new HashSet<String>();
            dict.add("lint");
            dict.add("code");
            boolean rst = _solution.wordBreak("lintcode", dict);
        }
    }
}
