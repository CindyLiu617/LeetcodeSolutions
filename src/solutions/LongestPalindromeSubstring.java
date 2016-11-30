package solutions;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int size = s.length();
        String longest = "";
        if (size == 0)
            return longest;
        //A palindromic number or numeral palindrome is a number that
        //remains the same when its digits are reversed
        for (int i=0; i<s.length(); ++i) {
            String palindrome = findPalindrome(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        //the following for loop is for strings like "bb" return "bb"
        //otherwise it will return "b"
        for (int i=1; i<s.length(); ++i) {
            String palindrome = findPalindrome(s, i-1, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }
    private String findPalindrome(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)) {
            left--; right++;
        }
        return s.substring(left+1, right);
    }
}
