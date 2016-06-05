package solutions;

/**
 * Created by James on 6/1/16.
 */
public class NumberOfIsland {
    public int numIslands(boolean[][] grid) {
        if (grid == null)
            return 0;
        if (grid.length == 0)
            return 0;
        if (grid[0].length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int num = 0;
        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                if (grid[i][j]){
                    ++num;
                    finder(i, j, grid);
                }
            }
        }
        return num;
    }
    private void finder(int i, int j, boolean[][] grid ){
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length)
            return;
        if (grid[i][j]){
            grid[i][j] = false;
            if (i > 0)
                finder(i-1, j, grid);
            finder(i+1, j, grid);
            if (j > 0)
                finder(i, j-1, grid);
            finder(i, j+1, grid);
        }
    }
}
