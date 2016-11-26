package solutions;

public class CoinsProblem {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     * There are n coins in a line. Two players take turns to take one or
     * two coins from right side until there are no more coins left.
     * The player who take the last coin wins.
     * Could you please decide the first play will win or lose?
     * Example
    n = 1, return true.

    n = 2, return true.

    n = 3, return false.

    n = 4, return true.
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

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     * There are n coins with different value in a line.
     * Two players take turns to take one or two coins from left side until
     * there are no more coins left. The player who take the coins with the
     * most value wins.
     * Could you please decide the first player will win or lose?
     * Example
    Given values array A = [1,2,2], return true.

    Given A = [1,2,4], return false.
     */
    public boolean firstWillWin2(int[] values) {
        //http://massivealgorithms.blogspot.com/2015/06/techinpad-lintcode-coins-in-line-ii.html
        // write your code here
        int len = values.length;
        if (len <= 2) {
            return true;
        }
        //dp[i] means the largest value you(the first player)
        //can get when you start from values[i]
        int[] dp = new int[len+1];
        //not even exist
        dp[len] = 0;
        //when you happen to have the last coin, yes, consider the last first
        dp[len-1] = values[len-1];
        //sure we should get the last two for most value
        dp[len-2] = values[len-1] + values[len-2];
        //same rules, why leave two(len-1, len-2) for the other player
        dp[len-3] = values[len-2] + values[len-3];
        //next we are gonna sum up
        for (int i = len-4; i >= 0; i--) {
            //you have to have values[i] and the non-optimal later choice
            //because the other player is smart to leave you the worse one
            //between two of your optimal choices
            dp[i] = values[i] + Math.min(dp[i+2], dp[i+3]);
            dp[i] = Math.max(dp[i], values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]));
            //equals to: dp[i] = Math.max(values[i] + Math.min(dp[i+2],dp[i+3]), values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]));
        }
        //compute the total value of coins
        int sum = 0;
        for (int a: values) {
            sum += a;
        }
        //compare your final value to the other player's
        return dp[0] > sum - dp[0];
    }

    static public class Test {
        static private CoinsProblem _solution = new CoinsProblem();

        static public void randomTest() {
            System.out.println(_solution.firstWillWin(6));
        }
    }
}
