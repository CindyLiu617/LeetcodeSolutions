package solutions;

public class PowXN {
    public double myPow(double x, int n) {
        //Binary Search
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1.0 / helper(x, -n);
        } else {
            return helper(x, n);
        }
    }
    private double helper (double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = helper(x, n / 2);
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

    static public class Test {
        static private PowXN _solution = new PowXN();

        static public void randomTest() {
            System.out.println(_solution.myPow(2, 8));
        }
    }
}
