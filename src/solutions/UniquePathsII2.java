package solutions;

/**
 * Created by James on 8/20/16.
 */
public class UniquePathsII2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        if (row == 1){
            for (int i = 0; i < col; ++i){
                if (obstacleGrid[0][i] == 1)
                    return 0;
            }
            return 1;
        }
        int[][] dp = new int[2][col];
        for (int i = 0; i < 2; ++i){
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
        int tmp = 0;
        for (int i = 1; i < row; ++i){
            for (int j = 1; j < col; ++j){
                if (obstacleGrid[i][j] == 0){
                    dp[1 - tmp][j] = dp[tmp][j] + dp[1 - tmp][j - 1];
                }
                else{
                    dp[1 - tmp][j] = 0;
                }
            }
            tmp = 1 - tmp;
        }
        return dp[1- tmp][col - 1];
    }
    static public class Test {
        static private UniquePathsII2 _solution =
                new UniquePathsII2();

        static public void randomTest() {
            int[][] A = {{0, 0}, {0, 0}, {0, 0}, {1, 0}, {0, 0}};
            int rst1 = _solution.uniquePathsWithObstacles(A);
            System.out.println(rst1);
        }
    }
}
