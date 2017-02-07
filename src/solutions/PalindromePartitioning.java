package solutions;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     Return all possible palindrome partitioning of s.
     For example, given s = "aab",
     Return:
     [
     ["aa","b"],
     ["a","a","b"]
     ]
     */
    public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return rst;
        }
        List<String> palindromeSet = new ArrayList<String>();
        generator(s, rst, palindromeSet, 0);
        return rst;
    }

    private void generator (String s, List<List<String>> rst, List<String>
            palindromeSet, int pos) {
        //!!!pos == s.length()
        if (pos == s.length()) {
            rst.add(new ArrayList<String>(palindromeSet));
            return;
        }
        //substring[start, end] exclusive end
        for (int i = pos + 1; i <= s.length(); ++i) {
            String tmp = s.substring(pos, i);
            if (isPalindrome(tmp)) {
                palindromeSet.add(tmp);
                generator(s, rst, palindromeSet, i);
                palindromeSet.remove(palindromeSet.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            --right;
            ++left;
        }
        return true;
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
