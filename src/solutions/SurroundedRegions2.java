package solutions;

/**
 * Created by James on 11/2/16.
 */
public class SurroundedRegions2 {
    public void surroundedRegions2(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int rows = board.length, cols = board[0].length;
        int oRoot = rows * cols;
        initUnionFind(rows * cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X') continue;
                int curr = i * cols + j;
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    union(curr, oRoot);
                } else {
                    if (j + 1 < cols && board[i][j + 1] == 'O')
                        union(curr, i * cols + j + 1);
                    if (j - 1 >= 0 && board[i][j - 1] == 'O')
                        union(curr, i * cols + j - 1);
                    if (i + 1 < rows && board[i + 1][j] == 'O')
                        union(curr, (i + 1) * cols + j);
                    if (i - 1 >= 0 && board[i - 1][j] == 'O')
                        union(curr, (i - 1) * cols + j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O' && find(i * cols + j) != oRoot) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    int[] s;
    int[] rank;
    private void initUnionFind(int n) {
        s = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++)
            s[i] = i;
        rank[n] = n + 1;
    }
    private int find(int p) {
        if (s[p] == p) return p;
        else return s[p] = find(s[p]);
    }
    private void union(int p, int q) {
        int pRoot = find(p), qRoot = find(q);
        if (pRoot == qRoot) return;
        if (rank[pRoot] > rank[qRoot]) {
            s[pRoot] = qRoot;
        } else {
            if (rank[pRoot] == rank[qRoot])
                rank[pRoot]++;
            s[qRoot] = pRoot;
        }
    }

    static public class Test {
        static private SurroundedRegions2 _solution = new SurroundedRegions2();

        static public void randomTest() {
            char[][] board = {{'X', 'X', 'X'}, {'X', 'O', 'X'}, {'X', 'O', 'X'}};
            _solution.surroundedRegions2(board);
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    System.out.print(board[i][j]);
                }
                System.out.println(">>>>");
            }
        }
    }
}
