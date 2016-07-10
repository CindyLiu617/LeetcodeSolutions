package solutions;

/**
 * Created by James on 5/28/16.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0)
            return null;
        //letters are 26 characters
        int[] cnt = new int[26];
        // the position for the smallest s[i]
        int pos = 0;
        for (int i = 0; i < s.length(); i++)
            cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0)
                break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
    static public class Test {
        static private RemoveDuplicateLetters _solution = new RemoveDuplicateLetters();

        static public void randomTest() {
            String s = "bcabc";
            String rst = _solution.removeDuplicateLetters(s);
            System.out.println(rst);
        }
    }
}
