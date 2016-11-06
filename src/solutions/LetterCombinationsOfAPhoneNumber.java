package solutions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by James on 11/5/16.
 */
public class LetterCombinationsOfAPhoneNumber {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    HashMap<Character, char[]> myMap = new HashMap<Character, char[]>();
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> rst = new ArrayList<String>();
        if (digits == null || digits.length() == 0){
            return rst;
        }
        myMap.put('0', new char[]{});
        myMap.put('1', new char[]{});
        myMap.put('2', new char[]{'a', 'b', 'c'});
        myMap.put('3', new char[]{'d', 'e', 'f'});
        myMap.put('4', new char[]{'g', 'h', 'i'});
        myMap.put('5', new char[]{'j', 'k', 'l'});
        myMap.put('6', new char[]{'m', 'n', 'o'});
        myMap.put('7', new char[]{'p', 'q', 'r', 's'});
        myMap.put('8', new char[]{'t', 'u', 'v'});
        myMap.put('9', new char[]{'w', 'x', 'y', 'z'});
        StringBuilder sb = new StringBuilder();
        helper(rst, sb, digits);
        return rst;
    }

    private void helper(ArrayList<String> rst, StringBuilder sb,
                                     String digits) {
       if (sb.length() == digits.length()) {
           rst.add(sb.toString());
           return;
       }
       for (int i = 0; i < myMap.get(digits.charAt(sb.length())).length;
            ++i) {
           sb.append(myMap.get(digits.charAt(sb.length()))[i]);
           helper(rst, sb, digits);
           sb.deleteCharAt(sb.length() - 1);
       }
    }

    static public class Test {
        static private LetterCombinationsOfAPhoneNumber _solution = new LetterCombinationsOfAPhoneNumber();

        static public void randomTest() {
            ArrayList<String> rst = _solution.letterCombinations("23");
            for (int i = 0; i < rst.size(); ++i){
                System.out.println(rst.get(i));
            }
        }
    }
}
