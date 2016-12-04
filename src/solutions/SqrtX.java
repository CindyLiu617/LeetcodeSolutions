package solutions;

public class SqrtX {
    // 二分法。基本思路是跟二分查找类似，要求是知道结果的范围，取定左界和右界，
    // 然后每次砍掉不满足条件的一半，知道左界和右界相遇。算法的时间复杂度是O(logx)，空间复杂度是O(1)。
    public int mySqrt(int x) {
        if(x<0) {
            return -1;
        }
        if(x==0) {
            return 0;
        }
        int l=1;
        int r=x/2+1;
        while(l<=r) {
            int m = (l+r)/2;
            if(m<=x/m && x/(m+1)<m+1) {
                return m;
            }
            if(x/m<m) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return 0;
    }
    static public class Test {
        static private SqrtX _solution = new SqrtX();

        static public void randomTest() {
            System.out.println(_solution.mySqrt(3));
        }
    }
}
