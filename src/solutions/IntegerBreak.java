package solutions;

public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    static public class Test {
        static private IntegerBreak _solution = new IntegerBreak();

        static public void randomTest() {
            int rst1 = _solution.integerBreak(10);
            System.out.println(rst1);
        }
    }
}
