package solutions;

import java.util.ArrayList;

public class GrayCode {
    /* grey code:
    * 0    0+0   0+00
    * 1 -> 0+1   0+10
    *      1+1   0+11
    *      1+0-> 0+01  ...
    *            1+01
    *            1+11
    *            1+10
    *            1+00
    *n=1   n=2   n=3  ...
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (n < 0){
            return rst;
        }
        return helper(n);
    }

    private ArrayList<Integer>  helper(int n) {
        //create rst list inside method!
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (n == 0) {
            rst.add(0);
            return rst;
        }
        ArrayList<Integer> prevGreyCode = helper(n - 1);
        rst.addAll(prevGreyCode);
        for (int i = prevGreyCode.size() - 1; i >= 0; --i) {
            //primitive type double cast to primitive type int, not Integer,
            // Integer is an object
            rst.add(prevGreyCode.get(i) + (int)Math.pow(2, n - 1));
        }
        return rst;
    }

    static public class Test {
        static private GrayCode _solution = new GrayCode();

        static public void randomTest() {
            ArrayList<Integer> rst = _solution.grayCode(1);
            for (int i = 0; i < rst.size(); ++i) {
                System.out.println(rst.get(i));
            }
        }
    }
}
