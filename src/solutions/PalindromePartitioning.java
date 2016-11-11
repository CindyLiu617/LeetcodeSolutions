package solutions;

import solutions.utils.TreeNode;
import sun.jvm.hotspot.utilities.IntegerEnum;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> rst = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return rst;
        }
        List<String> palindrome = new ArrayList<String>();
        helper(rst, palindrome, s, 0);
        return rst;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    private void helper (List<List<String>> rst, List<String> palindrome,
                         String s, int pos) {
        if (pos == s.length()) {
            rst.add(new ArrayList<String>(palindrome));
            return;
        }
        //Pay attention! i starts from pos + 1
        for (int i = pos + 1; i <= s.length(); ++i) {
            String tmp = s.substring(pos, i);
            if (isPalindrome(tmp)) {
                palindrome.add(tmp);
                helper(rst, palindrome, s, i);
                palindrome.remove(palindrome.size() - 1);
            }
        }

    }

    static public class Test {
        static private PalindromePartitioning _solution = new
                PalindromePartitioning();

        static public void randomTest() {
            List<List<String>> rst = _solution.partition("aab");
            for (int i = 0; i < rst.size(); ++i) {
                for (int j = 0; j < rst.get(i).size(); ++j) {
                    System.out.print(rst.get(i).get(j));
                }
                System.out.println(">>>>>>>>");
            }
        }
    }
}
