package solutions;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    static public class Test{
        static private FindMinimumInRotatedSortedArray _solution = new
                FindMinimumInRotatedSortedArray();

        static public void randomTest() {
            int[] nums = {7, 8, 9, 10, 1, 2};
            System.out.println(_solution.findMin(nums));
        }
    }
}
