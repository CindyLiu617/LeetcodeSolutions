package solutions;

public class SearchForARange {
    /*
    Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
     */
    public int[] searchRange(int[] nums, int target) {
        int[] rst = new int[2];
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        rst[0] = findFirstPos(nums, target);
        rst[1] = findLastPos(nums, target);
        return rst;
    }

    //find the position of first appearance of target in sorted array
    public int findFirstPos (int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //don't forget to check
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //find the position of last appearance of the target in sorted array
    public int findLastPos (int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        //don't forget to check
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
