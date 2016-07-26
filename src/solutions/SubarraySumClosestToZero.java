package solutions;

import java.util.Arrays;

/**
 * Created by James on 7/22/16.
 */
// find the subarray summation closest to zero.
public class SubarraySumClosestToZero {
    public int subarraySumClosestToZero(int[] array) {
        if (array == null || array.length == 0){
            return Integer.MIN_VALUE;
        }
        int len = array.length;
        int[] sum = new int[len + 1];
        sum[0] = array[0];
        for (int i = 1; i < len; ++i){
            sum[i] = sum[i - 1] + array[i];
        }
        Arrays.sort(sum);
        int diff = Math.abs(sum[1] - sum[0]), rst = diff;
        for (int i = 1; i < len; ++i){
            diff = sum[i + 1] - sum[i];
            rst = Math.min(diff, rst);
        }
        return rst;
    }
    static public class Test {
        static private SubarraySumClosestToZero _solution = new SubarraySumClosestToZero();

        static public void randomTest() {
            int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
            int rst = _solution.subarraySumClosestToZero(array);
            System.out.println(rst);

            int[] array1 = {1, -2, 3, 10, -4, 7, 2};
            int rst1 = _solution.subarraySumClosestToZero(array1);
            System.out.println(rst1);
        }
    }
}
