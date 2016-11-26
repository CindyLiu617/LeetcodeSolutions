package solutions;

import solutions.utils.Coordinate;
import java.util.ArrayList;

public class PostOfficeProblems {
    /**
     * @param grid a 2D grid
     * @return an integer
     * Given a 2D grid, each cell is either an house 1 or empty 0 (the number
     * zero, one), find the place to build a post office, the distance that
     * post office to all the house sum is smallest. Return the smallest
     * distance. Return -1 if it is not possible.
     * Given a grid:
     * 0 1 0 0
     * 1 0 1 1
     * 0 1 0 0
     * return 6
     */

    //Time Limit Exceeded
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int row = grid.length, col = grid[0].length;
        ArrayList<Integer> house = new ArrayList<Integer>();
        ArrayList<Integer> empty = new ArrayList<Integer>();
        //traverse grid to find house and empty positions
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    house.add(i * col + j);
                } else {
                    empty.add(i * col + j);
                }
            }
        }
        int minDist = Integer.MAX_VALUE, dist;
        for (Integer emptyPos: empty) {
            dist = 0;
            for (Integer housePos: house) {
                dist += _calDist(emptyPos, housePos, grid);
            }
            minDist = Math.min(minDist, dist);
        }
        return minDist;
    }

    private int _calDist(Integer c1, Integer c2, int[][] grid) {
        int col = grid[0].length;
        int y1 = c1 % col, x1 = c1 / col, y2 = c2 % col, x2 = c2 / col;
        return (Math.abs(y1 - y2) + Math.abs(x2 - x1));
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public int shortestDistance2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int row = grid.length, col = grid[0].length;
        return 0;
    }
    static public class Test {
        static private PostOfficeProblems _solution = new
                PostOfficeProblems();

        static public void randomTest() {
            int[][] grid = {{0, 1, 0, 0}, {1, 0, 1, 1}, {0, 1, 0, 0}};
            int rst = _solution.shortestDistance(grid);
            System.out.println(rst);
        }
    }
}
