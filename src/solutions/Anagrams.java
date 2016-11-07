package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> rst = new ArrayList<String>();
        if (strs == null || strs.length == 0){
            return rst;
        }
        int[] flag = new int[strs.length];
        for (int i = 0; i < strs.length; ++i){
            for (int j = i + 1; j < strs.length; ++j){
                if (isAnagram(strs[i], strs[j])){
                    if (flag[i] == 0){
                        rst.add(strs[i]);
                        flag[i] = 1;
                    }
                    if (flag[j] == 0){
                        rst.add(strs[j]);
                        flag[j] = 1;
                    }
                }
            }
        }
        return rst;
    }
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int sLen = s.length();
        int tLen = t.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < sLen; ++i){
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 1);
            else
                map.put(s.charAt(i), map.get(s.charAt(i))+ 1);
        }
        int j = 0;
        while (j < tLen){
            if (map.containsKey(t.charAt(j)) && map.get(t.charAt(j)) > 0){
                map.put(t.charAt(j), map.get(t.charAt(j)) - 1);
            }
            else
                return false;
            ++j;
        }
        return true;
    }

    static public class Test {
        static private Anagrams _solution = new Anagrams();

        static public void randomTest() {
            String[] strs = {"lint", "intl", "inlt", "code"};
            List<String> rst = _solution.anagrams(strs);
            for (String str: rst) {
                System.out.print(str);
            }
        }
    }
}
