package solutions;

import javafx.scene.control.Alert;

//Search in Rotated Sorted Array>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
public class SearchInRotatedArrayProblem {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    You are given a target value to search. If found in the array return its index, otherwise return -1.

    You may assume no duplicate exists in the array.
    Example
    For [4, 5, 1, 2, 3] and target=1, return 2.

    For [4, 5, 1, 2, 3] and target=0, return -1.
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int len = A.length, start = 0, end = len - 1;
        while (start <= end) {
            //Attention! mid = (end + start) / 2;
            int mid = (end + start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] <= A[end]) {
                if (target <= A[mid] || target >= A[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (A[mid] > A[end]){
                if (target <= A[mid] && target >= A[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    //Search in Rotated Sorted Array II>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    /**
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean
     * Follow up for Search in Rotated Sorted Array:

     What if duplicates are allowed?

     Would this affect the run-time complexity? How and why?

     Write a function to determine if a given target is in the array.
     Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
     Given [1, 1, 1, 1, 1, 1] and target = 0, return false
     */
    public boolean search2(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int len = A.length, start = 0, end = len - 1;
        while (start < end && A[start] == A[end]) {
            if (A[start] == target)
                return true;
            ++start; --end;
        }
        while (start <= end) {
            //Attention! mid = (end + start) / 2;
            int mid = (end + start) / 2;
            if (A[mid] == target) {
                return true;
            } else if (A[mid] <= A[end]) { //割点在原数组左边
                if (target <=  A[mid] || target >= A[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (A[mid] > A[end]){//割点在原数组右边
                if (target <= A[mid] && target >= A[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }

    static public class Test {
        static private SearchInRotatedArrayProblem _solution = new SearchInRotatedArrayProblem();

        static public void randomTest() {
            int[] nums = {1, 1, 1, 1, 1, 1};
            boolean rst = _solution.search2(nums, 0);
            System.out.println(rst);
        }
    }
}
