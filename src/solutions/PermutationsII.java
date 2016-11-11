package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        List<Integer> permutation = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, rst, permutation, visited);
        return rst;
    }

    private void helper (int[] nums, List<List<Integer>> rst, List<Integer>
            permutation, boolean[] visited) {
        if (permutation.size() == nums.length) {
            rst.add(new ArrayList<Integer>(permutation));
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i -
                    1])){
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            helper(nums, rst, permutation, visited);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }
}
