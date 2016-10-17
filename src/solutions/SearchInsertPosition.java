package solutions;

/**
 * Created by James on 10/9/16.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    //
    public int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (nums[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    static public class Test {
        static private SearchInsertPosition _solution =
                new SearchInsertPosition();

        static public void randomTest() {
            int[] A = {1, 3, 5, 6};
            int rst1 = _solution.searchInsert(A, 0);
            System.out.println(rst1);
        }
    }
}

