package solutions;

/**
 * Created by James on 10/31/16.
 */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0)
            return 0;
        int row = board.length, col = board[0].length, cnt = 0;
        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                if (board[i][j] == 'X') {
                    if (i < row - 1 && board[i + 1][j] == 'X'){
                        continue;
                    }
                    if (j < col - 1 && board[i][j + 1] == 'X'){
                        continue;
                    }
                    ++cnt;
                }
            }
        }
        return cnt;
    }
    static public class Test {
        static private BattleshipsInABoard
                _solution = new BattleshipsInABoard();

        static public void randomTest() {
//           char[][] board1 = {{'.', '.', 'X', 'X', 'X'},
//                   {'X', '.', '.', '.', '.'},
//            {'X', '.', '.', 'X', 'X'},
//            {'.', '.', 'X', 'X', 'X'}};
//            System.out.println(_solution.countBattleships(board1));

//            char[][] board2 = {{'.', '.', '.', 'X'},
//                    {'X', '.', '.', 'X'},
//                    {'.', '.', '.', 'X'}};
//            System.out.println(_solution.countBattleships(board2));

            char[][] board3 = {{'.', '.', 'X', 'X'},
                    {'.', '.', '.', 'X'},
                    {'.', '.', '.', 'X'}};
            System.out.println(_solution.countBattleships(board3));
        }
    }
}
