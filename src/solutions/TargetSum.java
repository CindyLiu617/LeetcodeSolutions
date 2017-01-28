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

    //DP
    //in other word: sum(pos) - |sum(neg)| = target
    //sum(pos) + |sum(neg)| + sum(pos) - |sum(neg)| = target + sum(pos) +
    // |sum(neg)|
    //sum(pos) * 2 = target + sum(nums)
    public int findTargetSumWays2(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        if ((S + sum) % 2 != 0 || sum < S) {
            return 0;
        }
        return genSubset(nums, (S + sum) / 2);
    }

    //find num of subsets of nums that sum(subset) = (target + sum(nums)) / 2
    //Backpack V problem
    private int genSubset (int[] nums, int bagsize) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[bagsize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = bagsize; j >= nums[i]; --j) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagsize];
    }

    static public class Test {
        static private TargetSum _solution = new TargetSum();

        static public void randomTest() {
            int[] nums = {1, 1, 1, 1, 1};
            System.out.println(_solution.findTargetSumWays2(nums, 3));

        }
    }
}
