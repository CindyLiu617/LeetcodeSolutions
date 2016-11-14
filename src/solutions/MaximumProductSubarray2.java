package solutions;

import solutions.utils.TreeNode;

public class MaximumProductSubarray2 {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] max = new int[len];
        max[0] = nums[0];
        int[] min = new int[len];
        min[0] = nums[0];
        int rst = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            min[i] = Math.min(Math.min(min[i - 1] * nums[i], max[i - 1] *
                    nums[i]), nums[i]);
            max[i] = Math.max(Math.max(min[i - 1] * nums[i], max[i - 1] *
                    nums[i]), nums[i]);
            rst = Math.max(max[i], rst);
        }
        return rst;
    }

    static public class Test {
        static private MaximumProductSubarray2 _solution = new
                MaximumProductSubarray2();

        static public void randomTest() {
//            int[] nums = {2, 3, -2, 8};
//            System.out.println(_solution.maxProduct(nums));

            int[] nums2 = {-1, 99};
            System.out.println(_solution.maxProduct(nums2));
        }
    }
}
