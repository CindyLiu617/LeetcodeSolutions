package solutions;

import solutions.utils.Interval;

/**
 * Created by James on 11/5/16.
 */
public class PaintHouseII2 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int houseNo = costs.length, paintNo = costs[0].length;
        int[][] minCost = new int[houseNo][paintNo];
        for (int i = 0; i < paintNo; ++i) {
            minCost[0][i] = costs[0][i];
        }
        for (int i = 1; i < houseNo; ++i) {
            //current color
            for (int j = 0; j < paintNo; ++j) {
                minCost[i][j] = Integer.MAX_VALUE;
                //previous color
                for (int m = 0; m < paintNo; ++m) {
                    if (m != j){
                        minCost[i][j] = Math.min(minCost[i][j],
                                                 minCost[i - 1][m] + costs[i][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < paintNo; ++i) {
            min = Math.min(min, minCost[houseNo - 1][i]);
        }
        return min;
    }
    static public class Test {
        static private PaintHouseII2 _solution = new PaintHouseII2();

        static public void randomTest() {
            int[][] costs = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
            System.out.println(_solution.minCostII(costs));
        }
    }
}
