package solutions;

/**
 * Created by James on 8/19/16.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; ++i){
            if (obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }
            else{
                break;
            }
        }
        for (int i = 0; i < col; ++i){
            if (obstacleGrid[0][i] == 0){
                dp[0][i] = 1;
            }
            else{
                break;
            }
        }
        for (int i = 1; i < row; ++i){
            for (int j = 1; j < col; ++j){
                if (obstacleGrid[i][j] == 0){
                   dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[row -1][col - 1];
    }
    static public class Test {
        static private UniquePathsII _solution =
                new UniquePathsII();

        static public void randomTest() {
            int[][] A = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
            int rst1 = _solution.uniquePathsWithObstacles(A);
            System.out.println(rst1);
        }
    }
}
