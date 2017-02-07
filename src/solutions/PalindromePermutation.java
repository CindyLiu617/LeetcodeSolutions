package solutions;

import java.util.HashMap;
import java.util.Iterator;

/*
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome.
How about character which occurs odd number of times?
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        boolean hasOdd = false;
        int countOdd = 0;
        for (Character k : map.keySet()) {
            if (map.get(k) % 2 != 0) {
                hasOdd = true;
                ++countOdd;
            }
        }
        return s.length() % 2 == 0 ? !hasOdd : (hasOdd && countOdd == 1);
    }

    static public class Test {
        static private PalindromePermutation _solution = new PalindromePermutation();

        static public void randomTest() {
            String s = "aacc";
            System.out.println(_solution.canPermutePalindrome(s));
        }
    }
}
