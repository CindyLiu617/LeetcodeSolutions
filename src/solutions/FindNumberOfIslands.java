package solutions;



/**
 * Created by James on 3/24/16.
 */
public class FindNumberOfIslands {
    private int[][] _movements = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numberOfIslands(int[][] matrix) {
        if (matrix == null)
            return 0;

        int countOfIslands = 0;
        final int row = matrix.length, col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    findIslands(matrix,visited, i, j);
                    ++countOfIslands;
                }
            }
        }
        return countOfIslands;
    }

    private void findIslands(int[][] matrix, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        for (int[] move : _movements) {
            int xx = x + move[0];
            int yy = y + move[1];
            if (xx >= 0 && xx < matrix.length && yy >= 0 && yy < matrix[0].length && matrix[xx][yy] == 1 && !visited[xx][yy]) {
                findIslands(matrix, visited, xx, yy);
            }
        }
    }

    static public class Test {
        static private FindNumberOfIslands _solution = new FindNumberOfIslands();

        static public void test(int[][] matrix, int ans) {
            assert ans == _solution.numberOfIslands(matrix);
        }

        static public void randomTest() {
            int[][] matrix1 = {{1, 1}};
            test(matrix1, 1);

            int[][] matrix2 = {{0, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}};
            test(matrix2, 3);

            int[][] matrix3 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
            test(matrix3, 1);

            int[][] matrix4 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
            test(matrix4, 0);
        }
    }
}
