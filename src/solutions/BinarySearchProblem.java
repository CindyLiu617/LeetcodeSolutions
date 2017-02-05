package solutions;

public class BinarySearchProblem {
    //find target in sorted array
    public int searchTarget (int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchTarget2 (int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid;
            } else if (target == nums[mid]) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        //don't forget to check
        if (nums[left] == target) {
            return target;
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

    public int findLastPos2 (int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        //don't forget to check
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //find the index of number which is smallest larger than target
    public int findCeiling (int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
             int mid = (left + right) / 2;
             if (target > nums[mid]) {
                 left = mid + 1;
             } else if (target < nums[mid]) {
                 right = mid;
             } else {
                 return mid + 1;
             }
        }
        return left;
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    //find the index of number which is largest smaller than target
    public int findFloor (int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                if (nums[mid + 1] >= target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                return mid - 1;
            }
        }
        return left;
    }



    static public class Test {
        static private BinarySearchProblem _solution = new BinarySearchProblem();

        static public void randomTest() {
            int[] nums = {0, 2, 3, 6, 7, 5};
            int rst = _solution.findCeiling(nums, 3);
            System.out.println(rst);
        }
    }
}
