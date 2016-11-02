package solutions;

/**
 * Created by James on 11/1/16.
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0){
            return;
        }
        for (int i = 1; i < nums.length; ++i){
            if ((i % 2 == 1 && nums[i] <= nums[i - 1]) || (i % 2 == 0 &&
                    nums[i] >= nums[i - 1]) ){
                swap(i, i - 1, nums);
            }
        }
    }
    private void swap(int idx1, int idx2, int[] array){
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    static public class Test {
        static private WiggleSort _solution = new WiggleSort();

        static public void randomTest() {
            int[] nums = {1, 3, 5, 1, 6, 4};
            _solution.wiggleSort(nums);
            for (int i = 0; i < nums.length; ++i) {
                System.out.println(nums[i]);
            }
        }
    }
}
