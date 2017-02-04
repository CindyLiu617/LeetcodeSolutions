package solutions;

/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums
being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int write = 0, read = 1, count = 0;
        for (; read < nums.length; ++read) {
            if (nums[write] != nums[read]) {
                ++write;
                nums[write] = nums[read];
                count = 0;
            } else {
                if (count == 0) {
                    ++write;
                    nums[write] = nums[read];
                }
                ++count;
            }
        }
        return write + 1;
    }

    static public class Test {
        static private RemoveDuplicatesFromSortedArrayII _solution = new
                RemoveDuplicatesFromSortedArrayII();

        static public void randomTest() {
            int[] nums = {1, 1, 1, 2, 2, 3};
            int rst = _solution.removeDuplicates(nums);
            System.out.println(rst);
        }
    }

}
