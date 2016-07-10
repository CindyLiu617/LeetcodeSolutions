package solutions;

import com.sun.tools.javac.util.Assert;

/**
 * Created by James on 7/1/16.
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n/m, b = n%m;
            ones += (a + 8) / 10 * m;
            if(a % 10 == 1) ones += b + 1;
        }
        return ones;
    }
    static public class Test {
        static private NumberOfDigitOne _solution = new NumberOfDigitOne();

        static public void test(int n, int ans) {
            Assert.check(ans == _solution.countDigitOne(n));
        }

        static public void randomTest() {
            test(13, 6);
        }
    }
}
