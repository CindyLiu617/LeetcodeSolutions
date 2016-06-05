package solutions;

/**
 * Created by James on 5/28/16.
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++)
            cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            System.out.println();
            System.out.println(s.charAt(i));
            System.out.println(s.charAt(i) - 'a');
            System.out.println(cnt[s.charAt(i) - 'a']);
            System.out.println();
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
