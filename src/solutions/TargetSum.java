package solutions;

import solutions.utils.ListNode;

public class TargetSum {
    //DFS
    //rst must be global
    int rst = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        helper(nums, 0, S, 0);
        return rst;
    }

    private void helper(int[] nums, int sum, int target, int cur) {
        if (cur == nums.length) {
            if (target == sum) {
                ++rst;
            }
            return;
        }
        helper(nums, sum + nums[cur], target, cur + 1);
        helper(nums, sum - nums[cur], target, cur + 1);
    }
    

    static public class Test {
        static private TargetSum _solution = new TargetSum();

        static public void randomTest() {
            int[] nums = {1, 1, 1, 1, 1};
            System.out.println(_solution.findTargetSumWays(nums, 3));

        }
    }
}
