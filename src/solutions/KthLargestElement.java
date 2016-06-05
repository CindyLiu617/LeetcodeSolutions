package solutions;

import com.sun.tools.javac.util.Assert;

/**
 * Created by James on 5/30/16.
 */
public class KthLargestElement {
    public int kthLargestElement(int k, int[] nums) {
        int kLargest = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0)
            return kLargest;
        kLargest = findK(nums, nums.length - k, 0, nums.length - 1);
        return kLargest;
    }

    private int findK(int[] nums, int k, int start, int end){
        if (start >= end)
            return nums[start];
        int m = partition(nums, start, end);
        if (m == k)
            return nums[m];
        else if (m < k)
            return findK(nums, k, m+1, end);
        else
            return findK(nums, k, start, m-1);
    }

    private int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int write = start;
        int read = start + 1;
        while (read <= end){
            if (nums[read] < pivot){
                ++write;
                swap(nums, write, read);
            }
            ++read;
        }
        swap(nums, start, write);
        return write;
    }

    private void swap(int[] nums, int pos1, int pos2){
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }

    static public class Test {
        static private KthLargestElement _solution = new KthLargestElement();

        static public void test(int[] nums,int k, int ans) {
            Assert.check(ans == (_solution.kthLargestElement(k, nums)));
        }
        static public void randomTest() {
            int[] nums = {9,3,2,4,8};
            int k = 3;
            test (nums, k, 4);
        }
    }
}
