package solutions;

public class PaintHouseII {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */

    public int minCostII(int[][] costs) {
        // Write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] minCost = new int[costs.length][costs[0].length];
        return helper(costs, 0, -1, minCost);
    }

    private int helper(int[][] costs, int curHouse, int prevColor, int[][]
            minCost) {
        if (curHouse == costs.length) {
            return 0;
        }
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; ++i) {
            if (prevColor != i) {
                if (minCost[curHouse][i] == 0){
                    int min = helper(costs, curHouse + 1, i, minCost);
                    cost = Math.min(cost, costs[curHouse][i] +
                            min);
                    minCost[curHouse][i] = min;
                } else {
                    cost = Math.min(cost, costs[curHouse][i] +
                            minCost[curHouse][i]);
                }
            }
        }
        return cost;
    }
    static public class Test {
            static private PaintHouseII _solution = new PaintHouseII();

            static public void randomTest() {
                int[][] costs = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
                System.out.println(_solution.minCostII(costs));
            }
        }
}
