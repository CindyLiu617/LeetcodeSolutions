package solutions;

/**
 * Created by James on 10/31/16.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int arithEleNumber = 2, rst = 0;
        for (int i = 1; i < A.length - 1; ++i){
            if (A[i] - A[i - 1] == A[i + 1] - A[i]){
                ++arithEleNumber;
            }
            else {
                rst += (arithEleNumber - 1) * (arithEleNumber - 2) / 2;
                arithEleNumber = 2;
            }
        }
        rst += (arithEleNumber - 1) * (arithEleNumber - 2) / 2;
        return rst;
    }
    static public class Test {
        static private ArithmeticSlices _solution = new ArithmeticSlices();

        static public void randomTest() {
            int[] A = {2, 1, 3, 4, 2, 3};
            int rst1 = _solution.numberOfArithmeticSlices(A);
            System.out.println(rst1);
        }
    }
}
