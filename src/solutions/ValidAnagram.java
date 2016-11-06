package solutions;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null) {
            return t == null;
        }
        if (t == null) {
            return s == null;
        }
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
}

