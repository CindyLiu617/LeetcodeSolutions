package solutions;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int split = nums.length - 1;
        while (split > 0) {
            if (nums[split - 1] >= nums[split]) {
                --split;
            } else {
                break;
            }
        }
        int change = nums.length - 1;
        if (split > 0) {
            --split;
            while (change > 0 && nums[change] <= nums[split]) {
                --change;
            }
            swap(nums, change, split);
            ++split;
        }
        reverse(nums, split, nums.length - 1);
    }

    private void swap (int[] nums, int target1, int target2) {
        int tmp = nums[target1];
        nums[target1] = nums[target2];
        nums[target2] = tmp;
    }

    private void reverse (int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            ++start;
            --end;
        }
    }

    static public class Test {
        static private NextPermutation _solution = new NextPermutation();

        static public void randomTest() {
            int[] nums = {5, 1, 1};
            _solution.nextPermutation(nums);
            for (int i = 0; i < nums.length; ++i){
                System.out.println(nums[i]);

            }
        }
    }
}
