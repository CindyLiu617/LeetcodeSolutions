package solutions;

public class HouseRobberII {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int houseNum = nums.length;
        if (houseNum == 1) {
            return nums[0];
        }
        int[] maxCon1 = new int[nums.length];
        //condition1: rob the first house, must not rob the last house
        maxCon1[0] = nums[0];
        maxCon1[1] = nums[0];
        for (int i = 2; i < nums.length - 1; ++i) {
            maxCon1[i] = Math.max(maxCon1[i - 1], maxCon1[i - 2] + nums[i]);
        }
        //condition2: do not rob the first house, can rob the last house
        int[] maxCon2 = new int[nums.length];
        maxCon2[0] = 0;
        maxCon2[1] = nums[1];
        for (int i = 2; i < nums.length; ++i) {
            maxCon2[i] = Math.max(maxCon2[i - 1], maxCon2[i - 2] + nums[i]);
        }
        //attention: maxCon1[nums.length - 1] = 0
        return Math.max(maxCon1[nums.length - 2], maxCon2[nums.length - 1]);
    }

    static public class Test {
        static private HouseRobberII _solution = new
                HouseRobberII();

        static public void randomTest() {
//            int[] A = {3, 6, 4};
//            long rst = _solution.houseRobber2(A);
//            System.out.println(rst);
//
//            int[] A2 = {3, 6, 4, 8, 5};
//            long rst2 = _solution.houseRobber2(A2);
//            System.out.println(rst2);

//            int[] A3 = {828,125,740,724,983,321,773,678,841,842,875,377,674,
//                    144,340,467,625,916,463,922,255,662,692,123,778,766,254,559,
//                    480,483,904,60,305,966,872,935,626,691,832,998,508,657,215,
//                    162,858,179,869,674,452,158,520,138,847,452,764,995,600,568,
//                    92,496,533,404,186,345,304,420,181,73,547,281,374,376,454,
//                    438,553,929,140,298,451,674,91,531,685,862,446,262,477,573,
//                    627,624,814,103,294,388};
//            long rst3 = _solution.houseRobber2(A3);
//            System.out.println(rst3);

            int[] A4 = {4,1,2,7,5,3,1};
            long rst4 = _solution.houseRobber2(A4);
            System.out.println(rst4);
        }
    }
}
