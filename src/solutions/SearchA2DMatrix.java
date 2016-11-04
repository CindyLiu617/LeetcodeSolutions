package solutions;

import solutions.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchA2DMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (target < matrix[0][0] ||
                target > matrix[matrix.length - 1][matrix[0].length - 1]){
            return false;
        }
        int row = matrix.length, col = matrix[0].length, rowStart = 0,
                rowEnd = row - 1, start = 0, end = matrix[0].length - 1;
        //find row
        while (rowStart <= rowEnd){
            int rowMid = (rowStart + rowEnd) / 2;
            if (matrix[rowMid][0] > target){
                rowEnd = rowMid - 1;
            } else if (matrix[rowMid][0] < target){
                rowStart = rowMid + 1;
            } else {
                return true;
            }
        }
        while (start <= end){
            int mid = (start + end) / 2;
            if (matrix[rowEnd][mid] > target){
                end = mid - 1;
            } else if (matrix[rowEnd][mid] < target){
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    static public class Test {
        static private SearchA2DMatrix _solution = new SearchA2DMatrix();

        static public void randomTest() {
            int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
            System.out.println(_solution.searchMatrix(matrix, 3));
        }
    }
}
