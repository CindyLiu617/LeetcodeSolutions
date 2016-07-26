package solutions;


import solutions.utils.Point;

/**
 * Created by James on 4/3/16.
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1){
            int mid = (right + left)/2;
            if (nums[mid] > nums[mid - 1])
                left = mid;
            else if (nums[mid] < nums[mid - 1])
                right = mid;
            else
                right = mid;
        }
        if (nums[left] >= nums[right])
            return left;
        else
            return right;
    }

    static public class Test {
        static private FindPeakElement _solution = new FindPeakElement();

        static public void test(int[] nums, int ans) {
            assert ans == _solution.findPeakElement(nums);
        }

        static public void randomTest() {
            int[] nums = {1,2,3,1};
            test(nums, 2);

            int[] nums2 = {1,2,3,4,2};
            test(nums2, 3);

            int[] nums3 = {1,5,4,3,2};
            test(nums3, 1);

            int[] num4 = {1,2,1};
            test(num4, 1);
        }
    }
}
