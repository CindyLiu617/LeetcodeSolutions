package solutions;

/**
 * Created by James on 6/15/16.
 */
public class TrappingRainWater {
    public int trapRainWater(int[] heights) {
        int vol = 0;
        if(heights == null || heights.length == 0)
            return vol;
        int size = heights.length;
        int[] left = new int[size], right = new int[size];
        left[0] = heights[0];
        for(int i = 1; i < size; ++i){
            left[i] = Math.max(left[i - 1], heights[i - 1]);
            right[size - 1 - i] = Math.max(right[size - i], heights[size - i]);
        }
        for(int i = 1; i < size; ++i){
            int temp = Math.min(left[i], right[i]) - heights[i];
            if(temp > 0)
                vol += temp;
        }
        return vol;
    }
    static public class Test {
        static private TrappingRainWater _solution = new TrappingRainWater();

        static public void randomTest() {
            int[] A1 = {0,1,0,2,1,0,1,3,2,1,2,1};
            int rst1 = _solution.trapRainWater(A1);
            System.out.println(rst1);
        }
    }
}
