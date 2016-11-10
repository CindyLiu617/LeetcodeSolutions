package solutions;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAdress {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        helper(s, 4, new StringBuilder(), result);
        return result;
    }

    private boolean isValid(String s){
        if (s.length() == 1 || (!s.isEmpty() && s.length() < 4 && !s
                .startsWith("0"))) {
            int num = Integer.parseInt(s);
            if (num >= 0 && num <= 255)
                return true;
        }
        return false;
    }

    private void helper(String s, int n, StringBuilder path, List<String> result){
        if (n == 1) {
            if (isValid(s)) {
                result.add(path + s);
            }
            return;
        }

        for (int i = 1 ,len = path.length(); i <= 3 && i < s.length(); ++i) {
            String field = s.substring(0, i);
            if (isValid(field)) {
                helper(s.substring(i), n - 1, path.append(field).append("."), result);
            }
            path.delete(len, path.length());
        }
    }
}
