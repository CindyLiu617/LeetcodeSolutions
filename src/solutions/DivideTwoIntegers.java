package solutions;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        long rst = 0, did = Math.abs(dividend), dir = Math.abs(divisor);
        while (did >= dir) {
            long record = 1, tmp = dir;
            while ((tmp << 1) < did) {
                tmp <<= 1;
                record <<= 1;
            }
            did -= tmp;
            rst += record;
        }
        return dividend * dividend > 0 ? (int)rst : (int)rst * (-1);
    }

    static public class Test {
        static private DivideTwoIntegers _solution = new
                DivideTwoIntegers();

        static public void randomTest() {
            System.out.println(_solution.divide(8, 7));
        }
    }
}
