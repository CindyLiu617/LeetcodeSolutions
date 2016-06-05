package solutions;

import com.sun.tools.javac.util.Assert;


/**
 * Created by James on 5/18/16.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return word == null;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; ++i){
            for (int j = 0; j < col; ++j){
                if (findPath(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }
    private boolean findPath(char[][] board, String word, int idx, int x, int y, boolean[][] visited){
        if(visited[x][y])
            return false;
        if (board[x][y] != word.charAt(idx))
            return false;
        if(idx == word.length() - 1)
            return true;
        visited[x][y] = true;
        if(x + 1 < board.length && findPath(board, word, idx + 1, x + 1, y, visited))
            return true;
        if(x > 0 && findPath(board, word, idx + 1, x - 1, y, visited))
            return true;
        if(y + 1 < board[0].length && findPath(board, word, idx + 1, x, y + 1, visited))
            return true;
        if(y > 0 && findPath(board, word, idx + 1, x, y - 1, visited))
            return true;
        visited[x][y] = false;
        return false;
    }
    static public class Test {
        static private WordSearch _solution = new WordSearch();

        static public void test(String A, char[][] board, boolean ans) {
            Assert.check(ans == (_solution.exist(board, A)));
        }
        static public void randomTest() {
            char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
            test("oath", board, true);
            test("abc", board, false);
            test("oate", board, false);
        }
    }
}
