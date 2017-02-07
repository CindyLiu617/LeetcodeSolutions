package solutions;

/**
 * Created by James on 11/3/16.
 */
public class FindPeekElement2 {
    /*
    A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function
should return the index number 2.
     */
    public int findPeak(int[] A) {
        //binary search
        if (A == null || A.length == 0){
            return 0;
        }
        int left = 0, right = A.length - 1;
        //while (left < right) will cause infinite loop
        while (left < right - 1){
            int mid = (left + right) / 2;
            if (A[mid] < A[mid + 1]){
                left = mid;
            }
            //the numbers in adjacent positions are must different
            //otherwise, we can not decide which part should be abandoned
            else{
                right = mid;
            }
        }
        return A[left] >= A[right] ? left : right;
    }

    public int findPeak2(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int left = 0, right = A.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (A[mid] <= A[mid + 1]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    static public class Test {
        static private FindPeekElement2 _solution = new FindPeekElement2();

        static public void randomTest() {
//            int[] nums = {1,2,1};
//            System.out.println(_solution.findPeak(nums));
////
//            int[] nums2 = {1,2,3,4,2};
//            test(nums2, 3);
//
//            int[] nums3 = {1,5,4,3,2};
//            test(nums3, 1);
//
//            int[] num4 = {1,2,1};
//            test(num4, 1);

//            int[] nums5 = {1,2,1,3,4,5,7,6};
//            test(nums5, 6);

            int[] nums6 = {2, 2, 2, 2, 2, 3, 1};
            System.out.println(_solution.findPeak(nums6));
        }
    }
}
