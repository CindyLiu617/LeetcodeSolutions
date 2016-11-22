package solutions;

public class PaintHouse {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int houseNumber = costs.length;

        int[][] minCost = new int[houseNumber][3];
        for (int i = 0; i < 3; ++i) {
            minCost[0][i] = costs[0][i];
        }
        for (int i = 1; i < houseNumber; ++i) {
            minCost[i][0] = Math.min(minCost[i - 1][1], minCost[i - 1][2]) +
                    costs[i][0];
            minCost[i][1] = Math.min(minCost[i - 1][0], minCost[i - 1][2]) +
                    costs[i][1];
            minCost[i][2] = Math.min(minCost[i - 1][1], minCost[i - 1][0]) +
                    costs[i][2];
        }
        return Math.min(Math.min(minCost[houseNumber - 1][0],
                                 minCost[houseNumber - 1][1]),
                        minCost[houseNumber - 1][2]);
    }

    static public class Test {
        static private PaintHouse _solution = new PaintHouse();

        static public void randomTest() {
            int[][] A = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
            int rst1 = _solution.minCost(A);
            System.out.println(rst1);
        }
    }
}
