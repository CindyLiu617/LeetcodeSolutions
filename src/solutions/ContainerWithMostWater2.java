package solutions;

public class ContainerWithMostWater2 {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int len = heights.length;
        int left = 0, right = len - 1, maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(heights[left],
                                                 heights[right]) * (right -
                    left));
            if (heights[left] < heights[right]) {
                ++left;
            } else if (heights[left] > heights[right]) {
                --right;
            } else {
                ++left;
                --right;
            }
        }
        return maxArea;
    }

    static public class Test {
        static private ContainerWithMostWater2 _solution = new ContainerWithMostWater2();

        static public void randomTest() {
            int[] heights = {1, 1};
            System.out.println(_solution.maxArea(heights));
        }
    }
}
