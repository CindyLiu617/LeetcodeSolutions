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
        generator(nums, rst, permutation, visited);
        return rst;
    }

    private void generator (int[] nums, List<List<Integer>> rst,
                            List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            rst.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            if (!visited[i]){
                path.add(nums[i]);
                visited[i] = true;
                generator(nums, rst, path, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}
