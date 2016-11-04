package solutions;

/**
 * Created by James on 11/4/16.
 */
public class SearchA2DMatrixII {
        public int searchMatrix(int[][] matrix, int target) {
    // write your code here
    if (matrix == null || matrix.length == 0){
        return 0;
    }
    if (target < matrix[0][0] ||
            target > matrix[matrix.length - 1][matrix[0].length - 1]){
        return 0;
    }
    int row = matrix.length, col = matrix[0].length, cnt = 0;
    //binary search every row
    for (int i = 0; i < row; ++i){
        int low = 0;
        int high = col - 1;
        while (low <= high){
            int mid = (low + high)/2;
            if (matrix[i][mid] == target){
                ++cnt;
                break;
            } else if (matrix[i][mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
    return cnt;
}
}
