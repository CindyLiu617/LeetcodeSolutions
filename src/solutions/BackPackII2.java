package solutions;

public class BackPackII2 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A  & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if (A == null || A.length == 0 || V == null || V.length == 0 ||
                m <= 0) {
            return 0;
        }
        int itemNum = A.length;
        // maxvalue[i][j] indicates the max value one can get when put
        // the first j items into a bag of size i.
        int[][] maxValue = new int[m + 1][itemNum + 1];
        // margin condition: for i : 0 -> m, maxvalue[i][0] = 0
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= itemNum; ++j) {
                if (i >= A[j - 1]) {
                    maxValue[i][j] = Math.max(maxValue[i][j - 1],
                                              maxValue[i - A[j - 1]][j - 1] +
                                                      V[j - 1]);
                } else {
                    maxValue[i][j] = maxValue[i][j - 1];
                }
            }
        }
        return maxValue[m][itemNum];
    }

    static public class Test {
        static private BackPackII2 _solution = new BackPackII2();

        static public void randomTest() {
            int[] A = {71, 34, 82, 23, 1, 88, 12, 57, 10, 68, 5, 33, 37, 69, 98,
                    24, 26, 83, 16, 26, 18, 43, 52, 71, 22, 65, 68, 8, 40, 40,
                    24, 72, 16, 34, 10, 19, 28, 13, 34, 98, 29, 31, 79, 33, 60,
                    74, 44, 56, 54, 17, 63, 83, 100, 54, 10, 5, 79, 42, 65, 93,
                    52, 64, 85, 68, 54, 62, 29, 40, 35, 90, 47, 77, 87, 75, 39,
                    18, 38, 25, 61, 13, 36, 53, 46, 28, 44, 34, 39, 69, 42, 97,
                    34, 83, 8, 74, 38, 74, 22, 40, 7, 94};
            int[] V =
                    {26, 59, 30, 19, 66, 85, 94, 8, 3, 44, 5, 1, 41, 82, 76, 1,
                            12, 81, 73, 32, 74, 54, 62, 41, 19, 10, 65, 53, 56,
                            53, 70, 66, 58, 22, 72, 33, 96, 88, 68, 45, 44, 61,
                            78, 78, 6, 66, 11, 59, 83, 48, 52, 7, 51, 37, 89,
                            72, 23, 52, 55, 44, 57, 45, 11, 90, 31, 38, 48, 75,
                            56, 64, 73, 66, 35, 50, 16, 51, 33, 58, 85, 77, 71,
                            87, 69, 52, 10, 13, 39, 75, 38, 13, 90, 35, 83, 93,
                            61, 62, 95, 73, 26, 85};
            int rst1 = _solution.backPackII(1000, A, V);
            System.out.println(rst1);
        }
    }
}
