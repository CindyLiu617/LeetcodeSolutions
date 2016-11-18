package solutions.utils;

public class TrappingRainWater {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int[] leftMax = new int[len], rightMax = new int[len];
        leftMax[0] = heights[0];
        rightMax[len - 1] = heights[len - 1];
        for (int i = 1; i < len; ++i) {
            //from i ~ i - 1,not including i
            leftMax[i] = Math.max(leftMax[i - 1], heights[i - 1]);
            //from len - 1 - i ~ len - 1
            rightMax[len - 1 - i] = Math.max(rightMax[len - i], heights[len
                    - i]);
        }
        int waterVolume = 0;
        for (int i = 0; i < len; ++i) {
            int vol =  Math.min(leftMax[i], rightMax[i]) - heights[i];
            if (vol > 0) {
                waterVolume += Math.min(leftMax[i], rightMax[i]) - heights[i];
            }
        }
        return waterVolume;
    }

    static public class Test {
        static private TrappingRainWater _solution = new
                TrappingRainWater();

        static public void randomTest() {
            int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
            System.out.println(_solution.trapRainWater(heights));
        }
    }
}
