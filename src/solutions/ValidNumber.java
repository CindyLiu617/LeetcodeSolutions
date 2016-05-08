package solutions;

import com.sun.tools.javac.jvm.Code;
import com.sun.tools.javac.util.Assert;

/**
 * Created by James on 4/13/16.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0 )
            return false;
        boolean dot = false, exp = false;
        int len = s.length();
        if (len == 1 && !Character.isDigit(s.charAt(0)))
            return false;
        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+' && s.charAt(0) != '.' && s.charAt(0) != ' ')
            return false;
        for (int i = 0; i < len; ++i){
            if (Character.isDigit(s.charAt(i)) || (i == 0 && (s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == '.' || s.charAt(i) == ' '))){
                continue;
            }
            if ((Character.isLetter(s.charAt(i)) && s.charAt(i) != 'e' && s.charAt(i) != 'E' )){
                return false;
            }
            if (s.charAt(i) == ' '){
                if (i != len - 1)
                    return false;
                else
                    continue;
            }
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                if (exp || i == len - 1)
                    return false;
                else{
                    exp = true;
                    continue;
                }
            }
            if (s.charAt(i) == '.'){
                if (dot || !Character.isDigit(s.charAt(i - 1)))
                    return false;
                else {
                    dot = true;
                    continue;
                }
            }
            if ((s.charAt(i) == '-' || s.charAt(i) == '+') && (s.charAt(i - 1) != '.'|| s.charAt(i - 1) != 'e' || s.charAt(i - 1) != 'E'))
                return false;
        }
        return true;
    }
    static public class Test {
        static private ValidNumber _solution = new ValidNumber();

        static public void test(String s, boolean ans) {
            Assert.check(ans == (_solution.isNumber(s)));
        }

        static public void randomTest() {

            String s1 =  "0";
            test(s1, true);

            String s2 = "0.1";
            test(s2, true);

            String s3 = "abc";
            test(s3, false);

            String s4 = "1 a";
            test(s4, false);

            String s5 = "2e10";
            test(s5, true);

            String s6 = "-1.";
            test(s6, false);

            String s7 = "1 ";
            test(s7, true);

            String s8 = ".1";
            test(s8, true);
//
            String s9 = ".";
            test(s9, false);

            String s10 = " 0";
            test(s10, true);

            String s11 = "2.";
            test(s11, true);
        }
    }
}
