package solutions;

import java.util.ArrayList;

public class NQueens {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> result = new
                ArrayList<ArrayList<String>>();
        if (n <= 0)
            return result;
        ArrayList<Integer> posInRow = new ArrayList<Integer>();
        search(n, posInRow, result);
        return result;
    }
    private void search(int n, ArrayList<Integer> colPos,
                        ArrayList<ArrayList<String>> result ){
        //every col has its queen position
        if (colPos.size() == n) {
            result.add(draw(colPos));
            return;
        }
        for (int i = 0; i < n; ++i){
            if (isValid(i, colPos)){
                colPos.add(i);
                search(n, colPos, result);
                colPos.remove(colPos.size() - 1);
            }
        }
    }
    private boolean isValid(int pos, ArrayList<Integer> colPos){
        //number of rows which already have queens
        int row = colPos.size();
        //i is for the row
        for (int i = 0; i < row; i++) {
            // same column
            if (colPos.get(i) == pos) {
                return false;
            }
            // diagonal
            if (Math.abs(pos - colPos.get(i)) == row - i) {
                return false;
            }
        }
        return true;
    }
    private ArrayList<String> draw (ArrayList<Integer> colPos){
        ArrayList<String> board = new ArrayList<String>();
        for (int i = 0; i < colPos.size(); ++i){
            //create a new sb every time when it moves to next line
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < colPos.size(); ++j){
                if (j == colPos.get(i)){
                    sb.append("Q");
                }
                else
                    sb.append(".");
            }
            board.add(sb.toString());
        }
        return board;
    }
}
