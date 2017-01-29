package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     * Given a set of candidate numbers (C) (without duplicates) and a target
     * number (T), find all unique combinations in C where the candidate numbers sums to T.
    The same repeated number may be chosen from C unlimited number of times.
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
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
            if (i > 0 && candidates[i] == candidates[i- 1]) {
                continue;
            }
            combination.add(candidates[i]);
            //start from i since every number can be used unlimited number
            // of times
            helper(rst, combination, candidates, target - candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
    static public class Test {
        static private CombinationSum _solution = new CombinationSum();

        static public void randomTest() {
            int[] nums = {2, 2};
            List<List<Integer>> rst = _solution.combinationSum(nums, 4);
            for (int i = 0; i < rst.size(); ++i) {
                for (int j = 0; j < rst.get(i).size(); ++j) {
                    System.out.print(rst.get(i).get(j));
                }
                System.out.println(">>>>>>>>");
            }
        }
    }
}
