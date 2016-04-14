package solutions;

import com.sun.tools.javac.util.Assert;

/**
 * Created by James on 4/13/16.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int len = height.length, left = 0, right = len - 1, maxWater = 0;
        while (left >= 0 && right <= len - 1 && left <= right){
            maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]){
                ++left;
            }
            else
                --right;
        }
        return maxWater;
    }
    static public class Test {
        static private ContainerWithMostWater _solution = new ContainerWithMostWater();

        static public void test(int[] height, int ans) {
            Assert.check(ans == (_solution.maxArea(height)));
        }

        static public void randomTest() {
            int[] height = {5, 15, 20, 2};
            test(height, 15);
        }
    }
}
