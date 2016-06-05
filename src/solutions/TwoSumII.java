package solutions;
import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

/**
 * Created by James on 5/30/16.
 */
public class TwoSumII {
    public int twoSum2(int[] nums, int target) {
        int cnt = 0;
        if (nums == null || nums.length == 0)
            return cnt;
        int ptr1 = 0, ptr2 = nums.length - 1;
        Arrays.sort(nums);
        while (ptr1 < ptr2){
            if (nums[ptr1] + nums[ptr2] <= target)
                ++ptr1;
            else {
//               ATTENTION !! not ++cnt
                cnt += ptr2 - ptr1;
                --ptr2;
            }
        }
        return cnt;
    }
    static public class Test {
        static private TwoSumII _solution = new TwoSumII();

        static public void test(int[] nums,int target, int ans) {
            Assert.check(ans == (_solution.twoSum2(nums, target)));
        }
        static public void randomTest() {
//            int[] nums = {2, 7, 11, 15};
//            int target = 24;
//            test(nums, target, 1);
//
//            int[] nums2 = {2, 17, 11, 15};
//            int target2 = 24;
//            test(nums2, target2, 2);

            int[] nums3 = {2, 7, 11, 15};
            int target3 = 0;
            test(nums3, target3, 6);
        }
    }
}
