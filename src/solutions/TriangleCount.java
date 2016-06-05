package solutions;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;

/**
 * Created by James on 5/31/16.
 */
public class TriangleCount {
    public int triangleCount(int S[]) {
        // write your code here
        int cnt = 0;
        if (S == null || S.length == 0)
            return cnt;
        Arrays.sort(S);
        for (int i = 0; i < S.length; ++i){
            int left = 0;
            int right = i - 1;
            while(left < right) {
                if(S[left] + S[right] > S[i]) {
                    cnt += right - left;
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return cnt;
    }
    static public class Test {
        static private TriangleCount _solution = new TriangleCount();

        static public void test(int[] k, int ans) {
            Assert.check(ans == (_solution.triangleCount(k)));
        }
        static public void randomTest() {
            int[] k = {3, 4, 6, 7};
            test (k, 3);
        }
    }
}
