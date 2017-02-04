package solutions;

/*
Given a sorted array, remove the duplicates in place such that each element
appear only once and return the new length.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int read = 1;
        int write = 0;
        while (read < nums.length){
            if (nums[read] != nums[write]){
                //move the write pointer first then write the new value
                ++write;
                nums[write] = nums[read];
            }
            //no matter the write pointer write or not, your read pointer has
            //to move
            ++read;
        }
        return write + 1;
    }

    static public class Test {
        static private RemoveDuplicatesFromSortedArray _solution = new
                RemoveDuplicatesFromSortedArray();

        static public void randomTest() {
            int[] nums = {1, 2, 2, 3};
            int rst = _solution.removeDuplicates(nums);
            System.out.println(rst);
        }
    }
}
