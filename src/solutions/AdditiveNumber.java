package solutions;

/**
 * Created by James on 7/2/16.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3){
            return false;
        }
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i)
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
                if (isValid(i, j, num)){
                    return true;
                }
        return false;
    }
    private boolean isValid(int i, int j, String num) {
        if (num.charAt(i) == '0' && j > 1){
            return false;
        }
        String sum;
//        String s1 = num.substring(0, i);
        if (num.substring(0, i).charAt(0) == '0' && num.substring(0, i).length() > 1){
            return false;
        }
        long x1 = Long.parseLong(num.substring(0, i));
//        String s2 = num.substring(i, i + j);
        if (num.substring(i, i + j).length() > 1 && num.substring(i, i + j).charAt(0) == '0'){
            return false;
        }
        long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            //renew x2 and x1 every time
            x2 = x2 + x1;
            x1 = x2 - x1;
            sum = Long.toString(x2);
            if (!num.startsWith(sum, start)){
                return false;
            }
        }
        return true;
    }
    static public class Test {
        static private AdditiveNumber _solution = new AdditiveNumber();

        static public void test(String num, boolean ans) {
            assert ans == _solution.isAdditiveNumber(num);
        }

        static public void randomTest() {
//            test("199100199", true);
//            test("112358", true);
//            test("199100200", false);
//            test("1", false);
//            test("1203", false);
//            test("0235813", false);
//            test("101", true);
            test("1992201", true);
        }
    }
}
