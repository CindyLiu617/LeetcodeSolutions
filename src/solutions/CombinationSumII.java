package solutions;

import solutions.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     * Given a collection of candidate numbers (C) and a target number (T),
     * find all unique combinations in C where the candidate numbers sums to T.

    Each number in C may only be used once in the combination.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return rst;
        }
        List<Integer> combination = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(rst, combination, candidates, target, 0);
        return rst;
    }

    private void helper(List<List<Integer>> rst, List<Integer> combination,
                        int[] candidates, int target, int ptr) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            rst.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = ptr; i < candidates.length; ++i) {
            //当candidates[i] == candidates[i- 1] 时，说明此组合之前已经有过，如果不跳过此种情况
            //则会重复
            //必须是i > ptr因为如果i > 0， 且数组中有重复元素，本来可以组合的却被忽略掉。
            if (i > ptr && candidates[i] == candidates[i- 1]) {
                continue;
            }
            combination.add(candidates[i]);
            //从下一个i开始传，避免使用重复
            helper(rst, combination, candidates, target - candidates[i], i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return rst;
        }
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, path, rst, 0, 0);
        return rst;
    }

    private void helper (int[] nums, int target, List<Integer>
            path, List<List<Integer>> rst, int cur, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            rst.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = cur; i < nums.length; ++i) {
            if (i > cur && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            //start from i + 1 since every number can be used once
            helper(nums, target, path, rst, i + 1, sum + nums[i]);
            path.remove(path.size() - 1);
        }
    }

    static public class Test {
        static private CombinationSumII _solution = new CombinationSumII();

        static public void randomTest() {
            int[] nums = {10, 1, 2, 7, 6, 1, 5};
            List<List<Integer>> rst = _solution.combinationSum2(nums, 8);
            for (int i = 0; i < rst.size(); ++i) {
                for (int j = 0; j < rst.get(i).size(); ++j) {
                    System.out.print(rst.get(i).get(j));
                }
                System.out.println(">>>>>>>>");
            }
        }
    }
}
