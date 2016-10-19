package solutions;

import java.util.HashMap;

/**
 * Created by James on 10/19/16.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i){
            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
            else {
                if (i - map.get(nums[i]) > k){
                    //renew position
                    map.put(nums[i], i);
                }
                else {
                    return true;
                }
            }
        }
        return false;
    }

    static public class Test {
        static private ContainsDuplicateII _solution = new ContainsDuplicateII();

        static public void randomTest() {
            int[] nums = {-1, -1};
            boolean rst = _solution.containsNearbyDuplicate(nums, 1);
            System.out.println(rst);
        }
    }
}
