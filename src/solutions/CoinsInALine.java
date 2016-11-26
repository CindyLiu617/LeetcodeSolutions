package solutions;

public class CoinsInALine {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        if (n <= 0) {
            return false;
        }
        boolean[] willWin = new boolean[n + 1];
        if (n == 1 || n == 2) {
            return true;
        }
        willWin[1] = true;
        willWin[2] = true;
        for (int i = 3; i <= n; ++i) {
            if (!willWin[i - 1] || !willWin[i - 2]) {
                willWin[i] = true;
            } else {
                willWin[i] = false;
            }
        }
        return willWin[n];
    }

    static public class Test {
        static private CoinsInALine _solution = new CoinsInALine();

        static public void randomTest() {
            System.out.println(_solution.firstWillWin(6));
        }
    }
}
