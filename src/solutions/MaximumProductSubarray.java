package solutions;



/**
 * Created by James on 7/9/16.
 */
//time limit exceeded
//public class MaximumProductSubarray {
//    public int maxProduct(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return 0;
//        int numsLen = nums.length, rst = nums[0];
//        if (numsLen == 1)
//            return nums[0];
//        int[][] maxProduct = new int[numsLen][numsLen];
//        maxProduct[0][0] = nums[0];
//        for (int i = 0; i < numsLen; ++i){
//            for (int j = i; j < numsLen; ++j){
//                if (i == j){
//                    maxProduct[i][i] = nums[i];
//                }
//                else{
//                    maxProduct[i][j] = maxProduct[i][j - 1] * nums[j];
//                }
//                if (maxProduct[i][j] > rst){
//                    rst = maxProduct[i][j];
//                }
//            }
//        }
//        return rst;
//    }
//    static public class Test {
//        static private MaximumProductSubarray _solution = new MaximumProductSubarray();
//
//        static public void test(int[] nums, int ans) {
//            assert ans == _solution.maxProduct(nums));
//        }
//
//        static public void randomTest() {
//            int[] nums1 = {2,3,-2,4};
//            test(nums1, 6);
//
//            int[] nums2 = {-2};
//            test(nums2, -2);

//            int[] nums3 = {0, 2};
//            test(nums3, 2);
//        }
//    }
//}

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int numsLen = nums.length, rst = nums[0], maxTemp = nums[0], minTempt = nums[0];
//        int[][] maxProduct = new int[numsLen][numsLen];
//        int[][] minProduct = new int[numsLen][numsLen];
        for (int i = 1; i < numsLen; ++i){
            int product1 = nums[i] * maxTemp;
            int product2 = nums[i] * minTempt;
            maxTemp = Math.max(Math.max(product1, product2), nums[i]);
            minTempt = Math.min(Math.min(product1, product2), nums[i]);
            rst = Math.max(rst, maxTemp);
        }
        return rst;
    }
    static public class Test {
        static private MaximumProductSubarray _solution = new MaximumProductSubarray();

        static public void test(int[] nums, int ans) {
            assert ans == _solution.maxProduct(nums);
        }

        static public void randomTest() {
            int[] nums1 = {2,3,-2,4};
            test(nums1, 6);

            int[] nums2 = {-2};
            test(nums2, -2);

            int[] nums3 = {0, 2};
            test(nums3, 2);
        }
    }
}


