package solutions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by James on 7/22/16.
 */
//find subarray (start index and end index) which its summation is closest zero
public class SubarraySumClosestToZeroII {
    public int[] subarraySumClosestToZeroII(int[] array) {
        if (array == null || array.length == 0){
            return null;
        }
        int len = array.length;
        int[] sum = new int[len + 1], rst = new int[2];
        rst[0] = array[0];
        rst[1] = array[1];
        HashMap <Integer, ArrayList<Integer>> idxSumRecord = new HashMap<Integer, ArrayList<Integer>>();
        sum[0] = array[0];
        for (int i = 1; i < len; ++i){
            sum[i] = sum[i - 1] + array[i];
            if (!idxSumRecord.containsKey(sum[i])){
                idxSumRecord.put(sum[i], new ArrayList<Integer>());
            }
            idxSumRecord.get(sum[i]).add(i);
        }
        Arrays.sort(sum);
        int min = Math.abs(sum[1] - sum[0]);
        for (int i = 1; i < len; ++i){
            int tmp = sum[i + 1] - sum[i];
            if (tmp < min){
                if (tmp != 0){
                    rst[0] = idxSumRecord.get(sum[i + 1]).get(0) + 1;
                    rst[1] = idxSumRecord.get(sum[i]).get(0);
                }
                else{
                    rst[0] = idxSumRecord.get(sum[i + 1]).get(0) + 1;
                    rst[1] = idxSumRecord.get(sum[i + 1]).get(1);
                }
                min = tmp;
            }
        }
        return rst;
    }
    static public class Test {
        static private SubarraySumClosestToZeroII _solution = new SubarraySumClosestToZeroII();

        static public void randomTest() {
//            int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
//            int[] rst = _solution.subarraySumClosestToZeroII(array);
//            for (Integer i : rst){
//                System.out.print(i);
//            }
//            System.out.println(">>>>>>>>>>>");

            int[] array1 = {1, -2, 3, 10, -4, 7, 2};
            int[] rst1 = _solution.subarraySumClosestToZeroII(array1);
            for (Integer i : rst1){
                System.out.print(i);
            }
        }
    }
}
