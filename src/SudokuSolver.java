import com.sun.tools.javac.util.Assert;

import java.util.List;

/**
 * Created by James on 5/5/16.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        helper(board);
    }
    private boolean helper(char[][] board){
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                if (board[i][j] == '.'){
                    for (char num = '1'; num <='9'; ++num){
                        if (isValid(board, i, j, num)){
                            board[i][j] = num;
                            if (helper(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int i, int j, char c){
        for (int row = 0; row < 9; ++row){
            if (board[row][j] == c){
                return false;
            }
        }
        for (int col = 0; col < 9; ++col){
            if (board[i][col] == c){
                return false;
            }
        }
        for (int row = i/3*3; row < i/3*3+3; ++row){
            for (int col = j/3*3; col< j/3*3+3; ++col){
                if (board[row][col] == c){
                    return false;
                }
            }
        }
        return true;
    }
    static public class Test {
        static private SudokuSolver _solution = new SudokuSolver();


        static public void randomTest() {
            char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
            _solution.solveSudoku(board);
            System.out.println(board);
        }
    }
}
