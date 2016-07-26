package solutions;



/**
 * Created by James on 7/8/16.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int rst = 0;
        if (dungeon == null || dungeon.length == 0)
            return rst;
        int row = dungeon.length, col = dungeon[0].length;
        int[][] energyValue = new int[row][col];
        energyValue[row - 1][col - 1] = Math.max(1 - dungeon[row - 1][col - 1], 1);

        for (int i = row - 2; i >= 0; --i){
            energyValue[i][col - 1] = Math.max(energyValue[i + 1][col - 1] - dungeon[i][col - 1], 1);
        }
        for (int j = col - 2; j >= 0; --j){
            energyValue[row - 1][j] = Math.max(energyValue[row - 1][j + 1] - dungeon[row - 1][j], 1);
        }
        for (int i = row - 2; i >= 0; --i){
            for (int j = col - 2; j >= 0; --j){
                dungeon[i][j] = Math.min(Math.max(energyValue[i][j + 1] - dungeon[i][j], 1), Math.max(energyValue[i + 1][j] - dungeon[i][j], 1));
            }
        }
        return energyValue[0][0];
    }
    static public class Test {
        static private DungeonGame _solution = new DungeonGame();

        static public void test(int[][] dungeon, int ans) {
            assert ans == _solution.calculateMinimumHP(dungeon);
        }

        static public void randomTest() {
//            int[][] d1 = {{100}};
//            test(d1, 1);
//
//            int[][] d2 = {{-200}};
//            test(d2, 201);

//            int[][] d3 = {{0, 0}};
//            test(d3, 1);

            int[][] d4 = {{2, 1}, {1, -1}};
            test(d4, 1);
        }
    }
}
