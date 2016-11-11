package solutions;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0)
            return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<Integer>();

        Arrays.sort(nums);
        return helper(nums, result, subset, 0);
    }

    private ArrayList<ArrayList<Integer>> helper(int[] nums,
                                             ArrayList<ArrayList<Integer>> result,
                                             ArrayList<Integer> path, int pos){

        result.add(new ArrayList<Integer>(path));
        for (int i = pos; i < nums.length; ++i){
            if (i != pos && nums[i-1] == nums[i]){
                continue;
            }
            path.add(nums[i]);

            helper(nums, result, path, i + 1);
            path.remove(path.size() - 1);
        }
        return result;
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
