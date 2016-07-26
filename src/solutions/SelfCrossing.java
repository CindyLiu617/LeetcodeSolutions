package solutions;



/**
 * Created by James on 7/3/16.
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        if(x == null || x.length <= 3){
            return false;
        }
        int len = x.length;
        for(int i = 3; i < len; i++){
            if(x[i-3] >= x[i-1] && x[i] >= x[i-2]){
                return true;
            }
            if(i >=4)
            {
                if(x[i-3] == x[i-1] && x[i] >= x[i-2] - x[i - 4]){
                    return true;
                }
            }
            if(i >=5)
            {
                if(x[i] >= x[i-2] - x[i-4] && x[i-1] >= x[i-3] - x[i-5] && x[i-1] <= x[i-3] && x[i-2] - x[i-4] >= 0){
                    return true;
                }
            }
        }
        return false;
    }
    static public class Test {
        static private SelfCrossing _solution = new SelfCrossing();

        static public void test(int[] x, boolean ans) {
            assert ans == _solution.isSelfCrossing(x);
        }

        static public void randomTest() {
            int[] x1 = {2, 1, 1, 2};
            test(x1, true);
//
//            int[] x2 = {1, 2, 3, 4};
//            test(x2, false);
//
//            int[] x3 = {1, 1, 1, 1};
//            test(x3, true);
//

            int[] x5 = {1, 1, 2, 3, 2, 4};
            test(x5, true);

            int[] x6 = {1, 2, 2, 3, 3, 2, 1};
            test(x6, true);
        }
    }
}
