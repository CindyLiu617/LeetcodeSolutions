package solutions;

import java.util.ArrayList;

public class SubsetsII {
    /*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        rst.add(new ArrayList<Integer>());
        generator(nums, rst, path, 0);
        return rst;
    }

    private void generator (int[] nums, ArrayList<ArrayList<Integer>> rst,
                            ArrayList<Integer> path, int cur) {
        for (int i = cur; i < nums.length; ++i) {
            if (i > cur && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            rst.add(new ArrayList<Integer>(path));
            generator(nums, rst, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    static public class Test {
        static private SubsetsII _solution = new SubsetsII();

        static public void randomTest() {
            int[] nums = {0};
            ArrayList<ArrayList<Integer>> rst = _solution.subsetsWithDup(nums);
            for (int i = 0; i < rst.size(); ++i) {
                for (int j = 0; j < rst.get(i).size(); ++j) {
                    System.out.println(rst.get(i).get(j));
                }
                System.out.println(">>>>>>>>>>");
            }
        }
    }
}
