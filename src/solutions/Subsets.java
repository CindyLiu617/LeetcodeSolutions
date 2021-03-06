package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * Given a set of distinct integers, nums, return all possible subsets.

    Note: The solution set must not contain duplicate subsets.

    For example,
    If nums = [1,2,3], a solution is:

    [
    [3],
    [1],
    [2],
    [1,2,3],
    [1,3],
    [2,3],
    [1,2],
    []
    ]
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rst = new
                ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<Integer>();
        helper(nums, subset, rst, 0);
        return rst;
    }

    private void helper (int[] nums, ArrayList<Integer> subset,
                         ArrayList<ArrayList<Integer>> rst, int pos) {
        rst.add(new ArrayList<Integer>(subset));
        for (int i = pos; i < nums.length; ++i) {
            subset.add(nums[i]);
            //pay attention i + 1
            helper(nums, subset, rst, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> subsets2 (int[] nums) {
        ArrayList<ArrayList<Integer>> rst = new
                ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        rst.add(new ArrayList<Integer>());
        generator(nums, rst, path, 0);
        return rst;
    }
    private void generator (int[] nums,  ArrayList<ArrayList<Integer>> rst,
                            ArrayList<Integer> path,  int cur) {
        for (int i = cur; i < nums.length; ++i) {
            path.add(nums[i]);
            rst.add(new ArrayList<Integer>(path));
            generator(nums, rst, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
    static public class Test {
        static private Subsets _solution = new Subsets();

        static public void randomTest() {
            int[] nums = {4, 1, 0};
            ArrayList<ArrayList<Integer>> rst = _solution.subsets(nums);
            for (int i = 0; i < rst.size(); ++i) {
               for (int j = 0; j < rst.get(i).size(); ++j) {
                   System.out.println(rst.get(i).get(j));
               }
                System.out.println(">>>>>>>>>>");
            }
        }
    }
}

