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
        long left = 0, right = x / 2 + 1;
        while (left <= right) {
            long mid = (left + right) / 2, sqrt = mid * mid;
            if (sqrt == x) {
                return (int)mid;
            } else if (sqrt > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)right;
    }

    //牛顿迭代，逼近求方根 因为要求x2 = n的解，令f(x)=x2-n，相当于求解f(x)=0的解，可以求出递推式如下：
    //xi+1=xi - (xi2 - n) / (2xi) = xi - xi / 2 + n / (2xi) = xi / 2 + n / 2xi =
    // (xi + n/xi) / 2
    public int mySqrt2(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        int rst = 1, pre = 0;
        while (rst != pre) {
            pre = rst;
            rst = (x / rst + rst) / 2;
        }
        return rst;
    }

    static public class Test {
        static private SqrtX _solution = new SqrtX();

        static public void randomTest() {
            System.out.println(_solution.mySqrt2(5));
        }
    }
}
