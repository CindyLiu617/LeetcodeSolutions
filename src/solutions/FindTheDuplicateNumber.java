package solutions;

public class FindTheDuplicateNumber {
    /*
    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //鸽子洞问题：走两次大循环，保证之前被换到前面的鸽子不被忽略
        for (int j = 0; j < 2; ++j) {
            for (int i = 0; i < nums.length; ++i) {
                //如果发现自己不在自己的洞里
                if (nums[i] != i + 1) {
                    //自己的洞理由别的鸽子
                    if (nums[nums[i] - 1] != nums[i]) {
                        swap(nums, i, nums[i] - 1);
                    } else { //自己的洞里的鸽子是自己的复制品，即找到重复数字
                        return nums[i];
                    }
                }
            }
        }
        return nums[nums.length - 1];
    }

    private void swap(int[] nums, int target1, int target2) {
        int tmp = nums[target1];
        nums[target1] = nums[target2];
        nums[target2] = tmp;
    }

    static public class Test {
        static private FindTheDuplicateNumber _solution = new FindTheDuplicateNumber();

        static public void randomTest() {
            int[] B = {1, 7, 5, 6, 3, 4, 6};
            int rst1 = _solution.findDuplicate(B);
            System.out.println(rst1);
        }
    }
}
