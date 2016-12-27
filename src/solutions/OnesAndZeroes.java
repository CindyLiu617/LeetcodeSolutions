package solutions;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0 || m < 0 || n < 0) {
            return 0;
        }
        int[][] max = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] noOneZero = _countOneZero(str);
            for (int i = m; i >= noOneZero[0]; --i) {
                for (int j = n; j >= noOneZero[1]; --j) {
                    //m, n 相当于背包大小， 现在的1 和 0 的个数相当于物体的大小。
                    max[i][j] = Math.max(max[i][j], max[i - noOneZero[0]][j -
                            noOneZero[1]] + 1);
                }
            }
        }
        return max[m][n];
    }

    private int[] _countOneZero (String str) {
        int[] rst = new int[2];
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '0') {
                ++rst[0];
            } else {
                ++rst[1];
            }
        }
        return rst;
    }

    static public class Test {
        static private OnesAndZeroes _solution = new OnesAndZeroes();
        static public void randomTest() {
            String[] strs = {"0", "00", "1"};
            int rst1 = _solution.findMaxForm(strs, 1, 0);
            System.out.println(rst1);
        }
    }
}
