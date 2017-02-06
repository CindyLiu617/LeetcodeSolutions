package solutions;

public class FindMinimumInRotatedSortedArrayII {
    /*
    Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { //能肯定排除的是最后一个，不能肯定排除左边还是右边
                --right;
            }
        }
        return nums[left];
    }

    static public class Test{
        static private FindMinimumInRotatedSortedArrayII _solution = new
                FindMinimumInRotatedSortedArrayII();

        static public void randomTest() {
            int[] nums = {3, 3, 1, 3};
            System.out.println(_solution.findMin(nums));
        }
    }
}
