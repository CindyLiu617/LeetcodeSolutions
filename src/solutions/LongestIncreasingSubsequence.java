package solutions;

/**
 * Created by James on 8/17/16.
 */
public class LongestIncreasingSubsequence {
    // BAT Algorithms, Num 9 class
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] minLast = new int[nums.length + 1];
        minLast[0] = -1;
        for (int i = 1; i <= nums.length; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            // find the first number in minLast > nums[i]
            int index = binarySearch(minLast, nums[i]);
            minLast[index] = nums[i];
        }

        for (int i = nums.length; i >= 1; i--) {
            if (minLast[i] != Integer.MAX_VALUE) {
                return i;
            }
        }

        return 0;
    }
    private int binarySearch(int[] minLast, int num) {
        int start = 0, end = minLast.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (minLast[mid] < num) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (minLast[start] > num) {
            return start;
        }
        return end;
    }
    static public class Test {
        static private LongestIncreasingSubsequence _solution = new LongestIncreasingSubsequence();

        static public void randomTest() {
            int[] A = {1, 4, 2};
            int rst1 = _solution.lengthOfLIS(A);
            System.out.println(rst1);
        }
    }
}
