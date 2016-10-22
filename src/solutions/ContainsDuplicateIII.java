package solutions;

import java.util.TreeMap;

/**
 * Created by James on 10/19/16.
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0){
            return false;
        }
        //time complexity of delete and add node in BST is log(n)
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
        for (int i = 0; i < nums.length; i++) {
            //always remove the head of the window
            if (i > k) {
                map.remove((long)nums[i-k-1]);
            }
            long val = (long)nums[i];
            //input parameter type of method ceilingKey is long
            Long greater = map.ceilingKey(val);
            if (greater != null && greater <= t + val) {
                return true;
            }
            Long smaller = map.lowerKey(val);
            if (smaller != null && smaller >= val - t) {
                return true;
            }
            //supply of the window
            map.put(val, i);
        }
        return false;
    }
    static public class Test {
        static private ContainsDuplicateIII _solution = new
                ContainsDuplicateIII();

        static public void randomTest() {
            int[] nums = {1,4,7,2,8};
            boolean rst = _solution.containsNearbyAlmostDuplicate(nums, 2, 1);
            System.out.println(rst);
        }
    }
}
