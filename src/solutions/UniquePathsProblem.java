package solutions;

public class UniquePathsProblem {
    //Unique Path >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?
     example:
     1,1    1,2     1,3     1,4     1,5     1,6     1,7
     2,1
     3,1                                            3,7
    Above is a 3 x 7 grid. How many possible unique paths are there?
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        //不用多加出来一行一列，因为margin condition在多余行列中都是0.
        //都等于0的含义是：从图以外的起点，到图以外的终点的路径数目是0.
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        //在图中，第一行和第一列的路径数目都是1.
        for (int i = 1; i < m; ++i) {
            paths[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) {
            paths[0][i] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

    //Unique Path II >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    /**
     * @param obstacleGrid
     * @return
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?

    An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     given : [
    [0,0,0],
    [0,1,0],
    [0,0,0]
    ] return 2;
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 ||
                obstacleGrid[0][0] == 1) {
            return 0;
        }
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] paths = new int[row][col];
        paths[0][0] = 1;
        for (int i = 1; i < row; ++i) {
            if (obstacleGrid[i][0] == 0) {
                paths[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < col; ++i) {
            if (obstacleGrid[0][i] == 0) {
                paths[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[row - 1][col - 1];
    }

    static public class Test {
        static private UniquePathsProblem _solution = new UniquePathsProblem();

        static public void randomTest() {
            int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
            int rst = _solution.uniquePathsWithObstacles(grid);
            System.out.println(rst);
        }
    }
}
