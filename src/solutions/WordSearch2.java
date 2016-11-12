package solutions;

import java.util.List;

public class WordSearch2 {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0 || word == null || word.length()
                == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0;i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (helper(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int x, int y,
                           boolean[][] visited, int ptr) {
        if (visited[x][y] || board[x][y] != word.charAt(ptr)) {
            return false;
        }
        if (ptr == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        if (x > 0 && helper(board, word, x - 1, y, visited, ptr + 1)) {
            return true;
        }
        if (y > 0 && helper(board, word, x, y - 1, visited, ptr + 1)) {
            return true;
        }
        if (x + 1 < board.length && helper(board, word, x + 1, y, visited, ptr +
                1)) {
            return true;
        }
        if (y + 1 < board[0].length && helper(board, word, x, y + 1, visited, ptr +
                1)) {
            return true;
        }
        //backtracking
        visited[x][y] = false;
        return false;
    }

    static public class Test {
        static private WordSearch2 _solution = new
                WordSearch2();

        static public void randomTest() {
            char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'},
                    {'a', 'd', 'e', 'e'}};
            boolean rst = _solution.exist(board, "abcb");
            System.out.println(rst);
        }
    }
}
