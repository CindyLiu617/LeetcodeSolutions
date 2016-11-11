package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
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
            if (!visited[i]) {
                permutation.add(nums[i]);
                visited[i] = true;
                helper(nums, rst, permutation, visited);
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}
