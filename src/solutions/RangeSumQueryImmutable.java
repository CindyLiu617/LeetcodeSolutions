package solutions;

/*
Given an integer array nums, find the sum of the elements between indices i
and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {
    int[] sumRecord;
    //constructor
    public RangeSumQueryImmutable(int[] nums) {
         if (nums == null || nums.length == 0) {
             return;
         }
         sumRecord = new int[nums.length];
         sumRecord[0] = nums[0];
         for (int i = 1; i < nums.length; ++i) {
             sumRecord[i] = sumRecord[i - 1] + nums[i];
         }
    }

    public int sumRange(int i, int j) {
        return i - 1 >= 0 ? sumRecord[j] - sumRecord[i - 1] : sumRecord[j];
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
}
